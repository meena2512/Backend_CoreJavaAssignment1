package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Task;

public class TaskDatabase
{
	// Get DB Connection
	Connection conn = TMS_DBConnection.getConnection();
	String     sql  = null;

	public int createTask(Task task) throws Exception
	{
		int taskId = 0;

		// Create statements

		sql = "insert into task values(?,?,?,?,?)";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, taskId);
		statement.setString(2, task.getTaskTitle());
		statement.setString(3, task.getTaskText());
		statement.setString(4, task.getAssignedTo());
		statement.setInt(5, task.getTaskStatus());

		statement.execute();

		// Fetching Task ID for the inserted task record
		sql = "select TaskId from task where TaskTitle like '" + task.getTaskTitle() + "' and AssignedUser like '"
				+ task.getAssignedTo() + "'";
		// System.out.println(sql);

		ResultSet rs = statement.executeQuery(sql);

		while (rs.next())
			// System.out.println("resultSet" + rs.getInt("TaskID"));
			taskId = rs.getInt("TaskID");

		return taskId;
	}

	public boolean updateTask(Task task) throws SQLException
	{
		boolean isTaskUpdated = false;

		// Inserting task title in table 'task'
		sql = "update task set TaskTitle=?, TaskText=?, AssignedUser=?, TaskStatus=? where TaskId=?";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, task.getTaskTitle());
		statement.setString(2, task.getTaskText());
		statement.setString(3, task.getAssignedTo());
		statement.setInt(4, task.getTaskStatus());
		statement.setInt(5, task.getTaskId());

		isTaskUpdated = statement.execute();
		// statement.executeUpdate(sql);

		return isTaskUpdated;
	}

	public boolean deleteTask(int taskId) throws SQLException
	{
		boolean isTaskDeleted = false;

		sql = "delete from task where TaskId=?";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, taskId);
		// System.out.println(sql);

		isTaskDeleted = statement.execute();

		return isTaskDeleted;
	}

	public Task searchTask(int taskId) throws SQLException
	{
		Task task = new Task();
		sql = "select * from task where TaskId = ?";
		// System.out.println(sql);

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, taskId);

		// Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery();

		while (rs.next())
		{
			task.setTaskId(rs.getInt(1));
			task.setTaskTitle(rs.getString(2));
			task.setTaskText(rs.getString(3));
			task.setAssignedTo(rs.getString(4));
			task.setTaskStatus(rs.getInt(5));
		}

		return task;
	}

	public List<Task> getAllTasks() throws SQLException
	{
		List<Task> taskList = new ArrayList<>();
		sql = "select * from task";

		// Create Statements
		Statement statement = conn.createStatement();
		ResultSet rs        = statement.executeQuery(sql);

		while (rs.next())
		{
			Task t = new Task();
			t.setTaskId(rs.getInt(1));
			t.setTaskTitle(rs.getString(2));
			t.setTaskText(rs.getString(3));
			t.setAssignedTo(rs.getString(4));
			t.setTaskStatus(rs.getInt(5));

			taskList.add(t);
		}

		return taskList;
	}

	public List<Task> getCompletedTasks() throws SQLException
	{
		List<Task> taskList = new ArrayList<>();
		sql = "select * from task where TaskStatus = '1'";

		// Create Statements
		Statement statement = conn.createStatement();
		ResultSet rs        = statement.executeQuery(sql);

		while (rs.next())
		{
			Task t = new Task();
			t.setTaskId(rs.getInt(1));
			t.setTaskTitle(rs.getString(2));
			t.setTaskText(rs.getString(3));
			t.setAssignedTo(rs.getString(4));
			t.setTaskStatus(rs.getInt(5));

			taskList.add(t);
		}

		return taskList;
	}

	public List<Task> getIncompletedTasks() throws SQLException
	{
		List<Task> taskList = new ArrayList<>();
		sql = "select * from task where TaskStatus = '0'";
		// System.out.println(sql);

		// Create Statements
		Statement statement = conn.createStatement();
		ResultSet rs        = statement.executeQuery(sql);

		while (rs.next())
		{
			Task t = new Task();
			t.setTaskId(rs.getInt(1));
			t.setTaskTitle(rs.getString(2));
			t.setTaskText(rs.getString(3));
			t.setAssignedTo(rs.getString(4));
			t.setTaskStatus(rs.getInt(5));

			taskList.add(t);
		}

		return taskList;
	}

	public boolean validateTaskId(int taskId) throws SQLException
	{
		sql = "select * from task where TaskId = " + taskId;
		// System.out.println(sql);

		Statement statement = conn.createStatement();
		ResultSet rs        = statement.executeQuery(sql);

		while (rs.next())
			return true;

		return false;
	}

}
