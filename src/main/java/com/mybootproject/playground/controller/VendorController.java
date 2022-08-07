package com.mybootproject.playground.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mybootproject.playground.model.Vendor;
import com.mybootproject.playground.repository.VendorRepository;

@RestController
public class VendorController {
	@Autowired
	VendorRepository vendorRepository;

	
	@PostMapping("/vendor")
	public void insertVendor(@RequestBody Vendor vendor) {
		
		vendorRepository.save(vendor);
	}
	
	@GetMapping("/vendor")
	public List<Vendor> getAllVendor(){
	List<Vendor> list = vendorRepository.findAll();
	return list;

}
	@GetMapping("/vendor/one/{id}")
	public Vendor getVebdorById(@PathVariable("id") Long id) {
		Optional<Vendor> optional = vendorRepository.findById(id);
		if(!optional.isPresent())
			throw new RuntimeException("Invalid ID Given");
		Vendor c = optional.get();
		return c;
	}
	@DeleteMapping("/vendor/{id}")
	public void deleteVendor(@PathVariable("id") Long id) {
		vendorRepository.deleteById(id);
	}
	
	@PutMapping("/vendor/{id}")
	public Vendor editVendor(@PathVariable("id")Long id, @RequestBody Vendor newVendor) {
		Optional<Vendor> optional = vendorRepository.findById(id);
		if(!optional.isPresent())
			throw new RuntimeException("Invalid ID Given");
		Vendor oldVendor = optional.get();
		
		oldVendor.setName(newVendor.getName());
		oldVendor.setCity(newVendor.getCity());
		
		return vendorRepository.save(oldVendor);
	}
	
	@GetMapping("/vendor/city/{city}")
	public List<Vendor> getVendorByPref(@PathVariable("city") String city){
		List<Vendor> list = vendorRepository.getByCity(city);
		return list;
	}
}
