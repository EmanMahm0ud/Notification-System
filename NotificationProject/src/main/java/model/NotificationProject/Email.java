package model.NotificationProject;

import java.util.LinkedList;
import java.util.Queue;

public class Email implements Channel{

	Queue<String> readyToSendNotifications =  new LinkedList<>();
	boolean online = false;
	
	public void addNotificationToQueue(String finalMessage)
	{
		readyToSendNotifications.add(finalMessage + "*This is email channel*");
		System.out.println("Notification is send successfully!");
		sendNotification();
	}
	
	@Override
	public void sendNotification() {
		// TODO Auto-generated method stub
		while (!readyToSendNotifications.isEmpty() && online)
		{
			String notificationMessage = readyToSendNotifications.remove();
			System.out.println(notificationMessage);
		}
		
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
		if (online)
			sendNotification();
	}
}
