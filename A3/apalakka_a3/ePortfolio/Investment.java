package ePortfolio;


public  class Investment {
    protected String symbol;
    protected String name;
    protected int quantity;
    protected double price;
    protected double bookValue; 

/**
 * Constructor is used for the investment objects 
 * @param symbol represents symbol for investment 
 * @param name represents name for investment 
 * @param quantity represents quantity for investment
 * @param price represents price for investment
 * @param bookValue represents bookValue for investment
 */
    public Investment(String symbol, String name, int quantity, double price, double bookValue){
        this.symbol = symbol;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.bookValue = bookValue;
    }

    /**
     * This method returns the attribures of the investments as a string 
     * @return returns attribures symbol, name, quantity, price, bookValue
     */
    public String toString(){
        return "\nSymbol:"  + this.symbol + "\nName: " + this.name + "\nQuantity: " + this.quantity + "\nPrice: " + this.price + "\nBookValue: " + this.bookValue;
    }

    /**
     * This method is used to format the investments when saved to the file 
     * @return returns one of the statements dependng on if investment is a stock or mutual fund 
     */
    public String toFile(){
        if(equals(new Stock(symbol, " ", 0, 0, 0))){
            return "\ntype = \"stock\"\n" + "Symbol = " + "\"" + symbol + "\"" +"\nName = "+ "\"" + name + "\"" +"\nQuantity = " + "\"" + quantity + "\"" + "\nPrice = "+ "\"" + price + "\"" +"\nBookValue = "+ "\"" + bookValue + "\"";
        }
        else{
            return "\ntype = \"mutualfund\"\n" + "Symbol = " + "\"" + symbol + "\"" +"\nName = "+ "\"" + name + "\"" +"\nQuantity = " + "\"" + quantity + "\"" + "\nPrice = "+ "\"" + price + "\"" +"\nBookValue = "+ "\"" + bookValue + "\"";
        }
    }

    /**
     * Method returns symbol of the investment
     * @return symbol of the investment
     */
    public String getSymbol(){
        return symbol;
    }

    /**
     * Method returns name of the investment
     * @return name of the investment
     */
    public String getName(){
        return name;
    }

    /**
     * Method return quantity of investment
     * @return quantity of the investment
     */
    public int getQuantity(){
        return quantity;
    }

    /**
     * Method returns price of investment
     * @return price of the investment
     */
    public double getPrice(){
        return price;
    }

    /**
     * Method returns bookValue of investment
     * @return bookValue of the investment
     */
    public double getBookValue(){
        return bookValue;
    }

    /**
     * Method sets price of investment 
     * @param newPrice represents the new price the price of the investment will be set to
     */
    public void setPrice(double newPrice) throws Exception{
        if(newPrice < 0){
            throw new Exception("new price cannot be negative");
        }
        this.price = newPrice;
    }

    /**
     * Method is used to set the new quantity of the investment
     * @param newQuantity represents the new quantity of the investment
     */
    public void setQuantity(int newQuantity)throws Exception{
        if(newQuantity < 0){
            throw new Exception("new quantity must be greater than 0");
        }
        this.quantity = newQuantity;
    }

    /**
     * Method is used to set new bookvalue for the investment
     * @param newBookValue represents the new book value for the investment
     */
    public void setBookValue(double newBookValue) throws Exception {
        if(newBookValue < 0){
            throw new Exception("New book value must be greater than 0");
        }
        this.bookValue = newBookValue;
    }

    /**
     * Equals method is used to determine if investment is a stock or mutual fund 
     * @param invest represents investment
     * @return returns one of the following statements depending if investment is a stock or mutual fund
     */
    public boolean equals(Investment invest){

        if(this instanceof Stock){

            return(symbol.toLowerCase().equals(invest.symbol.toLowerCase()) && invest instanceof Stock);

        }else{

            return(symbol.toLowerCase().equals(invest.symbol.toLowerCase()) && invest instanceof MutualFund);

        }
    }
}
