package com.ecart.ecartordersvc.resource;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecart.ecartordersvc.exception.BadOrderFormatException;
import com.ecart.ecartordersvc.exception.ItemNotInStockException;
import com.ecart.ecartordersvc.exception.OrderNotFoundException;
import com.ecart.ecartordersvc.exception.ProductNotFoundException;
import com.ecart.ecartordersvc.model.Order;
import com.ecart.ecartordersvc.model.OrderRequest;
import com.ecart.ecartordersvc.service.OrderService;

@RestController
public class OrderResource {
	
	@Autowired
	OrderService orderservice;
	
	
	@GetMapping(value="/orders", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Order> retrieveOrders() {
				
		return orderservice.retrieveOrders();
	}
	
	
	@PostMapping(value="/orders", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> placeOrders(@RequestBody OrderRequest orderRequest) {
		
		orderservice.placeOrders(orderRequest);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	

	@DeleteMapping(value = "/orders/{orderid}")
	public ResponseEntity<String> delete(@PathVariable("orderid") Integer orderid) {
		
		orderservice.delete(orderid);

		return ResponseEntity.status(202).build();
	}
	
	
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handleError(RuntimeException exception){
		
		if(exception instanceof BadOrderFormatException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
			
		}else if(exception instanceof ItemNotInStockException){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
			
		}else if(exception instanceof OrderNotFoundException){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
			
		}else if(exception instanceof ProductNotFoundException){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
			
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
		}
	}
}
