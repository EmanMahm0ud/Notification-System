import java.text.MessageFormat;

public class OrderConfirmation implements Notification {

	@Override
	public void sendNotification(User user) {
		// TODO Auto-generated method stub
		Shopper sUser = (Shopper) user;
		
		String message = user.getLanguageTemp().readTemplate("order confirmation");
		String finalTemplate = MessageFormat.format(message, user.getUserName(), sUser.getUserName(), sUser.getLastOrder().getOrder(), sUser.getLastOrder().getorderCode());
		
		user.getChannels().sendNotification(finalTemplate);

	}

}
