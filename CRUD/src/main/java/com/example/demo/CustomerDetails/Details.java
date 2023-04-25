package com.example.demo.CustomerDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Details {
	@Id
	private int id;
	private String Name;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Customer Details [id=" + id + ", Name=" + Name + ", age=" + age + "]";
	}
}
