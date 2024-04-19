package com.ecom.service;

import java.util.List;
import com.ecom.model.Product;

public interface CartService {
    void addToCart(int productId, int quantity);
    List<Product> getCartItems();
}
