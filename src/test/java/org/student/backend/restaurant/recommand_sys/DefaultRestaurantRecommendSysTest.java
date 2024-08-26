package org.student.backend.restaurant.recommand_sys;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.student.backend.restaurant.RestaurantCardDTO;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class DefaultRestaurantRecommendSysTest {

    @Autowired
    private DefaultRestaurantRecommendSys recommendSys;


    @Test
    void getTop5Restaurants() {
        List<RestaurantCardDTO> top5Restaurants = recommendSys.getTop5Restaurants();
        top5Restaurants.forEach(System.out::println);
    }
}