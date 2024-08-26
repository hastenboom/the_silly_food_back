package org.student.backend.order.service;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.student.backend.cart.service.CartService;
import org.student.backend.login.UserDTOHolder;
import org.student.backend.mapper.OrderMapper;
import org.student.backend.mapper.OrderToFoodMapper;
import org.student.backend.order.OrderDTO;
import org.student.backend.pojo.common.Result;
import org.student.backend.pojo.entity.Order;
import org.student.backend.pojo.entity.OrderToFood;

/**
 * @author Student
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderToFoodMapper orderToFoodMapper;

    @Resource
    private CartService cartService;


    @Override
    @Transactional
    public Result createOrder(OrderDTO orderDTO) {

        Long userId = UserDTOHolder.getUser().getId();

        Order order = new Order();

//        order.setId(123L);
        order.setUserId(userId);
        order.setRestaurantId(orderDTO.getRestaurantId());
        order.setAddressId(orderDTO.getAddressId());
        order.setCreditCardId(orderDTO.getCreditCardId());

        Result restaurantTotalPrice = cartService.getRestaurantTotalPrice(orderDTO.getRestaurantId());
        Double totalAmount = (Double) restaurantTotalPrice.getData();
        order.setTotalAmount(totalAmount);

        Double deliverFee = (Double) cartService.getDeliverFee(
                orderDTO.getAddressId(),
                orderDTO.getRestaurantId()
        ).getData();
        order.setDeliveryFee(deliverFee);

        order.setStatus("Pending");

        /*insert 1*/
        orderMapper.insert(order);

        /*insert 2*/
        Long orderId = order.getId();
        for (int i = 0; i < orderDTO.getFoodIds().size(); i++) {
            Long foodId = orderDTO.getFoodIds().get(i);
            Integer foodQuantity = orderDTO.getQuantities().get(i);

            OrderToFood orderToFood = new OrderToFood();
            orderToFood.setOrderId(orderId);
            orderToFood.setFoodId(foodId);
            orderToFood.setQuantity(foodQuantity);

            orderToFoodMapper.insert(orderToFood);
        }

        return Result.ok();
    }


}

