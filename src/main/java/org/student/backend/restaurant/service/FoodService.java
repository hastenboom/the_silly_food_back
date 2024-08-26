package org.student.backend.restaurant.service;

import org.springframework.stereotype.Service;
import org.student.backend.pojo.common.Result;

/**
 * @author Student
 */
@Service
public interface FoodService {
    Result getFoodByTypeAndCategory(Long restaurantId, String foodType, String foodCategory);

    Result getFoodById(Long foodId);
}
