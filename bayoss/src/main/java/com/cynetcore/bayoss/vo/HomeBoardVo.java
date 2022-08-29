package com.cynetcore.bayoss.vo;

import java.util.Date;

public class HomeBoardVo {
	private int hno;
	private String sid;
	private String main_category;
	private String detail_category;
	private String content;
	private Date regdate;
	private String reglocation;
	
	public HomeBoardVo() {
		super();
	}

	public HomeBoardVo(String sid, String main_category, String detail_category, String content, String reglocation) {
		super();
		this.sid = sid;
		this.main_category = main_category;
		this.detail_category = detail_category;
		this.content = content;
		this.reglocation = reglocation;
	}

	public HomeBoardVo(int hno, String sid, String main_category, String detail_category, String content, Date regdate,
			String reglocation) {
		super();
		this.hno = hno;
		this.sid = sid;
		this.main_category = main_category;
		this.detail_category = detail_category;
		this.content = content;
		this.regdate = regdate;
		this.reglocation = reglocation;
	}

	public int getHno() {
		return hno;
	}

	public void setHno(int hno) {
		this.hno = hno;
	}

	public String getsid() {
		return sid;
	}

	public void setsid(String sid) {
		this.sid = sid;
	}

	public String getMain_category() {
		return main_category;
	}

	public void setMain_category(String main_category) {
		this.main_category = main_category;
	}

	public String getDetail_category() {
		return detail_category;
	}

	public void setDetail_category(String detail_category) {
		this.detail_category = detail_category;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getReglocation() {
		return reglocation;
	}

	public void setReglocation(String reglocation) {
		this.reglocation = reglocation;
	}

	@Override
	public String toString() {
		return "HomeBoardVo [hno=" + hno + ", sid=" + sid + ", main_category=" + main_category + ", detail_category="
				+ detail_category + ", content=" + content + ", regdate=" + regdate + ", reglocation=" + reglocation
				+ "]";
	}
	
	
}
