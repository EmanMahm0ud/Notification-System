package model.NotificationProject;

public class User {
	
	private String userName;
	private String password;
	private String mobileNumber;
	private String email;
	private LanguageEnum language;
	private Channel channels;

	User (){
		userName = "user";
		password = "password";
		mobileNumber = "";
		email = "";
		language = LanguageEnum.Arabic;
		channels = new Email();
	}
	
	public String getUserName()
	{
		return userName;
	}
	
	public void setUserName (String userName)
	{
		this.userName = userName;
	}
	
	public String getMobileNumber()
	{
		return mobileNumber;
	}
	
	public void setMobileNumber(String mobileNumber)
	{
		this.mobileNumber = mobileNumber;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LanguageEnum getLanguage() {
		return language;
	}

	public void setLanguage(LanguageEnum language) {
		this.language = language;
	}

	public Channel getChannels() {
		return channels;
	}

	public void setChannels(Channel channels) {
		this.channels = channels;
	}
	
	
}