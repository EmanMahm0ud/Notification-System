package model.NotificationProject;

import java.text.MessageFormat;
import java.util.Random;

public class Verification implements Notification {

	@Override
	public void sendNotification(User user, int id) {
		// TODO Auto-generated method stub
		
		Random r = new Random();
        Integer vCode = r.nextInt((100000 - 10000) + 1) + 10000;
        
        NotificationSystem notification = new NotificationSystem();
		String message = notification.getNotification("verification", "English").getContent();
		String finalTemplate = MessageFormat.format(message, user.getUserName(), vCode.toString());
		

	}

}
