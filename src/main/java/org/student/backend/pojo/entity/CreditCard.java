package org.student.backend.pojo.entity;

import lombok.Data;

/**
 * @author Student
 */
@Data
public class CreditCard {

    private Long id;

    //card owner id
    private Long userId;

    private Long issuerId;

    private String cardNumber;

    private String cardType;

    private String password;

}
