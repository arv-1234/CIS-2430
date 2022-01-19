package ePortfolio;



    /**
     * Stock file for Stock class 
     * @author Arvind palakkal
     * 
     */

public class Stock {
    public static final double COMMISION = 9.99;
    private String symbol;
    private String name;
    private int quantity;
    private double price;
    private double bookValue;   

    /**
     * The constructor is used to help create the new stock objects 
     * @param symbol represents symbol for stock
     * @param name represents name for stock
     * @param quantity represents quantity for stock
     * @param price represents price for stock
     * @param bookValue represents bookValue for stock
     */
    public Stock(String symbol, String name, int quantity, double price, double bookValue){
        this.symbol = symbol;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.bookValue = bookValue;
    }

    /**
     * Empty constructor is used to help create temp stock object too calculate the bookvalue
     */
    public Stock(){
    }

    /**
     * This method returns the attributes of the stock object as a string
     * @return returns attribures: symbol, name, quantity, price, bookValue
     */
    public String toString(){ // used to display object as a string 
        return symbol + " " + name + " " + quantity + " " + price + " " + bookValue;
    }

     /**
     * This method returns the symbol of the given stock
     * @return returns symbol of stock
     */
    public String getSymbol(){ // method used to get symbol of stock
        return symbol;
    }
     
     /**
     * This method returns the name of the given stock
     * @return returns name of stock
     */
    public String getName(){ // method used to get name of stock
        return name;
    }

      /**
     * This method returns the quantity of the given stock
     * @return returns quantity of stock
     */
    public int getQuantity(){ // method used to get quantity of stock
        return quantity;
    }

      /**
     * This method returns the price of the given stock
     * @return returns price of stock
     */
    public double getPrice(){ // method used to get price of stock 
        return price;
    }

     /**
     * This method returns the bookValue of the given stock
     * @return returns bookValue of stock
     */
    public double getBookValue(){ // method used to get bookvalue of stock
        return bookValue;
    }

    /**
     * This method calculates the book value of a new stock object
     * @param priceGiven From user input. used in bookvalue calculation
     * @param quantityGiven From user input. used in bookvalue calculation
     * @return returns bookvalue of the new stock object 
     */
    public double newStockBookVal(double priceGiven, int quantityGiven){ // Calculates book value of new stock object 
        double temp;
        
        temp = (quantityGiven * priceGiven) + COMMISION; 
       
       return temp;
    }

    /**
     * This method updates the attributes of an existing stock after buying more of it
     * @param price used to set new price of stock. Also it is involved in the calculation for bookValue 
     * @param quantity was added to the original quantity to create the new quantity. Also it is involved in the calculation for bookValue 
     * @param stock was used to access specific attributes of the stock the user wants to buy
     */
    public void buyExistStock(double price, int quantity, Stock stock){// updates values when buying an existing stock 
        double newBookVal = 0;
        stock.price = price;
        stock.quantity = stock.quantity + quantity;
        newBookVal = (price * quantity) + COMMISION;
        stock.bookValue = newBookVal + stock.bookValue;
    }

    /**
     * This method calculates the payment after selling part or all of the stock 
     * @param priceSold represents the price inputted by the user. it is involved in the calculation of the payment 
     * @param quantitySold represents the quantity inputted by the user. it is involved in the calculation of the payment 
     * @return The payment is returned 
     */
    public double sellPayment(double priceSold, int quantitySold){ // calculates payment when selling stock 
        double payment = 0;

        payment = (quantitySold * priceSold) - COMMISION;

        return payment;
    }

    /**
     * This method updates the attributes after selling an existing stock 
     * @param priceSell input from the user. It is used update the current price of the stock 
     * @param quantitySell input from the user. It is used to update the book value and the current quantity of the stock
     * @param stockSell this is a stock object. It is used to access specific attributes of the stock the user wants to sell
     */
    public void sellExistStock(double priceSell, int quantitySell, Stock stockSell){ // updates values after selling existing stock 
        int existQuant = stockSell.quantity - quantitySell;
        int orgQuant = stockSell.quantity;
        double i = existQuant;
        double j = orgQuant;

        stockSell.price = priceSell;
        stockSell.bookValue = stockSell.bookValue * (i/j);
        stockSell.quantity = stockSell.quantity - quantitySell;
    }

    /**
     * This method sets the price of the given stock
     * @param setPrice this is input from the user. sets price of current stock
     * @param stock stock object is used to represent current stock
     */
    public void setPrice( double setPrice,Stock stock){ // Sets price of array 
        stock.price = setPrice;        
    }

    /**
     * This method calculates the gain from each stock 
     * @param stock the stock object is used to access specific attributes of the stock 
     * @return the gain for the stock is returned
     */
    public double getGainStock(Stock stock){ // calculates gain from each stock
        double gain = 0;
        double quant = stock.quantity;

        gain = ((quant * stock.price) - COMMISION) - stock.bookValue;

        return gain;
    }

}
