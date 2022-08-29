package com.cynetcore.bayoss.vo;

import java.sql.Date;

public class SellStoreVo {

	private int seller_reg_no;
	private String sid;
	private String sell_store_name;
	private String sell_store_ceo;
	private String sell_store_regnum;
	private int sell_store_phone;
	private int sell_store_fax;
	private String sell_store_status;
	private String sell_store_opendate;
	private Date sell_store_regdate;
	private String reglocation;
	
	public SellStoreVo() {
		super();
	}

	public SellStoreVo(String sid, String sell_store_name, String sell_store_ceo, String sell_store_regnum,
			int sell_store_phone, String sell_store_opendate, String reglocation) {
		super();
		this.sid = sid;
		this.sell_store_name = sell_store_name;
		this.sell_store_ceo = sell_store_ceo;
		this.sell_store_regnum = sell_store_regnum;
		this.sell_store_phone = sell_store_phone;
		this.sell_store_opendate = sell_store_opendate;
		this.reglocation = reglocation;
	}

	public SellStoreVo(String sid, String sell_store_name, String sell_store_ceo, String sell_store_regnum,
			int sell_store_phone, int sell_store_fax, String sell_store_opendate, String reglocation) {
		super();
		this.sid = sid;
		this.sell_store_name = sell_store_name;
		this.sell_store_ceo = sell_store_ceo;
		this.sell_store_regnum = sell_store_regnum;
		this.sell_store_phone = sell_store_phone;
		this.sell_store_fax = sell_store_fax;
		this.sell_store_opendate = sell_store_opendate;
		this.reglocation = reglocation;
	}

	public SellStoreVo(int seller_reg_no, String sid, String sell_store_name, String sell_store_ceo,
			String sell_store_regnum, int sell_store_phone, int sell_store_fax, String sell_store_status,
			String sell_store_opendate, Date sell_store_regdate,String reglocation) {
		super();
		this.seller_reg_no = seller_reg_no;
		this.sid = sid;
		this.sell_store_name = sell_store_name;
		this.sell_store_ceo = sell_store_ceo;
		this.sell_store_regnum = sell_store_regnum;
		this.sell_store_phone = sell_store_phone;
		this.sell_store_fax = sell_store_fax;
		this.sell_store_status = sell_store_status;
		this.sell_store_opendate = sell_store_opendate;
		this.sell_store_regdate = sell_store_regdate;
		this.reglocation = reglocation;
	}

	public int getSeller_reg_no() {
		return seller_reg_no;
	}

	public void setSeller_reg_no(int seller_reg_no) {
		this.seller_reg_no = seller_reg_no;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSell_store_name() {
		return sell_store_name;
	}

	public void setSell_store_name(String sell_store_name) {
		this.sell_store_name = sell_store_name;
	}

	public String getSell_store_ceo() {
		return sell_store_ceo;
	}

	public void setSell_store_ceo(String sell_store_ceo) {
		this.sell_store_ceo = sell_store_ceo;
	}

	public String getSell_store_regnum() {
		return sell_store_regnum;
	}

	public void setSell_store_regnum(String sell_store_regnum) {
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

	public String getSell_store_opendate() {
		return sell_store_opendate;
	}

	public void setSell_store_opendate(String sell_store_opendate) {
		this.sell_store_opendate = sell_store_opendate;
	}

	public Date getSell_store_regdate() {
		return sell_store_regdate;
	}

	public void setSell_store_regdate(Date sell_store_regdate) {
		this.sell_store_regdate = sell_store_regdate;
	}

	public String getReglocation() {
		return reglocation;
	}

	public void setReglocation(String reglocation) {
		this.reglocation = reglocation;
	}

	@Override
	public String toString() {
		return "SellStoreVo [seller_reg_no=" + seller_reg_no + ", sid=" + sid + ", sell_store_name=" + sell_store_name
				+ ", sell_store_ceo=" + sell_store_ceo + ", sell_store_regnum=" + sell_store_regnum
				+ ", sell_store_phone=" + sell_store_phone + ", sell_store_fax=" + sell_store_fax
				+ ", sell_store_status=" + sell_store_status + ", sell_store_opendate=" + sell_store_opendate
				+ ", sell_store_regdate=" + sell_store_regdate + ", reglocation=" + reglocation + "]";
	}

	
	
	
}
