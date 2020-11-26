
public abstract class User {
	
	private String userName;
	private String password;
	private String mobileNumber;
	private String email;
	private LanguageTemplate languageTemp;
	private Channel channels;

	User (){
		
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

	public LanguageTemplate getLanguageTemp() {
		return languageTemp;
	}

	public void setLanguageTemp(LanguageTemplate languageTemp) {
		this.languageTemp = languageTemp;
	}

	public Channel getChannels() {
		return channels;
	}

	public void setChannels(Channel channels) {
		this.channels = channels;
	}
	
	
}
