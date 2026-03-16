package com.alpha.SpringBootDemo1.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.SpringBootDemo1.entities.Orders;

public interface OrderRepository extends JpaRepository<Orders,Integer>{

}

