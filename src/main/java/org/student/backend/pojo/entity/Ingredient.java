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
public class Ingredient {

    private Long id;

    private Long foodId;

    private String type;

    private String name;
}
