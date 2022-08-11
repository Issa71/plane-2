package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Plane {
	
	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	
	private String name;

	private int size;

	private double cost;

	public Plane(Integer id,String name, int size, double cost) {
		super();
		this.id = id;
		this.name = name;
		this.size = size;
		this.cost = cost;
	}
	public Plane(String name, int size, double cost) {
		super();
		this.name = name;
		this.size = size;
		this.cost = cost;
	}
	public Plane() {
		super();
	}
	
	public Integer getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return this.size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public double getCost() {
		return this.cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Plane [name=" + this.name + ", size=" + this.size + ", cost=" + this.cost + "]";
	}

}
				