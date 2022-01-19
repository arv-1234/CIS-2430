package ePortfolio;


    /**
     * Mutual Fund file for Mutual Fund class 
     * @author Arvind palakkal
     * 
     */

public class MutualFund {
    public static final int REDEMPTION_FEE = 45;
    private String symbol;
    private String name;
    private int quantity;
    private double price;
    private double bookValue; 

    /**
     * The constructor is used to help create the new Mutual fund objects 
     * @param symbol represents symbol for mutual fund
     * @param name represents name for mutual fund 
     * @param quantity represents quantity for mutual fund 
     * @param price represents price for mutual fund
     * @param bookValue represents bookValue for mutual fund
     */
    public MutualFund(String symbol, String name, int quantity, double price, double bookValue){
        this.symbol = symbol;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.bookValue = bookValue;
    }

     /**
     * Empty constructor is used to help create temp mutual fund object too calculate the bookvalue
     */
    public MutualFund(){

    }

    /**
     * This method returns the attributes of the mutual fund object as a string
     * @return returns attribures: symbol, name, quantity, price, bookValue
     */
    public String toString(){ // used to display mutual fund object as string 
        return symbol + " " + name + " " + quantity + " " + price + " " + bookValue;
    }

         /**
     * This method returns the symbol of the given mutual fund 
     * @return returns symbol of mutual fund
     */
    public String getSymbol(){ // used to get symbol of mutual fund 
        return symbol;
    }

        /**
     * This method returns the name of the given mutual fund
     * @return returns name of mutual fund 
     */
    public String getName(){ // used too get name of mutual fund 
        return name;
    }

     /**
     * This method returns the quantity of the given mutual fund
     * @return returns quantity of mutual fund
     */
    public int getQuantity(){ // used to get quantity of mutual fund
        return quantity;
    }

     /**
     * This method returns the price of the given mutual fund 
     * @return returns price of mutual fund 
     */
    public double getPrice(){ // used to get price of mutual fund 
        return price;
    }

     /**
     * This method returns the bookValue of the given mutual fund 
     * @return returns bookValue of mutual fund 
     */
    public double getBookValue(){ // used to get book value of mutual fund 
        return bookValue;
    }
    
     /**
     * This method calculates the book value of a new mutual fund object
     * @param priceGiven From user input. used in bookvalue calculation
     * @param quantityGiven From user input. used in bookvalue calculation
     * @return returns bookvalue of the new mutual object 
     */
    public double newMutualBookVal(double priceGiven, int quantityGiven){ // calculate new book value of new mutual fund 
        double temp;

        temp = priceGiven * quantityGiven;

        return temp;
    }

    
    /**
     * This method updates the attributes of an existing mutual fund after buying more of it
     * @param newPrice used to set new price of mutual fund. Also it is involved in the calculation for bookValue 
     * @param newQuantity was added to the original quantity to create the new quantity. Also it is involved in the calculation for bookValue 
     * @param mutual was used to access specific attributes of the mutual fund the user wants to buy
     */
    public void buyExistMutual(double newPrice, int newQuantity, MutualFund mutual){ // update values of existing mutual fund 
        double temp = 0;
        mutual.price = newPrice;
        mutual.quantity = newQuantity + mutual.quantity;
        temp = newPrice * newQuantity;
        mutual.bookValue = temp + mutual.bookValue;
    }

     /**
     * This method updates the attributes after selling an existing mutual fund  
     * @param mPriceSell input from the user. It is used update the current price of the mutual fund  
     * @param mQuantitySell input from the user. It is used to update the book value and the current quantity of the mutual fund
     * @param mutualFund this is a mutual fund object. It is used to access specific attributes of the mutal fund the user wants to sell
     */
    public void sellExistMutualFund(double mPriceSell, int mQuantitySell, MutualFund mutualFund){ // update values after selling exisiting stock
        int mExistQuant = mutualFund.getQuantity() - mQuantitySell;
        int mOrgQuant = mutualFund.getQuantity();
        double i = mExistQuant;
        double j = mOrgQuant;

        mutualFund.price = mPriceSell;
        mutualFund.bookValue = mutualFund.bookValue * (i/j);
        mutualFund.quantity = mutualFund.quantity - mQuantitySell;
    }

     /**
     * This method calculates the payment after selling part or all of the mutual fund 
     * @param priceSold represents the price inputted by the user. it is involved in the calculation of the payment 
     * @param quantitySold represents the quantity inputted by the user. it is involved in the calculation of the payment 
     * @return The payment is returned 
     */
    public double sellPayment(double priceSold, int quantitySold){ // calculate payment for mutual fund 
        double payment = 0;

        payment = (quantitySold * priceSold) - REDEMPTION_FEE;

        return payment;
    }

        /**
     * This method sets the price of the given mutual fund 
     * @param setPrice this is input from the user. sets price of current mutual fund
     * @param mutualFund mutual fund object is used to represent current mutual fund
     */
    public void setPrice( double setPrice, MutualFund mutualFund){ // set price for mutual fund 
        mutualFund.price = setPrice;        
    }

    /**
     * This method calculates the gain from each mutual fund 
     * @param mutualFund the mutual fund object is used to access specific attributes of the mutual fund 
     * @return the gain for the mutual fund is returned
     */
    public double getGainMutual(MutualFund mutualFund){ // calculates gain from each mutual fund 
        double gain = 0;
        double quant = mutualFund.quantity;

        gain = ((quant * mutualFund.price) - REDEMPTION_FEE) - mutualFund.bookValue;

        return gain;
    }
}
