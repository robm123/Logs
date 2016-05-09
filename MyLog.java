
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
	This class manages the linked list. It has methods in which you are able to
	insert a node, return the size of the node, and return the entries based on
	time stamps.
*/

public class MyLog
{
	private int elements;
	private LogNode head;


	public MyLog()
	{
		elements = 0;
		head = null;
	}

	public void insert(Loggable obj)
	{
		if(head == null)
		{
			head = new LogNode(obj, null);
		}
		else
		{
			LogNode current = head;

			while(current.getNext() != null)
			{
				current = current.getNext();
			}
			current.setNext(new LogNode(obj, null));
		}
		elements++;
	}

	public int size()
	{
		return elements;
	}

	public void entriesBetween(LocalDateTime before, LocalDateTime after)
	{
		LogNode current = head;

		int i = 0;
		while(current.getNext() != null) ///now we are iterating through each node
		{

			Loggable please = current.getData();
			boolean flag = please.between(before, after);

			if(flag == true)
			{
				System.out.println(current.getData());
			}
			current = current.getNext();
		}
	}

	public void entriesContaining(String word)
	{
		LogNode current = head;

		while(current.getNext() != null)
		{
			Loggable please2 = current.getData();
			boolean flag2 = please2.contains(word);

			if(flag2 == true)
			{
				System.out.println(current.getData());
			}
			current = current.getNext();
		}

	}

	public String toString()
	{
		LogNode currentNode = head;

		String strLog = "";

		while(currentNode != null)
		{
			strLog += currentNode.getData() + "\n";

			currentNode = currentNode.getNext();
		}

		return strLog;
	}


}