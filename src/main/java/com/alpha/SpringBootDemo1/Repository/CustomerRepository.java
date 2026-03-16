package com.alpha.SpringBootDemo1.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.SpringBootDemo1.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{

	Optional<Customer> findByMobileNo(long mobileNo);

}

