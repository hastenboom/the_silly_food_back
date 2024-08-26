package org.student.backend.restaurant.service;

import org.student.backend.pojo.common.Result;

/**
 * @author Student
 */
public interface RestaurantService {
    Result getMainCards();

    Result getRestaurantById(Long restaurantId);
}
