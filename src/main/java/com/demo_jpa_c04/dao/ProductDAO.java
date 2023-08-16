package com.demo_jpa_c04.dao;

import com.demo_jpa_c04.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class ProductDAO {
    @PersistenceContext
    EntityManager entityManager;


    public List<Product> getAll(){
        return entityManager.createQuery("from Product", Product.class).getResultList();
    }

    public void save(Product product){
        entityManager.persist(product);
    }

    public void edit(Product product){
        entityManager.merge(product);
    }

    public void delete(Product product){
        entityManager.remove(product);
    }

    public Product findById(int id){
        return entityManager.find(Product.class,id);
    }
}
