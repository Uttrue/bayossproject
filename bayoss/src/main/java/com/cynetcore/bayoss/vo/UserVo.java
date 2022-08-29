package com.cynetcore.bayoss.vo;

import java.sql.Date;

public class UserVo {
	private int cno;
	private String cid;
	private String cpw;
	private String email;
	private String cellphone;
	private String shipname;
	private String address;
	private Date regdate;
	private String status;
	
	public UserVo() {
		super();
	}

	public UserVo(String cid, String cpw, String email, String cellphone) {
		super();
		this.cid = cid;
		this.cpw = cpw;
		this.email = email;
		this.cellphone = cellphone;
	}

	public UserVo(String cid, String cpw, String email, String cellphone, String shipname) {
		super();
		this.cid = cid;
		this.cpw = cpw;
		this.email = email;
		this.cellphone = cellphone;
		this.shipname = shipname;
	}

	public UserVo(String cid, String cpw, String email, String cellphone, String shipname, String address) {
		super();
		this.cid = cid;
		this.cpw = cpw;
		this.email = email;
		this.cellphone = cellphone;
		this.shipname = shipname;
		this.address = address;
	}

	public UserVo(int cno, String cid, String cpw, String email, String cellphone, String shipname, String address,
			Date regdate, String status) {
		super();
		this.cno = cno;
		this.cid = cid;
		this.cpw = cpw;
		this.email = email;
		this.cellphone = cellphone;
		this.shipname = shipname;
		this.address = address;
		this.regdate = regdate;
		this.status = status;
	}

	
	
	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCpw() {
		return cpw;
	}

	public void setCpw(String cpw) {
		this.cpw = cpw;
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

	public String getShipname() {
		return shipname;
	}

	public void setShipname(String shipname) {
		this.shipname = shipname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
		return "UserVo [cno=" + cno + ", cid=" + cid + ", cpw=" + cpw + ", email=" + email + ", cellphone=" + cellphone
				+ ", shipname=" + shipname + ", address=" + address + ", regdate=" + regdate + ", status=" + status
				+ "]";
	}
	
}
