package org.student.backend.pojo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Student
 */
@Data
@NoArgsConstructor
public class FavoriteRestaurant {

    private Long id;

    private Long userId;
    private Long restaurantId;

}
