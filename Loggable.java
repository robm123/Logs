
//interface

import java.time.LocalDateTime;

public interface Loggable
{
	public String toString();

		//format string

	public boolean equals(Loggable obj);

		//return T/F based on the equality of the timestamps

	public boolean isBefore(LocalDateTime obj);

		//return T/F based on whether the log entry timestamp is before the parm

	public boolean isAfter(LocalDateTime obj);

		//return T/F based on whether the log entry timestamp is after the parm

	public boolean between(LocalDateTime obj1, LocalDateTime obj2);

		//return T/F based on whether the log entry timestamp is between the parms

	public boolean contains(String str);

		//return T/F based on whether the log entry contains the parms

}