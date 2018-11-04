# Store-Sales-Manager
A java program that reads in 7 weeks of sales data of 5 different stores from a text file. Then, it do the calculation and return relevant information, such as the total sales for each week,  the average daily sales for each week, the total sales for all the weeks, the average weekly sales… User interact with this program via the console of whichever IDE they choose.

## Getting Started

Download this repo to your local computer. Get saledat.txt and other .java class in src folder
Salesdata.txt’s content: first line is number of stores in the Franchise, second line is headline from day 1 - day 35, for the rest: each of the line represents the sales of 35 days of each store, from store 1 - 6 respectively.
Let saledat.txt be in the same folder as other .java class. I suggest “src” folder
Open Eclipse, create a new project and import all the .java class in the src folder to that project
Remember to change to adjust the source files’ paths accordingly in Driver.java class that points at the current location of the source files

### Prerequisites

Eclipse IDE or any IDE of your choice, as long as user can interact via the console



## Running the tests

Menu —> Run —> Run 
The user interface of the program is in the console, which is integrated in Eclipse underneath the source file
The console will display a welcome message and prompt the  user to select one of the 6 stores for its information
If the input for store number is not invalid (not a positive whole number between 1 - 6), program will prompt user to input again. Once finish, user press Enter.
Then, the program will display a menu of 7 options of the chosen store’s information that user can choose from. Information including total sales for each week, average daily sales for each week, total sales for all weeks, average weekly sales, week with the highest amount in sales, week with the lowest amount in sales and display all analytical data above. Then it will prompt user to choose between 1 - 7
If the input for store number is not invalid (not a positive whole number between 1 - 7), program will prompt user to input again. Once finish, user press Enter.
After the program display the information of the store that user seek, it will prompt user if he/she wants to know more information about the Franchise by pressing any key but ‘q’. If user enter ‘q’, the program terminates.

For test cases, check out testrun.txt


## Versioning
1

## Authors

Anh Pham 

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

Bob Singh - instructor at De Anza College

## Notes

If you have any suggestion for more features, please let me know. I'd really appreciate constructive suggestion.
