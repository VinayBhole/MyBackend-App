package com.mybootproject.playground.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.mybootproject.playground.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	@Query("select p from Product p where p.category.id=?1")
	List<Product> getProductByCategoryId(Long cid);
	@Query("select p from Product p where p.vendor.id=?1")
	List<Product> getProductByVendorId(Long vid);
	@Transactional
	@Modifying
	@Query("delete from Product p where p.category.id=?1")
	void deleteProductByCategoryId(Long cid);

}