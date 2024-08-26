package org.student.backend.restaurant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.student.backend.mapper.FoodMapper;
import org.student.backend.pojo.common.Result;
import org.student.backend.pojo.entity.Food;
import org.student.backend.restaurant.service.FoodService;

import java.util.List;

/**
 * @author Student
 */

@Service
public class FoodServiceImpl implements FoodService {
    @Resource
    private FoodMapper foodMapper;

    @Override
    public Result getFoodByTypeAndCategory(Long restaurantId, String foodType, String foodCategory) {

        QueryWrapper<Food> wrapper = new QueryWrapper<Food>();
        List<Food> foodList = null;
        if (!foodType.equals("All") && !foodCategory.equals("All")) {

            wrapper.eq("restaurant_id", restaurantId).
                    eq("type", foodType)
                    .eq("category", foodCategory);

            foodList = foodMapper.selectList(wrapper);
        }
        else if (!foodType.equals("All") && foodCategory.equals("All")) {
            wrapper.eq("restaurant_id", restaurantId).
                    eq("type", foodType);

            foodList = foodMapper.selectList(wrapper);
        }
        else if (foodType.equals("All") && !foodCategory.equals("All")) {
            wrapper.eq("restaurant_id", restaurantId).
                    eq("category", foodCategory);
            foodList = foodMapper.selectList(wrapper);
        }
        else {
            wrapper.eq("restaurant_id", restaurantId);
            foodList = foodMapper.selectList(wrapper);
        }

        return Result.ok(foodList);
    }

    @Override
    public Result getFoodById(Long foodId) {
        return Result.ok(foodMapper.selectById(foodId));
    }
}
