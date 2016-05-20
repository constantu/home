package com.vasutin.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class User {	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private int id;
	@Column
	private String name;
	@Column
	private int age;
	@Column
	private boolean isAdmin;
	@Column
	private Date createDate;
	
	public User(){}
	public User(int id, String name, int age, boolean isAdmin, Date createDate) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.isAdmin = isAdmin;
		this.createDate = createDate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	

}
