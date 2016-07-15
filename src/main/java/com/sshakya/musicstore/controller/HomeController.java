package com.sshakya.musicstore.controller;

import com.sshakya.musicstore.model.Product;
import com.sshakya.musicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by sshakya on 7/9/16.
 */
@Controller
public class HomeController {
    private Path path;
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
    @RequestMapping("/admin")
    public String adminPage(){
        return "admin";
    }
    @RequestMapping("/admin/productInventory")
    public String productInventory(ModelMap model){
        List<Product> productList = productService.getAll();
        model.addAttribute("products",productList);
        return "productInventory";
    }
    @RequestMapping("/admin/productInventory/addProduct")
    public String addProduct(ModelMap map){
        Product product = new Product();
        product.setProductCategory("instrument");
        product.setProductCondition("new");
        product.setProductStatus("active");
        map.addAttribute("product",product);
        return "addProduct";
    }
    @RequestMapping(value = "/admin/productInventory/addProduct",method = RequestMethod.POST)
    public String addProductPost(@ModelAttribute("product")Product product, HttpServletRequest request){
        productService.addProduct(product);
        MultipartFile productImage = product.getProductImage();
        String rootDirectory =request.getSession().getServletContext().getRealPath("/");
        path= Paths.get(rootDirectory+"//WEB-INF//resources//images//"+product.getProductId()+".png");
        if(productImage!=null && !productImage.isEmpty()){
            try{
                productImage.transferTo(new File(path.toString()));
            }catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed",e);

            }
        }

        return "redirect:/admin/productInventory";

    }

    @RequestMapping("/admin/productInventory/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id,ModelMap map) throws IOException {
        productService.deleteProduct(id);
        return "redirect:/admin/productInventory";
    }
}
