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


import com.market.apirest.models.Delivery;

import com.market.apirest.repository.DeliveryRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Market")
@CrossOrigin(origins = "*")
public class DeliveryResource {

	@Autowired
	DeliveryRepository deliveryRepository;
	
	@GetMapping("/deliveries")
	@ApiOperation(value="Return a deliveries list")
	public List<Delivery> listDeliveries(){
		return deliveryRepository.findAll();
	}

	@GetMapping("/delivery/{id}")
	@ApiOperation(value="Return a single delivery")
	public Delivery listDeliveriesUn(@PathVariable(value="id") long id){
		return deliveryRepository.findById(id);
	}
	
	@PostMapping("/delivery")
	@ApiOperation(value="Save a delivery")
	public Delivery saveDelivery(@RequestBody Delivery delivery)
	{
		return deliveryRepository.save(delivery);
	}
	
	@DeleteMapping("/delivery")
	@ApiOperation(value="Delete a delivery")
	public void deleteDelivery(@RequestBody Delivery delivery) {
		
		deliveryRepository.delete(delivery);
	}
	
	@PutMapping("/delivery")
	@ApiOperation(value="Update a delivery")
	public Delivery updateDelivery(@RequestBody Delivery delivery) {
		return deliveryRepository.save(delivery);
	}
}
