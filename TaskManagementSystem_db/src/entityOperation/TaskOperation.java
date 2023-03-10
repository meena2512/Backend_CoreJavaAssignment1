package entityOperation;

import java.sql.SQLException;
import java.util.Scanner;

import database.TaskDatabase;
import entity.Task;

public class TaskOperation
{
	Task         task = new Task();
	TaskDatabase td   = new TaskDatabase();
	Scanner      s    = new Scanner(System.in);

	public boolean addTask()
	{
		// Task task = new Task();
		// s.nextLine();

		System.out.println("Enter Task Title: ");
		task.setTaskTitle(s.nextLine());
		System.out.println("Enter Task Description: ");
		task.setTaskText(s.nextLine());
		System.out.println("Enter the assigned user:");
		task.setAssignedTo(s.nextLine());

		/*
		 * System.out.println("Enter Task Status:" +
		 * "\n1. Completed \n2. Not Completed");
		 * task.setTaskStatus(s.nextInt());
		 * if (s.nextInt() == 1)
		 * task.setTaskStatus(true);
		 * else
		 * task.setTaskStatus(false);
		 */

		try
		{
			System.out.println(task);
			task.setTaskId(td.createTask(task));
			System.out.println("Great! Your Task has been created successfully. The Task ID is " + task.getTaskId());
			return true;
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}
		return false;
	}

	public boolean updateTask()
	{
		// Task task = new Task();

		System.out.println("Please Enter Task ID");
		task.setTaskId(s.nextInt());

		s.nextLine();
		if (validateTaskId(task.getTaskId()))
		{
			System.out.println("Please enter the following details to update:");
			System.out.println("Task Title: ");
			task.setTaskTitle(s.nextLine());

			System.out.println("Task Description: ");
			task.setTaskText(s.nextLine());

			System.out.println("Assigned User:");
			task.setAssignedTo(s.nextLine());

			System.out.println("Task Status: (0. Not Completed  1. Completed)");
			task.setTaskStatus(s.nextInt());

			try
			{
				td.updateTask(task);
				System.out.println("Great! Your Task has been updated successfully.");
				return true;
			}
			catch (SQLException e1)
			{
				System.out.println(e1.getMessage());
				// e1.printStackTrace();
			}
		}

		return false;
	}

	public boolean deleteTask()
	{
		System.out.println("Please Enter Task ID to delete record: ");
		task.setTaskId(s.nextInt());

		if (validateTaskId(task.getTaskId()))
		{
			try
			{
				td.deleteTask(task.getTaskId());
				System.out.println("Your Task has been deleted successfully.");
				return true;
			}
			catch (SQLException e)
			{
				System.out.println(e.getMessage());
				// e.printStackTrace();
			}
		}

		return false;
	}

	public boolean searchTask()
	{
		System.out.println("Please Enter Task ID to search: ");
		task.setTaskId(s.nextInt());

		try
		{
			task = td.searchTask(task.getTaskId());
			if (task.getTaskId() != 0)
			{
				System.out.println("Your Task has been found!\n" + task);
				return true;
			}
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}

		System.out.println("Task is not found!");
		return false;
	}

	public boolean getAllTasks()
	{
		try
		{
			System.out.println(td.getAllTasks());
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}
		return true;
	}

	public boolean getCompletedTask()
	{
		try
		{
			System.out.println(td.getCompletedTasks());
			return true;
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}
		return false;
	}

	public boolean getIncompletedTask()
	{
		try
		{
			System.out.println(td.getIncompletedTasks());
			return true;
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}
		return false;
	}

	public boolean validateTaskId(int taskId)
	{
		System.out.println("Validating the Task Id... \n ...  \n ...");
		try
		{
			if (td.validateTaskId(taskId))
			{
				System.out.println("Task Id is valid");
				return true;
			}
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
			// e.printStackTrace();

		}
		System.out.println("Task Id is not valid!");
		return false;
	}

}
