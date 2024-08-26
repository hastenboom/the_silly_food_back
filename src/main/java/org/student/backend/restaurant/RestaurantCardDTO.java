package org.student.backend.restaurant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Student
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantCardDTO {
    Long id;
    String openingHours;
    String images;
    String name;
    String desc;
    double avgRating;
    String address;
}
