package org.student.backend.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Student
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("cart")
public class Cart {

    @TableId
    private Long id;

    private Long userId;

    private Long restaurantId;

    private Long foodId;

    private Integer quantity;

}
