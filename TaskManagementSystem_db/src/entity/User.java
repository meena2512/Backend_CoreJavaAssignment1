package entity;

/*
 * pojo class for User
 */

public class User
{
	private String userName, userEmail, password;

	public User(String userName, String userEmail, String password)
	{
		super();
		this.userName  = userName;
		this.userEmail = userEmail;
		this.password  = password;
	}

	public User()
	{
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getUserEmail()
	{
		return userEmail;
	}

	public void setUserEmail(String userEmail)
	{
		this.userEmail = userEmail;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Override
	public String toString()
	{
		return "User [userName=" + userName + ", userEmail=" + userEmail + ", password=" + password + "]";
	}

}
