package com.demo_jpa_c04.service.impl;

import com.demo_jpa_c04.model.Category;
import com.demo_jpa_c04.model.Product;
import com.demo_jpa_c04.repository.ICategoryRepo;
import com.demo_jpa_c04.repository.ProductRepo;
import com.demo_jpa_c04.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    ICategoryRepo iCategoryRepo;

    @Autowired
    ProductRepo productRepo;

    @Override
    public List<Product> getAll() {
        return (List<Product>) productRepo.findAll();
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Override
    public void edit(Product product) {
        productRepo.save(product);
    }

    @Override
    public void delete(int id) {
        productRepo.deleteById(id);
    }

    @Override
    public Product findById(int id) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if (optionalProduct.isPresent()){
            return optionalProduct.get();
        } else {
            return new Product();
        }
    }

    @Override
    public void save(Product product, int idCategory) {
        Category category = iCategoryRepo.findById(idCategory).get();
        product.setCategory(category);
        productRepo.save(product);
    }

    @Override
    public Product findByName(String name) {
        return productRepo.findByName(name);
    }

    @Override
    public Page<Product> getAll(Pageable pageable, String nameSearch) {
        return productRepo.getAllByNameHQL(nameSearch, pageable);
    }
}
