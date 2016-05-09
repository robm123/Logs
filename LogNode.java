

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/*
	This class creates each node in which it will hold a log entry, as well as a link
	to the next Node. It has methods that can manipulate the data of the node as well
	as link to another node.
*/

public class LogNode
{
	Loggable logEntry;

	LogNode next;

	public LogNode(Loggable logEntry, LogNode next)
	{
		this.logEntry = logEntry;
		this.next = next;
	}

	public Loggable getData()
	{
		return logEntry;
	}

	public void setData(Loggable logEntry)
	{
		this.logEntry = logEntry;
	}

	public LogNode getNext()
	{
		return next;
	}

	public void setNext(LogNode newNode)
	{
		next = newNode;
	}
}