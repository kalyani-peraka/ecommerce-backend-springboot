package com.alpha.SpringBootDemo1.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.SpringBootDemo1.entities.Admin;


public interface AdminRepository extends JpaRepository<Admin,Integer>{

	 Optional<Admin> findByMobileNo(long mobileNo);

}
