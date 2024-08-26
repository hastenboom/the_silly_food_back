package org.student.backend.cart;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.student.backend.cart.service.CartService;
import org.student.backend.pojo.common.Result;

/**
 * @author Student
 */
@RestController
@RequestMapping("/cart")
public class CartController {

    @Resource
    private CartService cartService;

    @PostMapping("/{userId}/add/{restaurantId}/{foodId}")
    public Result addOneFoodToCart(
            @PathVariable("userId") Long userId,
            @PathVariable("restaurantId") Long restaurantId,
            @PathVariable("foodId") Long foodId)
    {
        return cartService.addOneFoodToCart(userId, restaurantId, foodId);
    }

    @GetMapping("/itemList")
    public Result getCartItemList() {
        return cartService.getCartItemList();
    }

    @GetMapping("/totalPrice")
    public Result getCartTotalPrice() {
        return cartService.getCartTotalPrice();
    }


    @GetMapping("/deliverFee/{selectedAddrId}/{restaurantId}")
    public Result getDeliverFee(@PathVariable("selectedAddrId") Long selectedAddrId,
                                @PathVariable("restaurantId") Long restaurantId)
    {
        return cartService.getDeliverFee(selectedAddrId, restaurantId);
    }


}
