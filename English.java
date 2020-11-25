package com.company;

public class English implements LanguageTemplate {

	public English() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String forgetPasswordTemplate(String Email) {
		String message = "hi " + Email + "please enter your new password and confirm it again.";
		// TODO Auto-generated method stub
		return message;
	}

	@Override
	public String verificationPasswordTemplate(String userName) {
		String message = "Hi " + userName + "thank you for Signing up :)";
		// TODO Auto-generated method stub
		return message;
	}

	@Override
	public String OrderConfirmationTemplate(String userName, String orderItem) {
		String message = "Dear " + userName + "your booking of the " + " orderItem + is confirmed. thanks for using our store :)"; 
		// TODO Auto-generated method stub
		return message;
	}

}
