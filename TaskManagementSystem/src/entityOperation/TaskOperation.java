package entityOperation;

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
		int taskId = 0;
		// s.nextLine();

		System.out.println("Enter Task Title: ");
		task.setTaskTitle(s.nextLine());
		System.out.println("Enter Task Description: ");
		task.setTaskText(s.nextLine());
		System.out.println("Enter the assigned user:");
		task.setAssignedTo(s.nextLine());

		taskId = td.createTask(task);
		System.out.println(task);
		if (taskId != 0)
		{
			System.out.println("Great! Your Task has been created successfully. The Task ID is " + taskId + ".");
			return true;
		}

		return false;
	}

	public void updateTask()
	{
		// Task task = new Task();

		System.out.println("Please Enter Task ID");
		task.setTaskId(s.nextInt());

		s.nextLine();
		try
		{
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
				if (s.nextInt() == 1)
					task.setTaskStatus(true);
				else
					task.setTaskStatus(false);

				td.updateTask(task);
				System.out.println("Great! Your Task has been updated successfully.");
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}
	}

	public void deleteTask()
	{
		System.out.println("Please Enter Task ID to delete record: ");
		task.setTaskId(s.nextInt());

		try
		{
			if (validateTaskId(task.getTaskId()))
			{
				td.deleteTask(task.getTaskId());
				System.out.println("Your Task has been deleted successfully.");
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}
	}

	public void searchTask()
	{
		System.out.println("Please Enter Task ID to search: ");
		int taskId = s.nextInt();

		task = td.searchTask(taskId);

		if (task != null)
			System.out.println("Your Task has been found!\n" + task);

		else
			System.out.println("Task Id not found..");
	}

	public void getAllTasks()
	{
		System.out.println(td.getAllTasks());
	}

	public void getCompletedTask()
	{
		System.out.println(td.getCompletedTasks());
	}

	public void getIncompletedTask()
	{
		System.out.println(td.getIncompletedTasks());
	}

	public boolean validateTaskId(int taskId) throws Exception
	{
		System.out.println("Validating the Task Id... \n ... \n ...");
		// System.out.println(td.validateTaskId(taskId));
		if (td.validateTaskId(taskId))
		{
			System.out.println("Task Id is valid");
			return true;
		}

		throw new Exception("Invalid task Id");
	}

}
