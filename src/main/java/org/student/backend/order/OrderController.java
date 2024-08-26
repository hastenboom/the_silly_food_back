package org.student.backend.order;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.student.backend.order.service.OrderService;
import org.student.backend.pojo.common.Result;

/**
 * @author Student
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;


    //!! FIXME: the frontend data is not trusted, need to validate it first
    //!! But, I just leave a comment here
    @PostMapping
    public Result createOrder(@RequestBody OrderDTO orderDTO) {

        System.out.println(orderDTO);

        return orderService.createOrder(orderDTO);
    }

}
