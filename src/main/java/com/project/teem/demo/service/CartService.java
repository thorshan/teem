package com.project.teem.demo.service;

import com.project.teem.demo.models.Cart;

import java.util.List;

public interface CartService {

    List<Cart> getAllCarts();

    long cartCount();

    Cart saveCart(Cart cart);

    Cart getCardById(Long id);

    void deleteCart(Long id);

    Cart updateCart(Cart cart);
}
