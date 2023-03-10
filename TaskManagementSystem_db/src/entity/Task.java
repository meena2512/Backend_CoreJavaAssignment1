package entity;

/*
 * pojo class for Task
 */

public class Task
{
	private int    taskId;
	private String taskTitle, taskText, assignedTo;
	private int    taskStatus;
	// private boolean taskStatus = false;
	// TODO: check why boolean doesn't work in mysql

	public Task(int taskId, String taskTitle, String taskText, String assignedTo, int taskStatus)
	{
		super();
		this.taskId     = taskId;
		this.taskTitle  = taskTitle;
		this.taskText   = taskText;
		this.assignedTo = assignedTo;
		this.taskStatus = taskStatus;
	}

	public Task()
	{
	}

	public int getTaskId()
	{
		return taskId;
	}

	public void setTaskId(int taskId)
	{
		this.taskId = taskId;
	}

	public String getTaskTitle()
	{
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle)
	{
		this.taskTitle = taskTitle;
	}

	public String getTaskText()
	{
		return taskText;
	}

	public void setTaskText(String taskText)
	{
		this.taskText = taskText;
	}

	public String getAssignedTo()
	{
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo)
	{
		this.assignedTo = assignedTo;
	}

	public void setTaskStatus(int taskStatus)
	{
		this.taskStatus = taskStatus;
	}

	public int getTaskStatus()
	{
		return taskStatus;
	}

	@Override
	public String toString()
	{
		return "Task [taskId=" + taskId + ", taskTitle=" + taskTitle + ", taskText=" + taskText + ", assignedTo="
				+ assignedTo + ", taskStatus=" + taskStatus + "]";
	}

}
