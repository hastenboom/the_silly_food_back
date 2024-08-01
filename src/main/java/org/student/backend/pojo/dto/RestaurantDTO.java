package org.student.backend.pojo.dto;


import lombok.Data;

import java.util.List;

/**
 * @author Student
 */
@Data
public class RestaurantDTO {

    private String title;

    //separator ","
    private String images;

    private String description;

    private Long id;

}

