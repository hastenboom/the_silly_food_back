package org.student.backend.cart;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Student
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardDTO {

    @TableId(type= IdType.AUTO)
    private Long id;

    //card owner id
    private Long userId;

    private Long issuerId;

    private String issuerName;

    private String issuerLogoUrl;

    private String cardNumber;
}
