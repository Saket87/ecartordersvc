package com.ecart.ecartordersvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="ordertb")
public class Order {
	
	@Id
	@GeneratedValue
	private Integer orderid;
	
	private String productcode;
	
	private Integer quantity;
	
	public Order() {
	}
	

	/**
	 * @param orderid
	 * @param productcode
	 * @param quantity
	 */
	public Order(Integer orderid, String productcode, Integer quantity) {
		this.orderid = orderid;
		this.productcode = productcode;
		this.quantity = quantity;
	}

	/**
	 * @return the orderid
	 */
	public Integer getOrderid() {
		return orderid;
	}

	/**
	 * @param orderid the orderid to set
	 */
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	/**
	 * @return the productcode
	 */
	public String getProductcode() {
		return productcode;
	}

	/**
	 * @param productcode the productcode to set
	 */
	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order [orderid=");
		builder.append(orderid);
		builder.append(", productcode=");
		builder.append(productcode);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append("]");
		return builder.toString();
	}
	
	

}
