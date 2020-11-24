package main;

public abstract class User {
	
	private String userName;
	private String mobileNumber;
	private String email;

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
	
	
}
