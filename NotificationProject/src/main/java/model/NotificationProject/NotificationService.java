package model.NotificationProject;

import java.util.ArrayList;

public interface NotificationService {
	
	public Status addNotification(NotificationTemplate notification);
	public Status deleteNotification(int id);
	public Status updateNotifiction(int id, NotificationTemplate notification);
	public Status searchNotification(int id);
	public NotificationTemplate getNotification(int id);
	public ArrayList<NotificationTemplate> getAllNotifications();
}
