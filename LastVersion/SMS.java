
public class SMS implements Channel {
	
	public void sendNotification(String finalMessage) {
		System.out.println(finalMessage + "\t" + "*This is SMS channel*");
	}
}