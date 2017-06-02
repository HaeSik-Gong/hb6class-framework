package com.hb.day01.model;

import java.sql.Date;

public class UserVo {
	private int sabun, pay;
	private String name;
	private Date nalja;
	
	public UserVo() {
		// TODO Auto-generated constructor stub
	}

	public UserVo(int sabun, String name, Date nalja, int pay) {
		super();
		this.sabun = sabun;
		this.pay = pay;
		this.name = name;
		this.nalja = nalja;
	}

	public int getSabun() {
		return sabun;
	}

	public void setSabun(int sabun) {
		this.sabun = sabun;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getNalja() {
		return nalja;
	}

	public void setNalja(Date nalja) {
		this.nalja = nalja;
	}

	@Override
	public String toString() {
		return "UserVo [sabun=" + sabun + ", pay=" + pay + ", name=" + name + ", nalja=" + nalja + "]";
	}
	
}
