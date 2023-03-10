package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TMS_DBConnection
{
	public static Connection getConnection()
	{
		Connection conn = null;

		try
		{
			// 1. Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("mysql Driver loaded..");

			// 2. Connect to the driver
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tms", "root", "");
			System.out.println("Database Connected!");
		}

		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}

		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return conn;
	}

}
