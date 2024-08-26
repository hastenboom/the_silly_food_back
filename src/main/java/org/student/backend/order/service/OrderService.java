package org.student.backend.order.service;

import org.student.backend.order.OrderDTO;
import org.student.backend.pojo.common.Result;

/**
 * @author Student
 */
public interface OrderService {
    Result createOrder(OrderDTO orderDTO);
}
