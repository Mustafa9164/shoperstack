package com.jsp.prc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.jsp.prc.entity.Product;

import jakarta.transaction.Transactional;

public interface ProductRepo extends JpaRepository<Product, Integer>{
	@Transactional
	@Modifying
	@Query(value = "UPDATE Product p SET p.productPrice=?2 "
			+ "WHERE " + "p.productId = ?1")
	void updateProductPrice(Integer productId, Double productPrice);
}
