package database;

import java.util.ArrayList;
import java.util.List;

import entity.User;

public class UserDatabase
{
	private List<User> users = new ArrayList();

	public UserDatabase()
	{
		users.add(new User("User1", "user1@g.com", "user1"));
		users.add(new User("User2", "user2@g.com", "user2"));
	}

	public boolean validateCredentials(String mailId, String password)
	{
		for (User user : users)
		{
			if (user.getUserEmail().equals(mailId))
				if (user.getPassword().equals(password))
					return true;
		}

		return false;
	}

}