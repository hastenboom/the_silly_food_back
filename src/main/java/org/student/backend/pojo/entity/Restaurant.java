package org.student.backend.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


/**
 * @author Student
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

    private Long id;

//    private Long userId;

    private Long ownerId;

    @TableField("`name`")
    private String name;

    @TableField("`desc`")
    private String desc;

    private String address;

    private Double latitude;

    private Double longitude;

    private String type;

    private String phone;

    private String openingHours;

    private Integer numRating;

    private Double avgRating;

    //separator ","
    private String images;

    private LocalDateTime createdAt;

    /*lazy behavior*/
    private String foodCategories;
}
