package org.student.backend.cart.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.student.backend.login.UserDTOHolder;
import org.student.backend.mapper.AddressMapper;
import org.student.backend.mapper.CartMapper;
import org.student.backend.mapper.FoodMapper;
import org.student.backend.mapper.RestaurantMapper;
import org.student.backend.pojo.common.Result;
import org.student.backend.pojo.entity.Address;
import org.student.backend.pojo.entity.Cart;
import org.student.backend.pojo.entity.Food;
import org.student.backend.pojo.entity.Restaurant;

import java.util.List;

/**
 * @author Student
 */
@Service
public class CartServiceImpl implements CartService {

    @Resource
    private CartMapper cartMapper;

    @Resource
    private FoodMapper foodMapper;

    @Resource
    private AddressMapper addressMapper;

    @Resource
    private RestaurantMapper restaurantMapper;

    private static final double EARTH_RADIUS_KM = 6371.0;

    private static final double DELIVER_FEE_PER_KM = 5;

    @Override
    public Result addOneFoodToCart(Long userId, Long restaurantId, Long foodId) {
        Cart cart = new Cart();
        cart.setUserId(userId);
        cart.setRestaurantId(restaurantId);
        cart.setFoodId(foodId);

        QueryWrapper<Cart> selectWrapper = new QueryWrapper<Cart>()
                .eq("user_id", userId)
                .eq("restaurant_id", restaurantId)
                .eq("food_id", foodId);

        Cart queryCart = cartMapper.selectOne(selectWrapper);

        if (queryCart == null) {
            cart.setQuantity(1);
            cartMapper.insert(cart);
        }
        else {
            queryCart.setQuantity(queryCart.getQuantity() + 1);
            cartMapper.updateById(queryCart);
        }

        return Result.ok();
    }

    @Override
    public Result getCartItemList() {

        Long userId = UserDTOHolder.getUser().getId();

        List<Cart> CartList = cartMapper.selectList(new QueryWrapper<Cart>()
                .eq("user_id", userId));

        return Result.ok(CartList);
    }

    @Override
    @Transactional
    public Result getCartTotalPrice() {
        Long userId = UserDTOHolder.getUser().getId();

        List<Cart> CartList = cartMapper.selectList(new QueryWrapper<Cart>()
                .eq("user_id", userId));

        double totalPrice = 0.00;

        for (Cart cartItem : CartList) {
            Food food = foodMapper.selectById(cartItem.getFoodId());
            totalPrice += food.getPrice() * cartItem.getQuantity();
        }

        return Result.ok(totalPrice);
    }

    @Override
    @Transactional
    public Result getDeliverFee(Long selectedAddrId, Long restaurantId) {

        /*1. get the selected latitude and longitude(Address)*/
        Address selectedAddr = addressMapper.selectById(selectedAddrId);

        /*2. get the restaurant latitude and longitude(Restaurant)*/
        Restaurant restaurant = restaurantMapper.selectById(restaurantId);

        Double distance = getDistance(
                selectedAddr.getLatitude(),
                selectedAddr.getLongitude(),
                restaurant.getLatitude(),
                restaurant.getLongitude()
        );

        return Result.ok(distance * DELIVER_FEE_PER_KM);
    }

    @Override
    public Result getRestaurantTotalPrice(Long restaurantId) {
        Long userId = UserDTOHolder.getUser().getId();

        List<Cart> CartList = cartMapper.selectList(new QueryWrapper<Cart>()
                .eq("user_id", userId)
                .eq("restaurant_id", restaurantId));

        double totalPrice = 0.00;

        for (Cart cartItem : CartList) {
            Food food = foodMapper.selectById(cartItem.getFoodId());
            totalPrice += food.getPrice() * cartItem.getQuantity();
        }

        return Result.ok(totalPrice);
    }

    public Double getDistance(double lat1, double lon1, double lat2, double lon2) {
        lat1 = Math.toRadians(lat1);
        lon1 = Math.toRadians(lon1);
        lat2 = Math.toRadians(lat2);
        lon2 = Math.toRadians(lon2);

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dLon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Calculate the result
        return EARTH_RADIUS_KM * c;
    }


}
