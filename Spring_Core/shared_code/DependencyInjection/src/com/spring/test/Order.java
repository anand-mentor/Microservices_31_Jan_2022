package com.spring.test;

public class Order {
	private Item item;
	private String title;
	public Order() {
	}
	public Order(Item item, String title) {
		this.item = item;
		this.title = title;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String toString() {
		return title + " - " + item;
	}
}
