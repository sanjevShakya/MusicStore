package com.sshakya.musicstore.dao.impl;

import com.sshakya.musicstore.dao.ProductDao;
import com.sshakya.musicstore.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * Created by sshakya on 7/9/16.
 */
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Product> getAllProducts() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product");
        List<Product> products = query.list();
        session.flush();
        return products;
    }

    public Product getByProductId(int id) throws IOException {
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product)session.get(Product.class,id);
        session.flush();
        return product;
    }

    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession(); //used as a singleton pattern
        session.saveOrUpdate(product);
        session.flush();
    }

    public void deleteProduct(int id) throws IOException {
        Session session = sessionFactory.getCurrentSession();
        session.delete(getByProductId(id));
        session.flush();
    }

    public void editProduct(Product product) {
        Session session = sessionFactory.getCurrentSession(); //used as a singleton pattern
        session.saveOrUpdate(product);
        session.flush();
    }
}
