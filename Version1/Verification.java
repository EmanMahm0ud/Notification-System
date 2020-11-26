import java.text.MessageFormat;
import java.util.Random;

public class Verification implements Notification {

	@Override
	public void sendNotification(User user) {
		// TODO Auto-generated method stub
		
		Random r = new Random();
        Integer vCode = r.nextInt((100000 - 10000) + 1) + 10000;
		
		String message = user.getLanguageTemp().readTemplate("verification");
		String finalTemplate = MessageFormat.format(message, user.getUserName(), vCode.toString());
		
		user.getChannels().sendNotification(finalTemplate);

	}

}
