package com.gn.shopping.vo;

public class Product {
	private int prodCode;
	private String prodName;
	private int prodPrice;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int prodCode, String prodName, int prodPrice) {
		super();
		this.prodCode = prodCode;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
	}
	public int getProdCode() {
		return prodCode;
	}
	public void setProdCode(int prodCode) {
		this.prodCode = prodCode;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public int getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}
	@Override
	public String toString() {
		return "[제품코드=" + prodCode + ", 제품명=" + prodName + ", 제품가격=" + prodPrice + "]";
	}
	
	
}
