package com.cynetcore.bayoss.vo;

import java.sql.Date;

public class SellStoreVo {

	private int seller_reg_no;
	private String sid;
	private String sell_store_name;
	private int sell_store_regnum;
	private int sell_store_phone;
	private int sell_store_fax;
	private String sell_store_status;
	private Date regdate;
	
	public SellStoreVo() {
		super();
	}

	public SellStoreVo(String sid, String sell_store_name, int sell_store_regnum, int sell_store_phone,
			int sell_store_fax) {
		super();
		this.sid = sid;
		this.sell_store_name = sell_store_name;
		this.sell_store_regnum = sell_store_regnum;
		this.sell_store_phone = sell_store_phone;
		this.sell_store_fax = sell_store_fax;
	}
	
	

	public SellStoreVo(String sid, String sell_store_name, int sell_store_regnum, int sell_store_phone) {
		super();
		this.sid = sid;
		this.sell_store_name = sell_store_name;
		this.sell_store_regnum = sell_store_regnum;
		this.sell_store_phone = sell_store_phone;
	}

	

	public SellStoreVo(int seller_reg_no, String sid, String sell_store_name, int sell_store_regnum,
			int sell_store_phone, int sell_store_fax, String sell_store_status, Date regdate) {
		super();
		this.seller_reg_no = seller_reg_no;
		this.sid = sid;
		this.sell_store_name = sell_store_name;
		this.sell_store_regnum = sell_store_regnum;
		this.sell_store_phone = sell_store_phone;
		this.sell_store_fax = sell_store_fax;
		this.sell_store_status = sell_store_status;
		this.regdate = regdate;
	}

	public int getSeller_reg_no() {
		return seller_reg_no;
	}

	public void setSeller_reg_no(int seller_reg_no) {
		this.seller_reg_no = seller_reg_no;
	}

	public String getsid() {
		return sid;
	}

	public void setsid(String sid) {
		this.sid = sid;
	}

	public String getSell_store_name() {
		return sell_store_name;
	}

	public void setSell_store_name(String sell_store_name) {
		this.sell_store_name = sell_store_name;
	}

	public int getSell_store_regnum() {
		return sell_store_regnum;
	}

	public void setSell_store_regnum(int sell_store_regnum) {
		this.sell_store_regnum = sell_store_regnum;
	}

	public int getSell_store_phone() {
		return sell_store_phone;
	}

	public void setSell_store_phone(int sell_store_phone) {
		this.sell_store_phone = sell_store_phone;
	}

	public int getSell_store_fax() {
		return sell_store_fax;
	}

	public void setSell_store_fax(int sell_store_fax) {
		this.sell_store_fax = sell_store_fax;
	}

	public String getSell_store_status() {
		return sell_store_status;
	}

	public void setSell_store_status(String sell_store_status) {
		this.sell_store_status = sell_store_status;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "SellStoreVo [seller_reg_no=" + seller_reg_no + ", sid=" + sid + ", sell_store_name=" + sell_store_name
				+ ", sell_store_regnum=" + sell_store_regnum + ", sell_store_phone=" + sell_store_phone
				+ ", sell_store_fax=" + sell_store_fax + ", sell_store_status=" + sell_store_status + ", regdate="
				+ regdate + "]";
	}

	
	
	
}
