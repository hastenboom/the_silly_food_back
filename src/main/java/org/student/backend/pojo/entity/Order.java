package org.student.backend.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.student.backend.pojo.enumeration.ORDER_STATUS;

import java.time.LocalDateTime;

/**
 * @author Student
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    /**
     * TODO: !IMPORTANT! The id field must be non-null and unique globally, the way it generated should consider the
     * redis.
     */
    @NonNull
    private Long id;

    private Long userId;

    private Long restaurantId;

    private Long deliveryAddressId;

    private Long totalAmount;

    private String orderStatus;

    private LocalDateTime createAt;

    private int totalItem;

    private int totalPrice;

    private ORDER_STATUS status;
}
