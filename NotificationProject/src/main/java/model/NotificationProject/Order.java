package model.NotificationProject;

import java.util.ArrayList;

public class Order {
	
	private ArrayList<Item> items;
	private String orderCode;
	
	Order(){
		items = new ArrayList();
		items.add(new Item());
		orderCode = "123";
	}
	
	public void addItem(Item item)
	{
		items.add(item);
	}
	
	public String getOrder() {
		String order = "";
		for (int i = 0 ; i < items.size() ; i++) {
			order = items.get(items.size()-1).getItemName() + " ";
		}
		return order;
	}
	
	public String getorderCode()
	{
		return orderCode;
	}
	
	public void setOrderCode(String orderCode)
	{
		this.orderCode = orderCode;
	}
	

}

