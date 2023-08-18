package com.demo_jpa_c04.repository;

import com.demo_jpa_c04.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepo extends PagingAndSortingRepository<Product,Integer> {
    List<Product> findAllByCategoryId(int id);

    Product findByName(String name);

    @Query(value = "select p from Product p where p.name like concat('%',:name,'%')")
    Page<Product> getAllByNameHQL(@Param("name") String name, Pageable pageable);

    @Query(nativeQuery = true, value = "select * from product  where name like concat('%',:name,'%')")
    List<Product> getAllByNameSQL(@Param("name") String name);



}
