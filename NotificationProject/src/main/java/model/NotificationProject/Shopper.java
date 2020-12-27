package model.NotificationProject;

import java.util.ArrayList;

public class Shopper extends User {
	
	private ArrayList<Order> orders;
	
	Shopper(){
		orders = new ArrayList();
		orders.add(new Order());
	}
	
	public Order getLastOrder()
	{
		
		return orders.get(orders.size()-1);
		
	}

}
