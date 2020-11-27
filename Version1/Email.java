package main;

public class Email implements Channel{

	@Override
	public void sendNotification(String finalMessage) {
		// TODO Auto-generated method stub
		
		System.out.println(finalMessage + "\t" + "*This is email channel*");
		
	}

}
