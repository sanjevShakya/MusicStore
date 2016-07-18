package com.sshakya.musicstore.service;

import com.sshakya.musicstore.dao.CartDao;
import com.sshakya.musicstore.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sshakya on 7/18/16.
 */
@Service
public class CartService {
    @Autowired
    private CartDao cartDao;

    public Cart create (Cart cart){
       return cartDao.create(cart);
    }
    public Cart read(String cartId){
        return cartDao.read(cartId);
    }
    public void update(String cartId, Cart cart){
        cartDao.update(cartId,cart);
    }
    public void delete(String cartId){
        cartDao.delete(cartId);
    }
}
