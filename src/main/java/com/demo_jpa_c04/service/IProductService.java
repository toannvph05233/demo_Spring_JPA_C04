package com.demo_jpa_c04.service;

import com.demo_jpa_c04.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService extends IService<Product> {
    void save(Product product, int idCategory);
    Page<Product> getAll(Pageable pageable);
}
