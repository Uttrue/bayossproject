package com.cynetcore.bayoss.vo;

import java.sql.Date;

public class RequestVo {
	private int sno;
	private String category;
	private String service;
	private String wname;
	private String shipname;
	private String phone;
	private String email;
	private String wdate;
	private String message;
	
	public RequestVo() {
		super();
	}

	public RequestVo(String category, String wname, String shipname, String phone, String email, String wdate) {
		super();
		this.category = category;
		this.wname = wname;
		this.shipname = shipname;
		this.phone = phone;
		this.email = email;
		this.wdate = wdate;
	}

	public RequestVo(String category, String service, String wname, String shipname, String phone, String email,
			String wdate) {
		super();
		this.category = category;
		this.service = service;
		this.wname = wname;
		this.shipname = shipname;
		this.phone = phone;
		this.email = email;
		this.wdate = wdate;
	}


	public RequestVo(String category, String service, String wname, String shipname, String phone, String email,
			String wdate, String message) {
		super();
		this.category = category;
		this.service = service;
		this.wname = wname;
		this.shipname = shipname;
		this.phone = phone;
		this.email = email;
		this.wdate = wdate;
		this.message = message;
	}

	public RequestVo(int sno, String category, String service, String wname, String shipname, String phone, String email,
			String wdate,String message) {
		super();
		this.sno = sno;
		this.category = category;
		this.service = service;
		this.wname = wname;
		this.shipname = shipname;
		this.phone = phone;
		this.email = email;
		this.wdate = wdate;
		this.message = message;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getWname() {
		return wname;
	}

	public void setWname(String wname) {
		this.wname = wname;
	}

	public String getShipname() {
		return shipname;
	}

	public void setShipname(String shipname) {
		this.shipname = shipname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "RequestVo [sno=" + sno + ", category=" + category + ", service=" + service + ", wname=" + wname
				+ ", shipname=" + shipname + ", phone=" + phone + ", email=" + email + ", wdate=" + wdate + ", message="
				+ message + "]";
	}

	
	
	
	
}
