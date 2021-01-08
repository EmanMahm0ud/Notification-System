package model.NotificationProject;

import java.util.ArrayList;

public class iSender {
	public String send() {
		String status = "";
		if (Math.random() < 0.5)
			status = "false";
		else
			status = "true";
		return status;
	}
	public void send(ArrayList<String> messages) {
		for (String str : messages) {
			System.out.println(str);
		}
	}
}
