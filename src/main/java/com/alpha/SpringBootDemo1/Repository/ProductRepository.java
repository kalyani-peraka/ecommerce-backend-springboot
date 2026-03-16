package com.alpha.SpringBootDemo1.Repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.SpringBootDemo1.entities.Customer;
import com.alpha.SpringBootDemo1.entities.Product;

public interface ProductRepository  extends JpaRepository<Product,Integer>{
	Optional<List<Product>> findByAvailabilityStatus(String availabilityStatus);

}