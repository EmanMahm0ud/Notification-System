import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class English implements LanguageTemplate {

	private String notificationType;
	private String message;
	
	private HashMap<String, String>EnglishTemplates = new HashMap<>();
	
	public English() {
		// TODO Auto-generated constructor stub
		readFile();
	}
	
	private void readFile() {
		File file = new File("English.txt");
		Scanner fileReader;
		String data;
		try {
			fileReader = new Scanner(file);
			while (fileReader.hasNextLine()) {
				data = fileReader.nextLine();
				notificationType = data;
				data = fileReader.nextLine();
				message = data;
				addTemplete(notificationType, message);
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void writeFile() {
		File file = new File("English.txt");
		try {
			FileWriter fileWriter = new FileWriter(file);
			for (HashMap.Entry<String, String> temp : EnglishTemplates.entrySet()) {
				fileWriter.write(temp.getKey() + "\n" + temp.getValue() + "\n");
			}
		    fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addTemplete(String messageType, String message) {
		EnglishTemplates.put(messageType, message);
		writeFile();
	}
	
	public void updateTemplate(String messageType, String newMessage) {
		EnglishTemplates.replace(messageType, newMessage);
	}
	
	public String readTemplate(String messageType) {
		return EnglishTemplates.get(messageType);
	}
	
	public void deleteTemplate(String messageType) {
		EnglishTemplates.remove(messageType);
		writeFile();
	}

}
