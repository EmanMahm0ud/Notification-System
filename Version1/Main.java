import java.text.MessageFormat;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		English e = new English();
		
		e.addTemplete("forget password", "Dear {0}, your temporary password is {1}. Thanks for using our store.");
		
		e.addTemplete("order confirmation", "Dear {0}, your booking of the order {1} with order code {2} is confirmed. Thanks for using our store.");
		
		e.addTemplete("verification", "Dear {0}, your verification code is {1}. Thanks for using our store.");
		
		Channel channels = new SMS();
		
		User user = new Shopper();
		user.setUserName("eman");
		user.setChannels(channels);
		user.setLanguageTemp(e);
		
		Notification n = new ForgetPassword();
		n.sendNotification(user);
	}
}
