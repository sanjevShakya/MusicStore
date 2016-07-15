package com.sshakya.musicstore.service;

import com.sshakya.musicstore.dao.ProductDao;
import com.sshakya.musicstore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by sshakya on 7/9/16.
 */
@Service
public class ProductService {
    @Autowired
    ProductDao productDao;
    public List<Product> getAll(){
        return productDao.getAllProducts();
    }

    public Product getById(int id) throws IOException{
        return productDao.getByProductId(id);
    }
    public void addProduct(Product product){
        productDao.addProduct(product);
    }

    public void deleteProduct(int id) throws IOException{
        productDao.deleteProduct(id);
    }
}
