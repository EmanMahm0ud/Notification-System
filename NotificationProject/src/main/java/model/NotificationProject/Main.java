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
		
//		e.addTemplete("forget password", "Dear {0}, your temporary password is {1}. Thanks for using our store.");
//		
//		e.addTemplete("order confirmation", "Dear {0}, your booking of the order {1} with order code {2} is confirmed. Thanks for using our store.");
//		
//		e.addTemplete("verification", "Dear {0}, your verification code is {1}. Thanks for using our store.");
//		
//		e.addTemplete("order confirmation", "Hi {0}, how are you ");
//		
//		String s = e.readTemplate("order confirmation");
//		System.out.println(s);
		
		Channel channels = new SMS();
		
		User user = new Shopper();
		user.setUserName("eman");
		user.setChannels(channels);
		
		Notification n = new ForgetPassword();
		n.sendNotification(user, 1);
	}
}
