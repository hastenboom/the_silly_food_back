package org.student.backend.restaurant.recommand_sys;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.student.backend.mapper.RestaurantMapper;
import org.student.backend.pojo.entity.Restaurant;
import org.student.backend.restaurant.RestaurantCardDTO;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author Student
 */
@Component
public class DefaultRestaurantRecommendSys implements RestaurantRecommendSys {

    @Resource
    private RestaurantMapper restaurantMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public List<RestaurantCardDTO> getTop5Restaurants() {

        QueryWrapper<Restaurant> wrapper = new QueryWrapper<Restaurant>()
                .select("id","opening_hours", "images", "`name`", "`desc`", "avg_rating","address")
                .orderByDesc("avg_rating")
                .last("LIMIT 5");

        List<Restaurant> restaurants = restaurantMapper.selectList(wrapper);

        List<RestaurantCardDTO> restaurantCardDTOList = restaurants.stream().map(
                restaurant -> BeanUtil.copyProperties(restaurant, RestaurantCardDTO.class)
        ).toList();

        return restaurantCardDTOList;
    }


    @Override
    public Predicate<?> defineAndGetBaseline() {
        return null;
    }

}
