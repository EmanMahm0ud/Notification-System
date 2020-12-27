package model.NotificationProject;

import jakarta.ws.rs.PathParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("notification")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class NotificationSystem implements NotificationService {
	
	private static Map<Integer,NotificationTemplate> NotificationTemplates = new HashMap();
	
	@Inject
	public NotificationSystem() {
		getAllNotifications();
	}
	
	@POST
	@Path("/add")
	public Status addNotification(NotificationTemplate notification) {
		Status status = new Status();
		if(NotificationTemplates.get(notification.getId()) != null){
			status.setStatus(false);
			status.setMessage("Notification already exists!");
			return status;
		}
		NotificationConnection connection = new NotificationConnection();
		connection.addNotification(notification);
		NotificationTemplates.put(notification.getId(), notification);
		status.setStatus(true);
		status.setMessage("Notification created successfully!");
		return status;
	}
	
	@GET
    @Path("/{id}/delete")
	public Status deleteNotification(@PathParam("id") int id) {
		Status status = new Status();
		if(NotificationTemplates.get(id) == null){
			status.setStatus(false);
			status.setMessage("Notification is not found!");
			return status;
		}
		NotificationConnection connection = new NotificationConnection();
		connection.deleteNotification(id);
		NotificationTemplates.remove(id);
		status.setStatus(true);
		status.setMessage("Notification deleted successfully!");
		return status;
	}
	
	@POST
	@Path("/{id}/update")
	public Status updateNotifiction(@PathParam("id") int id, NotificationTemplate notification) {
		Status status = new Status();
		if(NotificationTemplates.get(id) == null){
			status.setStatus(false);
			status.setMessage("Notification is not found!");
			return status;
		}
		NotificationConnection connection = new NotificationConnection();
		connection.updateNotification(id, notification);
		NotificationTemplates.replace(id, notification);
		status.setStatus(true);
		status.setMessage("Notification created successfully!");
		return status;
	}
	
	@GET
	@Path("/{id}/search")
	public String searchNotification(@PathParam("id") int id) {
		Status status = new Status();
		if(NotificationTemplates.get(id) == null){
			status.setStatus(false);
			status.setMessage("Notification is not found!");
			return "Notification is not found!";
		} else {
			status.setStatus(true);
			status.setMessage("Notification is found!");
			return "Notification is found!";
		}
	}
	
	@GET
	@Path("/{id}/getOne")
	public NotificationTemplate getNotification(@PathParam("id") int id) {
		if(NotificationTemplates.get(id) == null){
			System.out.println("Notification is not found!");
		}
		NotificationTemplate notification = new NotificationTemplate();
		NotificationConnection connection = new NotificationConnection();
		notification = connection.getNotification(id);
		return notification;
	}
	
	@GET
	@Path("/getAll")
	public ArrayList<NotificationTemplate> getAllNotifications() {
		NotificationConnection nConnection = new NotificationConnection();
		ArrayList<NotificationTemplate> notifications = new ArrayList();
		notifications = nConnection.getAllNotifications();
		NotificationTemplates.clear();
		for (NotificationTemplate temp : notifications) {
			NotificationTemplates.put(temp.getId(), temp);
		}
		return notifications;
	}
	
	@GET
	@Path("/check")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
}
