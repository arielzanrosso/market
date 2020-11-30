package com.market.apirest.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.market.apirest.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	Product findById(long id);
//	Product savProduct(Product product, Manufacturer manufacturer);

	

	
	
	

}
