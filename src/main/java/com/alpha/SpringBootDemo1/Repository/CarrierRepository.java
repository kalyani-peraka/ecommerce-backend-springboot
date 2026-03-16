package com.alpha.SpringBootDemo1.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.SpringBootDemo1.entities.Admin;
import com.alpha.SpringBootDemo1.entities.Carrier;

public interface CarrierRepository extends JpaRepository<Carrier,Integer>{

	Optional<Carrier> findByMobileNo(long mobNo);

}

