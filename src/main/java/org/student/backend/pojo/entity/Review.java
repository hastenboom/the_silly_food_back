package org.student.backend.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Student
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    private Long id;

    private Long restaurantId;
    private Long userId;

    private String title;
    private String content;
    private Integer rating;
}
