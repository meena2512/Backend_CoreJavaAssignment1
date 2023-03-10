package entityOperation;

import database.UserDatabase;

public class UserOperation
{
	UserDatabase ud = new UserDatabase();

	public boolean userLogin(String mailId, String password)
	{
		if (ud.validateCredentials(mailId, password))
		{
			System.out.println("User Login Successful!");
			return true;
		}

		System.out.println("Invalid User, Cannot login!");

		return false;

	}

	public boolean userLogoff()
	{
		System.out.println("User logged off successfully!");
		return true;
	}

}
