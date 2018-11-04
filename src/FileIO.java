/*
Anh Pham
CIS D035A 61Y
Assignment #3
Due date: 		Thursday, Nov 1, 2018
Submit date: 	Thursday, Nov 1, 2018
*/

import java.io.*;
import java.util.*;

public class FileIO {
	private String fname = null;
	private boolean DEBUG = false; // a debugger: true to view data FileIO reads

	// default constructor
	public FileIO() {
	}

	// constructor: set file's name
	public FileIO(String fname) {
		this.fname = fname;
	}

	// ************************ readDate() ************************
	// Responsibility: read data from input file and populate
	// Receive: none
	// Return: an Franchise object
	// *************************************************************
	public Franchise readData() {
		Franchise a1 = null; // Franchise object that will contain 5 weeks of sales data of 6 stores
		int counter = 0; // track the number of line we are reading. Ex: 1st line - counter = 1 //better
							// name is lineNumber
		try {
			FileReader file = new FileReader(fname); // Open a file object to read from .txt file
			BufferedReader buff = new BufferedReader(file); //// to reads text from a character-input stream , connect
															//// the file reference with a buffer
			String temp;
			boolean eof = false; // flag for End-Of-File

			while (!eof) { // while not reach EOF
				String line = buff.readLine(); // returns null if eof, otherwise, return the string read from input file
				counter++; // move to the next line of input file
				if (line == null) // if no more line, then we reach end-of-file
					eof = true; // to escape while-loop and stop reading from input
				else { // if there's character to read
					if (DEBUG)
						System.out.println("Reading" + line);
					if (counter == 1) { // if program reads first line
						temp = line; // temp contains the first line of Salesdat.txt, which is number of stores
						a1 = new Franchise(Integer.parseInt(temp)); // create a Franchise object with array of stores
																	// according to line 1
						if (DEBUG)
							System.out.println("d  " + a1.numberofstores());
					}
					if (counter == 2) // ignore line 2, which contains header (day 1, day 2, ...)
						;
					if (counter > 2) {
						int x = buildStore(a1, (counter - 3), line); // counter-3 = store index,
						if (DEBUG)
							System.out.println("Reading Store # " + (counter - 2) + " Number of weeks read =  " + x);
						if (DEBUG) {
							System.out.println("Data read:");
							a1.getStores(counter - 3).printdata(); // print 35 Sales data of each store
						}
					}
				}
			}
			buff.close();
		} catch (Exception e) {
			System.out.println("Error -- " + e.toString()); // print the error to console
		}
		return a1;
	}

	// ************************ buildStore() ************************
	// Receive: a1( Franchise's name), counter (store number), temp (an entire line
	// of 35 sales for 1 store)
	// Return: number of weeks read from each store
	// Responsibility: set sales for each day, a.k.a set up a table of sales by week
	// and day
	// *************************************************************

	public int buildStore(Franchise a1, int counter, String temp) {
		Store tstore = new Store(); // a temporary empty array to create array of Stores
		String s1 = "";
		float sale = 0.0f;
		int week = 0;
		int day = 0;
		StringTokenizer st = new StringTokenizer(temp); // to break a string into tokens
		while (st.hasMoreTokens()) { // 'true' if and only if there is at least one token in the string after the
										// current position
			for (day = 0; day < 7; day++) {
				s1 = st.nextToken(); // contains 7 sales from 7 days at a time
				sale = Float.parseFloat(s1); // parse 7 values from the s1
				tstore.setSaleForWeekDayIntersection(week, day, sale); // set sales of a single day of tStore
			}
			week++;
		}
		a1.setStores(tstore, counter); // assign tStore read to Franchise a1
		return week;
	}

}
