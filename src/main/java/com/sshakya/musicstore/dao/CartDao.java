package com.sshakya.musicstore.dao;

import com.sshakya.musicstore.model.Cart;

/**
 * Created by sshakya on 7/18/16.
 */
public interface CartDao {
    Cart create (Cart cart);
    Cart read(String cartId);
    void update(String cartId, Cart cart);
    void delete(String cartId);
}

