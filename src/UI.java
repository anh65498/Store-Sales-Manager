
//UI class: take input and print output

import java.io.*; //to display to console
import java.util.Scanner; //to read input
import java.util.Arrays; //to sort arrays
/*
Anh Pham
CIS D035A 61Y
Assignment #3
Due date: 		Thursday, Nov 1, 2018
Submit date: 	Thursday, Nov 1, 2018
*/

public class UI {
	private int numberOfLoops; // keep track of how many times user use the program
	private int optionChoice;
	private int storeChoice;
	private int MAXSTORECHOICE = 6; // to limit the number of stores customer can choose, same as number of store in
									// Salesdat.txt
	private int MAXOPTIONCHOICE = 7;// the number of options in the menu for customer to choose

	// default constructor: auto initialize PRIMITIVE private instance variables
	UI() {
		System.out.printf("Welcome to Franchise Sales Manager Application.\n");
		System.out.printf("We have sales data for 6 stores for the last 5 weeks.\n");
	}

	// setter methods for instance variables - optionChoice and storeChoice
	public void setOptionChoice(int choice) {
		this.optionChoice = choice;
	}

	public void setStoreChoice(int choice) {
		this.storeChoice = choice;
	}

	// display Option Menu, get and set store choice and option choice of user
	public void displayOptionMenu(int storeChoice, int optionChoice) {
		Scanner in = new Scanner(System.in);
		System.out.printf("Select a store # you want to see analytics for - enter <1 through 6>");

		setStoreChoice(getPositiveIntegerInput(in, MAXSTORECHOICE) - 1);

		System.out.printf(
				"\nSelect operation -\n 1. Enter 1 for total sales for each week\n 2. Enter 2 for average daily sales for each week\n"
						+ " 3. Enter 3 for total sales for all weeks\n 4. Enter 4 for average weekly sales\n"
						+ " 5. Enter 5 for week with the highest amount in sales.\n 6. Enter 6 for week with the lowest amount in sales.\n"
						+ " 7. Enter 7 for all analytical data. (1 through 6)\n");
		// optionChoice = getPositiveIntegerInput(in);
		setOptionChoice(getPositiveIntegerInput(in, MAXOPTIONCHOICE));
	}

	// assumption: Franchise is instantiated and filled with data from FileIO
	// argument: franchise (in case there are multiple franchises, each has stores)
	// create a loop so that user can use the program as much as possible until
	// he/she wants to quit
	public void loop(Franchise franchise) {
		String user_choice = "";
		// loop the application until the user press "q" or "Q" to quit

		do {
			Scanner in = new Scanner(System.in);
			displayOptionMenu(storeChoice, optionChoice);

			switch (optionChoice) {
			case 1:
				displayTotalWeeklySales(franchise);
				break;

			case 2:
				displayAverageDailySales(franchise);
				break;

			case 3:
				displayTotalSales(franchise);
				break;

			case 4:
				displayAverageWeeklySales(franchise);
				break;

			case 5:
				displayWeekWithHighestSales(franchise);
				break;

			case 6:
				displayWeekWithLowestSales(franchise);
				break;

			case 7:
				displayTotalWeeklySales(franchise);
				displayAverageDailySales(franchise);
				displayTotalSales(franchise);
				displayWeekWithHighestSales(franchise);
				displayWeekWithLowestSales(franchise);
				break;

			default:
				System.out.println("Error: invalid status");
				System.exit(1);
			}

			// Let user decide to continue the program or not, via their input
			System.out.printf("Press 'q' if you want to quit the program. Any other key to continue: ");
			user_choice = in.nextLine();
			System.out.printf("\n\n");
			// System.out.printf("User choice is %4s\n", user_choice); //debug
			numberOfLoops++;
		} while (!user_choice.equals("q") && !user_choice.equals("Q")); // Use equals(). not ==, to compare contents of
																		// string
	}

	// prompt user for positive integer input between 1 and max
	public int getPositiveIntegerInput(Scanner in, int max) {
		System.out.printf("\nEnter your choice: ");
		int num = 0;
		while (!in.hasNextInt() || (num = in.nextInt()) <= 0 || num > max) {
			System.out.printf("Please enter a positive number within range: ");
			in.nextLine();
		}
		return num;
	}

	// display information for option 1
	public void displayTotalWeeklySales(Franchise franchise) {
		System.out.printf("Total sales for each week of store %1d\n", storeChoice + 1);
		// reiterate through each week and print the total sales for each week of the
		// chosen store
		for (int weekIndex = 0; weekIndex < franchise.getStores(storeChoice).getWEEK(); weekIndex++) {
			// System.out.printf("\t\tWeek %2d is %5f\n", weekIndex+1,
			// franchise.getStores(storeChoice).getTotalSalesEachWeek()[weekIndex]);
			System.out.printf("\t\tWeek %2d is %5f\n", weekIndex + 1,
					franchise.getStores(storeChoice).getTotalSalesEachWeek()[weekIndex]);
			System.out.print("\n"); // for debug
		}
	}

	// display information for option 2
	public void displayAverageDailySales(Franchise franchise) {
		System.out.printf("The average daily sales for each week of store %1d\n", storeChoice + 1);
		for (int weekIndex = 0; weekIndex < franchise.getStores(storeChoice).getWEEK(); weekIndex++) {
			System.out.printf("\t\tWeek %2d is %5f\n", weekIndex + 1,
					franchise.getStores(storeChoice).getAverageDailySalesPerWeek()[weekIndex]);
			System.out.print("\n"); // for debug
		}
	}

	// display information for option 3
	public void displayTotalSales(Franchise franchise) {
		float total = franchise.getStores(storeChoice).getTotalSalesOfStore();
		System.out.printf("The total sales of store %1d is %5f\n", storeChoice + 1, total);
	}

	// display information for option 4
	public void displayAverageWeeklySales(Franchise franchise) {
		System.out.printf("The average weekly sales of store %1d is %5f\n", storeChoice + 1,
				franchise.getStores(storeChoice).getAverageWeeklySales());
	}

	// display information for option 5
	public void displayWeekWithHighestSales(Franchise franchise) {
		int highestWeek = franchise.getStores(storeChoice).getWeekWithHighestSales();
		System.out.printf("The week with the highest amount in sales of store %1d is %1d\n", storeChoice + 1,
				highestWeek);

	}

	// display information for option 6
	public void displayWeekWithLowestSales(Franchise franchise) {
		int lowestWeek = franchise.getStores(storeChoice).getWeekWithLowestSales();
		System.out.printf("The week with the lowest amount in sales of store %1d is %1d\n", storeChoice + 1,
				lowestWeek);

	}

} // end of class UI
