package model.NotificationProject;

import java.text.MessageFormat;

public class OrderConfirmation implements Notification {

	@Override
	public void sendNotification(User user, int id) {
		// TODO Auto-generated method stub
		User sUser = new User();
		
		NotificationSystem notification = new NotificationSystem();
		String message = notification.getNotification("order confirmation", "English").getContent();
		String finalTemplate = MessageFormat.format(message, sUser.getUserName());

	}

}