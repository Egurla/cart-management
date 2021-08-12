package com.nisum.cms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LineItem {
	
	/*
	 * public LineItem(long l, double d, long m, int i) { // TODO Auto-generated
	 * constructor stub }
	 */
	private Long id;
	private Double line_amount;
	private Long productId;
	private Integer quantity;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getLine_amount() {
		return line_amount;
	}
	public void setLine_amount(Double line_amount) {
		this.line_amount = line_amount;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	//private Long cartid;
	
}
