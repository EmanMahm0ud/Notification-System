package model.NotificationProject;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class NotificationTemplate {
	private int id;
	private String subject;
	private String content;
	private LanguageEnum language;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LanguageEnum getLanguage() {
		return language;
	}
	public void setLanguage(LanguageEnum language) {
		this.language = language;
	}
	
	
}
