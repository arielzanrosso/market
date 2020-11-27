package com.market.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.apirest.models.Item;


public interface ItemRepository extends JpaRepository<Item, Long> {

	Item findById(long id);
	
	
}
