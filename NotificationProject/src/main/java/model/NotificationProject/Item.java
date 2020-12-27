package model.NotificationProject;

public class Item {
	
	private String itemName;
	private String itemID;
	
	Item(){
		itemName = "item";
		itemID = "1";
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemID() {
		return itemID;
	}
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

}