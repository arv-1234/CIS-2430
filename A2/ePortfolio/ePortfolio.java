package ePortfolio;


import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class ePortfolio {
    public static final int REDEMPTION_FEE = 45;
    public static final double COMMISION = 9.99;
    ArrayList<Investment> Investments = new ArrayList<Investment>();
    HashMap<String, ArrayList<Integer>> index = new HashMap<String, ArrayList<Integer>>();

    /**
     * 
     * This method goes is used when the user wants to buy a mutual fund
     * 
     * @param input the Scanner object is used for inputing the attributes of a new
     *              or existing mutual fund
     *
     */
    public void BuyMutualFund(Scanner input) { // Method for buying mutual funds
        String mutualSymbol;
        String newName;
        int newQuantity;
        double newPrice;
        int existQuantity;
        double existPrice;
        int setQuant;
        double existBook;
        int indexVal;
        ArrayList<Integer> indexValue = new ArrayList<Integer>();

        do { // reprompt the user if they leave the prompt empty
            System.out.print("Enter symbol for mutual fund: ");
            mutualSymbol = input.nextLine();

            if (mutualSymbol.isBlank()) {
                System.out.println("Cannot leave name blank. Enter input again");
                System.out.println();
            }

        } while ((mutualSymbol.isBlank() == true));

        for (int k = 0; k < Investments.size(); k++) { // Checks if symbol user entered is in the stocks arraylist. If
                                                       // so return

            if (Investments.get(k).equals(new Stock(mutualSymbol, " ", 0, 0, 0))) {
                System.out.println("This symbol already exisits in stocks. Please try agian");
                return;
            }

        }

        for (int i = 0; i < Investments.size(); i++) { // if the symbol entered is part of an existing mutual fund buy
                                                       // more quantity and set new price
            if (Investments.get(i).getSymbol().equalsIgnoreCase(mutualSymbol)) {
                do { // reprompt user if quantity is less than 0 or equal to 0
                    System.out.print("Enter quantity: ");
                    existQuantity = input.nextInt();
                    System.out.println();

                    if (existQuantity <= 0) {
                        System.out.println("Cannot make quantity 0 or a negative number. Enter input again");
                        System.out.println();
                    }
                } while (existQuantity <= 0);

                do { // reprompt user if price is 0 or less than 0
                    System.out.print("Enter price: ");
                    existPrice = input.nextDouble();

                    if (existPrice <= 0) {
                        System.out.println("Cannot make quantity 0 or a negative number. Enter input again");
                        System.out.println();
                    }

                } while (existPrice <= 0);

                Investments.get(i).setPrice(existPrice);
                setQuant = Investments.get(i).getQuantity() + existQuantity;
                Investments.get(i).setQuantity(setQuant);
                existBook = Investments.get(i).getBookValue() + (existPrice * existQuantity);
                Investments.get(i).setBookValue(existBook);
                System.out.println(Investments.get(i));
                return;
            }
        }
        // If the symbol entered is not part of an existing mutual fund create a mutual
        // fund object and add it too the arraylist
        do { // reprompt user if they leave it blank
            System.out.print("Enter name: ");
            newName = input.nextLine();

            if (newName.isBlank()) {
                System.out.println("Cannot leave name blank. Enter input again");
                System.out.println();
            }
        } while (newName.isBlank() == true);

        do { // reprompt user if quantity is less than 0 or negative
            System.out.print("Enter Quantity: ");
            newQuantity = input.nextInt();

            if (newQuantity <= 0) {
                System.out.println("Cannot make quantity 0 or a negative number. Enter input again");
                System.out.println();
            }
        } while (newQuantity <= 0);

        do {// reprompt user if price is 0 or negative
            System.out.print("Enter price: ");
            newPrice = input.nextDouble();

            if (newPrice <= 0) {
                System.out.println("Cannot make price 0 or a negative number. Enter input again");
                System.out.println();
            }
        } while (newPrice <= 0);

        double newBookVal = newPrice * newQuantity; // Bookvalue is calculated using quantity and price

        MutualFund newMutual = new MutualFund(mutualSymbol, newName, newQuantity, newPrice, newBookVal); // new mutual
                                                                                                         // fund object
                                                                                                         // is created
        Investments.add(newMutual); // adds mutual fund object to arraylist
        System.out.println(Investments); // for testing

        indexVal = Investments.size() - 1;
        //indexValue.add(indexVal);

      //  System.out.println(indexValue);

        System.out.println("Hash map before adding: " + index);

        String keyWord[] = newName.split(" ");

        for(int i = 0; i < keyWord.length; i++){
            String word = keyWord[i].toLowerCase();
            if(index.containsKey(word)){
                indexValue = index.get(word);
                indexValue.add(indexVal);
            }
            else{
                indexValue = new ArrayList<>();
                indexValue.add(indexVal);
                index.put(word, indexValue);
            }
        }

        System.out.println("Hash map " + index);
    }

    /**
     * This method is used when the user wants to buy a new or existing stocks
     * 
     * @param input the Scanner object is used for inputing the attributes of a new
     *              or existing stock
     */

    public void BuyStock(Scanner input) { // method for buying stocks
        String stockSymbol;
        String newName;
        int newQuantity;
        double newPrice;
        int existQuantity;
        double existPrice;
        int setQuant;
        double existBook;
         int indexVal;
         ArrayList<Integer> indexValue = new ArrayList<Integer>();

        do {// reprompt user if symbol is empty
            System.out.print("Enter symbol for stock fund: ");
            stockSymbol = input.nextLine();

            if (stockSymbol.isBlank()) {
                System.out.println("Cannot leave name blank. Enter input again");
                System.out.println();
            }

        } while (stockSymbol.isBlank() == true);

        for (int k = 0; k < Investments.size(); k++) { // Checks if symbol user entered is a symbol used for a mutual
                                                       // fund. If so return

            if (Investments.get(k).equals(new MutualFund(stockSymbol, " ", 0, 0, 0))) {
                System.out.println("This symbol already exisits in Mutal Funds. Please try agian");
                return;
            }

        }
        for (int i = 0; i < Investments.size(); i++) { // If symbol is part of existing stock buy more quantity and set
                                                       // new price
            if (Investments.get(i).getSymbol().equalsIgnoreCase(stockSymbol)) {

                do { // reprompt user if quantity is less than 0 or equal to 0
                    System.out.print("Enter quantity: ");
                    existQuantity = input.nextInt();
                    System.out.println();

                    if (existQuantity <= 0) {
                        System.out.println("Cannot make price 0 or a negative number. Enter input again");
                        System.out.println();
                    }
                } while (existQuantity <= 0);

                do { // reprompt user if price is less than 0 or equal to 0
                    System.out.print("Enter price: ");
                    existPrice = input.nextDouble();

                    if (existPrice <= 0) {
                        System.out.println("Cannot make price 0 or a negative number. Enter input again");
                        System.out.println();
                    }
                } while (existPrice <= 0);

                Investments.get(i).setPrice(existPrice);
                setQuant = Investments.get(i).getQuantity() + existQuantity;
                existBook = ((existPrice * existQuantity) + COMMISION) + Investments.get(i).getBookValue();
                Investments.get(i).setBookValue(existBook);
                Investments.get(i).setQuantity(setQuant);
                System.out.println(Investments.get(i));
                return;
            }
        }

        // If the symbol entered is not part of an existing stock create a stock object
        // and add it too the arraylist
        do {// reprompt the user if name is blank
            System.out.print("Enter name: ");
            newName = input.nextLine();

            if (newName.isBlank()) {
                System.out.println("Cannot leave name blank. Enter input again");
                System.out.println();
            }

        } while (newName.isBlank() == true);

        do { // reprompt user if quantity is equal to 0 or less than 0
            System.out.print("Enter Quantity: ");
            newQuantity = input.nextInt();

            if (newQuantity <= 0) {
                System.out.println("Cannot make price 0 or a negative number. Enter input again");
                System.out.println();
            }

        } while (newQuantity <= 0);

        do { // reprompt user if quantity is equal to 0 or less than 0
            System.out.print("Enter price: ");
            newPrice = input.nextDouble();

            if (newPrice <= 0) {
                System.out.println("Cannot make price 0 or a negative number. Enter input again");
                System.out.println();
            }
        } while (newPrice <= 0);

        double newBookVal = (newPrice * newQuantity) + COMMISION; // Bookvalue is calculated using price and quantity

        Stock newStock = new Stock(stockSymbol, newName, newQuantity, newPrice, newBookVal); // new stock object is
                                                                                             // created
        Investments.add(newStock);
        System.out.println(Investments); // for testing

        String keyWord[] = newName.split(" ");

        indexVal = Investments.size() - 1;

        for(int i = 0; i < keyWord.length; i++){
            String word = keyWord[i].toLowerCase();
            if(index.containsKey(word)){
                indexValue = index.get(word);
                indexValue.add(indexVal);
            }
            else{
                indexValue = new ArrayList<>();
                indexValue.add(indexVal);
                index.put(word, indexValue);
            }
        }

        System.out.println("Hash map " + index);
   
    }

    /**
     * This method is used when the user chooses the buy option. In this method they
     * will choose what type of investment they want too buy. Based on there input
     * the following buy method for stock or mutual fund will be called. If they
     * enter the wrong input they will be reprompted
     * 
     * @param input the Scanner object is used for getting input on the type of
     *              investment
     */

    public void Buy(Scanner input) { // This method is used to determine the type of investment wants to buy
        System.out.print("Enter type of investment (stock or mutual fund): ");
        String type = input.nextLine();

        if (type.equalsIgnoreCase("Stock")) { // if the user enters stock the following method will be called to buy a
                                              // stock
            BuyStock(input);
        } else if (type.equalsIgnoreCase("mutual fund") || type.equalsIgnoreCase("mutualfund")) { // if user enters
                                                                                                  // mutual fund the
                                                                                                  // following method
                                                                                                  // will be called to
                                                                                                  // buy a mutual fund
            BuyMutualFund(input);
        } else {// if the input is neither stock or mutual fund the user will be reprompted
                // until input is correct
            System.out.println("Invalid input. Try again");
            Buy(input);
            return;
        }
    }

    /**
     * This method checks both arraylists for the symbol that is entered by the
     * user. If the symbol is not found in either arraylist then the user will go
     * back to the menu. If the symbol is found in the respective arraylist then
     * call the proper method for either stock or mutual fund
     * 
     * @param input used to get the user input for the symbol
     */

    public void sell(Scanner input) {
        String symbol;
        do {
            System.out.print("Enter symbol: ");
            symbol = input.nextLine();

            if (symbol.isBlank()) {
                System.out.println("Cannot leave name blank. Enter input again");
                System.out.println();
            }

        } while (symbol.isBlank() == true);

        if (Investments.size() == 0) { // if stocks arraylist is empty the following message will be printed
            System.out.println();
            System.out.println("The list for Investments is empty");
            System.out.println();
        }

        for (int i = 0; i < Investments.size(); i++) { // if investments array is not empty check if symbol is present in the
                                                       // arraylist
            if (Investments.get(i).equals(new Stock(symbol, " ", 0, 0, 0))) { // if symbol is present the sell method
                                                                              // for stocks will be called
                System.out.println("This symbol is from a stock");
                sellStock(input, Investments.get(i));
                return;
            }

            else if (Investments.get(i).equals(new MutualFund(symbol, " ", 0, 0, 0))) { // if element in arraylist matches symbol for mutual fund
                                                                                        
                                                                                        
                System.out.println("This symbol is from a mutual fund");
                sellMutual(input, Investments.get(i));
                return;
            }
        }

        System.out.println("No investment exists with symbol entered"); // if no investment exists with the symbol then
                                                                        // print message and return to main
        System.out.println("Press enter to continue");
        return;
    }

    /**
     * This method is used when the user wants to sell a stock. They could sell part
     * of the stock or all of it. If they sell all of it, it will be deleted from
     * the arraylist. Then the payment for the transaction is displayed and then and
     * then the user returns back to the menu
     * 
     * @param input used to get input from the user regarding the quantity and the
     *              price
     * @param stock used to access specific stock and its attributes
     */

    public void sellStock(Scanner input, Investment stock) { // Method to sell stocks
        int sellQuantity; // holds the selling quantity of the user
        double sellPrice; // holds the selling price of the user
        double payment; // holds the payment value
        String nameStock = stock.getName(); 

        do { // error check input for quantity and price
            System.out.print("Enter quantity for selling stock: ");
            sellQuantity = input.nextInt();

            System.out.print("Enter price: ");
            sellPrice = input.nextDouble();

            if (sellQuantity > stock.getQuantity() || sellPrice <= 0 || sellQuantity <= 0) { // if the following
                                                                                             // coditions are met print
                                                                                             // error messages
                System.out.println();
                System.out.println("Your input is invalid");
                System.out.println("Enter quantity and price again");
                System.out.println();
            }
        } while (sellQuantity > stock.getQuantity() || sellPrice <= 0 || sellQuantity <= 0);

        if (stock.getQuantity() == sellQuantity) { // if the quantity the user enters is equal to the quantity of the
                                                   // stock then remove the stock from the arraylist after calculating
                                                   // the payment
            String stockName[] = nameStock.toLowerCase().split(" ");
            
            for(int i = 0; i < stockName.length; i++) { // removes keywords if they only contain 1 index in arraylist 
                if(index.get(stockName[i]).size() == 1){
                    index.remove(stockName[i]);
                }
            }

            payment = (sellQuantity * sellPrice) - COMMISION;
            System.out.printf("The payment you have recieved is: %.2f", payment);
            System.out.println();
            System.out.println("The whole quantity of the stock has been sold. It will be removed from the list");
            Investments.remove(stock);
     
            return;
        } else {
            double existQuant = stock.getQuantity() - sellQuantity;
            double orgQuant = stock.getQuantity();
            double setBookVal;
            int sellQ = stock.getQuantity() - sellQuantity;

            stock.setPrice(sellPrice); // set selling price 

            setBookVal = stock.getBookValue() * (existQuant / orgQuant); // calculate new book value 

            stock.setBookValue(setBookVal); // set bookvalue

            stock.setQuantity(sellQ); // set quantity

            System.out.println(stock); // print stock

            System.out.println();

            payment = (sellPrice * sellQuantity) - COMMISION; // payment is calculated 

            System.out.printf("The payment you have recieved is: %.2f\n", payment);
            return;
        }
    }

    /**
     * This method is used when the user wants to sell a mutual fund. They could
     * sell part of the mutual or all of it. If they sell all of it, it will be
     * deleted from the arraylist. Then the payment for the transaction is displayed
     * and then and then the user returns back to the menu
     * 
     * @param input      used to get input for quantity and price from user
     * @param mutualFund used to access specific mutual fund and its attributes
     */

    public void sellMutual(Scanner input, Investment mutualFund) { // Method for selling mutual funds
        int sellMQuant; // holds the selling quantity of the user
        double sellMPrice; // holds the selling price of the user
        double mPayment; // holds the payment value
        String nameMutual = mutualFund.getName();

        do { // error check input for quantity and price
            System.out.print("Enter quantity for selling Mutual Fund: ");
            sellMQuant = input.nextInt();

            System.out.print("Enter price: ");
            sellMPrice = input.nextDouble();

            if (sellMQuant > mutualFund.getQuantity() || sellMPrice <= 0 || sellMQuant <= 0) { // if the following
                                                                                               // coditions are met
                                                                                               // print error messages
                System.out.println();
                System.out.println("Your input is invalid");
                System.out.println("Enter quantity and price again");
                System.out.println();
            }
        } while (sellMQuant > mutualFund.getQuantity() || sellMPrice <= 0 || sellMQuant <= 0);

        if (mutualFund.getQuantity() == sellMQuant) { // if the quantity the user enters is equal to the quantity of the
                                                      // mutual fund then remove the mutual fund from the arraylist
                                                      // after calculating the payment
            String mfName[] = nameMutual.toLowerCase().split(" ");
            
            for(int i = 0; i < mfName.length; i++){ // removes keywords if they only contain 1 index in arraylist 
                if(index.get(mfName[i]).size() == 1){
                    index.remove(mfName[i]);
                }
            }
            mPayment = (sellMQuant * sellMPrice) - REDEMPTION_FEE; // method for payment is called
            System.out.printf("The payment you have recieved is: %.2f\n", mPayment); // payment is displayed
            System.out.println();
            System.out.println("The whole quantity of the Mutual Fund has been sold. It will be removed from the list");
            Investments.remove(mutualFund);

            System.out.println(index);

            return;
        }

        else { // If user does not sell the whole quantity of the stock then the following sell
               // methods will occur
            double existQuant = mutualFund.getQuantity() - sellMQuant;
            double orgQuant = mutualFund.getQuantity();
            double setBookVal;
            int sellQ = mutualFund.getQuantity() - sellMQuant;

            mutualFund.setPrice(sellMPrice);

            setBookVal = mutualFund.getBookValue() * (existQuant / orgQuant);
            mutualFund.setBookValue(setBookVal);

            mutualFund.setQuantity(sellQ);

            System.out.println(mutualFund); // for testing

            System.out.println();

            mPayment = (sellMPrice * sellMQuant) - REDEMPTION_FEE; // method of payment is called

            System.out.printf("The payment you have recieved is: %.2f\n", mPayment); // payment is displayed
            return;
        }
    }

    /**
     * This method is used when the user wants to update all the prices of the
     * Investments
     * 
     * @param input used for user input
     */

    public void update(Scanner input) { // method for updating prices of stocks or/and mutual funds
        double newPriceInvestment; // holds new price for investment

        if (Investments.size() == 0) { // if stocks arraylist is empty following message is printed
            System.out.println();
            System.out.println("The Arraylist for Investments is empty. Cannot update prices");
            System.out.println("Press enter to continue");
            System.out.println();
            return;
        } else {// if stock arraylist is not empty enter new prices for stocks
            for (int l = 0; l < Investments.size(); l++) {

                System.out.println("Enter new price for " + Investments.get(l).getSymbol());
                System.out.println();

                do { // reprompt user if price of stock is less than or eqaul to 0
                    System.out.print("Enter new price for Investment: ");
                    newPriceInvestment = input.nextDouble();

                    if (newPriceInvestment <= 0) {
                        System.out.println("Price cannot be set to 0. Enter input again");
                        System.out.println();
                    }
                } while (newPriceInvestment <= 0);
                Investments.get(l).setPrice(newPriceInvestment);
                System.out.println(Investments.get(l).getPrice());
            }
        }
        System.out.println(Investments); // for testing
        return;
    }

    /**
     * This method is used when the user wants to calculate there gain. It
     * calculates the gain of the stocks and mutual funds individually and then adds
     * them together for the total gain
     * 
     * @param input used for user input
     */

    public void getGain(Scanner input) {
        double totalStockGain = 0; // holds the total gain from the stock
        double totalMutualGain = 0; // holds the total gain from the mutual fund
        double totalGain = 0; // Total gain from stocks and mutual funds

        if (Investments.size() == 0) { // if both arraylists are empty gain cannot be calculated. return to main
            System.out.println("Arraylist is empty. It is not possible to calculate the gain");
            System.out.println("Press enter to continue");
            return;
        }

        else {// if stocks arraylist is not empty then the gain for each stock is calculated
            for (int r = 0; r < Investments.size(); r++) {
                String investSymbol = Investments.get(r).getSymbol();
                int investQuant = Investments.get(r).getQuantity();
                double investPrice = Investments.get(r).getPrice();
                double investBookVal = Investments.get(r).getBookValue();
                double gainStock = ((investQuant * investPrice) - COMMISION) - investBookVal;
                double gainMutual = ((investQuant * investPrice) - REDEMPTION_FEE) - investBookVal;

                if (Investments.get(r).equals(new Stock(investSymbol, " ", 0, 0, 0))) {
                    totalStockGain = totalStockGain + gainStock; // holds total value of gains from stock

                } else {
                    totalMutualGain = totalMutualGain + gainMutual; // holds total value of gains from mutual funds
                }
            }

        }

        System.out.printf("Total stock gain is now: %.2f\n", totalStockGain);// for testing
        System.out.printf("Total Mutual gain is now: %.2f\n", totalMutualGain);// for testing
        totalGain = totalStockGain + totalMutualGain; // total gain is calculated
        System.out.printf("Your total gains are: %.2f\n", totalGain); // gain is printed
        System.out.println("Press enter to continue");
        return;
    }

    /**
     * This method is called to save the contents of the arraylist into a file 
     *
     * @param fileName this argument will be from command line args[0]. It will contain the file name
     */
    public void saveFile(String fileName) {

        if (fileName.length() == 0) {
            System.out.println("Filename was not given in command line. Cannot save Investments");
            return;
        }

        PrintWriter writeToFile = null;

        try {
            writeToFile = new PrintWriter(fileName, "UTF-8");

            for (int i = 0; i < Investments.size(); i++) {
                writeToFile.println(Investments.get(i).toFile());
            }
            writeToFile.close();
            System.out.println();
            System.out.println("Contents were successfully written to file");
        } catch (Exception e) {
            System.out.println();
            System.out.println("Could not save contents of arraylist to file");
            System.out.println();
        }
        return;
    }

    /**
     * This method will load the contents of the file into the arraylist 
     * @param fileName This argument will be from command line (args[0])
     */
    public void openFile(String fileName) {

        try {
            // Create a new file object and scanner object
            File file = new File(fileName);
            Scanner fileScan = new Scanner(file);
            String info[] = new String[6];
            while (fileScan.hasNextLine()) {
                for (int i = 0; i < 6; i++) {
                    if (i == 0) {
                        fileScan.nextLine();
                    }
                    String input = fileScan.nextLine();
                    String seperate[] = input.split("\"");
                    info[i] = seperate[1];
                }

                if (info[0].equalsIgnoreCase("Stock")) {
                    Stock readStock = new Stock(info[1], info[2], Integer.parseInt(info[3]),
                            Double.parseDouble(info[4]), Double.parseDouble(info[5]));
                    Investments.add(readStock);
                    System.out.println(readStock);
                } else if (info[0].equalsIgnoreCase("MutualFund")) {
                    MutualFund readMF = new MutualFund(info[1], info[2], Integer.parseInt(info[3]),
                            Double.parseDouble(info[4]), Double.parseDouble(info[5]));
                    Investments.add(readMF);
                    System.out.println(readMF);
                }
            }
            fileScan.close();
        } catch (FileNotFoundException e) {
            // error check
            System.out.println("File not Found" + e);

        }
    }

    /**
     * This method is used when the user chooses the search option in the menu. it
     * asks the user for three fields the symbol, key words, and the price range.
     * (This function is incomplete)
     * 
     * @param input used for user input for 3 fields
     */

    public void search(Scanner input) { // Method for search option
        
        
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
            
            for(int i = 0; i < Investments.size(); i++){ // displays all stock invesments 
                System.out.println(Investments.toString());
            }
        }

        else if(symbol.isBlank() == false){ // if symbol is the only field entered print stock with the matching symbol

            for(int i = 0; i < Investments.size(); i++){
                if(Investments.get(i).getSymbol().equalsIgnoreCase(symbol)){
                    System.out.println("Symbol Match");
                    System.out.println("Symbol: " +Investments.get(i).getSymbol());
                }
            }
        }

        
        else if(price.isBlank() == false){ // if price is not blank 
            if(storePrice.length == 1){
                singlePrice = Double.parseDouble(storePrice[0]);

                if(storePrice[0].indexOf("-") == -1){ // if only a single number is entered then display all stocks and mutual funds with equal price
                    for(int i = 0; i < Investments.size(); i++){
                        if(Investments.get(i).getPrice() == singlePrice){
                            System.out.println("Price match");
                            System.out.println("Price: " + Investments.get(i). getPrice());
                        }
                    }
    
                }
            }

            if(storePrice.length == 2){ // if price range with includes two numbers then print investments that follow the price range
                firstPrice = Double.parseDouble(storePrice[0]); // holds first number 
                secondPrice = Double.parseDouble(storePrice[1]); // holds second number 

                for(int i = 0; i < Investments.size(); i++){
                    if(Investments.get(i).getPrice() >= firstPrice || Investments.get(i).getPrice() <= secondPrice){ // 
                        System.out.println("Price match");
                        System.out.println("Price match: " + Investments.get(i).getPrice());
                    }
                }
            }
 
        }

        
    }
           

}