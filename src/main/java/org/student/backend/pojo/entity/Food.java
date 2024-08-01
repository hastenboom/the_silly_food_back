package org.student.backend.pojo.entity;

import lombok.Data;

/**
 * @author Student
 */
@Data
public class Food {

    private Long id;

    private Long restaurantId;

    private String name;

    private String desc;

    private String images;

    private Double price;

    private Boolean isAvailable;

    private Boolean isVeg;

    private Boolean isSeasonal;

}
