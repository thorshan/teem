package com.project.teem.demo.service.impl;

import com.project.teem.demo.models.Cart;
import com.project.teem.demo.repository.CartRepository;
import com.project.teem.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public long cartCount() {
        return cartRepository.count();
    }

    @Override
    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart getCardById(Long id) {
        return cartRepository.findById(id).get();
    }

    @Override
    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    public Cart updateCart(Cart cart) {
        return null;
    }
}
