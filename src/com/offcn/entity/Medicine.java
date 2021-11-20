package com.offcn.entity;

public class Medicine {
	public Medicine() {
		super();
	}
	
	public Medicine(String name) {
		super();
		this.name = name;
	}

	public Medicine(String mid, String picture, double inPrice, double salPrice, String name, int type, String descs,
			int qualityDate, String description, String produceFirm, String readme, String remark) {
		super();
		this.mid = mid;
		this.picture = picture;
		this.inPrice = inPrice;
		this.salPrice = salPrice;
		this.name = name;
		this.type = type;
		this.descs = descs;
		this.qualityDate = qualityDate;
		this.description = description;
		this.produceFirm = produceFirm;
		this.readme = readme;
		this.remark = remark;
	}

	private String mid;//药品编号
	private String picture;//图片
	private double inPrice;//进价
	private double salPrice;//售价
	private String name;//名称
	private int type;//类型
	private String descs;//简述
	private int qualityDate;//保质期
	private String description;//详细描述
	private String produceFirm;//厂家
	private String readme;//服用说明 
	private String remark;//备注
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public double getInPrice() {
		return inPrice;
	}
	public void setInPrice(double inPrice) {
		this.inPrice = inPrice;
	}
	public double getSalPrice() {
		return salPrice;
	}
	public void setSalPrice(double salPrice) {
		this.salPrice = salPrice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getDescs() {
		return descs;
	}
	public void setDescs(String descs) {
		this.descs = descs;
	}
	public int getQualityDate() {
		return qualityDate;
	}
	public void setQualityDate(int qualityDate) {
		this.qualityDate = qualityDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProduceFirm() {
		return produceFirm;
	}
	public void setProduceFirm(String produceFirm) {
		this.produceFirm = produceFirm;
	}
	public String getReadme() {
		return readme;
	}
	public void setReadme(String readme) {
		this.readme = readme;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Medicine [mid=" + mid + ", picture=" + picture + ", inPrice=" + inPrice + ", salPrice=" + salPrice
				+ ", name=" + name + ", type=" + type + ", descs=" + descs + ", qualityDate=" + qualityDate
				+ ", description=" + description + ", produceFirm=" + produceFirm + ", readme=" + readme + ", remark="
				+ remark + "]";
	}
	
}
