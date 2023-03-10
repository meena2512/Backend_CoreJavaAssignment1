package database;

import java.util.ArrayList;
import java.util.List;

import entity.Task;

public class TaskDatabase
{
	private List<Task> tasks  = new ArrayList();
	int                taskId = 0;

	public int createTask(Task task)
	{
		task.setTaskId(++taskId);

		tasks.add(new Task(task.getTaskId(), task.getTaskTitle(), task.getTaskText(), task.getAssignedTo(), false));

		return task.getTaskId();
	}

	public void updateTask(Task task)
	{

		for (Task t : tasks)
		{
			if (t.getTaskId() == task.getTaskId())
				tasks.set(tasks.indexOf(t), task);
		}
	}

	public void deleteTask(int taskId)
	{
		for (Task task : tasks)
			if (task.getTaskId() == taskId)
				tasks.remove(tasks.indexOf(task));
	}

	public Task searchTask(int taskId)
	{
		for (Task task : tasks)
			if (task.getTaskId() == taskId)
				return tasks.get(tasks.indexOf(task));

		return null;
	}

	public List<Task> getAllTasks()
	{
		return this.tasks;
	}

	public List<Task> getCompletedTasks()
	{
		List<Task> completedTasks = new ArrayList();
		for (Task task : tasks)
			if (task.getTaskStatus())
				completedTasks.add(task);

		return completedTasks;
	}

	public List<Task> getIncompletedTasks()
	{
		List<Task> incompletedTasks = new ArrayList();
		for (Task task : tasks)
			if (task.getTaskStatus() == false)
				incompletedTasks.add(task);

		return incompletedTasks;
	}

	public boolean validateTaskId(int taskId)
	{
		for (Task task : tasks)
			if (task.getTaskId() == taskId)
				return true;

		return false;
	}

}
