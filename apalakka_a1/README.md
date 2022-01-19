ARVIND PALAKKAl
CIS*2430 Assignment 1
----------------------------------------------------------------------------------------------------------------------------
LIMITATIONS:
	The limitations of my code are that the code is not the most efficient. It can be altered and simplified in order to make sure the code is running as efficiently as possible. Also since I did not complete the search function most of the cases for the search function will not work.
    The only cases I have finished is when all three fields of data are empty, only the symbol is entered, and part of when a price range is entered. Other than those cases it search function is limited in the cases it can execute.
----------------------------------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------------------------------
HOW TO BUILD:
	1. Make sure you're in the directory apalakka_a1
	2. Type the command:
		javac ePortfolio/*.java
	This will create class files for every .java file in the folder, which will allow us to execute the code
	3. To run, simply type the command:
		java ePortfolio.Menu
----------------------------------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------------------------------
TEST PLAN:
	1. Try all the possible command line outputs:
	Such as: B or BUY or SELL, SEARCH, U or UPDATE, G OR GETGAIN, Q OR QUIT (all these are case-insensitive)
	3. Buy two investments (one for stock and one for mutual fund)
	4. Try to buy both investments BUT using the opposite type of investment - SHOULD PREVENT USER FROM DOING SO (ex. using Stock to buy an existing investment that's in mutual fund)
	5. Buy one more investment for each list to make sure that arraylist is functioning properly
    6. To see results the contents of the arraylists will be displayed after each transaction 
	7. Since the search function only covers two cases. leave all the inputs blank. Then try with just the symbol. Then try with just the price range with a single number ex: 100 and with two numbers ex: 100-200

EDGE CASES:
	-Enter negative values for the price and quantity with the buy/sell function
	-leave the inputs for the symbols blank 
    - in search try leaving all the inputs blank
----------------------------------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------------------------------
IMPROVEMENTS I COULD HAVE MADE:
	If I had more time, I would finish the search function. Since I didnt finish it most of the cases will not work other than the ones I have mentioned above. I would have also made a seperate class specifically for handling input checking and applied it throughout the assignment to
    make error checking faster and more efficent. I could have also made the code more effiecent by creating methods that did repettitve tasks 
----------------------------------------------------------------------------------------------------------------------------