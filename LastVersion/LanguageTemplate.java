import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class LanguageTemplate {
	private String notificationType;
	private String message;
	private String fileName;
	private HashMap<String, String>LanguageTemplates = new HashMap<>();
	
	public LanguageTemplate() {
		
	}
	
	
	public LanguageTemplate(fileName) {
		// TODO Auto-generated constructor stub
		readFile(fileName);
	}
	
	public void setFile(String filename) {
		// TODO Auto-generated constructor stub
		this.fileName=filename;
	}
	
	private void readFile(fileName) {
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
		File file = new File(fileName);
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
		status(1);
	}
	
	public void updateTemplate(String messageType, String newMessage) {
		LanguageTemplates.replace(messageType, newMessage);
		status(2);
	}
	
	public String readTemplate(String messageType) {
		return LanguageTemplates.get(messageType);
	}
	
	public void deleteTemplate(String messageType) {
		LanguageTemplates.remove(messageType);
		writeFile();
		status(3);
	}
	public void status (int n)
	{
		switch(n)
		{
		case 1:
			System.out.println("Language template added succefully");
			break;
		case 2:
			System.out.println("Language template updated succefully");
			break;
		case 3:
			System.out.println("Language template removed succefully");
			break;
		case 4:
			System.out.println("File name is not correct( File not exist)");
			break;
			
		}
		
	}
}
