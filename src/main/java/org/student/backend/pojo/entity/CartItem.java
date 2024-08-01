package org.student.backend.pojo.entity;

import lombok.Data;

/**
 * @author Student
 */
@Data
public class CartItem {

    private Long id;
    private Long cartId;
    private Long foodId;
    private Integer quantity;

    // food price * quantity
    private Double price;

}
