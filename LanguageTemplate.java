
public interface LanguageTemplate {
	
	public void addTemplete(String messageType, String message);
	public void updateTemplate(String messageType, String newMessage);
	public String readTemplate(String messageType);
	public void deleteTemplate(String messageType);
	
}
