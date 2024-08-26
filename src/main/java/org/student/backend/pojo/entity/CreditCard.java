package org.student.backend.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("creditcard")
public class CreditCard {


    @TableId(type= IdType.AUTO)
    private Long id;

    //card owner id
    private Long userId;

    private Long issuerId;

    private String cardNumber;

    private String password;

    private Double balance;
}
