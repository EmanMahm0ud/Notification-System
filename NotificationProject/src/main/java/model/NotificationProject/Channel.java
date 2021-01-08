package model.NotificationProject;

import java.util.ArrayList;

import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.ext.Provider;

@Provider
public interface Channel {
	public ArrayList<String> sendNotification(@Context UriInfo uriInfo);
}
