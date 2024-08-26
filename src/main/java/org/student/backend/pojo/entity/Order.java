package org.student.backend.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;


/**
 * @author Student
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("`order`")
public class Order {

    /**
     * TODO: !IMPORTANT! The id field must be non-null and unique globally, the way it generated should consider the
     * redis.
     */
    @NonNull
    @TableId(type= IdType.AUTO)
    private Long id;

    private Long userId;

    private Long restaurantId;
    private Long addressId;

    @TableField("credit_card_id")
    private Long creditCardId;

    private Double totalAmount;
    private Double deliveryFee;

    @TableField("`status`")
    private String status;

//    private LocalDateTime createAt;
}
