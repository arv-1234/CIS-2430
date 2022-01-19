package ePortfolio;

/**
     * Stock file for Stock class 
     * @author Arvind palakkal
     * 
     */

public class Stock extends Investment{
    public static final double COMMISION = 9.99;
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

        /**
     * This method calculates the gain from each stock 
     * @param stock the stock object is used to access specific attributes of the stock 
     * @return the gain for the stock is returned
     */
    public double getGainStock(Stock stock){ // calculates gain from each stock
        double gain = 0;
        double quant = stock.quantity;

        gain = ((quant * stock.price) - 9.99) - stock.bookValue;

        return gain;
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

}
