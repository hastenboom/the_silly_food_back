package org.student.backend.restaurant;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.student.backend.pojo.common.Result;
import org.student.backend.restaurant.service.FoodService;
import org.student.backend.restaurant.service.RestaurantService;

/**
 * @author Student
 */
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Resource
    private RestaurantService restaurantService;

    @Resource
    private FoodService foodService;

    /*http://localhost:8080/restaurant/main/cards*/
    //TODO: consider the redis cache
    @GetMapping("/main/cards")
    public Result getMainCards() {
        return restaurantService.getMainCards();
    }


    @GetMapping("/{restaurant_id}")
    public Result getRestaurantById(@PathVariable("restaurant_id") Long restaurantId) {
        return restaurantService.getRestaurantById(restaurantId);
    }


    @GetMapping("/{restaurant_id}/food/{type}/{category}")
    public Result getRestaurantFood(@PathVariable("restaurant_id") Long restaurantId,
                                    @PathVariable("type") String foodType,
                                    @PathVariable("category") String foodCategory)
    {
        return foodService.getFoodByTypeAndCategory(restaurantId, foodType, foodCategory);
    }


}
