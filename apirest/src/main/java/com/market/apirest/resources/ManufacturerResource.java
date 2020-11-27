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

import com.market.apirest.models.Manufacturer;

import com.market.apirest.repository.ManufacturerRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value="/api")
@Api(value="API REST Market")
@CrossOrigin(origins = "*")
public class ManufacturerResource {
	
	@Autowired
ManufacturerRepository manufacturerRepository;
	
	@GetMapping("/manufacturers")
	@ApiOperation(value="Return a manufacturer list")
	public List<Manufacturer> listManufacturers(){
		return manufacturerRepository.findAll();
	}

	@GetMapping("/manufacturer/{id}")
	@ApiOperation(value="Return a single manufacturer")
	public Manufacturer listManufacturerUn(@PathVariable(value="id") long id){
		return manufacturerRepository.findById(id);
	}
	
	@PostMapping("/manufacturer")
	@ApiOperation(value="Save a manufacturer")
	public Manufacturer saveManufacturer(@RequestBody Manufacturer manufacturer)
	{
		return manufacturerRepository.save(manufacturer);
	}
	
	@DeleteMapping("/manufacturer")
	@ApiOperation(value="Delete a manufacturer")
	public void deleteManufacturer(@RequestBody Manufacturer manufacturer) {
		
		manufacturerRepository.delete(manufacturer);
	}
	
	@PutMapping("/manufacturer")
	@ApiOperation(value="Update a manufacturer")
	public Manufacturer updateManufacturer(@RequestBody Manufacturer manufacturer) {
		return manufacturerRepository.save(manufacturer);
	}

}
