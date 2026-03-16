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

	import com.alpha.SpringBootDemo1.dto.AdminDto;
import com.alpha.SpringBootDemo1.dto.CarrierDto;
import com.alpha.SpringBootDemo1.dto.ProductDto;
import com.alpha.SpringBootDemo1.dto.ResponseStructure;
	import com.alpha.SpringBootDemo1.Service.AdminService;
import com.alpha.SpringBootDemo1.entities.Address;
import com.alpha.SpringBootDemo1.entities.Admin;
import com.alpha.SpringBootDemo1.entities.Carrier;
import com.alpha.SpringBootDemo1.entities.Orders;
import com.alpha.SpringBootDemo1.entities.Product;

	@RestController
		public class AdminController {
		@Autowired
		AdminService adminService;
		@PostMapping("/Admin/saveadmin")
		public ResponseEntity<ResponseStructure<Admin>> saveadmin(@RequestBody AdminDto a) {
			return adminService.saveadmin(a);
		}
			
		
		@PostMapping("/Admin/addNewAddress")
		public ResponseEntity<ResponseStructure<Admin>> addAddress(@RequestParam long mobileNo,@RequestBody Address a) {
			return adminService.addAddress(mobileNo,a);
		}	
		
			
		@DeleteMapping("/admin/deleteAdmin")
		public ResponseEntity<ResponseStructure<AdminDto>> deleteAdmin(@RequestParam long mobileNo) {
			return adminService.deleteAdmin(mobileNo);
		}
		
		
		@DeleteMapping("/admin/deleteAdminAddress")
		public ResponseEntity<ResponseStructure<Admin>> deleteAdminAddress(@RequestParam long amobileNo,@RequestParam long addmobileNo){
			return adminService.deleteAdminAddress(amobileNo,addmobileNo);
		}
		
			
		@PostMapping("/Admin/saveCarrier")
		public ResponseEntity<ResponseStructure<Carrier>> saveCarrier(@RequestBody CarrierDto c) {
			return adminService.saveCarrier(c);
		}
		
		
		@PostMapping("/admin/findCarrier")
		public ResponseEntity<ResponseStructure<CarrierDto>> findCarrier(@RequestParam long mobNo){
			return adminService.findcarrier(mobNo);
		}
			
		
		@DeleteMapping("/admin/deleteCarrier")
		public ResponseEntity<ResponseStructure<CarrierDto>> deleteCarrier(@RequestParam long mobileNo){
			return adminService.deleteCarrier(mobileNo);
		}
		
		@PostMapping("/admin/addNewProduct")
		public ResponseEntity<ResponseStructure<Product>> addNewProduct(@RequestBody ProductDto p) {
			return adminService.saveproduct(p);
		}
		
		
		@PatchMapping("/admin/updateOrder/assignCarrier")
		public ResponseEntity<ResponseStructure<Orders>> assignCarrier(@RequestParam int orderId,@RequestParam long carriermobileNo,@RequestParam int addressId) {
			return adminService.assignCarrier(orderId,carriermobileNo,addressId);
		}
		
		
		@GetMapping("/admin/seeAllCarrier")
		public ResponseEntity<ResponseStructure<List<Carrier>>> seeAllCarrier() {
			return adminService.seeAllCarrier();
		}
		
		}

	