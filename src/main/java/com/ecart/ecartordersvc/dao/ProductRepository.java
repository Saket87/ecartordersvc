package com.ecart.ecartordersvc.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ecart.ecartordersvc.model.Product;

public interface ProductRepository extends CrudRepository<Product, String>  {
	
	List<Product> findByProductcode(String productcode);

}
