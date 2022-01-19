package ePortfolio;


import java.util.ArrayList;
import java.util.Scanner;


public class ePortfolio {
    ArrayList<Stock> stocks = new ArrayList<Stock>();
    ArrayList<MutualFund> mutualFunds = new ArrayList<MutualFund>();

    
    /** 
     * This method goes is used when the user wants to buy a mutual fund
     * @param input the Scanner object is used for inputing the attributes of a new or existing mutual fund
     *
     */
    public void BuyMutualFund(Scanner input){ // Method for buying mutual funds 
        String mutualSymbol;
        String newName;
        int newQuantity;
        double newPrice;
        int existQuantity;
        double existPrice;


        do{ // reprompt the user if they leave the prompt empty 
            System.out.print("Enter symbol for mutual fund: ");
            mutualSymbol = input.nextLine();

            if(mutualSymbol.isBlank()){
                System.out.println("Cannot leave name blank. Enter input again");
                System.out.println();
            }

        } while((mutualSymbol.isBlank() == true));


        for(int k = 0; k < stocks.size(); k++){ // Checks if symbol user entered is in the stocks arraylist. If so return
            if(stocks.get(k).getSymbol().equalsIgnoreCase(mutualSymbol)){
                System.out.println("This symbol already exisits in stocks. Please try agian");
                return;
            }
        }

        for(int i = 0; i < mutualFunds.size(); i++){ // if the symbol entered is part of an existing mutual fund buy more quantity and set new price
            if(mutualFunds.get(i).getSymbol().equalsIgnoreCase(mutualSymbol)){
                do{ // reprompt user if quantity is less than 0 or equal to 0
                    System.out.print("Enter quantity: ");
                    existQuantity = input.nextInt();
                    System.out.println();
                    
                    if(existQuantity <= 0){
                        System.out.println("Cannot make quantity 0 or a negative number. Enter input again");
                        System.out.println();
                    }
                } while(existQuantity <= 0);

                do{ // reprompt user if price is 0 or less than 0
                    System.out.print("Enter price: ");
                    existPrice = input.nextDouble();

                    
                    if(existPrice <= 0){
                        System.out.println("Cannot make quantity 0 or a negative number. Enter input again");
                        System.out.println();
                    }

                } while(existPrice <= 0);

                mutualFunds.get(i).buyExistMutual(existPrice, existQuantity, mutualFunds.get(i)); // updates bookvalue, price and price of existing mutual fund 
                System.out.println(mutualFunds.get(i));
                return;
            }
        }
        // If the symbol entered is not part of an existing mutual fund create a mutual fund object and add it too the arraylist
        do{ // reprompt user if they leave it blank
            System.out.print("Enter name: ");
            newName = input.nextLine();

            if(newName.isBlank()){
                System.out.println("Cannot leave name blank. Enter input again");
                System.out.println();
            }
        } while(newName.isBlank() == true);

        do{ // reprompt user if quantity is less than 0 or negative
            System.out.print("Enter Quantity: ");
            newQuantity = input.nextInt();

            if(newQuantity <= 0){
                System.out.println("Cannot make quantity 0 or a negative number. Enter input again");
                System.out.println();
            }
        } while(newQuantity <= 0);

        do{// reprompt user if price is 0 or negative 
            System.out.print("Enter price: ");
            newPrice = input.nextDouble();

            if(newPrice <= 0){
                System.out.println("Cannot make price 0 or a negative number. Enter input again");
                System.out.println();
            }
        } while(newPrice <= 0);

        MutualFund temp = new MutualFund(); // temp object is created to use method too calculate bookvalue for mutual fund 

        double newBookVal = temp.newMutualBookVal(newPrice, newQuantity); // Bookvalue is calculated using quantity and price 

        MutualFund newMutual = new MutualFund(mutualSymbol, newName, newQuantity, newPrice, newBookVal); // new mutual fund object is created 
        mutualFunds.add(newMutual); // adds mutual fund object to arraylist 
        System.out.println(mutualFunds); // for testing 
    }

    
    /** This method is used when the user wants to buy a new or existing stocks 
     * @param input  the Scanner object is used for inputing the attributes of a new or existing stock
     */
    public void BuyStock(Scanner input){ // method for buying stocks 
        String stockSymbol;
        String newName;
        int newQuantity;
        double newPrice;
        int existQuantity;
        double existPrice;


            do{// reprompt user if symbol is empty 
                System.out.print("Enter symbol for stock fund: ");
                stockSymbol = input.nextLine();

                if(stockSymbol.isBlank()){
                    System.out.println("Cannot leave name blank. Enter input again");
                    System.out.println();
                }

            } while(stockSymbol.isBlank() == true);


            for(int j = 0; j < mutualFunds.size(); j++){ //Checks if symbol user entered is in the stocks arraylist. If so return
                if(mutualFunds.get(j).getSymbol().equalsIgnoreCase(stockSymbol)){
                    System.out.println("This symbol already exsits in mutual funds. Please try again");
                    return;
                }
            }

        for(int i = 0; i < stocks.size(); i++){ // If symbol is part of existing stock buy more quantity and set new price 
            if(stocks.get(i).getSymbol().equalsIgnoreCase(stockSymbol)){

                do{ // reprompt user if quantity is less than 0 or equal to 0
                    System.out.print("Enter quantity: ");
                    existQuantity = input.nextInt();
                    System.out.println();

                    if(existQuantity <= 0){
                        System.out.println("Cannot make price 0 or a negative number. Enter input again");
                        System.out.println();
                    }
                } while(existQuantity <= 0);

                do{ // reprompt user if price is less than 0 or equal to 0
                    System.out.print("Enter price: ");
                    existPrice = input.nextDouble();

                    if(existPrice <= 0){
                        System.out.println("Cannot make price 0 or a negative number. Enter input again");
                        System.out.println();
                    }
                } while(existPrice <= 0);

                stocks.get(i).buyExistStock(existPrice, existQuantity, stocks.get(i)); // updates bookvalue, price and quantity of existing stock
                System.out.println(stocks.get(i));
                return;
            }
        }

        // If the symbol entered is not part of an existing stock create a stock object and add it too the arraylist
        do{// reprompt the user if name is blank
            System.out.print("Enter name: ");
            newName = input.nextLine();

            if(newName.isBlank()){
                System.out.println("Cannot leave name blank. Enter input again");
                System.out.println();
            }

        }while(newName.isBlank() == true);

        do{ // reprompt user if quantity is equal to 0 or less than 0
            System.out.print("Enter Quantity: ");
            newQuantity = input.nextInt();

            if(newQuantity <= 0){
                System.out.println("Cannot make price 0 or a negative number. Enter input again");
                System.out.println();
            }

        } while(newQuantity <= 0);

        do{ // reprompt user if quantity is equal to 0 or less than 0
            System.out.print("Enter price: ");
            newPrice = input.nextDouble();

            if(newPrice <= 0){
                System.out.println("Cannot make price 0 or a negative number. Enter input again");
                System.out.println();
            }
        } while(newPrice <= 0);

        Stock temp = new Stock(); // temp Stock object is created to use too use method to calculate bookvalue 

        double newBookVal = temp.newStockBookVal(newPrice, newQuantity); // Bookvalue is calculated using price and quantity 


        Stock newStock = new Stock(stockSymbol, newName, newQuantity, newPrice, newBookVal); // new stock object is created 
        stocks.add(newStock);
        System.out.println(stocks); // for testing 
    }

    
    /** This method is used when the user chooses the buy option. In this method they will choose what type of investment they want too buy. Based 
     * on there input the following buy method for stock or mutual fund will be called. If they enter the wrong input they will be reprompted 
     * @param input  the Scanner object is used for getting input on the type of investment 
     */
    public void Buy(Scanner input){ // This method is used to determine the type of investment wants to buy
        System.out.print("Enter type of investment (stock or mutual fund): ");
        String type = input.nextLine();

        if(type.equalsIgnoreCase("Stock")){ // if the user enters stock the following method will be called to buy a stock
            BuyStock(input);
        }
        else if(type.equalsIgnoreCase("mutual fund") || type.equalsIgnoreCase("mutualfund")){ // if user enters mutual fund the following method will be called to buy a mutual fund
            BuyMutualFund(input);
        }
        else{// if the input is neither stock or mutual fund the user will be reprompted until input is correct 
            System.out.println("Invalid input. Try again");
            Buy(input);
            return;
        }
    }
    
    
    /** 
     * This method checks both arraylists for the symbol that is entered by the user. If the symbol is not found in either arraylist then
     * the user will go back to the menu. If the symbol is found in the respective arraylist then call the proper method for either stock or
     * mutual fund 
     * @param input used to get the user input for the symbol
     */
    public void sell(Scanner input){
        String symbol;
        do{
            System.out.print("Enter symbol: ");
            symbol = input.nextLine();

            if(symbol.isBlank()){
                System.out.println("Cannot leave name blank. Enter input again");
                System.out.println();
            }

        } while(symbol.isBlank() == true);

            if(stocks.size() == 0){ // if stocks arraylist is empty the following message will be printed 
                System.out.println();
                System.out.println("The list for stocks is empty");
                System.out.println();
            }

            for(int i = 0; i < stocks.size(); i++){ // if stocks array is not empty check if symbol is present in the arraylist 
                if(stocks.get(i).getSymbol().equalsIgnoreCase(symbol)){ // if symbol is present the sell method for stocks will be called 
                    sellStock(input, stocks.get(i));
                    return;
                }
                else if(!(stocks.get(i).getSymbol().equalsIgnoreCase(symbol))){ // if element in arraylist does not match symbol then print the following message
                    System.out.println("The symbol in stocks does not match your input: " + stocks.get(i).getSymbol());
                }
                else{// If symbol is not is stocks arraylist the following message will be printed 
                    System.out.println("The stock does not exist in the list");
                }
            }
    
            if(mutualFunds.size() == 0){ // if mutual funds arraylist is empty the following message will be printed 
                System.out.println();
                System.out.println("The list for mutual funds is empty");
                System.out.println();
            }

            for(int i = 0; i < mutualFunds.size(); i++){// if mutual funds array is not empty check if symbol is present in the arraylist 
                if(mutualFunds.get(i).getSymbol().equalsIgnoreCase(symbol)){
                    sellMutual(input, mutualFunds.get(i));
                    return;
                }
                else if(!(mutualFunds.get(i).getSymbol().equalsIgnoreCase(symbol))){// if element in arraylist does not match symbol then print the following message
                    System.out.println("The symbol in mutual funds does not match your input: " + mutualFunds.get(i).getSymbol());
                }
                else{// If symbol is not is mutual funds arraylist the following message will be printed 
                    System.out.println("The mutual fund does not exist in the list");
                }
            }
            
        System.out.println("No investment exists with symbol entered"); // if no investment exists with the symbol then print message and return to main
        System.out.println("Press enter to continue");
        return;
    }

    
    /** 
     * This method is used when the user wants to sell a stock. They could sell part of the stock or all of it. If they sell all of it, it will
     * be deleted from the arraylist. Then the payment for the transaction is displayed and then and then the user returns back to the menu
     * @param input used to get input from the user regarding the quantity and the price 
     * @param stock used to access specific stock and its attributes 
     */
    public void sellStock(Scanner input, Stock stock){ // Method to sell stocks 
        int sellQuantity; // holds the selling quantity of the user 
        double sellPrice; // holds the selling price of the user 
        double payment; // holds the payment value 

        do{ // error check input for quantity and price
            System.out.print("Enter quantity for selling stock: ");
            sellQuantity = input.nextInt();

            System.out.print("Enter price: ");
            sellPrice = input.nextDouble();

            if(sellQuantity > stock.getQuantity() || sellPrice <= 0 || sellQuantity <= 0){  // if the following coditions are met print error messages
                System.out.println();
                System.out.println("Your input is invalid");
                System.out.println("Enter quantity and price again"); 
                System.out.println();
            }
        }while(sellQuantity > stock.getQuantity() || sellPrice <= 0 || sellQuantity <= 0);

        
        if(stock.getQuantity() == sellQuantity){ // if the quantity the user enters is equal to the quantity of the stock then remove the stock from the arraylist after calculating the payment
            payment = stock.sellPayment(sellPrice, sellQuantity);
            System.out.printf("The payment you have recieved is: %.2f", payment);
            System.out.println();
            System.out.println("The whole quantity of the stock has been sold. It will be removed from the list");
            stocks.remove(stock);
            return;
        }
        else{
            stock.sellExistStock(sellPrice, sellQuantity, stock);
            System.out.println(stock);
            System.out.println();
            payment = stock.sellPayment(sellPrice, sellQuantity);
            System.out.printf("The payment you have recieved is: %.2f", payment);
            return;
        }
    }

    
    /** 
     * This method is used when the user wants to sell a mutual fund. They could sell part of the mutual or all of it. If they sell all of it, it will
     * be deleted from the arraylist. Then the payment for the transaction is displayed and then and then the user returns back to the menu
     * @param input used to get input for quantity and price from user 
     * @param mutualFund  used to access specific mutual fund and its attributes 
     */
    public void sellMutual(Scanner input, MutualFund mutualFund){ // Method for selling mutual funds 
        int sellMQuant; // holds the selling quantity of the user 
        double sellMPrice; // holds the selling price of the user 
        double mPayment; // holds the payment value 

        do{ // error check input for quantity and price 
            System.out.print("Enter quantity for selling Mutual Fund: ");
            sellMQuant = input.nextInt();

            System.out.print("Enter price: ");
            sellMPrice = input.nextDouble();

            if(sellMQuant > mutualFund.getQuantity() || sellMPrice <= 0 || sellMQuant <= 0){ // if the following coditions are met print error messages
                System.out.println();
                System.out.println("Your input is invalid");
                System.out.println("Enter quantity and price again"); 
                System.out.println();
            }
        }while(sellMQuant > mutualFund.getQuantity() || sellMPrice <= 0 || sellMQuant <= 0);

        if(mutualFund.getQuantity() == sellMQuant){ // if the quantity the user enters is equal to the quantity of the mutual fund then remove the mutual fund from the arraylist after calculating the payment
            mPayment = mutualFund.sellPayment(sellMPrice, sellMQuant); // method for payment is called 
            System.out.printf("The payment you have recieved is: %.2f\n", mPayment); // payment is displayed 
            System.out.println();
            System.out.println("The whole quantity of the stock has been sold. It will be removed from the list");
            mutualFunds.remove(mutualFund);
            return;
        }

        else{ // If user does not sell the whole quantity of the stock then the following sell methods will occur 
            mutualFund.sellExistMutualFund(sellMPrice, sellMQuant, mutualFund); // updates price quantity and book value 
            System.out.println(mutualFund); // for testing 
            System.out.println();
            mPayment = mutualFund.sellPayment(sellMPrice, sellMQuant); // method of payment is called 
            System.out.printf("The payment you have recieved is: %.2f\n", mPayment); // payment is displayed 
            return;
        }
    }

    
    /** 
     * This method is used when the user wants to update all the prices of the investments
     * @param input used for user input 
     */
    public void update(Scanner input){ // method for updating prices of stocks or/and mutual funds
        double newPriceStock; // holds new price for stock
        double newPriceMutual; // holds new price for mutual fund 

        if((stocks.size() == 0) && (mutualFunds.size() == 0)){ // if both arraylists are empty then the following message 
            System.out.println("The Arraylists are empty. Cannot update prices");
            return;
        }
        
        if(stocks.size() == 0){ // if stocks arraylist is empty following message is printed 
            System.out.println();
            System.out.println("The Arralist for stocks is empty. Cannot update prices");
            System.out.println();
        }
        else{// if stock arraylist is not empty enter new prices for stocks
            for(int l = 0; l < stocks.size(); l++){
                System.out.println("Enter new price for " + stocks.get(l).getSymbol());
                System.out.println();

                do{ // reprompt user if price of stock is less than or eqaul to 0
                    System.out.print("Enter new price for stock: ");
                    newPriceStock = input.nextDouble(); 
                    
                    if(newPriceStock <= 0){
                        System.out.println("Cannot leave name blank. Enter input again");
                        System.out.println();
                    }

                } while(newPriceStock <= 0);

                stocks.get(l).setPrice(newPriceStock, stocks.get(l));
                System.out.println(stocks.get(l).getPrice());
            }
        }

        if(mutualFunds.size() == 0){ // if mutual funds arraylist is empty following message is printed
            System.out.println("The Arraylist for mutual funds is empty. Cannot update prices");
        }
        else{// if mutual fund arraylist is not empty enter new prices for mutual funds 
            for(int m = 0; m < mutualFunds.size(); m++){
                System.out.println("Enter new price for " + mutualFunds.get(m).getSymbol());
                System.out.println();
                
                do{
                    System.out.print("Enter new price for mutual fund:  ");
                    newPriceMutual = input.nextDouble();

                    if(newPriceMutual <= 0){
                        System.out.println("Cannot leave name blank. Enter input again");
                        System.out.println();
                    }
                } while(newPriceMutual <= 0);

                mutualFunds.get(m).setPrice(newPriceMutual, mutualFunds.get(m));
                System.out.println(mutualFunds.get(m).getPrice());
            }
        }
        System.out.println(stocks); // for testing 
        System.out.println(mutualFunds); // for testing
    }

    
    /** 
     * This method is used when the user wants to calculate there gain. It calculates the gain of the stocks and mutual funds individually and 
     * then adds them together for the total gain
     * @param input used for user input 
     */
    public void getGain(Scanner input){
        double totalStockGain = 0; // holds the total gain from the stock
        double totalMutualGain = 0; // holds the total gain from the mutual fund 
        double totalGain = 0; // Total gain from stocks and mutual funds

        if((stocks.size() == 0) && (mutualFunds.size() == 0)){ // if both arraylists are empty gain cannot be calculated. return to main
            System.out.println("Both Array lists are empty. It is not possible to calculate the gain");
            return;
        }

        if(stocks.size() == 0){ // if stock array list is empty the following message is printed 
            System.out.println("The stocks ArrayList is empty. No gains can be calculated from it");
        }
        else{// if stocks arraylist is not empty then the gain for each stock is calculated 
            for(int r = 0; r < stocks.size(); r++){
                totalStockGain = stocks.get(r).getGainStock(stocks.get(r)) + totalStockGain; // holds total value of gains from stock
                System.out.printf("Total stock gain is now: %.2f\n", totalStockGain);// for testing 
            }
        }

        if(mutualFunds.size() == 0){// if mutual fund array list is empty the following message is printed 
            System.out.println("The stocks ArrayList is empty. No gains can be calculated from it");
        }
        else{// if mutual fund arraylist is not empty then the gain for each stock is calculated
            for(int s = 0; s < mutualFunds.size(); s++){// if the mutual funds array list is not empty calculate total gains from mutual funds
                totalMutualGain = mutualFunds.get(s).getGainMutual(mutualFunds.get(s)) + totalMutualGain; // holds total value of gains from mutual funds
                System.out.printf("Total mutual gain is now: %.2f\n", totalMutualGain); // for testing
            }
        }

        totalGain = totalStockGain + totalMutualGain; // total gain is calculated 
        System.out.printf("Your total gains are: %.2f\n", totalGain); // gain is printed 
        return;
    }

    
    /** 
     * This method is used when the user chooses the search option in the menu. it asks the user for three fields the symbol, key words, and 
     * the price range. (This function is incomplete)
     * @param input used for user input for 3 fields 
     */
    public void search(Scanner input){ // Method for search option 
        String symbol; // holds symbol
        String keyWords; // holds keywords
        String price; // holds price range 
        double secondPrice = 0;  // holds second number if price range has this input: num-num
        double firstPrice = 0;// holds first number if price range has this input: num-num
        double singlePrice = 0; // holds price if input of price range is a single number 


        System.out.print("Enter symbol you would like to search for (Press enter to keep empty): ");
        symbol = input.nextLine();

        System.out.println();

        System.out.print("Enter Key words you would like to search for (Press enter to keep empty): ");
        keyWords = input.nextLine();

        System.out.println();

        System.out.print("Enter price range you would like to search for (Press enter to keep empty): ");
        price = input.nextLine();

        String storePrice [] = price.split("[-]+"); // split input for price range 


        System.out.println(storePrice.length);

        if((symbol.isBlank() == true) && (keyWords.isBlank() == true) && (price.isBlank() == true)){ // If all 3 fields are blank then display all the investments 
            
            for(int i = 0; i < stocks.size(); i++){ // displays all stock invesments 
                System.out.println("---Stock(s)---");
                System.out.println();
                System.out.println("Symbol: " + stocks.get(i).getSymbol().toUpperCase());
                System.out.println("Name: " + stocks.get(i).getName());
                System.out.println("Quantity: " + stocks.get(i).getQuantity());
                System.out.printf("Price: %.2f\n", stocks.get(i).getPrice());
                System.out.printf("BookValue: %.2f\n", stocks.get(i).getBookValue());
                System.out.println();
            }

            for(int j = 0; j < mutualFunds.size(); j++){ // displays all mutual fund invesments 
                System.out.println("---Mutual Fund(s)---");
                System.out.println();
                System.out.println("Symbol: " + mutualFunds.get(j).getSymbol().toUpperCase());
                System.out.println("Name: " + mutualFunds.get(j).getName());
                System.out.println("Quantity: " + mutualFunds.get(j).getQuantity());
                System.out.printf("Price: %.2f\n", mutualFunds.get(j).getPrice());
                System.out.printf("BookValue: %.2f\n", mutualFunds.get(j).getBookValue());
                System.out.println();
            }
        }

        else if(symbol.isBlank() == false){ // if symbol is the only field entered print stock with the matching symbol

            for(int i = 0; i < stocks.size(); i++){
                if(stocks.get(i).getSymbol().equalsIgnoreCase(symbol)){
                    System.out.println("Symbol match with stock(s)");
                    System.out.println("---Stock(s)---");
                    System.out.println();
                    System.out.println("Symbol: " + stocks.get(i).getSymbol().toUpperCase());
                    System.out.println("Name: " + stocks.get(i).getName());
                    System.out.println("Quantity: " + stocks.get(i).getQuantity());
                    System.out.printf("Price: %.2f\n", stocks.get(i).getPrice());
                    System.out.printf("BookValue: %.2f\n", stocks.get(i).getBookValue());
                    System.out.println();
                }
            }

            for(int j = 0; j < mutualFunds.size(); j++){// if symbol is the only field entered print mutual fund with the matching symbol
                if(mutualFunds.get(j).getSymbol().equalsIgnoreCase(symbol)){
                    System.out.println("Symbol match with mutual fund(s)");
                    System.out.println("---Mutual Fund(s)---");
                    System.out.println();
                    System.out.println("Symbol: " + mutualFunds.get(j).getSymbol().toUpperCase());
                    System.out.println("Name: " + mutualFunds.get(j).getName());
                    System.out.println("Quantity: " + mutualFunds.get(j).getQuantity());
                    System.out.printf("Price: %.2f\n", mutualFunds.get(j).getPrice());
                    System.out.printf("BookValue: %.2f\n", mutualFunds.get(j).getBookValue());
                    System.out.println();
                }
            }
        }

        
        else if(price.isBlank() == false){ // if price is not blank 
            if(storePrice.length == 1){
                singlePrice = Double.parseDouble(storePrice[0]);

                if(storePrice[0].indexOf("-") == -1){ // if only a single number is entered then display all stocks and mutual funds with equal price
                    for(int i = 0; i < stocks.size(); i++){
                        if(stocks.get(i).getPrice() == singlePrice){
                            System.out.println("Price match with stock(s)");
                            System.out.println("---Stock(s)---");
                            System.out.println();
                            System.out.println("Symbol: " + stocks.get(i).getSymbol().toUpperCase());
                            System.out.println("Name: " + stocks.get(i).getName());
                            System.out.println("Quantity: " + stocks.get(i).getQuantity());
                            System.out.printf("Price: %.2f\n", stocks.get(i).getPrice());
                            System.out.printf("BookValue: %.2f\n", stocks.get(i).getBookValue());
                            System.out.println();
                        }
                    }
        
                    for(int j = 0; j < mutualFunds.size(); j++){
                        if(mutualFunds.get(j).getPrice() == singlePrice){
                            System.out.println("Price match with mutual fund(s)");
                            System.out.println("---Mutual Fund(s)---");
                            System.out.println();
                            System.out.println("Symbol: " + mutualFunds.get(j).getSymbol().toUpperCase());
                            System.out.println("Name: " + mutualFunds.get(j).getName());
                            System.out.println("Quantity: " + mutualFunds.get(j).getQuantity());
                            System.out.printf("Price: %.2f\n", mutualFunds.get(j).getPrice());
                            System.out.printf("BookValue: %.2f\n", mutualFunds.get(j).getBookValue());
                            System.out.println();
                        }
                    }
                }

            }

            if(storePrice.length == 2){ // if price range with includes two numbers then print investments that follow the price range
                firstPrice = Double.parseDouble(storePrice[0]); // holds first number 
                secondPrice = Double.parseDouble(storePrice[1]); // holds second number 

                for(int i = 0; i < stocks.size(); i++){
                    if(stocks.get(i).getPrice() >= firstPrice || stocks.get(i).getPrice() <= secondPrice){ // 
                        System.out.println("Price match with stock");
                        System.out.println();
                        System.out.println("Symbol: " + stocks.get(i).getSymbol().toUpperCase());
                        System.out.println("Name: " + stocks.get(i).getName());
                        System.out.println("Quantity: " + stocks.get(i).getQuantity());
                        System.out.printf("Price: %.2f\n", stocks.get(i).getPrice());
                        System.out.printf("BookValue: %.2f\n", stocks.get(i).getBookValue());
                        System.out.println();
                    }
                }
            }
        }
    }
}
