/*
Anh Pham
CIS D035A 61Y
Assignment #3
Due date: 		Thursday, Nov 1, 2018
Submit date: 	Thursday, Nov 1, 2018
*/

public class Store {
	private float[][] salesByWeek; // 2D array (like a table): [Week][[Day]
	private float[] totalWeeklySales; // array of 5 total weekly sales of 5 weeks
	private float[] averageDailySalesPerWeek; // array of 5 average daily sales per week
	private float totalSales; // total sales of 5 weeks per store
	private float averageWeeklySales;
	private int weekWithHighestSales;
	private int weekWithLowestSales;

	private static int WEEK = 5; // 5 week
	private static int DAY = 7; // each week has 7 days

	// default constructor: initialize private instance variable
	Store() {
		salesByWeek = new float[WEEK][DAY]; // 5 weeks, 7 days
		totalWeeklySales = new float[WEEK];
		averageDailySalesPerWeek = new float[WEEK];
	}

	// getter method of sales of a single day
	public float getSaleForWeekDayIntersection(int week, int day) {
		return salesByWeek[week][day];
	}

	// setters method of sales of a single day
	public void setSaleForWeekDayIntersection(int week, int day, float sale) {
		salesByWeek[week][day] = sale;
	}

	// getter methods of WEEK and DAY
	public int getWEEK() {
		return WEEK;
	}

	public int getDAY() {
		return DAY;
	}

	// Responsibility: calculate the total sales of each week for each store
	public void calculateTotalSalesEachWeek() {
		float weeklySum = 0f;
		for (int row = 0; row < WEEK; row++) { // represent day
			for (int col = 0; col < DAY; col++) { // represent week
				weeklySum += salesByWeek[row][col];
			}
			this.totalWeeklySales[row] = weeklySum;
			weeklySum = 0f;

		}
	}

	// Resp.: return an array of 5 total weekly sales
	public float[] getTotalSalesEachWeek() {
		// calculateTotalSalesEachWeek();
		return this.totalWeeklySales; // totalWeeklySales is an array of 5 integer, each is the sum calculated of
										// weekly sales
	}

	// option 2:
	public void calculateAverageDailySalesPerWeek() {
		for (int weekIndex = 0; weekIndex < WEEK; weekIndex++) {
			averageDailySalesPerWeek[weekIndex] = (this.totalWeeklySales[weekIndex]) / 7;
		}
	}

	public float[] getAverageDailySalesPerWeek() {
		return this.averageDailySalesPerWeek;
	}

	// option 3:
	public void calculateTotalSalesOfStore() {
		for (int weekIndex = 0; weekIndex < WEEK; weekIndex++) {
			this.totalSales += this.totalWeeklySales[weekIndex];
		}
	}

	public float getTotalSalesOfStore() {
		return this.totalSales;
	}

	// option 4
	// average weekly sales = sum of weekly total sales / 5
	public void calculateAverageWeeklySales() {
		float sum = 0;
		for (int weekIndex = 0; weekIndex < WEEK; weekIndex++) {
			sum += this.totalWeeklySales[weekIndex];
		}
		this.averageWeeklySales = sum / 5;
	}

	public float getAverageWeeklySales() {
		return this.averageWeeklySales;
	}

	// option 5
	//// Disclaimer: displayWeekWithHighestSales() need this function
	public void calculateWeekWithHighestSales() {
		float maxValue = totalWeeklySales[0];
		for (int i = 1; i < totalWeeklySales.length; i++) {
			if (totalWeeklySales[i] > maxValue) {
				maxValue = totalWeeklySales[i];
				this.weekWithHighestSales = i;
			}
		}
		this.weekWithHighestSales++;
	}

	public int getWeekWithHighestSales() {
		return this.weekWithHighestSales;
	}

	// option 6
	public void calculateWeekWithLowestSales() {
		float minValue = totalWeeklySales[0];
		for (int i = 1; i < totalWeeklySales.length; i++) {
			if (totalWeeklySales[i] < minValue) {
				minValue = totalWeeklySales[i];
				this.weekWithLowestSales = i;
			}

		}
		this.weekWithLowestSales++;
	}

	public int getWeekWithLowestSales() {
		return this.weekWithLowestSales;
	}

	// call all of the calculation method
	public void analyzeResult() {
		calculateTotalSalesEachWeek();
		calculateAverageDailySalesPerWeek();
		calculateTotalSalesOfStore();
		calculateWeekWithHighestSales();
		calculateWeekWithLowestSales();
		calculateAverageWeeklySales();
	}

	// print sales by day from salesByWeek table
	public void printdata() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(salesByWeek[i][j] + " ");
			}
			System.out.println("");
		}
	}

}
