package com.cynetcore.bayoss.vo;

import java.sql.Date;

public class UserVo {

	private String cid;
	private String cpw;
	private String email;
	private String cellphone;
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

	

	public UserVo(String cid, String cpw, String email, String cellphone, Date regdate, String status) {
		super();
		this.cid = cid;
		this.cpw = cpw;
		this.email = email;
		this.cellphone = cellphone;
		this.regdate = regdate;
		this.status = status;
	}

	public String getcid() {
		return cid;
	}

	public void setcid(String cid) {
		this.cid = cid;
	}

	public String getcpw() {
		return cpw;
	}

	public void setcpw(String cpw) {
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
		return "SellerVo [cid=" + cid + ", cpw=" + cpw + ", email=" + email + ", cellphone=" + cellphone + ", regdate="
				+ regdate + ", status=" + status + "]";
	}

	
	
}
