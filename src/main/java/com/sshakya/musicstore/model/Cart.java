package com.sshakya.musicstore.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sshakya on 7/18/16.
 */
public class Cart {
    private String cartId;
    private Map<String,CartItem> cartItem;
    private double grandTotal;

   public Cart(){
       cartItem= new HashMap<String, CartItem>();
       grandTotal=0;
   }
    public Cart(String cartId){
        this();
        this.cartId= cartId;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public Map<String, CartItem> getCartItem() {
        return cartItem;
    }

    public void setCartItem(Map<String, CartItem> cartItem) {
        this.cartItem = cartItem;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public void addCartItem(CartItem item){
        String productId=item.getProduct().getProductId();
        if(cartItem.containsKey(productId)){
            CartItem existingCartItem=cartItem.get(productId);
            existingCartItem.setQuantity((existingCartItem.getQuantity()+item.getQuantity()));
            cartItem.put(productId,existingCartItem);
        }else {
            cartItem.put(productId,item);
        }
        updateGrandTotal();

    }
    public void removeCartItem(CartItem item){
        String productId = item.getProduct().getProductId();
        cartItem.remove(productId);
        updateGrandTotal();
    }
    public void updateGrandTotal(){
        grandTotal=0;
        for(CartItem item:cartItem.values()){
            grandTotal= grandTotal+item.getTotalPrice();
        }
    }
}
