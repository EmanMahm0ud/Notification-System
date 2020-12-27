package model.NotificationProject;

import java.util.ArrayList;

public class Shopper extends User {
	
	private ArrayList<Order> orders;
	
	public Order getLastOrder()
	{
		
		return orders.get(orders.size()-1);
		
	}

}