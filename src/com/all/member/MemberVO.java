package com.all.member;

public class MemberVO {	
	private String id;
	private String name;
	private String pw;
	private String regno;
	
	public MemberVO(String id, String name, String pw, String regno) {
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.regno = regno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getRegno() {
		return regno;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", name=" + name + ", pw=" + pw + ", regno=" + regno + "]";
	}
	
}
