package org.student.backend.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Student
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food {

    private Long id;

    private Long restaurantId;

    private String name;

    @TableField("`desc`")
    private String desc;

    private String images;

    private Double price;

    //>>>>> filter
    private String type;

    private String category;

    @TableField("is_available")
    private Integer isAvailable;
    //<<<<< filter

}
