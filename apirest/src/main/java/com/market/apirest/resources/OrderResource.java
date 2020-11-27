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

import com.market.apirest.models.Item;
import com.market.apirest.models.Order;

import com.market.apirest.repository.OrderRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Market")
@CrossOrigin(origins = "*")
public class OrderResource {

	@Autowired
	OrderRepository orderRepository;
	
	@GetMapping("/orders")
	@ApiOperation(value="Return a order list")
	public List<Order> listOrders(){
		return orderRepository.findAll();
	}

	@GetMapping("/order/{id}")
	@ApiOperation(value="Return a single order")
	public Order listOrdersUn(@PathVariable(value="id") long id){
		return orderRepository.findById(id);
	}
	
	@PostMapping("/order")
	@ApiOperation(value="Save a order")
	public Order saveOrder(@RequestBody Order order)
	{
		return orderRepository.save(order);
	}
	
	@DeleteMapping("/order")
	@ApiOperation(value="Delete a order")
	public void deleteOrder(@RequestBody Order order) {
		
		orderRepository.delete(order);
	}
	
	@PutMapping("/order")
	@ApiOperation(value="Update a order")
	public Order updateOrder(@RequestBody Order order) {
		return orderRepository.save(order);
	}
}
