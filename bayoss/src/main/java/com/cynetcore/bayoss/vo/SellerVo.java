package com.cynetcore.bayoss.vo;

import java.sql.Date;

public class SellerVo {

	private String sid;
	private String spw;
	private String email;
	private String cellphone;
	private Date regdate;
	private String status;
	
	public SellerVo() {
		super();
	}

	public SellerVo(String sid, String spw, String email, String cellphone) {
		super();
		this.sid = sid;
		this.spw = spw;
		this.email = email;
		this.cellphone = cellphone;
	}

	

	public SellerVo(String sid, String spw, String email, String cellphone, Date regdate, String status) {
		super();
		this.sid = sid;
		this.spw = spw;
		this.email = email;
		this.cellphone = cellphone;
		this.regdate = regdate;
		this.status = status;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSpw() {
		return spw;
	}

	public void setSpw(String spw) {
		this.spw = spw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SellerVo [sid=" + sid + ", spw=" + spw + ", email=" + email + ", cellphone=" + cellphone + ", regdate="
				+ regdate + ", status=" + status + "]";
	}

	
	
}
