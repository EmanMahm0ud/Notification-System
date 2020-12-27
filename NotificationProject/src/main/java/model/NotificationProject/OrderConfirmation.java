package model.NotificationProject;

import java.text.MessageFormat;

public class OrderConfirmation implements Notification {

	@Override
	public void sendNotification(User user, int id) {
		// TODO Auto-generated method stub
		Shopper sUser = (Shopper) user;
		
		NotificationSystem notification = new NotificationSystem();
		String message = notification.getNotification(id).getContent();
		String finalTemplate = MessageFormat.format(message, sUser.getUserName(), sUser.getLastOrder().getOrder(), sUser.getLastOrder().getorderCode());
		
		user.getChannels().addNotificationToQueue(finalTemplate);

	}

}
