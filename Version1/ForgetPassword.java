import java.text.MessageFormat;
import java.util.Random;

public class ForgetPassword implements Notification {

	@Override
	public void sendNotification(User user) {
		// TODO Auto-generated method stub
		
		Random r = new Random();
        	Integer code = r.nextInt((100000 - 10000) + 1) + 10000;
		
		String message = user.getLanguageTemp().readTemplate("forget password");
		String finalTemplate = MessageFormat.format(message, user.getUserName(), code.toString());
		
		user.getChannels().sendNotification(finalTemplate);
		
	}

}
