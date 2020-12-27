package model.NotificationProject;

import java.text.MessageFormat;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		NotificationTemplate nTemplate = new NotificationTemplate();
		nTemplate.setId(1);
		nTemplate.setSubject("forget password");
		nTemplate.setContent("Dear {0}, your temporary password is {1}. Thanks for using our store.");
		nTemplate.setLanguage(LanguageEnum.English);
		
		NotificationSystem notification = new NotificationSystem();
		notification.addNotification(nTemplate);
		
		nTemplate.setId(2);
		nTemplate.setSubject("order confirmation");
		nTemplate.setContent("Dear {0}, your booking of the order {1} with order code {2} is confirmed. Thanks for using our store.");
		nTemplate.setLanguage(LanguageEnum.English);
		
		notification.addNotification(nTemplate);
		
		nTemplate.setId(3);
		nTemplate.setSubject("verification");
		nTemplate.setContent("Dear {0}, your verification code is {1}. Thanks for using our store.");
		nTemplate.setLanguage(LanguageEnum.English);

		notification.addNotification(nTemplate);
		
		Channel channels = new Email();
		
		User user = new Shopper();
		user.setUserName("eman");
		user.setChannels(channels);
		
		Notification n = new ForgetPassword();
		n.sendNotification(user, 1);
		
		n = new OrderConfirmation();
		n.sendNotification(user, 2);
		
		n = new Verification();
		n.sendNotification(user, 3);
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		user.getChannels().setOnline(true);
	}
}
