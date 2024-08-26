package org.student.backend.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Student
 */
@Data
@TableName("ordertofood")
public class OrderToFood {
    private Long id;
    private Long orderId;
    private Long foodId;
    private Integer quantity;
}
