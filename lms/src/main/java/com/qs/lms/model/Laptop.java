package com.qs.lms.model;

public class Laptop {

	private int id;
	private String brand;
	private double price;
	private String model;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Laptop() {

	}

	public Laptop(int id, String brand, double price, String model) {
		super();
		this.id = id;
		this.brand = brand;
		this.price = price;
		this.model = model;
	}

	@Override
	public String toString() {
		return "Laptop [id=" + id + ", brand=" + brand + ", price=" + price + ", model=" + model + "]";
	}
}
