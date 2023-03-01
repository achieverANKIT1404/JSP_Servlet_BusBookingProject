package com.entity;

public class busData {

	private int id;
	
	private String busNo,busName,fromCity,toCity,date,time,ticketPrice;

	public busData() {
		super();
	}

	public busData(String busNo, String busName, String fromCity, String toCity, String date, String time,
			String ticketPrice) {
		super();
		this.busNo = busNo;
		this.busName = busName;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.date = date;
		this.time = time;
		this.ticketPrice = ticketPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBusNo() {
		return busNo;
	}

	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getFromCity() {
		return fromCity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public String getToCity() {
		return toCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(String ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
}
