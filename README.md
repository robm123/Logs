## ![](https://cdn2.iconfinder.com/data/icons/circle-icons-1/64/document-24.png)Searching Through Different Logs


This program allows the user to create unordered list from the Catalina Log, Error Log, or Access log.Upon selecting one of the logs the user gets presented with a menu:

* Print the log
* display size of the log
* search for entries between dates
* search for specific word
* exit

A linked list is used in order to seperate each entry with all the information. All the logs have different configurations so each log gets broken down differently. 

The *java.time.LocalDateTime* gets imported inorder to decipher the dates from each log because each of them have different date arrangements. This is used to display the information back to the user.

