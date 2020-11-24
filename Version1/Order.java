package main;

import java.util.ArrayList;

public class Order {
	
	private ArrayList<Item> items;
	private String orderCode;
	
	public void addItem(Item item)
	{
		items.add(item);
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
