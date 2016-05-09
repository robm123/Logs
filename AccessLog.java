
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.*;


public class AccessLog implements Loggable
{
	LocalDateTime timeStamp1;
	String info1;

	DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss");



	public AccessLog()
	{
		timeStamp1 = null;
		info1 = null;
	}

	//Overloaded constructor
	public AccessLog(String timeStamp, String restOfLogEntry)
	{
	    this.timeStamp1 = LocalDateTime.parse(timeStamp, formatter3);
		info1 = restOfLogEntry;
	}

	public boolean equals(Loggable obj)
	{

	   AccessLog var = (AccessLog)obj;

	   if(var.equals(timeStamp1))
		return true;
           else
		return false;
	}

	public boolean isBefore(LocalDateTime obj)
	{
		//return T/F based on whether the log entry timestamp is before the parm

		if(timeStamp1.isBefore(obj))
			return true;
		else
			return false;
	}

	public boolean isAfter(LocalDateTime obj)
	{
		//return T/F based on whether the log entry timestamp is after the parm

		if(timeStamp1.isAfter(obj))
			return true;
		else
			return false;
	}

	public boolean between(LocalDateTime obj1, LocalDateTime obj2)   //LOOKS LIKE IT USES THE CURRENT TIMESTAMP TO MAKE THE COMPARISON WITH THE PASSEDPARM(STAYS THE SAME
	{	

		if(timeStamp1.isAfter(obj1) == true && timeStamp1.isBefore(obj2) == true)
			return true;
		else
			return false;

	}

	public boolean contains(String str)  //return T/F based on whether the log entry contains the parms
	{

		if(info1.contains(str))
			return true;
			else
			return false;
	}

	public String toString()   //format string with bracket around timestamp then spaces followed by the log entry
	{

		String formattedStr1 = "[" + timeStamp1 + "]   " +   info1;
		return formattedStr1;
	}
}