Name: Arvind Palakkal
StudentID:1141879
Course: CIS2430
Due Date: Nov 30 2021

----------------------------------------------------------------------------------------------------------------------------
LIMITATIONS:
	The limitations of my code are that the code is not the most efficient. It can be altered and simplified in order to make sure the code is running as efficiently as possible. Also since I did not complete the search function most of the cases for the search function will not work.
    The only cases I have finished is when all three fields of data are empty, only the symbol is entered, and part of when a price range is entered. Other than those cases it search function is limited in the cases it can execute. I also did not add the hashmap part to the search function so finding key words will be the same as A1. I also did not finsih the implementation of the hash map for sell, File, and the keywords for search. Additionally my since I did not complete my search function the search UI will not work properly .

	I also didnt apply the exceptions for the constructors or the abstract classes or add the copy constructor.
----------------------------------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------------------------------

(1) Problem: Create a user interface where a user can intereact with basic functions of the stock market such as buying and utillizing hashmaps and Data files to read and write data to files .
Utilize The Packages of Java swing and awt to Create a working and interactive GUI 
    This program is used to store and manage stocks and Mutual Funds
    This program is able to enter information about a stock as well they can buy or sell stock at specific range
    This program is able to update get the user's gains and losses from a stock
    This program is able to search for a certian mutual fund or stock so the user can research their finding in the stock market
    This program is able to utilize data files to overwrite and manipulate existing data
    This program is able to use hashmaps to search keywords in the functions as well as add and remove data from the hashmaps
    This program is able to Create a Jframe and utlize buttons,textboxes and also labels to create an interactive program
    This program is able to take advantage of the use of actionlistener to communcate both the back end and front end of the program 
    This program is able to implement the buy feature where users can buy and add to their current invesement and add a new stock as well using the textarea as input and then use the submit button to excute the backend as mentioned in the previous Note
    This program is able to implement the buy feature where users can sell their current investment which in the backend is able to remove from an array list and hashmap users can also sell 
    This program is able to check different exceptions such as if the price and quantity is greater = 0
    This program is able to implement getgains when user opens the interface and will show the get gain immedaely
    This program is able to accept 4 inputs in a textarea for search a symbol,name a high price and low price the program is able to and is able output the investment upon the correct search values
    This program update interface is able to move to the next investment of the array list of the previous investment and the user is able to update the price for each investment as well

----------------------------------------------------------------------------------------------------------------------------
HOW TO BUILD:
	1. Make sure you're in the directory apalakka_a3
	2. Type the command:
		javac ePortfolio/*.java
	This will create class files for every .java file in the folder, which will allow us to execute the code
	3. To run, simply type the command:
		java ePortfolio.Main
----------------------------------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------------------------------
(4). 

When testing for the I would use 2 different Stocks and 1  Mutual Fund

Stock one: 
Stock Symbol:AAPL
Stock Name:Apple Inc.
Stock Quantity:500
Price:142.23
bookvalue:55,049.99

Mutual Fund One: 
Mutual Fund Symbol:APPL
Mutual Fund Name:Apples Inc.
Mutual Fund Quantity:500
Price:200.00
bookvalue:100,009.99

Stock two:
Stock Symbol:TSLA
Stock Name:Tesla Inc.
Stock Quantity:500
Price:800
bookvalue:400,009.99

By using these test cases I am able to test all my methods indivually. In any case when a method is complete then a test would be 
done to ensure all input work with crietera such is does the arraylist work does the arraylist add are the forloops and if 
statements correct and are they outputing the correct values. 

TEST PLAN:
	1. Try all the possible options for the menu:
	Such as: Buy, Sell, update, getGain, search. Error message will be printed for invalid option
	2. Attempt to run the program with no file listed. The program should show an error message and exit the program
	3. Buy two investments (one for stock and one for mutual fund). There names should be added to the hashmap and be displayed after each transaction 
	4. Try to buy both investments BUT using the opposite type of investment - SHOULD PREVENT USER FROM DOING SO (ex. using Stock to buy an existing investment that's in mutual fund)
	5. Buy one more investment for each list to make sure that arraylist is functioning properly
	7. Since the search function only covers two cases. leave all the inputs blank. Then try with just the symbol. Then try with just the low price and high price 
	8. Since my search does not apply the hash map part there is no keywords part 
	9. When selling an investment completely. if the key word only existed in 1 index it will be removed from the hash map


EDGE CASES:
	-Enter negative values for the price and quantity with the buy/sell function
	-leave the inputs for the symbols blank 
    - in search try leaving all the inputs blank
----------------------------------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------------------------------------------
Conditions for Search function

- If the given element is not on the list 
- Test a value of keyword that does not exist  in where the value should not exist unless more than one condition is filled in 
- Test a value of the price that does not exist  in where the value should not exist unless more than one condition is filled in 
- Test a value of the symbol that does not exist in where the value should not exist unless more than one condition is filled in 
- The given element is at the start of the list
- Enter a symbol,keyword,Price range either one-three of the atributes and for the end of the list and print the given element at the list from the start of the list
- The given element is at the end of the list
- Enter a symbol,keyword,Price range either one-three of the atributes and for the end of the list and print the given element at the list from the start of the list
- The given Element is somewhere between the two ends in the list
- Enter a symbol,keyword,Price range either one-three of the atributes and for the end of the list and print the given element at the list from the start of the list

Conditions for the GUI Buy

- Check if the text boxes can accept 5 values, Check if the values are parsed and checked if not display in the message box
- Check if labels are printing out
- Check if the message box is printing the investment after buying and also checking if exceptions are being printed with things as check if the symbol and name is blank
- Check if the reset button works but see if it erases all the values

Condtitions for the GUI Sell

- Check if the Textboxes can accept the following values for the symbol,quantity and price check if the values are being parsed correctly such are the exception printing out correctly 
- check if the backend is working correctly as in is the values be sold the investment have the correct numbers
- Check if the reset button works and resets all the values to nothing


Conditions for the GUI interface of update

- Check if the textboxes are not editable for the symbol and name
- Check if the next and previous button are able to scroll through and move through the arraylist
- Check if the price textarea can accept values 
- Check if the price upates in the stock and sees if the values are printinng in the textarea to show that price for the investments are updating

Conditions for the getGain interface
- The textarea for the getgain cannot be edits
- the textarea should immedaely display the total gain
- The area at the bottom for messages should display each stock's individual gains

Condtiions for the search interface
- Reset button is able to reset values 
- The textarea is able to take in values for symbol names/keywords and also the low and high price range
- Check if the Strings can be parsed and see if any exceptions are thrown in the textarea 
- Check if the search functions works if only one field is filled in for either keyword price or symbol
- Check if the search function works when 2 fields are filled in for either keyword price or symbol
- Check if the search function works when 3 fields are all filled in for the keyword price or symbol
- Check and parse for exceptions when entering one field,two fields for 3 fields either checking if it's blank or if it's an invalid price or quanity

----------------------------------------------------------------------------------------------------------------------------
IMPROVEMENTS I COULD HAVE MADE:
	If I had more time, I would finish the search function. Since I didnt finish it most of the cases will not work other than the ones I have mentioned above. I would have also finished the hashmap implementation for sell file and search. Another improvement I coudl of made was better error checking with try catches and implementing the abstract classes and exceptions in the constructors 
----------------------------------------------------------------------------------------------------------------------------