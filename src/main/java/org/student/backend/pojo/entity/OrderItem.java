package org.student.backend.pojo.entity;

import lombok.Data;

@Data
public class OrderItem {

    private Long id;

    private Long orderId;

    private Long foodId;

    private Integer quantity;

    private Double totalPrice;
}