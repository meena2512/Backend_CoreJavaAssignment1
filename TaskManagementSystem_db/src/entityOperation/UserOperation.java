package entityOperation;

import java.sql.SQLException;

import database.UserDatabase;

public class UserOperation
{
	UserDatabase ud = new UserDatabase();

	public boolean userLogin(String mailId, String password)
	{
		try
		{
			if (ud.validateCredentials(mailId, password))
			{
				System.out.println("User Login Successful!");
				return true;
			}
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
			// e.printStackTrace();
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
