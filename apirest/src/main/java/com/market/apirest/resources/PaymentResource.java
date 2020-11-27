package com.market.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.market.apirest.models.Payment;

import com.market.apirest.repository.PaymentRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Market")
@CrossOrigin(origins = "*")
public class PaymentResource {

	
	@Autowired
	PaymentRepository paymentRepository;
	
	@GetMapping("/payment")
	@ApiOperation(value="Return a payment list")
	public List<Payment> listPayments(){
		return paymentRepository.findAll();
	}

	@GetMapping("/payment/{id}")
	@ApiOperation(value="Return a single payment")
	public Payment listPaymentsUn(@PathVariable(value="id") long id){
		return paymentRepository.findById(id);
	}
	
	@PostMapping("/payment")
	@ApiOperation(value="Save a payment")
	public Payment savePayment(@RequestBody Payment payment)
	{
		return paymentRepository.save(payment);
	}
	
	@DeleteMapping("/payment")
	@ApiOperation(value="Delete a payment")
	public void deletePayment(@RequestBody Payment payment) {
		
		paymentRepository.delete(payment);
	}
	
	@PutMapping("/payment")
	@ApiOperation(value="Update a payment")
	public Payment updatePayment(@RequestBody Payment payment) {
		return paymentRepository.save(payment);
	}
}
