package main;

import java.util.Random;

public class ForgetPassword implements Notification {

	@Override
	public void sendNotification(User user) {
		// TODO Auto-generated method stub
		
		Random r = new Random();
        int tPass = r.nextInt((100000 - 10000) + 1) + 10000;
		
		System.out.println("Dear " + user.getUserName() + ", your temporary password is " + r);
		
	}

}
