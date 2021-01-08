package model.NotificationProject;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.UriInfo;

@Path("sms")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SMS implements Channel {
	
	@POST
	public void addNotification(@Context UriInfo uriInfo) {
		MultivaluedMap<String, String> map = uriInfo.getQueryParameters();
		Map<String, String> queryPara = queryParameters(map);

		NotificationSystem notification = new NotificationSystem();
		Random r = new Random();
	    Integer code = r.nextInt((100000 - 10000) + 1) + 10000;
		String message = notification.getNotification(queryPara.get("subject"), queryPara.get("language")).getContent();
		String content = MessageFormat.format(message, queryPara.get("name"), code.toString());
		SMSSender dummySMS = new SMSSender();
		String smsStatus = dummySMS.send();
		SMSConnection smsConn = new SMSConnection();
		smsConn.addtoSMSQueue(queryPara.get("subject"), content, queryPara.get("name"), queryPara.get("phone"), queryPara.get("language"), smsStatus);
	}
	
	public Map<String, String> queryParameters(MultivaluedMap<String, String> map) {
		Map<String, String> query = new HashMap<>();
		for (String string : map.keySet()) {
			query.put(string, map.getFirst(string));
		}
		return query;
	}
	
	@GET
	public ArrayList<String> sendNotification(@Context UriInfo uriInfo) {
		ArrayList<String> messages = new ArrayList<>();
		MultivaluedMap<String, String> map = uriInfo.getQueryParameters();
		Map<String, String> queryPara = queryParameters(map);
		SMSConnection smsConn = new SMSConnection();
		messages = smsConn.dequeue(queryPara.get("phone"));
		SMSSender smsSend = new SMSSender();
		smsSend.send();
		return messages;
	}
}