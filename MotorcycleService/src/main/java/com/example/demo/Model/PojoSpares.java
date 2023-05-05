package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "spares_list")
public class PojoSpares {

	@Id 
	@Column(name = "job_card") private int jobcard;
	@Column(name = "engine_oil") private String engoil;
	@Column(name = "air_filter") private String airfilter;
	@Column(name = "oil_filter") private String oilfilter;
	@Column(name = "spark_plug") private String plug;
	@Column(name = "other_spares") private String others;
	
	public int getJobcard() {
		return jobcard;
	}
	public void setJobcard(int jobcard) {
		this.jobcard = jobcard;
	}
	public String getEngoil() {
		return engoil;
	}
	public void setEngoil(String engoil) {
		this.engoil = engoil;
	}
	public String getAirfilter() {
		return airfilter;
	}
	public void setAirfilter(String airfilter) {
		this.airfilter = airfilter;
	}
	public String getOilfilter() {
		return oilfilter;
	}
	public void setOilfilter(String oilfilter) {
		this.oilfilter = oilfilter;
	}
	public String getPlug() {
		return plug;
	}
	public void setPlug(String plug) {
		this.plug = plug;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
}
