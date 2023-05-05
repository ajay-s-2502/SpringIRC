package com.example.demo.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer_details")

public class Pojo {
	
	@Column(name = "customer_name") private String cname;
	@Column(name = "vehicle_name") private String vname;
	@Id @Column(name = "register_number") private String regnum;
	@Column(name = "engine_number") private String engnum;
	@Column(name = "chassis_number") private String chsnum;
	@Column(name = "type_of_service") private String typeofserv;
	@Column(name = "problems") private String prob;
	@Column(name = "estimated_time_hrs") private double esttime;
	@Column(name = "estimated_cost") private int estcost;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "job_card")
	private PojoSpares jobcard;
	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getRegnum() {
		return regnum;
	}
	public void setRegnum(String regnum) {
		this.regnum = regnum;
	}
	public String getEngnum() {
		return engnum;
	}
	public void setEngnum(String engnum) {
		this.engnum = engnum;
	}
	public String getChsnum() {
		return chsnum;
	}
	public void setChsnum(String chsnum) {
		this.chsnum = chsnum;
	}
	public String getTypeofserv() {
		return typeofserv;
	}
	public void setTypeofserv(String typeofserv) {
		this.typeofserv = typeofserv;
	}
	public String getProb() {
		return prob;
	}
	public void setProb(String prob) {
		this.prob = prob;
	}
	public double getEsttime() {
		return esttime;
	}
	public void setEsttime(double esttime) {
		this.esttime = esttime;
	}
	public int getEstcost() {
		return estcost;
	}
	public void setEstcost(int estcost) {
		this.estcost = estcost;
	}
	public PojoSpares getJobcard() {
		return jobcard;
	}
	public void setJobcard(PojoSpares jobcard) {
		this.jobcard = jobcard;
	}
}