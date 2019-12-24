package com.szt.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 违法车辆的实体类
 * 违法车辆,违法车型,经度,纬度,抓怕时间,车主姓名,联系方式
 * @author Administrator
 *
 */
public class CarDomain {
	//违法车辆
	public String carNumber;
	//违法车型
	public String carType;
	//经度
	public double jd;
	//纬度
	public double wd;
	//时间
	public String regdate;
	//车主姓名
	public String uname;
	//联系方式
	public String phone;
	//违法信息
	public String lawMessage;
	//单双号违法标记 1:违法  0:不违法
	public Integer isodd;
	//违法地点 二环  2，四环 4  六环  6
	public String lawAddr;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CarDomain [carNumber=" + carNumber + ", carType=" + carType + ", jd=" + jd + ", wd=" + wd + ", regdate="
				+ regdate + ", uname=" + uname + ", phone=" + phone + ", lawMessage=" + lawMessage + ", isodd=" + isodd
				+ ", lawAddr=" + lawAddr + "]";
	}
	/**
	 * @return the carNumber
	 */
	public String getCarNumber() {
		return carNumber;
	}
	/**
	 * @param carNumber the carNumber to set
	 */
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	/**
	 * @return the carType
	 */
	public String getCarType() {
		return carType;
	}
	/**
	 * @param carType the carType to set
	 */
	public void setCarType(String carType) {
		this.carType = carType;
	}
	/**
	 * @return the jd
	 */
	public double getJd() {
		return jd;
	}
	/**
	 * @param jd the jd to set
	 */
	public void setJd(double jd) {
		this.jd = jd;
	}
	/**
	 * @return the wd
	 */
	public double getWd() {
		return wd;
	}
	/**
	 * @param wd the wd to set
	 */
	public void setWd(double wd) {
		this.wd = wd;
	}
	/**
	 * @return the regdate
	 */
	public String getRegdate() {
		return regdate;
	}
	/**
	 * @param regdate the regdate to set
	 */
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	/**
	 * @return the uname
	 */
	public String getUname() {
		return uname;
	}
	/**
	 * @param uname the uname to set
	 */
	public void setUname(String uname) {
		this.uname = uname;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the lawMessage
	 */
	public String getLawMessage() {
		return lawMessage;
	}
	/**
	 * @param lawMessage the lawMessage to set
	 */
	public void setLawMessage(String lawMessage) {
		this.lawMessage = lawMessage;
	}
	/**
	 * @return the isodd
	 */
	public Integer getIsodd() {
		return isodd;
	}
	/**
	 * @param isodd the isodd to set
	 */
	public void setIsodd(Integer isodd) {
		this.isodd = isodd;
	}
	/**
	 * @return the lawAddr
	 */
	public String getLawAddr() {
		return lawAddr;
	}
	/**
	 * @param lawAddr the lawAddr to set
	 */
	public void setLawAddr(String lawAddr) {
		this.lawAddr = lawAddr;
	}
	public CarDomain() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CarDomain(String carNumber, String carType, double jd, double wd, String regdate, String uname, String phone,
			String lawMessage, Integer isodd, String lawAddr) {
		super();
		this.carNumber = carNumber;
		this.carType = carType;
		this.jd = jd;
		this.wd = wd;
		this.regdate = regdate;
		this.uname = uname;
		this.phone = phone;
		this.lawMessage = lawMessage;
		this.isodd = isodd;
		this.lawAddr = lawAddr;
	}
	
	
	
	
	
}
