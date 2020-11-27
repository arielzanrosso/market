package com.market.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.apirest.models.Payment;


public interface PaymentRepository extends JpaRepository<Payment, Long> {

	Payment findById(long id);
}
