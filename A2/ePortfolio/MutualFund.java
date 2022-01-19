package ePortfolio;

/**
     * Mutual Fund file for Mutual Fund class 
     * @author Arvind palakkal
     * 
     */

public class MutualFund extends Investment{
    public static final int REDEMPTION_FEE = 45;
  
    /**
     * The constructor is used to help create the new Mutual fund objects 
     * @param symbol represents symbol for mutual fund
     * @param name represents name for mutual fund 
     * @param quantity represents quantity for mutual fund 
     * @param price represents price for mutual fund
     * @param bookValue represents bookValue for mutual fund
     */
    public MutualFund(String symbol, String name, int quantity, double price, double bookValue){
        super(symbol, name, quantity, price, bookValue);
    }

    /**
     * This method returns the attributes of the mutual fund object as a string
     * @return returns attribures: symbol, name, quantity, price, bookValue
     */
    @Override
    public String toString(){ // used to display mutual fund object as string 
        return super.toString();
    }

}
