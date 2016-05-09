
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.*;


public class CatalinaLog implements Loggable
{
	LocalDateTime timeStamp;
	String info;

	DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


	public CatalinaLog()
	{
		timeStamp = null;
		info = null;
	}
	//Overloaded constructor
	public CatalinaLog(String timeStamp, String restOfLogEntry)
	{
	    this.timeStamp = LocalDateTime.parse(timeStamp, formatter1);
		info = restOfLogEntry;
	}

	public boolean equals(Loggable obj)
	{

	   CatalinaLog var = (CatalinaLog)obj;

	   if(var.equals(timeStamp))
		return true;
           else
		return false;
	}

	public boolean isBefore(LocalDateTime obj)//return T/F based on whether the log entry timestamp is before the parm
	{


		if(timeStamp.isBefore(obj))
			return true;
		else
			return false;
	}

	public boolean isAfter(LocalDateTime obj) 	//return T/F based on whether the log entry timestamp is after the parm
	{


		if(timeStamp.isAfter(obj))
			return true;
		else
			return false;
	}

	public boolean between(LocalDateTime obj1, LocalDateTime obj2)
	{

		if(timeStamp.isAfter(obj1) == true && timeStamp.isBefore(obj2) == true)
			return true;
		else
			return false;
	}

	public boolean contains(String str)  //return T/F based on whether the log entry contains the parms
	{

		if(info.contains(str))
			return true;
			else
			return false;
	}

	public String toString()   //format string with bracket around timestamp then spaces followed by the log entry
	{

		String formattedStr = "[" + timeStamp + "]" +   info;
		return formattedStr;
	}
}