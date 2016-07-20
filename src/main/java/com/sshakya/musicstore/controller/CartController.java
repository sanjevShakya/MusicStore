package com.sshakya.musicstore.controller;

import com.sshakya.musicstore.model.Cart;
import com.sshakya.musicstore.model.CartItem;
import com.sshakya.musicstore.model.Product;
import com.sshakya.musicstore.service.CartService;
import com.sshakya.musicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by sshakya on 7/18/16.
 */
@Controller
@RequestMapping("/rest/cart")
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/{cartId}",method = RequestMethod.GET)
    public @ResponseBody Cart read(@PathVariable(value = "cartId")String cartId){
        return cartService.read(cartId);
    }


    @RequestMapping(value = "/{cartId}",method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable (value = "cartId")String cartId,@RequestBody Cart cart){
        cartService.update(cartId,cart);

    }

    @RequestMapping(value = "/{cartId}",method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "cartId")String cartId){
        cartService.delete(cartId);
    }

    @RequestMapping(value = "/add/{productId}",method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable (value = "productId")String productId, HttpServletRequest request) throws IOException {
        String sessionId=request.getSession(true).getId();
        Cart cart =cartService.read(sessionId);
        if(cart==null){
            cart = cartService.create(new Cart(sessionId));

        }
        Product product=productService.getById(productId);
        if(product==null){
            throw new IllegalArgumentException(new Exception());
        }
        cart.addCartItem(new CartItem(product));
        cartService.update(sessionId,cart);

    }

    @RequestMapping(value = "/remove/{productId}",method = RequestMethod.PUT)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable(value ="productId")String productId,HttpServletRequest request) throws IOException {
        String sessionId=request.getSession(true).getId();
        Cart cart =cartService.read(sessionId);
        if(cart==null){
            cart = cartService.create(new Cart(sessionId));

        }
        Product product=productService.getById(productId);
        if(product==null){
            throw new IllegalArgumentException(new Exception());
        }
        cart.removeCartItem(new CartItem(product));
        cartService.update(sessionId,cart);

    }
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "Illegal request, Please verify your payload")
    public void handleClientErrors(Exception e){

    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR,reason = "Internal Server Error")
    public void handleServerErrors(Exception e){

    }

}
