package com.hb.framework03.model;

public class UserVo {
	private int sabun, pay;
	private String name, nalja;
	
	public UserVo() {
		// TODO Auto-generated constructor stub
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

	public String getNalja() {
		return nalja;
	}

	public void setNalja(String nalja) {
		this.nalja = nalja;
	}
	
	@Override
	public String toString() {
		return sabun + name + nalja + pay;
	}
}
