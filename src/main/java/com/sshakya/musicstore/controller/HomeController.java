package com.sshakya.musicstore.controller;

import com.sshakya.musicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

/**
 * Created by sshakya on 7/9/16.
 */
@Controller
public class HomeController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String home(){
        return "home";
    }
    @RequestMapping("/productList")
    public String getProducts(ModelMap model){
        model.addAttribute("products",productService.getAll());
        return "productList";
    }
    @RequestMapping("/productList/viewProduct/{productId}")
    public String viewProduct(@PathVariable int productId,ModelMap model)throws IOException{
        model.addAttribute(productService.getById(productId));
        return "viewProduct";
    }
}
