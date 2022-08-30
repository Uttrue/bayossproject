package com.cynetcore.bayoss.vo;

import java.util.Date;

public class CommentVo {
	private int cmno;
	private String cid;
	private int ino;
	private String sid;
	private String comment;
	private String item_title;
	private Date regdate;
	private String status;
	
	public CommentVo() {
		super();
	}

	public CommentVo(String cid, int ino, String sid, String comment, String item_title) {
		super();
		this.cid = cid;
		this.ino = ino;
		this.sid = sid;
		this.comment = comment;
		this.item_title = item_title;
	}

	public CommentVo(int cmno, String cid, int ino, String sid, String comment, String item_title, Date regdate,
			String status) {
		super();
		this.cmno = cmno;
		this.cid = cid;
		this.ino = ino;
		this.sid = sid;
		this.comment = comment;
		this.item_title = item_title;
		this.regdate = regdate;
		this.status = status;
	}

	public int getCmno() {
		return cmno;
	}

	public void setCmno(int cmno) {
		this.cmno = cmno;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
		return "CommentVo [cmno=" + cmno + ", cid=" + cid + ", ino=" + ino + ", sid=" + sid + ", comment=" + comment
				+ ", item_title=" + item_title + ", regdate=" + regdate + ", status=" + status + "]";
	}
	
	
	
}
