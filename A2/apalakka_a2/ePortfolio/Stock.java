package ePortfolio;

/**
     * Stock file for Stock class 
     * @author Arvind palakkal
     * 
     */

public class Stock extends Investment{
    /**
     * The constructor is used to help create the new stock objects 
     * @param symbol represents symbol for stock
     * @param name represents name for stock
     * @param quantity represents quantity for stock
     * @param price represents price for stock
     * @param bookValue represents bookValue for stock
     */
    public Stock(String symbol, String name, int quantity, double price, double bookValue){
        super(symbol, name, quantity, price, bookValue);
    }

    /**
     * This method returns the attributes of the stock object as a string
     * @return returns attribures: symbol, name, quantity, price, bookValue
     */
    @Override 
    public String toString(){ // used to display object as a string 
        return super.toString();
    }
}
