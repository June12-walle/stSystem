package com.offcn.entity;

import java.util.Date;

public class User {
	public User() {
		
	}
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public User(String name, String email,String username, String password, Date modifytime) {
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.modifytime = modifytime;
	}

	public User(String name, String email, int status, String username, String password, Date modifytime) {
		this.name = name;
		this.email = email;
		this.status = status;
		this.username = username;
		this.password = password;
		this.modifytime = modifytime;
	}
	private int uid;//用户id
	private String name;//真实姓名
	private String email;//邮箱
	private int status;//状态 0表示禁用  1表示正常
	private String username;//账号
	private String password;//密码
	private Date modifytime;//修改时间
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getModifytime() {
		return modifytime;
	}
	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}
	@Override
	public String toString() {		//toString 方法-测试
		return "User [uid=" + uid + ", name=" + name + ", email=" + email + ", status=" + status + ", username="
				+ username + ", password=" + password + ", modifytime=" + modifytime + "]";
	}	
}
