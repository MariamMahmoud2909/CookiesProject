package com.CartService.controller;

import com.CartService.model.Cart;
import com.CartService.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Cart>> getUserCart(@PathVariable int userId) {
        List<Cart> cart = cartService.getUserCart(userId);
        return ResponseEntity.ok(cart);
    }

    @PostMapping("/AddToCart")
    public ResponseEntity<Cart> addItemToCart(@RequestBody Cart cartItem) {
        Cart addedItem = cartService.addItemToCart(cartItem);
        return ResponseEntity.ok(addedItem);
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<Void> removeItemFromCart(@PathVariable int cartId) {
        cartService.removeItemFromCart(cartId);
        return ResponseEntity.noContent().build();
    }

}
