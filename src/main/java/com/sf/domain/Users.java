package com.sf.domain;

import java.math.BigDecimal;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private Long usersId;
	private Long areaId;
	private String usersNum;
	private String usersName;
	private String usersLoginname;
	private String usersPassword;
	private String usersGender;
	private String usersBirth;
	private String usersPhoto;
	private BigDecimal usersDepartment;
	private String usersPhone;
	private String usersPhone1;
	private String usersPhone2;
	private String usersHomeaddress;
	private String usersLasttime;
	private String usersRegtime;
	private BigDecimal userstateId;
	private String usersRemark;
	private BigDecimal onlinere;
	private String ip;
	private BigDecimal isalarm;
	private String urlhost;

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** full constructor */
	public Users(Long areaId, String usersNum, String usersName,
			String usersLoginname, String usersPassword, String usersGender,
			String usersBirth, String usersPhoto, BigDecimal usersDepartment,
			String usersPhone, String usersPhone1, String usersPhone2,
			String usersHomeaddress, String usersLasttime, String usersRegtime,
			BigDecimal userstateId, String usersRemark, BigDecimal onlinere,
			String ip, BigDecimal isalarm, String urlhost) {
		this.areaId = areaId;
		this.usersNum = usersNum;
		this.usersName = usersName;
		this.usersLoginname = usersLoginname;
		this.usersPassword = usersPassword;
		this.usersGender = usersGender;
		this.usersBirth = usersBirth;
		this.usersPhoto = usersPhoto;
		this.usersDepartment = usersDepartment;
		this.usersPhone = usersPhone;
		this.usersPhone1 = usersPhone1;
		this.usersPhone2 = usersPhone2;
		this.usersHomeaddress = usersHomeaddress;
		this.usersLasttime = usersLasttime;
		this.usersRegtime = usersRegtime;
		this.userstateId = userstateId;
		this.usersRemark = usersRemark;
		this.onlinere = onlinere;
		this.ip = ip;
		this.isalarm = isalarm;
		this.urlhost = urlhost;
	}

	// Property accessors

	public Long getUsersId() {
		return this.usersId;
	}

	public void setUsersId(Long usersId) {
		this.usersId = usersId;
	}

	public Long getAreaId() {
		return this.areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public String getUsersNum() {
		return this.usersNum;
	}

	public void setUsersNum(String usersNum) {
		this.usersNum = usersNum;
	}

	public String getUsersName() {
		return this.usersName;
	}

	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}

	public String getUsersLoginname() {
		return this.usersLoginname;
	}

	public void setUsersLoginname(String usersLoginname) {
		this.usersLoginname = usersLoginname;
	}

	public String getUsersPassword() {
		return this.usersPassword;
	}

	public void setUsersPassword(String usersPassword) {
		this.usersPassword = usersPassword;
	}

	public String getUsersGender() {
		return this.usersGender;
	}

	public void setUsersGender(String usersGender) {
		this.usersGender = usersGender;
	}

	public String getUsersBirth() {
		return this.usersBirth;
	}

	public void setUsersBirth(String usersBirth) {
		this.usersBirth = usersBirth;
	}

	public String getUsersPhoto() {
		return this.usersPhoto;
	}

	public void setUsersPhoto(String usersPhoto) {
		this.usersPhoto = usersPhoto;
	}

	public BigDecimal getUsersDepartment() {
		return this.usersDepartment;
	}

	public void setUsersDepartment(BigDecimal usersDepartment) {
		this.usersDepartment = usersDepartment;
	}

	public String getUsersPhone() {
		return this.usersPhone;
	}

	public void setUsersPhone(String usersPhone) {
		this.usersPhone = usersPhone;
	}

	public String getUsersPhone1() {
		return this.usersPhone1;
	}

	public void setUsersPhone1(String usersPhone1) {
		this.usersPhone1 = usersPhone1;
	}

	public String getUsersPhone2() {
		return this.usersPhone2;
	}

	public void setUsersPhone2(String usersPhone2) {
		this.usersPhone2 = usersPhone2;
	}

	public String getUsersHomeaddress() {
		return this.usersHomeaddress;
	}

	public void setUsersHomeaddress(String usersHomeaddress) {
		this.usersHomeaddress = usersHomeaddress;
	}

	public String getUsersLasttime() {
		return this.usersLasttime;
	}

	public void setUsersLasttime(String usersLasttime) {
		this.usersLasttime = usersLasttime;
	}

	public String getUsersRegtime() {
		return this.usersRegtime;
	}

	public void setUsersRegtime(String usersRegtime) {
		this.usersRegtime = usersRegtime;
	}

	public BigDecimal getUserstateId() {
		return this.userstateId;
	}

	public void setUserstateId(BigDecimal userstateId) {
		this.userstateId = userstateId;
	}

	public String getUsersRemark() {
		return this.usersRemark;
	}

	public void setUsersRemark(String usersRemark) {
		this.usersRemark = usersRemark;
	}

	public BigDecimal getOnlinere() {
		return this.onlinere;
	}

	public void setOnlinere(BigDecimal onlinere) {
		this.onlinere = onlinere;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public BigDecimal getIsalarm() {
		return this.isalarm;
	}

	public void setIsalarm(BigDecimal isalarm) {
		this.isalarm = isalarm;
	}

	public String getUrlhost() {
		return this.urlhost;
	}

	public void setUrlhost(String urlhost) {
		this.urlhost = urlhost;
	}

}