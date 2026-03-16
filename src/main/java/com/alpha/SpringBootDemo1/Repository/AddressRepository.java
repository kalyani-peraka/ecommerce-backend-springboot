package com.alpha.SpringBootDemo1.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.SpringBootDemo1.entities.Address;
import com.alpha.SpringBootDemo1.entities.Admin;


public interface AddressRepository extends JpaRepository<Address,Integer>{

	Optional<Address> findByMobileNo(long addmobileNo);

}
