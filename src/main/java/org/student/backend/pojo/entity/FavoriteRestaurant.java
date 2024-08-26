package org.student.backend.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Student
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteRestaurant {

    private Long id;
    private Long userId;
    private Long restaurantId;

}
