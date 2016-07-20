package com.sshakya.musicstore.dao.impl;

import com.sshakya.musicstore.dao.CartDao;
import com.sshakya.musicstore.model.Cart;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by sshakya on 7/18/16.
 */
@Repository
public class CartDaoImpl implements CartDao {

    private Map<String,Cart> listOfCart;

    public CartDaoImpl(){
        listOfCart = new HashMap<String, Cart>();
    }

    public Cart create(Cart cart) {
        if(listOfCart.keySet().contains(cart.getCartId())){
            throw new IllegalArgumentException(String.format("Cannot create a cart. A cart with the given id(%)" +
                    "already" +
                    "exists ",cart.getCartId()));

        }
        listOfCart.put(cart.getCartId(),cart);
        return cart;

    }

    public Cart read(String cartId) {
        return listOfCart.get(cartId);
    }

    public void update(String cartId,Cart cart) {
        if(!listOfCart.keySet().contains(cartId)){
            throw new IllegalArgumentException(String.format("Cannot update cart. The cart with the given id(%) does not exists" ,cart.getCartId()));
        }
        listOfCart.put(cartId,cart);

    }

    public void delete(String cartId) {
        if(!listOfCart.keySet().contains(cartId)){
            throw new IllegalArgumentException(String.format("Cannot delete cart. The cart with the given id(%) does not exist" ,cartId));
        }
        listOfCart.remove(cartId);
    }
}
