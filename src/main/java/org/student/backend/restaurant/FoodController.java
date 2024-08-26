package org.student.backend.restaurant;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.student.backend.pojo.common.Result;
import org.student.backend.restaurant.service.FoodService;

/**
 * @author Student
 */
@RestController
@RequestMapping("/food")
public class FoodController {

    @Resource
    private FoodService foodService;

    @RequestMapping("/{foodId}")
    public Result getFoodById(@PathVariable("foodId") Long foodId) {
        return foodService.getFoodById(foodId);
    }
}
