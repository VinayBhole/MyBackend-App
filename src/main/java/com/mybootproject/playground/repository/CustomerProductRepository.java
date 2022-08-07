package com.mybootproject.playground.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mybootproject.playground.model.Customer;
import com.mybootproject.playground.model.CustomerProduct;
import com.mybootproject.playground.model.Product;

public interface CustomerProductRepository extends JpaRepository<CustomerProduct, Long>{
	@Query("select cp.customer from CustomerProduct cp where cp.product.id=?1")
	List<Customer> getCustomerByProduct(Long pid);

	@Query("select cp.product from CustomerProduct cp where cp.customer.id=?1")
	List<Product> getProductByCustomerId(Long cid);

	@Query("select cp.customer from CustomerProduct cp where cp.product.vendor.id=?1")
	List<Customer> getCustomerByVendorId(Long vid);
}