package org.student.backend.order;

import lombok.Data;

import java.util.ArrayList;

/**
 * @author Student
 */
@Data
public class OrderDTO {
    Long restaurantId;
    ArrayList<Long> foodIds;
    ArrayList<Integer> quantities;
    Long addressId;
    Long creditCardId;
}
