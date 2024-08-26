package org.student.backend.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Student
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {

    private Long id;
    private Long cartId;
    private Long foodId;
    private Integer quantity;

    // food price * quantity
    private Double price;

}
