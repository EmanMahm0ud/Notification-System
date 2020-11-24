package main;

public class OrderConfirmation implements Notification {

	@Override
	public void sendNotification(User user) {
		// TODO Auto-generated method stub
		Shopper sUser = (Shopper) user;
		
		System.out.println("Dear" + sUser.getUserName() + " , your booking of the order " + sUser.getLastOrder().getorderCode()+" is confirmed. thanks for using our store ");

	}

}
