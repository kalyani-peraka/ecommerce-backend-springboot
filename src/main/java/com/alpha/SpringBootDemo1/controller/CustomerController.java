package com.alpha.SpringBootDemo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.SpringBootDemo1.Service.AdminService;
import com.alpha.SpringBootDemo1.Service.CustomerService;
import com.alpha.SpringBootDemo1.dto.CustomerDto;
import com.alpha.SpringBootDemo1.dto.ResponseStructure;
import com.alpha.SpringBootDemo1.entities.Address;
import com.alpha.SpringBootDemo1.entities.Customer;
import com.alpha.SpringBootDemo1.entities.Orders;
import com.alpha.SpringBootDemo1.entities.Product;
@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/customer/saveCustomer")
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody CustomerDto dto) {
		return customerService.saveCustomer(dto);
	}
	
	@PostMapping("/customer/addAddress")
	public ResponseEntity<ResponseStructure<Customer>> addAddress(@RequestParam long cmobileNo,@RequestBody Address add) {
		return customerService.addAddress(cmobileNo,add);
	}
	
	@DeleteMapping("/customer/deleteAddress")
	public ResponseEntity<ResponseStructure<Customer>> deleteAddress(@RequestParam long cmobileNo,@RequestParam long addmobileNo) {
		return customerService.deleteAddress(cmobileNo,addmobileNo);
	}
	
	
	@GetMapping("/customer/seeAllAvailableProducts")
	public ResponseEntity<ResponseStructure<List<Product>>> findByAvailabilityStatus(@RequestParam String availabilityStatus) {
		return customerService.findByAvailabilityStatus(availabilityStatus);
	}
	
	@GetMapping("/customer/findCustomer")
	public ResponseEntity<ResponseStructure<Customer>> findCustomer(@RequestParam long mobileNo) {
		return customerService.findCustomer(mobileNo);
	}
	
	@PostMapping("/customer/addProductToCart")
	public ResponseEntity<ResponseStructure<Customer>> addProductToCart(@RequestParam long cmobileNo,@RequestParam int id) {
		return customerService.addProductToCart(cmobileNo,id);
	}
	
	@GetMapping("/customer/seeCart")
	public ResponseEntity<ResponseStructure<List<Product>>> seeCart(@RequestParam long mobileNo) {
		return customerService.seeCart(mobileNo);
	}
	
	@PatchMapping("/customer/removeProductFromCart")
	public ResponseEntity<ResponseStructure<Customer>> removeProductFromCart(@RequestParam long cmobileNo,@RequestParam int pid) {
		return customerService.removeProductFromCart(cmobileNo,pid);
	}
	
	@PostMapping("/customer/placeOrder")
	public void placeOrder(@RequestParam long cmobileNo,@RequestParam int deliveryAddId) {
		customerService.placeOrder(cmobileNo,deliveryAddId);
	}
}
