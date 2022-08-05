package com.cynetcore.bayoss.vo;

import java.sql.Date;

public class SellerItemVo {
	private int ino;
	private String sid;
	private String item_title;
	private int item_cost;
	private Date item_start_date;
	private Date item_end_date;
	private String item_mainimage;
	private String item_content;
	private String item_status;
	
	public SellerItemVo() {
		super();
	}

	public SellerItemVo(String sid, String item_title, int item_cost, Date item_start_date, String item_mainimage,
			String item_content) {
		super();
		this.sid = sid;
		this.item_title = item_title;
		this.item_cost = item_cost;
		this.item_start_date = item_start_date;
		this.item_mainimage = item_mainimage;
		this.item_content = item_content;
	}

	public SellerItemVo(String sid, String item_title, int item_cost, Date item_start_date, Date item_end_date,
			String item_mainimage, String item_content) {
		super();
		this.sid = sid;
		this.item_title = item_title;
		this.item_cost = item_cost;
		this.item_start_date = item_start_date;
		this.item_end_date = item_end_date;
		this.item_mainimage = item_mainimage;
		this.item_content = item_content;
	}

	public SellerItemVo(int ino, String sid, String item_title, int item_cost, Date item_start_date, Date item_end_date,
			String item_mainimage, String item_content, String item_status) {
		super();
		this.ino = ino;
		this.sid = sid;
		this.item_title = item_title;
		this.item_cost = item_cost;
		this.item_start_date = item_start_date;
		this.item_end_date = item_end_date;
		this.item_mainimage = item_mainimage;
		this.item_content = item_content;
		this.item_status = item_status;
	}

	public int getIno() {
		return ino;
	}

	public void setIno(int ino) {
		this.ino = ino;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getItem_title() {
		return item_title;
	}

	public void setItem_title(String item_title) {
		this.item_title = item_title;
	}

	public int getItem_cost() {
		return item_cost;
	}

	public void setItem_cost(int item_cost) {
		this.item_cost = item_cost;
	}

	public Date getItem_start_date() {
		return item_start_date;
	}

	public void setItem_start_date(Date item_start_date) {
		this.item_start_date = item_start_date;
	}

	public Date getItem_end_date() {
		return item_end_date;
	}

	public void setItem_end_date(Date item_end_date) {
		this.item_end_date = item_end_date;
	}

	public String getItem_mainimage() {
		return item_mainimage;
	}

	public void setItem_mainimage(String item_mainimage) {
		this.item_mainimage = item_mainimage;
	}

	public String getItem_content() {
		return item_content;
	}

	public void setItem_content(String item_content) {
		this.item_content = item_content;
	}

	public String getItem_status() {
		return item_status;
	}

	public void setItem_status(String item_status) {
		this.item_status = item_status;
	}

	@Override
	public String toString() {
		return "SellerItemVo [ino=" + ino + ", sid=" + sid + ", item_title=" + item_title + ", item_cost=" + item_cost
				+ ", item_start_date=" + item_start_date + ", item_end_date=" + item_end_date + ", item_mainimage="
				+ item_mainimage + ", item_content=" + item_content + ", item_status=" + item_status + "]";
	}

	
	
}
