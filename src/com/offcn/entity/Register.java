package com.offcn.entity;

import java.util.Date;

public class Register {
	
	public Register() {
	}
	
	public Register(String rid, String name) {
		super();
		this.rid = rid;
		this.name = name;
	}
	
	public Register(String rid, String name, String idCard, String siNumber, double registerMoney, String phone,
			int isPay, int sex, int age, int consultation, int department, int did,
			Date registerDate, String remark) {
		this.rid = rid;
		this.name = name;
		this.idCard = idCard;
		this.siNumber = siNumber;
		this.registerMoney = registerMoney;
		this.phone = phone;
		this.isPay = isPay;
		this.sex = sex;
		this.age = age;
		this.consultation = consultation;
		this.department = department;
		this.did = did;
		this.registerDate = registerDate;
		this.remark = remark;
	}
	
	public Register(String rid, String name, String idCard, String siNumber, double registerMoney, String phone,
			int isPay, int sex, int age, int consultation, int department, int did, int status,
			Date registerDate, String remark) {
		super();
		this.rid = rid;
		this.name = name;
		this.idCard = idCard;
		this.siNumber = siNumber;
		this.registerMoney = registerMoney;
		this.phone = phone;
		this.isPay = isPay;
		this.sex = sex;
		this.age = age;
		this.consultation = consultation;
		this.department = department;
		this.did = did;
		this.status = status;
		this.registerDate = registerDate;
		this.remark = remark;
	}

	private String rid;//编号 
	private String name;//姓名
	private String idCard;//身份证号
	private String siNumber;//社保号
	private double registerMoney;//挂号费
	private String phone;//电话
	private int isPay;//是否自费 0-否 1-是
	private int sex;//性别 0-男 1-女
	private int age;//年龄
	private int consultation;//初复诊 0-初  1-复
	private int department;//科室 1-急诊  2-儿科 3-妇科 4-皮肤科 5-内分泌科 6-牙科 
	private int did;//医生编号 
	private Doctor doctor; // 辅助查询功能
	private int status;//患者状态 1-挂号  2-退号  3-已住院  4-已出院  5-已结算
	private Date registerDate;//挂号日期
	private String remark; //备注
	
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
	public String getSiNumber() {
		return siNumber;
	}

	public void setSiNumber(String siNumber) {
		this.siNumber = siNumber;
	}

	public double getRegisterMoney() {
		return registerMoney;
	}
	public void setRegisterMoney(double registerMoney) {
		this.registerMoney = registerMoney;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getIsPay() {
		return isPay;
	}
	public void setIsPay(int isPay) {
		this.isPay = isPay;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getConsultation() {
		return consultation;
	}
	public void setConsultation(int consultation) {
		this.consultation = consultation;
	}
	public int getDepartment() {
		return department;
	}
	public void setDepartment(int department) {
		this.department = department;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Register [rid=" + rid + ", name=" + name + ", idCard=" + idCard + ", siNumber=" + siNumber
				+ ", registerMoney=" + registerMoney + ", phone=" + phone + ", isPay=" + isPay + ", sex=" + sex
				+ ", age=" + age + ", consultation=" + consultation + ", department=" + department + ", did=" + did
				+ ", doctor=" + doctor + ", status=" + status + ", registerDate=" + registerDate + ", remark=" + remark
				+ "]";
	}
	
}
