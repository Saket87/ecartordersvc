package com.ecart.ecartordersvc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecart.ecartordersvc.dao.OrderRepository;
import com.ecart.ecartordersvc.dao.ProductRepository;
import com.ecart.ecartordersvc.exception.BadOrderFormatException;
import com.ecart.ecartordersvc.exception.ItemNotInStockException;
import com.ecart.ecartordersvc.exception.OrderNotFoundException;
import com.ecart.ecartordersvc.exception.ProductNotFoundException;
import com.ecart.ecartordersvc.model.Order;
import com.ecart.ecartordersvc.model.OrderRequest;
import com.ecart.ecartordersvc.model.Product;

@Service
public class OrderService {
	

	@Autowired
	OrderRepository orderrepository;
	
	@Autowired
	ProductRepository productrepository;
	
	/**
	 * Retrieve orders
	 * @return
	 */
	public List<Order> retrieveOrders() {
		
		List<Order> orders = new ArrayList<Order>();
				
		orderrepository.findAll().forEach(orders::add);

		return orders;
	}
	
	/**
	 * Retrieve orders by order id
	 * @return
	 */
	public Optional<Order> retrieveOrdersByOrderId(Integer orderid) {
				
		return orderrepository.findById(orderid);

	}
	
	
	/**
	 * Place a dummy order. Order placement should fail if the stock = number of dummy orders 
	 * @param order
	 * @param product
	 */
	@Transactional
	public void placeOrders(OrderRequest orderRequest) {
		
			List<Product> products = productrepository.findByProductcode(orderRequest.getProductcode());
		
			if(!products.isEmpty()) {
				
				Product product = products.get(0);
				
				if(orderRequest.getQuantity() < 1) {
					throw new BadOrderFormatException("Bad order format");
				}
				
				if(product.getStock() < orderRequest.getQuantity()) {
					throw new ItemNotInStockException("Item not in Stock");
				}
				
				product.setStock(product.getStock() - orderRequest.getQuantity());
				
				productrepository.save(product);
				
				Order order = new Order();
				
				order.setProductcode(orderRequest.getProductcode());
				order.setQuantity(orderRequest.getQuantity());
				
				orderrepository.save(order);
			}else {
				throw new ProductNotFoundException("Product Not Found");
			}

	}
	

	/**
	 * Delete the dummy order(s)
	 * @param order
	 * @param product
	 */
	@Transactional
	public void delete(Integer orderid) {
		
		
		Optional<Order> orderPresent = orderrepository.findById(orderid);
		
		if(orderPresent.isPresent()) {
			
			Order order = orderPresent.get();
			
			Optional<Product> productPresent = productrepository.findById(order.getProductcode());
			
			if(productPresent.isPresent()) {
				Product product = productPresent.get();
				product.setStock(product.getStock() + order.getQuantity());
	
				productrepository.save(product);
				orderrepository.delete(order);
			}else {
				throw new ProductNotFoundException("Product Not Found");
			}
		}else {
			throw new OrderNotFoundException("Order Not Found");
		}

	}
}
