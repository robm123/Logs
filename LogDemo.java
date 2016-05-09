
import java.util.Scanner;
import java.io.*;
import java.time.LocalDateTime;

/*
	This LogDemo class allows the user to create a specific log. it also
	allows the user to check for different logs and return log entries
	according to what the user wants.
*/
public class LogDemo
{
	public static void main(String [] args)throws IOException
	{
		int num;
		boolean loop = true;
		boolean isActive = false;
		Scanner keyboard = new Scanner(System.in);
		
		Log log = new Log();
		
		do{
				log.startMenu();
				
				if(keyboard.hasNextInt())
				{	
					num = keyboard.nextInt();

					switch(num)
					{
						case 1:	log.createCatalinaLog();
										break;
						case 2: 	log.createErrorLog();
										break;
						case 3:	log.createAccessLog();
										break;
						case 4:	loop = false;
										break;
						default:	System.out.println("Please enter a valid integer 1, 2, 3 ,4\n");
					}
				}
				else
				{
					System.out.println("Incorrect Input, please enter an integer\n");
					keyboard.next();
				}
				
		}while(loop);

	System.out.println("Thank You!\nGOOD BYE!");
	}
}