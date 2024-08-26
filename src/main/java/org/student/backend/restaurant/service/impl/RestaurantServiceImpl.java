package org.student.backend.restaurant.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.student.backend.mapper.RestaurantMapper;
import org.student.backend.pojo.common.Result;
import org.student.backend.restaurant.recommand_sys.RestaurantRecommendSys;
import org.student.backend.restaurant.service.RestaurantService;

/**
 * @author Student
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Resource
    private RestaurantRecommendSys restaurantRecommendSys;


    @Resource
    private RestaurantMapper restaurantMapper;

    @Override
    public Result getMainCards() {
        return Result.ok(restaurantRecommendSys.getTop5Restaurants());
    }

    @Override
    public Result getRestaurantById(Long restaurantId) {
        return Result.ok(restaurantMapper.selectById(restaurantId));
    }
}
