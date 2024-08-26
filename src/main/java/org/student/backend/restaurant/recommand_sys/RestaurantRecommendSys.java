package org.student.backend.restaurant.recommand_sys;

import org.springframework.stereotype.Component;
import org.student.backend.restaurant.RestaurantCardDTO;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author Student
 */
public interface RestaurantRecommendSys {

    List<RestaurantCardDTO> getTop5Restaurants();

    Predicate<?> defineAndGetBaseline();
}
