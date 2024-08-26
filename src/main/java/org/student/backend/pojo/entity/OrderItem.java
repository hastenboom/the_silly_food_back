package org.student.backend.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    private Long id;

    private Long orderId;

    private Long foodId;

    private Integer quantity;

    private Double totalPrice;
}