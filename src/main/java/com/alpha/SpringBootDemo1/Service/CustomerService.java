package com.alpha.SpringBootDemo1.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alpha.SpringBootDemo1.Repository.AddressRepository;
import com.alpha.SpringBootDemo1.Repository.CustomerRepository;
import com.alpha.SpringBootDemo1.Repository.OrderRepository;
import com.alpha.SpringBootDemo1.Repository.ProductRepository;
import com.alpha.SpringBootDemo1.dto.CustomerDto;
import com.alpha.SpringBootDemo1.dto.ResponseStructure;
import com.alpha.SpringBootDemo1.entities.Address;
import com.alpha.SpringBootDemo1.entities.Customer;
import com.alpha.SpringBootDemo1.entities.Orders;
import com.alpha.SpringBootDemo1.entities.Product;
import com.alpha.SpringBootDemo1.exception.AddressNotFound;
import com.alpha.SpringBootDemo1.exception.CartIsEmptyException;
import com.alpha.SpringBootDemo1.exception.CustomerNotFound;
import com.alpha.SpringBootDemo1.exception.ProductNotFound;
import com.alpha.SpringBootDemo1.exception.ProductOutOfStockException;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(CustomerDto dto) {
		// TODO Auto-generated method stub
		Customer c=new Customer();
		c.setName(dto.getName());
		c.setMobileNo(dto.getMobileNo());
		c.setMail(dto.getMail());
		Address add=new Address();
		add.setCity(dto.getAddress().getCity());
		add.setPincode(dto.getAddress().getPincode());
		add.setCountry(dto.getAddress().getCountry());
		add.setAddressDescription(dto.getAddress().getAddressDescription());
		add.setMobileNo(dto.getAddress().getMobileNo());
		add.setAddressType(dto.getAddress().getAddressType());
		addressRepository.save(add);
		c.getLadd().add(add);
		customerRepository.save(c);
		ResponseStructure<Customer> rs=new ResponseStructure<Customer>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMessage("Customer with details has been saved");
		rs.setData(c);
		return new ResponseEntity<ResponseStructure<Customer>>(rs,HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructure<Customer>> addAddress(long cmobileNo, Address add) {
			// TODO Auto-generated method stub
			Customer cust=customerRepository.findByMobileNo(cmobileNo).orElseThrow(()->new CustomerNotFound());
			addressRepository.save(add);
			cust.getLadd().add(add);
			customerRepository.save(cust);
			ResponseStructure<Customer> rs=new ResponseStructure<Customer>();
			rs.setStatuscode(HttpStatus.OK.value());
			rs.setMessage("Customer with details has been saved");
			rs.setData(cust);
			return new ResponseEntity<ResponseStructure<Customer>>(rs,HttpStatus.OK);
		}
	public ResponseEntity<ResponseStructure<Customer>> deleteAddress(long cmobileNo, long addmobileNo) {
			// TODO Auto-generated method stub
			Customer cust=customerRepository.findByMobileNo(cmobileNo).orElseThrow(()->new CustomerNotFound());
			Address a=addressRepository.findByMobileNo(addmobileNo).orElseThrow(()->new AddressNotFound());
			cust.getLadd().remove(a);
			customerRepository.save(cust);
			ResponseStructure<Customer> rs=new ResponseStructure<Customer>();
			rs.setStatuscode(HttpStatus.OK.value());
			rs.setMessage("Customer with mobileno "+cmobileNo+"of address mobileno"+addmobileNo+"has been deleted");
			rs.setData(cust);
			return new ResponseEntity<ResponseStructure<Customer>>(rs,HttpStatus.OK);
			
		}
	public ResponseEntity<ResponseStructure<List<Product>>> findByAvailabilityStatus(String availabilityStatus) {
			// TODO Auto-generated method stub
		List<Product>	products=(List<Product>) productRepository.findByAvailabilityStatus(availabilityStatus).orElseThrow(()->new ProductNotFound());
		if(products.isEmpty()) {
			throw new ProductNotFound();
		}
		ResponseStructure<List<Product>> rs=new ResponseStructure<List<Product>>();
		rs.setStatuscode(HttpStatus.FOUND.value());
		rs.setMessage("PRODUCT LIST has been displayes");
		rs.setData(products);
		return new ResponseEntity<ResponseStructure<List<Product>>>(rs,HttpStatus.FOUND);
		}
	public ResponseEntity<ResponseStructure<Customer>> findCustomer(long mobileNo) {
			// TODO Auto-generated method stub
		Customer customer=customerRepository.findByMobileNo(mobileNo).orElseThrow(()->new CustomerNotFound());
		ResponseStructure<Customer> rs=new ResponseStructure<Customer>();
		rs.setStatuscode(HttpStatus.FOUND.value());
		rs.setMessage("Customer with mobileno "+mobileNo+"has been found");
		rs.setData(customer);
		return new ResponseEntity<ResponseStructure<Customer>>(rs,HttpStatus.FOUND);
		}
	public ResponseEntity<ResponseStructure<Customer>> addProductToCart(long cmobileNo, int id) {
			// TODO Auto-generated method stub
			Customer cust=customerRepository.findByMobileNo(cmobileNo).orElseThrow(()->new CustomerNotFound());
			Product p=productRepository.findById(id).orElseThrow(()->new ProductNotFound());
			cust.getCart().add(p);
			customerRepository.save(cust);
			ResponseStructure<Customer> rs=new ResponseStructure<Customer>();
			rs.setStatuscode(HttpStatus.OK.value());
			rs.setMessage("Customer with mobileno "+cmobileNo+"and Product with id"+id+"has been added to cart");
			rs.setData(cust);
			return new ResponseEntity<ResponseStructure<Customer>>(rs,HttpStatus.OK);
		}
	public ResponseEntity<ResponseStructure<List<Product>>> seeCart(long cmobileNo) {
			Customer cust = customerRepository.findByMobileNo(cmobileNo).orElseThrow(() -> new CustomerNotFound());
			List<Product> products = cust.getCart();
			if (products == null || products.isEmpty()) {
		        throw new ProductNotFound();
		    }
		    ResponseStructure<List<Product>> rs = new ResponseStructure<>();
		    rs.setStatuscode(HttpStatus.OK.value());
		    rs.setMessage("Cart products fetched successfully");
		    rs.setData(products);
		    return new ResponseEntity<>(rs, HttpStatus.OK);
		}
	public ResponseEntity<ResponseStructure<Customer>> removeProductFromCart(long cmobileNo, int pid) {
			// TODO Auto-generated method stub
			Customer cust=customerRepository.findByMobileNo(cmobileNo).orElseThrow(()->new CustomerNotFound());
			Product product=productRepository.findById(pid).orElseThrow(()->new ProductNotFound());
			cust.getCart().remove(product);
			customerRepository.save(cust);
			ResponseStructure<Customer> rs=new ResponseStructure<Customer>();
			rs.setStatuscode(HttpStatus.FOUND.value());
			rs.setMessage("Customer with mobileno "+cmobileNo+"and Product with id"+pid+"has been removed from cart");
			rs.setData(cust);
			return new ResponseEntity<ResponseStructure<Customer>>(rs,HttpStatus.FOUND);
		}


	public ResponseEntity<ResponseStructure<Orders>> placeOrder(long cmobileNo, int deliveryAddId) {

	    Customer cust = customerRepository.findByMobileNo(cmobileNo)
	            .orElseThrow(() -> new CustomerNotFound());

	    Address a = addressRepository.findById(deliveryAddId)
	            .orElseThrow(() -> new AddressNotFound());

	    List<Product> cart = cust.getCart();
	    if (cart.isEmpty()) {
	        throw new CartIsEmptyException();
	    }

	    double totalPrice = 0;
	    for (Product p : cart) {
	        if (p.getQuantity() <= 0) {
	            throw new ProductOutOfStockException();
	        }
	        p.setQuantity(p.getQuantity() - 1);
	        productRepository.save(p);
	        totalPrice += p.getPricePerUnit();
	    }

	    Orders o = new Orders();
	    o.setCust(cust);
	    o.setDate(LocalDate.now());
	    o.setDeliveryLocation(a);
	    o.setExpectedDelivaryDate(LocalDate.now().plusDays(2));
	    o.setTotalPrice(totalPrice);
	    o.setPurchaselist(new ArrayList<>(cart));

	    int otp = (int) (Math.random() * 900000) + 100000;
	    o.setOtp(otp);

	    o.setCarrier(null);
	    o.setPickupLocation(null);

	    orderRepository.save(o);
	    List<Orders> orderList = cust.getLorder();
	    if (orderList == null) {
	        orderList = new ArrayList<>();
	    }
	    orderList.add(o);
	    cust.setLorder(orderList);

	    cust.getCart().clear();
	    customerRepository.save(cust);

	    ResponseStructure<Orders> rs = new ResponseStructure<>();
	    rs.setStatuscode(HttpStatus.CREATED.value());
	    rs.setMessage("ORDER placed successfully for customer " + cmobileNo);
	    rs.setData(o);

	    return new ResponseEntity<>(rs, HttpStatus.CREATED);
	}

	
	}
	
	
	
