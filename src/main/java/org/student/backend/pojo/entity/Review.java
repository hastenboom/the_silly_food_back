package org.student.backend.pojo.entity;

import lombok.Data;

/**
 * @author Student
 */
@Data
public class Review {
    private Long id;

    private Long restaurantId;
    private Long userId;

    private String title;
    private String content;
    private Integer rating;
}
