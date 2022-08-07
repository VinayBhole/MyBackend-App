package com.mybootproject.playground.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mybootproject.playground.model.Customer;
import com.mybootproject.playground.model.CustomerProduct;
import com.mybootproject.playground.model.Product;
import com.mybootproject.playground.repository.CustomerProductRepository;
import com.mybootproject.playground.repository.CustomerRepository;
import com.mybootproject.playground.repository.ProductRepository;

@RestController
public class CustomerProductController {
	@Autowired
	CustomerProductRepository  customerProductRepository ;
	@Autowired
	CustomerRepository  customerRepository ;
	@Autowired
	ProductRepository  productRepository ;
	
	@PostMapping("/purchase/customer/product/{cid}/{pid}")
	public CustomerProduct purchaseAPI(@RequestBody CustomerProduct customerProduct,
			@PathVariable("cid")Long cid,@PathVariable("pid")Long pid)
	{
		Optional<Customer> optionalC=customerRepository.findById(cid);
		if(!optionalC.isPresent())
			throw new RuntimeException("category id is invalid");
		Customer customer=optionalC.get();
		
		Optional<Product> optionalP=productRepository.findById(pid);
		if(!optionalP.isPresent())
			throw new RuntimeException("product id is invalid");
		Product product=optionalP.get();
		customerProduct.setProduct(product);
		customerProduct.setCustomer(customer);
		customerProduct.setDateOfPurchase(LocalDate.now());
		return customerProductRepository.save(customerProduct);
		

     }
	
	@GetMapping("/customer/product/{pid}")
	public List<Customer> getCustomerByProduct(@PathVariable("pid") Long pid){
		List<Customer> list = customerProductRepository.getCustomerByProduct(pid);
		return list;
	}
	
	@GetMapping("/product/customer/{cid}")
	  public List<Product> getProductByCustomerId(@PathVariable("cid") Long cid){
		  List<Product> list=customerProductRepository.getProductByCustomerId(cid);
		  return list;
	  }
	
	@GetMapping("/customer/vendor/{vid}")
	  public List<Customer> getCustomerByVendorId(@PathVariable("vid") Long vid)
	  { 
		  
		  List<Customer> list= customerProductRepository.getCustomerByVendorId(vid);
		  return list;
		  
	  }
	
}