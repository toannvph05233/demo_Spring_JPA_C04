package com.demo_jpa_c04.service;

import com.demo_jpa_c04.model.Product;

import java.util.List;

public interface IService<E> {
    List<E> getAll();
    void save(E e);
    void edit(E e);
    void delete(int id);
    E findById(int id);
}
