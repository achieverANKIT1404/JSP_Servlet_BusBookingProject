package com.entity;

public class book {

	private int id;
	private String email,ph,date,nperson,addr,price;
	
	public book() {
		super();
	}

	public book(String email, String ph, String date, String nperson, String addr,String price) {
		super();
		this.email = email;
		this.ph = ph;
		this.date = date;
		this.nperson = nperson;
		this.addr = addr;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPh() {
		return ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getNperson() {
		return nperson;
	}

	public void setNperson(String nperson) {
		this.nperson = nperson;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
    
}
