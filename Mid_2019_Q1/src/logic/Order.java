package logic;

import java.util.ArrayList;

public class Order {
	private ArrayList<OrderItem> orderItemList;
	private static int totalOrderCount = 0;
	private int orderNumber;

	public Order() {
		// TODO
		orderItemList = new ArrayList<OrderItem>();
		totalOrderCount=orderNumber;
		totalOrderCount++;
	}

	public OrderItem addItem(Item item, int amount) {
		// TODO
		for(OrderItem o1:orderItemList){
			if(o1.getItem().equals(item)){
				if(amount>0)
					o1.setItemAmount(o1.getItemAmount()+amount);
				return o1;
			}
		}
		OrderItem o2 = new OrderItem(item,amount);
		orderItemList.add(o2);
		return o2;


	}

	public int calculateOrderTotalPrice() {
		// TODO
		// Calculate total price of the order by summing total price of each orderItem in orderItemList
		int totalPrice=0;
		for(OrderItem orderItem : orderItemList){
			totalPrice+=orderItem.calculateTotalPrice();
		}
		return totalPrice;
	}

	public static int getTotalOrderCount() {
		return totalOrderCount;
	}

	public static void resetTotalOrderCount() {
		totalOrderCount = 0;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public ArrayList<OrderItem> getOrderItemList() {
		return orderItemList;
	}


}
