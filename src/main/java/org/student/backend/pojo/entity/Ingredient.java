package org.student.backend.pojo.entity;

import lombok.Data;

/**
 * @author Student
 */
@Data
public class Ingredient {

    private Long id;

    private Long foodId;

    private String name;
}
