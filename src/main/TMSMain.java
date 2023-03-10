package main;

import java.util.Scanner;

import entityOperation.TaskOperation;
import entityOperation.UserOperation;

public class TMSMain
{
	public static void main(String[] args)
	{
		String mail, password;

		int lChoice = 1; // Login choice
		int tChoice;     // User choice on task operation

		UserOperation uo = new UserOperation();
		TaskOperation to = new TaskOperation();

		Scanner s = new Scanner(System.in);
		System.out.println("Welcome to Task Management System!" + "\nPlease enter 1 to Login");
		lChoice = s.nextInt();

		if (lChoice == 1)
		{
			s.nextLine();
			// User Login
			System.out.println("Enter Email ID:");
			mail = s.nextLine();

			System.out.println("Enter Password:");
			password = s.nextLine();

			// s.nextLine();
			s.reset();

			try
			{
				if (uo.userLogin(mail, password) == true)
				{
					do
					{
						System.out.println("Please select any of the operations:" + " \n1. Add Task"
								+ "\n2. Update Task" + "\n3. Delete Task" + "\n4. Search Task" + "\n5. Get All Tasks"
								+ "\n6. Get Completed Tasks" + "\n7. Get Incompleted Tasks");
						tChoice = s.nextInt();

						switch (tChoice)
						{
							case 1:
								to.addTask();
								break;

							case 2:
								to.updateTask();
								break;

							case 3:
								to.deleteTask();
								break;

							case 4:
								to.searchTask();
								break;

							case 5:
								to.getAllTasks();
								break;

							case 6:
								to.getCompletedTask();
								break;

							case 7:
								to.getIncompletedTask();
								break;

							default:
								System.out.println("Invalid selection.");
								break;
						}

						// TODO: why sometimes scanner is not triggered & sometimes lchoice is
						// automatically filled as null
						System.out.println("\nDo you want to continue? \n1. Yes  \n2. No");
						lChoice = s.nextInt();
						System.out.println(lChoice);
					}
					while (lChoice == 1);

					// User log off
					uo.userLogoff();
				}
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
				// e.printStackTrace();
			}

		}

		else
			System.out.println("Invalid entry");
	}

}