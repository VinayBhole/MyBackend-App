package com.mybootproject.playground.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mybootproject.playground.model.Category;
import com.mybootproject.playground.model.Product;
import com.mybootproject.playground.model.Vendor;
import com.mybootproject.playground.repository.CategoryRepository;
import com.mybootproject.playground.repository.ProductRepository;
import com.mybootproject.playground.repository.VendorRepository;


@RestController
public class ProductController {
	
	
	@Autowired
	private ProductRepository productRepository;
               
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private VendorRepository vendorRepository;
	
	@PostMapping("/product/{cid}/{vid}")
	public Product postProduct(@RequestBody Product product,
			                 @PathVariable("cid") long cid,
			                 @PathVariable("vid") long vid) {
		
		   Optional<Category> optionalC =categoryRepository.findById(cid);
		    
		   if(!optionalC.isPresent())
			   throw new RuntimeException("cid not valid");
		   
		   Category category=optionalC.get();
		   
		   Optional<Vendor> optionalV =vendorRepository.findById(vid);
		    
		   if(!optionalV.isPresent())
			   throw new RuntimeException("vid not valid");
		   
		   Vendor vendor=optionalV.get();
		   
		   product.setCategory(category);
		   product.setVendor(vendor);
          
		   
		  return  productRepository.save(product);
		   
	}
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	@GetMapping("/product/category/{cid}")
	public List<Product> getProductByCategoryId(@PathVariable("cid") Long cid){
		Optional<Category> optionalC =categoryRepository.findById(cid);
	    
		   if(!optionalC.isPresent())
			   throw new RuntimeException("cid not valid");
		   
		   List<Product> list = productRepository.getProductByCategoryId(cid);
		   return list;
	}
	@GetMapping("/product/vendor/{vid}")
	public List<Product> getProductByVendorId(@PathVariable("vid") Long vid){
		Optional<Vendor> optionalV =vendorRepository.findById(vid);
	    
		   if(!optionalV.isPresent())
			   throw new RuntimeException("vid not valid");
		   
		   List<Product> list = productRepository.getProductByVendorId(vid);
		   return list;
		
	}
	
	@DeleteMapping("/product/category/{cid}")
	public void deleteProductByCategoryId(@PathVariable("cid")Long cid) {
		Optional<Category> optionalC =categoryRepository.findById(cid);
	    
		   if(!optionalC.isPresent())
			   throw new RuntimeException("cid not valid");
		   
		   productRepository.deleteProductByCategoryId(cid);
	}
		
	
	
}