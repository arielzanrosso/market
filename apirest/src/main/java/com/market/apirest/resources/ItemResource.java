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

import com.market.apirest.repository.ItemRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Market")
@CrossOrigin(origins = "*")
public class ItemResource {

	@Autowired
	ItemRepository itemRepository;
	
	@GetMapping("/items")
	@ApiOperation(value="Return a item list")
	public List<Item> listItems(){
		return itemRepository.findAll();
	}

	@GetMapping("/item/{id}")
	@ApiOperation(value="Return a single item")
	public Item listItemsUn(@PathVariable(value="id") long id){
		return itemRepository.findById(id);
	}
	
	@PostMapping("/item")
	@ApiOperation(value="Save a item")
	public Item saveItem(@RequestBody Item item)
	{
		return itemRepository.save(item);
	}
	
	@DeleteMapping("/item")
	@ApiOperation(value="Delete a item")
	public void deleteItem(@RequestBody Item item) {
		
		itemRepository.delete(item);
	}
	
	@PutMapping("/item")
	@ApiOperation(value="Update a item")
	public Item updateItem(@RequestBody Item item) {
		return itemRepository.save(item);
	}
}
