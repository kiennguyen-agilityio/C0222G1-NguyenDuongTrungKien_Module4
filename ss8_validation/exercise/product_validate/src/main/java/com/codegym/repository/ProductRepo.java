package com.codegym.repository;


import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ProductRepo extends JpaRepository<Product, Integer> {
    @Query(value = "select * from product", nativeQuery = true)
    List<Product> findAllProduct();

    @Query(value = "select * from product", nativeQuery = true)
    Page<Product> findAllProductPage(Pageable pageable);

    @Modifying
    @Query(value = "update product set name=:name,price=:price,description=:description,producer=:producer where id=:id", nativeQuery = true)
    int update(@Param("name") String name,
               @Param("price") String price,
               @Param("description") String description,
               @Param("producer") String producer,
               @Param("id") Integer id);

    @Query(value = "select * from product where id=:id", nativeQuery = true)
    Product getProductById(@Param("id") Integer id);

    @Query(value = "delete from product where id=:id", nativeQuery = true)
    @Modifying
    void deleteProduct(@Param("id") Integer id);

    @Query(value = "select * from product where name like :name", nativeQuery = true)
    Page<Product> searchByProductName(@Param("name") String name, Pageable pageable);

}
