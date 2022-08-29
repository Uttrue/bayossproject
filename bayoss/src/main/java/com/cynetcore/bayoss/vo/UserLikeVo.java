package com.cynetcore.bayoss.vo;

public class UserLikeVo {
	private int lno;
	private int ino;
	private String cid;
	private String item_title;
	private String sid;
	private String status;
	
	public UserLikeVo() {
		super();
	}

	public UserLikeVo(int ino, String cid, String item_title, String sid) {
		super();
		this.ino = ino;
		this.cid = cid;
		this.item_title = item_title;
		this.sid = sid;
	}

	

	public UserLikeVo(int lno, int ino, String cid, String item_title, String sid, String status) {
		super();
		this.lno = lno;
		this.ino = ino;
		this.cid = cid;
		this.item_title = item_title;
		this.sid = sid;
		this.status = status;
	}

	public int getLno() {
		return lno;
	}

	public void setLno(int lno) {
		this.lno = lno;
	}

	public int getIno() {
		return ino;
	}

	public void setIno(int ino) {
		this.ino = ino;
	}

	public String getcid() {
		return cid;
	}

	public void setcid(String cid) {
		this.cid = cid;
	}

	public String getItem_title() {
		return item_title;
	}

	public void setItem_title(String item_title) {
		this.item_title = item_title;
	}

	public String getsid() {
		return sid;
	}

	public void setsid(String sid) {
		this.sid = sid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserLikeVo [lno=" + lno + ", ino=" + ino + ", cid=" + cid + ", item_title=" + item_title + ", sid="
				+ sid + ", status=" + status + "]";
	}

	
	
	
}
