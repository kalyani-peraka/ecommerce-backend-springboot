package com.alpha.SpringBootDemo1.Service;
	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.stereotype.Service;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;

	import com.alpha.SpringBootDemo1.dto.AdminDto;
import com.alpha.SpringBootDemo1.dto.CarrierDto;
import com.alpha.SpringBootDemo1.dto.ProductDto;
import com.alpha.SpringBootDemo1.dto.ResponseStructure;
import com.alpha.SpringBootDemo1.Repository.AddressRepository;
import com.alpha.SpringBootDemo1.Repository.AdminRepository;
import com.alpha.SpringBootDemo1.Repository.CarrierRepository;
import com.alpha.SpringBootDemo1.Repository.OrderRepository;
import com.alpha.SpringBootDemo1.Repository.ProductRepository;
import com.alpha.SpringBootDemo1.entities.Address;
import com.alpha.SpringBootDemo1.entities.Admin;
import com.alpha.SpringBootDemo1.entities.Carrier;
import com.alpha.SpringBootDemo1.entities.Orders;
import com.alpha.SpringBootDemo1.entities.Product;
import com.alpha.SpringBootDemo1.exception.AddressNotFound;
import com.alpha.SpringBootDemo1.exception.AdminNotFound;
import com.alpha.SpringBootDemo1.exception.CarrierDoesNotHaveCapacity;
import com.alpha.SpringBootDemo1.exception.CarrierNotFound;
import com.alpha.SpringBootDemo1.exception.OrderDeliveredOrCancelled;
import com.alpha.SpringBootDemo1.exception.OrderNotFound;
	@Service
	public class AdminService {
	
		
		@Autowired
		private AdminRepository adminRepository;

		@Autowired
		private CarrierRepository carrierRepository;

		@Autowired
		private AddressRepository addressRepository;

		@Autowired
		private ProductRepository productRepository;	
			
		@Autowired
		private OrderRepository orderRepository;
       
		
		public ResponseEntity<ResponseStructure<Admin>> saveadmin(AdminDto a) {
			Admin admin=new Admin();
			admin.setName(a.getName());
			admin.setMobileNo(a.getMobNo());
			admin.setMail(a.getMail());
			 adminRepository.save(admin);
			 ResponseStructure<Admin> rs=new ResponseStructure<Admin>();
				rs.setStatuscode(HttpStatus.CREATED.value());
				rs.setMessage("Admin with details has been saved");
				rs.setData(admin);
				return new ResponseEntity<ResponseStructure<Admin>>(rs,HttpStatus.CREATED);
		}


		public ResponseEntity<ResponseStructure<Admin>> addAddress(long mobileNo, Address a) {
			Admin admin=adminRepository.findByMobileNo(mobileNo).orElseThrow(()->new AdminNotFound());
			admin.getAlist().add(a);
			addressRepository.save(a);
			ResponseStructure<Admin> rs=new ResponseStructure<Admin>();
			rs.setStatuscode(HttpStatus.CREATED.value());
			rs.setMessage("Admin with mobileNo of"+mobileNo+"Address has been added");
			rs.setData(admin);
			return new ResponseEntity<ResponseStructure<Admin>>(rs,HttpStatus.CREATED);
		}


		public ResponseEntity<ResponseStructure<Carrier>> saveCarrier(CarrierDto c) {
				Carrier c1=new Carrier();
				c1.setName(c.getName());
				c1.setMobileNo(c.getMobNo());
				c1.setMailId(c.getMailId());
				carrierRepository.save(c1);
				ResponseStructure<Carrier> rs=new ResponseStructure<Carrier>();
				rs.setStatuscode(HttpStatus.CREATED.value());
				rs.setMessage("Carrier with details has been saved");
				rs.setData(c1);
				return new ResponseEntity<ResponseStructure<Carrier>>(rs,HttpStatus.CREATED);
			}


		public ResponseEntity<ResponseStructure<AdminDto>> deleteAdmin(long mobileNo) {
				Admin admin=adminRepository.findByMobileNo(mobileNo).orElseThrow(()->new AdminNotFound());
				AdminDto dto=new AdminDto();
				dto.setName(admin.getName());
				dto.setMobNo(admin.getMobileNo());
				dto.setMail(admin.getMail());
				adminRepository.delete(admin);
				ResponseStructure<AdminDto> rs=new ResponseStructure<AdminDto>();
				rs.setStatuscode(HttpStatus.FOUND.value());
				rs.setMessage("ADMIN WITH MOBILENO"+mobileNo+"HAS BEEN DELETED");
				rs.setData(dto);
				return new ResponseEntity<ResponseStructure<AdminDto>>(rs,HttpStatus.FOUND);
			}
		public ResponseEntity<ResponseStructure<Admin>> deleteAdminAddress(long amobileNo, long addmobileNo) {
			Admin admin=adminRepository.findByMobileNo(amobileNo).orElseThrow(()->new AdminNotFound());
			Address address=addressRepository.findByMobileNo(addmobileNo).orElseThrow(()->new AddressNotFound());
			admin.getLadd().remove(address);
			adminRepository.save(admin);
			ResponseStructure<Admin> rs=new ResponseStructure<Admin>();
			rs.setStatuscode(HttpStatus.FOUND.value());
			rs.setMessage("ADMIN WITH MOBILENO"+amobileNo+"AND ADDRESS WITH MOBILENO"+addmobileNo+"HAS BEEN REMOVED");
			rs.setData(admin);
			return new ResponseEntity<ResponseStructure<Admin>>(rs,HttpStatus.FOUND);
		}

		public ResponseEntity<ResponseStructure<Product>> saveproduct(ProductDto dto) {
				Product product=new Product();
				product.setName(dto.getName());
				product.setQuantity(dto.getQuantity());
				product.setCatagory(dto.getCatagory());
				product.setPricePerUnit(dto.getPricePerUnit());
				product.setBrandName(dto.getBrandName());
				product.setDescription(dto.getDescription());
				productRepository.save(product);
				ResponseStructure<Product> rs=new ResponseStructure<Product>();
				rs.setStatuscode(HttpStatus.CREATED.value());
				rs.setMessage("Product details has been saved");
				rs.setData(product);
				return new ResponseEntity<ResponseStructure<Product>>(rs,HttpStatus.CREATED);
			}


		public ResponseEntity<ResponseStructure<CarrierDto>> findcarrier(long mobNo) {
				 Carrier carrier = carrierRepository.findByMobileNo(mobNo).orElseThrow(() -> new CarrierNotFound());
				 CarrierDto dto = new CarrierDto();
				    dto.setName(carrier.getName());
				    dto.setMobNo(carrier.getMobileNo());
				    dto.setMailId(carrier.getMailId());
				    ResponseStructure<CarrierDto> rs = new ResponseStructure<>();
				    rs.setStatuscode(HttpStatus.OK.value());
				    rs.setMessage("CARRIER FOUND WITH MOBILE NO " + mobNo);
				    rs.setData(dto);
				return new ResponseEntity<ResponseStructure<CarrierDto>>(rs,HttpStatus.OK);
			}


		public ResponseEntity<ResponseStructure<CarrierDto>> deleteCarrier(long mobileNo) {
				// TODO Auto-generated method stub
				Carrier c=carrierRepository.findByMobileNo(mobileNo).orElseThrow(()->new CarrierNotFound());
				CarrierDto dto=new CarrierDto();
				dto.setName(c.getName());
				dto.setMobNo(c.getMobileNo());
				dto.setMailId(c.getMailId());
				carrierRepository.delete(c);
				ResponseStructure<CarrierDto> rs=new ResponseStructure<CarrierDto>();
				rs.setStatuscode(HttpStatus.FOUND.value());
				rs.setMessage("CARRIER WITH MOBILENO"+mobileNo+"HAS BEEN DELETED");
				rs.setData(dto);
				return new ResponseEntity<ResponseStructure<CarrierDto>>(rs,HttpStatus.FOUND);
				
			}


		public ResponseEntity<ResponseStructure<Orders>> assignCarrier(int orderId, long carriermobileNo,int addressId) {
				Orders orders=orderRepository.findById(orderId).orElseThrow(()->new OrderNotFound());
				Address address=addressRepository.findById(addressId).orElseThrow(()->new AddressNotFound());
				Carrier carrier=carrierRepository.findByMobileNo(carriermobileNo).orElseThrow(()->new CarrierNotFound());
				
				if(orders.getOrderStatus()=="Delivered" && orders.getOrderStatus()=="Cancelled") {
					throw new OrderDeliveredOrCancelled();
				}
				if(carrier.getCapacity()==0) {
					throw new CarrierDoesNotHaveCapacity();
				}
				carrier.setCapacity(carrier.getCapacity()-1);
				orders.setCarrier(carrier);
				orders.setOrderStatus("Confirmed");
				orders.setPickupLocation(address);
				orderRepository.save(orders);
				carrier.setOlist((List<Orders>) orders);
				carrierRepository.save(carrier);
				ResponseStructure<Orders> rs=new ResponseStructure<Orders>();
				rs.setStatuscode(HttpStatus.FOUND.value());
				rs.setMessage("Order with"+orderId+"has been assigned to carrier"+carriermobileNo);
				rs.setData(orders);
				return new ResponseEntity<ResponseStructure<Orders>>(rs,HttpStatus.FOUND);
			}


		public ResponseEntity<ResponseStructure<List<Carrier>>> seeAllCarrier() {
				List<Carrier> carrier=carrierRepository.findAll();
				if(carrier.isEmpty()) {
					throw new CarrierNotFound();
				}
				ResponseStructure<List<Carrier>> rs=new ResponseStructure<List<Carrier>>();
				rs.setStatuscode(HttpStatus.FOUND.value());
				rs.setMessage("Carrier LIST has been displayes");
				rs.setData(carrier);
				return new ResponseEntity<ResponseStructure<List<Carrier>>>(rs,HttpStatus.FOUND);
				
			}
		}
		
		
		
		

		
			
