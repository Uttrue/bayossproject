package com.cynetcore.bayoss.vo;

import java.util.Date;

public class ReviewVo {
	private int rno;
	private String cid;
	private int ino;
	private String sid;
	private String review;
	private String item_title;
	private Date regdate;
	private String status;
	
	public ReviewVo() {
		super();
	}

	public ReviewVo(String cid, int ino, String sid, String review, String item_title) {
		super();
		this.cid = cid;
		this.ino = ino;
		this.sid = sid;
		this.review = review;
		this.item_title = item_title;
	}

	public ReviewVo(int rno, String cid, int ino, String sid, String review, String item_title, Date regdate,
			String status) {
		super();
		this.rno = rno;
		this.cid = cid;
		this.ino = ino;
		this.sid = sid;
		this.review = review;
		this.item_title = item_title;
		this.regdate = regdate;
		this.status = status;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
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

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getItem_title() {
		return item_title;
	}

	public void setItem_title(String item_title) {
		this.item_title = item_title;
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
		return "ReviewVo [rno=" + rno + ", cid=" + cid + ", ino=" + ino + ", sid=" + sid + ", review=" + review
				+ ", item_title=" + item_title + ", regdate=" + regdate + ", status=" + status + "]";
	}

	
	
}
