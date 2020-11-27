package com.market.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.apirest.models.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {

	Order findById(long id);
	
	
}
