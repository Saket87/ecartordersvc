package com.ecart.ecartordersvc.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="product")
public class Product {
	
	@Id
	private String productcode;
	
	private String productdescription;
	
	private String color;
	
	private String company;
	
	private String category;
	
	private Integer stock;
	
	private BigDecimal price;
	
	private BigDecimal discount;
	
	public Product() {
	}

	/**
	 * @param productcode
	 * @param productdescription
	 * @param color
	 * @param companycode
	 * @param categorycode
	 */
	public Product(String category, String company, String productcode,  String color, String productdescription, 
			BigDecimal price, BigDecimal discount, Integer stock) {
		this.productcode = productcode;
		this.productdescription = productdescription;
		this.color = color;
		this.company = company;
		this.category = category;
		this.stock = stock;
		this.price = price;
		this.discount = discount;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
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
	 * @return the productdescription
	 */
	public String getProductdescription() {
		return productdescription;
	}

	/**
	 * @param productdescription the productdescription to set
	 */
	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}



	/**
	 * @return the stock
	 */
	public Integer getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(Integer stock) {
		this.stock = stock;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * @return the discount
	 */
	public BigDecimal getDiscount() {
		return discount;
	}

	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [productcode=");
		builder.append(productcode);
		builder.append(", productdescription=");
		builder.append(productdescription);
		builder.append(", color=");
		builder.append(color);
		builder.append(", company=");
		builder.append(company);
		builder.append(", category=");
		builder.append(category);
		builder.append(", stock=");
		builder.append(stock);
		builder.append(", price=");
		builder.append(price);
		builder.append(", discount=");
		builder.append(discount);
		builder.append("]");
		return builder.toString();
	}





}
