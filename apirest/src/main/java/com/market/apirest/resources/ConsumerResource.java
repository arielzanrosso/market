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

import com.market.apirest.models.Consumer;

import com.market.apirest.repository.ConsumerRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping(value="/api")
@Api(value="API REST Market")
@CrossOrigin(origins = "*")
public class ConsumerResource {

	
	@Autowired
	ConsumerRepository consumerRepository;
	
	@GetMapping("/consumers")
	@ApiOperation(value="Return a consumers list")
	public List<Consumer> listConsumers(){
		return consumerRepository.findAll();
	}

	@GetMapping("/consumer/{id}")
	@ApiOperation(value="Return a single consumer")
	public Consumer listConsumersUn(@PathVariable(value="id") long id){
		return consumerRepository.findById(id);
	}
	
	@PostMapping("/consumer")
	@ApiOperation(value="Save a consumer")
	public Consumer saveConsumer(@RequestBody Consumer consumer)
	{
		return consumerRepository.save(consumer);
	}
	
	@DeleteMapping("/consumer")
	@ApiOperation(value="Delete a consumer")
	public void deleteConsumer(@RequestBody Consumer consumer) {
		
		consumerRepository.delete(consumer);
	}
	
	@PutMapping("/consumer")
	@ApiOperation(value="Update a consumer")
	public Consumer updateConsumer(@RequestBody Consumer consumer) {
		return consumerRepository.save(consumer);
	}
}
