package com.sshakya.musicstore.dao;

import com.sshakya.musicstore.model.Product;

import java.io.IOException;
import java.util.List;

/**
 * Created by sshakya on 7/9/16.
 */
public interface ProductDao {

    List<Product> getAllProducts();
    Product getByProductId(String id) throws IOException;
    void addProduct(Product product);
    void deleteProduct(String id) throws IOException ;
    void editProduct(Product product);
}
