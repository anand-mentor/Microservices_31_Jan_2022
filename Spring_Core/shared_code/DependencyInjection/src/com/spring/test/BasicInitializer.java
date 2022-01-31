package com.spring.test;

public class BasicInitializer {

	public static void main(String args[]) {
		Item item = new Item("Chair", 1500.0);
		
		// 1) Constructor based injection
		Order order = new Order(item, "Purchase Chairs");
		System.out.println("Order details: " + order);
		
		// 2) Setter method based injection
		Order order_2 = new Order();
		order_2.setTitle("Purchase Chairs");
		order_2.setItem(item);
		System.out.println("Order_2 details: " + order_2);
	}
}
