package org.student.backend.cart.service;

import org.student.backend.pojo.common.Result;

/**
 * @author Student
 */
public interface CartService {

    Result addOneFoodToCart(Long userId, Long restaurantId, Long foodId);

    Result getCartItemList();

    Result getCartTotalPrice();

    Result getDeliverFee(Long selectedAddrId, Long restaurantId);

    Result getRestaurantTotalPrice(Long restaurantId);
}
