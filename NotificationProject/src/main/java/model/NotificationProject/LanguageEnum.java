package model.NotificationProject;

public enum LanguageEnum {
	English,
	Arabic;
	
	public String toString() {
		switch(this) {
			case English: return "English";
			case Arabic: return "Arabic";
			default: return "English";
		}
	}
}
