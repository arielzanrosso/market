package com.market.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.apirest.models.Delivery;


public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

	Delivery findById(long id);
}
