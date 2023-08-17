package com.demo_jpa_c04.repository;

import com.demo_jpa_c04.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepo extends CrudRepository<Category,Integer> {
}
