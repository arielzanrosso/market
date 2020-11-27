package com.market.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.apirest.models.Consumer;



public interface ConsumerRepository extends JpaRepository<Consumer, Long> {

	Consumer findById(long id);
}
