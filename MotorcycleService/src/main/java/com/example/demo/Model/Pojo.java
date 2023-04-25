package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pojo {
	@Id private int job_card;
	private String c_name;
	private String v_name;
	private String reg_num;
	private String eng_num;
	private String chs_num;
	private int est_cost;
	private String type_of_serv;
	public int getJob_card() {
		return job_card;
	}
	public void setJob_card(int job_card) {
		this.job_card = job_card;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getV_name() {
		return v_name;
	}
	public void setV_name(String v_name) {
		this.v_name = v_name;
	}
	public String getReg_num() {
		return reg_num;
	}
	public void setReg_num(String reg_num) {
		this.reg_num = reg_num;
	}
	public String getEng_num() {
		return eng_num;
	}
	public void setEng_num(String eng_num) {
		this.eng_num = eng_num;
	}
	public String getChs_num() {
		return chs_num;
	}
	public void setChs_num(String chs_num) {
		this.chs_num = chs_num;
	}
	public int getEst_cost() {
		return est_cost;
	}
	public void setEst_cost(int est_cost) {
		this.est_cost = est_cost;
	}
	
	public String getType_of_serv() {
		return type_of_serv;
	}
	public void setType_of_serv(String type_of_serv) {
		this.type_of_serv = type_of_serv;
	}
}