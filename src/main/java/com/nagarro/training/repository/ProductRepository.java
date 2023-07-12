package com.nagarro.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nagarro.training.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	Product findByCode(String code);
	@Query("from Product where code like %:keyword% or name like %:keyword% or  brand like %:keyword% ORDER BY code,brand,name")
    List<Product> findByKeyword(@Param("keyword") String keyword);
}
