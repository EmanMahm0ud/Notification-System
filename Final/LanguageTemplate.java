import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class LanguageTemplate {
	private String notificationType;
	private String message;
	
	private HashMap<String, String>LanguageTemplates = new HashMap<>();
	
	public LanguageTemplate() {
		
	}
	
	public LanguageTemplate(String fileName) {
		// TODO Auto-generated constructor stub
		readFile(fileName);
	}
	
	private void readFile(String fileName) {
		File file = new File(fileName);
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
			for (HashMap.Entry<String, String> temp : LanguageTemplates.entrySet()) {
				fileWriter.write(temp.getKey() + "\n" + temp.getValue() + "\n");
			}
		    fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addTemplete(String messageType, String message) {
		LanguageTemplates.put(messageType, message);
		writeFile();
	}
	
	public void updateTemplate(String messageType, String newMessage) {
		LanguageTemplates.replace(messageType, newMessage);
	}
	
	public String readTemplate(String messageType) {
		return LanguageTemplates.get(messageType);
	}
	
	public void deleteTemplate(String messageType) {
		LanguageTemplates.remove(messageType);
		writeFile();
	}
}
