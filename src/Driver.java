
/*
Anh Pham
CIS D035A 61Y
Assignment #3
Due date: 		Thursday, Nov 1, 2018
Submit date: 	Thursday, Nov 1, 2018
*/

/*
 * Write a program that opens the salesdat.txt file and processes it contents. The program should display the following per store:
The	total sales for each week. (Should print 5 values - one for each week).
The average daily sales for each week. (Should print 5 values - one for each week).
The total sales for all the weeks. (Should print 1 value)
The average weekly sales. (Should print 1 value)
The week with the highest amount in sales. (Should print 1 week #)
The week with the lowest amount in sales. (Should print 1 week #)
The file contains the dollars amount of sales that a retail store made each day for a number of weeks. Each line in the file contains thirty five numbers, which are sales numbers for five weeks. The number are separated by space.  Each line in the file represents a separate store.
Please make sure that you:
a. Add a class diagram with your submission.
b. Add comments to your code in FileIO class.
c. Make sure you adequately test your code.
d. Provide a user-friendly interface (Console based).
 */
import java.io.*;

public class Driver {
	public static void main(String[] args) {
		// create a File object. The current working directory is project's root
		// directory. Not bin's directory. Not src's directory, but the root dir.
		FileIO a1 = new FileIO("src/Salesdat.txt");
		
		// Create Franchise object and read data from Salesdat.txt and finish building
		// table of sales for 6 stores 7 week in Franchise
		Franchise f = a1.readData();

		//Do all the calculation before interacting with user
		f.doCalculation();

		// create UI object and create a loop to interact with users
		UI ui = new UI();
		ui.loop(f);

	}

}
