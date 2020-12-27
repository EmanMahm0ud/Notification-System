package model.NotificationProject;

public interface Channel {
	public boolean isOnline();
	public void setOnline(boolean online);
	public void addNotificationToQueue(String finalMessage);
	public void sendNotification();
}
