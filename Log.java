import java.util.Scanner;
import java.io.*;
import java.time.LocalDateTime;

public class Log
{
	
	public static void startMenu()
	{
		System.out.println("*********************************************************");
		System.out.println("*\tPlease select which Log you would like to create.\t\t*");
		System.out.println("*  \t\t1. Catalina Log\t\t\t\t*\n*  \t\t2. Error Log\t\t\t\t*\n*"
									+ "\t\t3. Access Log\t\t\t\t*\n*"
									+ "\t\t4. Exit\t\t\t\t\t*");
		System.out.println("*********************************************************");
	}

	public static void subMenu()
	{
		String subMenu = "\n*************************************************\n"
					  + "*\tPlease select one of the following options\t*\n"
					  + "*\t\t1. Print the Log\t\t\t*\n"
					  +	"*\t\t2. Print the Size of the log\t\t*\n"
					  +	"*\t\t3. Search for entries between dates\t*\n"
					  + "*\t\t4. Search entries for specific word\t*\n"
					  +	"*\t\t5. Exit\t\t\t\t*\n"
					  +  "*************************************************\n";
					  
		System.out.println(subMenu);
	}

	
	public static void createCatalinaLog()throws IOException
	{
		Scanner keyboard = new Scanner(System.in);

		MyLog obj = new MyLog();
		String date = "";
		String info = "";
		String entry = "";
		boolean loop = true;
		int choice = 0;
		
		File myFile = new File("catalina_log_small.java");
		
		Scanner inputFile = new Scanner(myFile);

		Loggable log = new CatalinaLog();

		while(inputFile.hasNextLine())
		{
			entry = inputFile.nextLine();

			date = entry.substring(0,19);						//date part
			info = entry.substring(20, entry.length()); 	//info part

			log = new CatalinaLog(date, info);

			obj.insert(log);
		}
		
		inputFile.close();

		do{
				System.out.print("\t\t-------Catalina Log-------");
				subMenu();
				if(keyboard.hasNextInt())
				{
					choice = keyboard.nextInt();
					
					switch(choice)
					{
						case 1:	printLog(obj);
								break;
						case 2: 	printNumberofEntries(obj);
								break;
						case 3:	searchBetweenDates(obj);
								break;
						case 4:	searchForWord(obj);
								break;
						case 5:	System.out.println("Log finished\n");
										loop = false;
								break;
						default:	System.out.println("Please enter a valid number 1, 2, 3, 4, or 5\n");
					}
				}
				else
				{
					System.out.println("Input is invalid, please try again");
					keyboard.next();
				}
			
		}while(loop);
		
	}

	public static void createErrorLog()throws IOException
	{
		Scanner keyboard = new Scanner(System.in);

		MyLog obj = new MyLog();
		String date = "";
		String info = "";
		String entry = "";
		boolean loop = true;		
		int choice = 0;
		File myFile = new File("error_log_small.java");
		Scanner inputFile = new Scanner(myFile);

		Loggable log = new ErrorLog();

		while(inputFile.hasNextLine())
		{
			entry = inputFile.nextLine();          //a string

			date = entry.substring(1,32);				//date part
			
			info = entry.substring(33, entry.length()); //info part

			log = new ErrorLog(date, info);

			obj.insert(log);
		}
		inputFile.close();//

		do{
				System.out.print("\t\t-------Error Log-------");				
				subMenu();
			
				if(keyboard.hasNextInt())
				{	
					choice = keyboard.nextInt();
					
					switch(choice)
					{
						case 1:		printLog(obj);
									break;
						case 2: 		printNumberofEntries(obj);
									break;
						case 3:		searchDatesForErrorLog(obj);
									break;
						case 4:		searchForWord(obj);
									break;
						case 5:		System.out.println("Log finished\n");	
											loop = false;
									break;
						default:	System.out.println("Please enter a valid number 1, 2, 3, 4, or 5\n");
					}
				}
				else
				{
					System.out.println("Input is invalid, please try again");
					keyboard.next();
				}
			}while(loop);

		}

	public static void createAccessLog()throws IOException
	{
		Scanner keyboard = new Scanner(System.in);

		MyLog obj1 = new MyLog();

		String date = "";
		String info1 = "";
		String info2 = "";
		boolean loop = true;
		String entry = "";	
		int choice;
		
		File myFile = new File("access_log_small.java");
		Scanner inputFile = new Scanner(myFile);
		
		Loggable log = new AccessLog();

		while(inputFile.hasNextLine())								//inserts new node into link list with each day's info and message
		{
			entry = inputFile.nextLine();

			int num = entry.indexOf('[');

			info1 = entry.substring(0,num);

			date = entry.substring(num+1,num+21);				       //date part

			info2 = entry.substring(num+21, entry.length());        //info part

			String entireInfo = info1 + info2;

			log = new AccessLog(date, entireInfo);

			obj1.insert(log);
		}
		inputFile.close();

		do{
				System.out.print("\t\t-------Access Log-------");
				subMenu();
				
				if(keyboard.hasNextInt())
				{
					choice = keyboard.nextInt();
			
					switch(choice)
					{
						case 1:		printLog(obj1);
									break;
						case 2: 		printNumberofEntries(obj1);
									break;
						case 3:		searchBetweenDates(obj1);    //searchDatesAccessLog(obj1);
									break;
						case 4:		searchForWord(obj1);
									break;
						case 5:		loop = false;
											System.out.println("Finished Access Log\n");
									break;
						default:	System.out.println("Invalid Integer Please try 1, 2, 3, 4, 5\n");
					}
					
				}
				else	
				{
					System.out.println("Input is invalid, please try again");
					keyboard.next();
				}
				
		}while(loop);

	}

	
	
	
	public static void printLog(MyLog log)
	{
		System.out.println("\nThe entries in this Log are: \n\n" + log);
	}

	public static void printNumberofEntries(MyLog log)
	{

		System.out.println("\nThe number of log entries: " + log.size());
	}

	public static void searchForWord(MyLog log)
	{
		String word = "";

		Scanner keyboard = new Scanner(System.in);

		System.out.println("Please Enter a word,phrase,IP address, process IF, error/info code");
		word = keyboard.nextLine();


		System.out.println("\nThe log entries that contain \"" + word + "\" are:\n");
		log.entriesContaining(word);
	}

	
	
	public static void searchBetweenDates(MyLog log)
	{
		Scanner keyboard = new Scanner(System.in);

		int year, day, month, hour, minutes, seconds;

		System.out.println("\nPlease enter two dates inorder to find entries between them");
		System.out.println("Enter the \" Before Date\"\n");

		System.out.print("Please Enter the Year(number):\t");
		year = keyboard.nextInt();

		System.out.print("Please Enter the day(number):\t");
		day = keyboard.nextInt();

		System.out.print("Please Enter the month(number):\t");
		month = keyboard.nextInt();

		System.out.print("Please Enter the hour(number):\t");
		hour = keyboard.nextInt();

		System.out.print("Please Enter the minutes(number):\t");
		minutes = keyboard.nextInt();

		System.out.print("Please Enter the seconds(number):\t");
		seconds = keyboard.nextInt();

		LocalDateTime before = LocalDateTime.of(year, month, day, hour, minutes, seconds);   //of(year, month, day, hour, minutes, seconds);

		System.out.println("\nEnter the \"After Date\" \n");
		System.out.print("Please Enter the Year(number):\t");
		year = keyboard.nextInt();

		System.out.print("Please Enter the day(number):\t");
		day = keyboard.nextInt();

		System.out.print("Please Enter the month(number):\t");
		month = keyboard.nextInt();

		System.out.print("Please Enter the hour(number):\t");
		hour = keyboard.nextInt();

		System.out.print("Please Enter the minutes(number):\t");
		minutes = keyboard.nextInt();

		System.out.print("Please Enter the seconds(number):\t");
		seconds = keyboard.nextInt();

		LocalDateTime after = LocalDateTime.of(year, month, day, hour, minutes, seconds);

		System.out.println("\nThe Log entries between: " + before + " and " + after + " are:\n");
		log.entriesBetween(before, after);
	}

	public static void searchDatesForErrorLog(MyLog log)
	{
		Scanner keyboard = new Scanner(System.in);

		int year, month, dayOfMonth, hour, minutes, seconds, nanoOfSecond;

		System.out.println("\nPlease enter two dates inorder to find entries between them");
		System.out.println("Enter the \" Before Date\"\n");

		System.out.print("Please Enter the year(number):\t");
		 year = keyboard.nextInt();

		System.out.print("Please Enter month(number):\t");
		month = keyboard.nextInt();

		System.out.print("Please Enter the day of month(number):\t");
		dayOfMonth = keyboard.nextInt();

		System.out.print("Please Enter the hour(number):\t");
		hour = keyboard.nextInt();

		System.out.print("Please Enter the minutes(number):\t");
		minutes = keyboard.nextInt();

		System.out.print("Please Enter the seconds(number):\t");
		seconds = keyboard.nextInt();

		System.out.print("Please Enter the nano seconds(number):\t");
		nanoOfSecond = keyboard.nextInt();

		LocalDateTime before = LocalDateTime.of(year, month, dayOfMonth, hour, minutes, seconds, nanoOfSecond);

		System.out.println("\nPlease enter two dates inorder to find entries between them");
		System.out.println("Enter the \" After Date\"\n");

		System.out.print("Please Enter the year(number):\t");
		 year = keyboard.nextInt();

		System.out.print("Please Enter month(number):\t");
		month = keyboard.nextInt();

		System.out.print("Please Enter the day of month(number):\t");
		dayOfMonth = keyboard.nextInt();

		System.out.print("Please Enter the hour(number):\t");
		hour = keyboard.nextInt();

		System.out.print("Please Enter the minutes(number):\t");
		minutes = keyboard.nextInt();

		System.out.print("Please Enter the seconds(number):\t");
		seconds = keyboard.nextInt();

		System.out.print("Please Enter the nano seconds(number):\t");
		nanoOfSecond = keyboard.nextInt();

		LocalDateTime after = LocalDateTime.of(year, month, dayOfMonth, hour, minutes, seconds, nanoOfSecond);

		System.out.println("\nThe Log entries between: " + before + " and " + after + " are:\n");
		log.entriesBetween(before, after);
	}

}