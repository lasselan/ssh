package com.mashen.user;

public class HeadLineUser {
	String headaccount;
	String headpassword;
	String headname;
	String headimg;
	String email;
	String created;
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getHeadaccount() {
		return headaccount;
	}
	public void setHeadaccount(String headaccount) {
		this.headaccount = headaccount;
	}
	public String getHeadpassword() {
		return headpassword;
	}
	public void setHeadpassword(String headpassword) {
		this.headpassword = headpassword;
	}
	public String getHeadname() {
		return headname;
	}
	public void setHeadname(String headname) {
		this.headname = headname;
	}
	public String getHeadimg() {
		return headimg;
	}
	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "HeadLineUser [headaccount=" + headaccount + ", headpassword=" + headpassword + ", headname=" + headname
				+ ", headimg=" + headimg + ", email=" + email + ", created=" + created + "]";
	}
	
}
