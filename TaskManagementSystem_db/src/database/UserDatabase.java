package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDatabase
{
	// Get DB Connection
	Connection conn = TMS_DBConnection.getConnection();
	String     sql  = null;

	public boolean validateCredentials(String mailId, String password) throws SQLException
	{
		sql = "select * from user where Email = ? and Password = ?";
		// System.out.println(sql);

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, mailId);
		statement.setString(2, password);

		ResultSet rs = statement.executeQuery();
		while (rs.next())
		{
			return true;
		}

		return false;
	}

}