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

        /**
     * This method calculates the gain from each mutual fund 
     * @param mutualFund the mutual fund object is used to access specific attributes of the mutual fund 
     * @return the gain for the mutual fund is returned
     */
    public double getGainMutual(MutualFund mutualFund){ // calculates gain from each mutual fund 
        double gain = 0;
        double quant = mutualFund.quantity;

        gain = ((quant * mutualFund.price) - 45) - mutualFund.bookValue;

        return gain;
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

}
