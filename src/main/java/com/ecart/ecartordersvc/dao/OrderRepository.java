package com.ecart.ecartordersvc.dao;

import org.springframework.data.repository.CrudRepository;

import com.ecart.ecartordersvc.model.Order;

public interface OrderRepository extends CrudRepository<Order, Integer>  {
	


}
