package ePortfolio;
import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;

/**
     * Sell file for Sell option 
     * @author Arvind palakkal
     * 
     */

public class Sell extends JFrame implements ActionListener{

    JLabel sellMessage = new JLabel("<html><span style='font-size:15px;color:black;'>"+"Selling an investment"+"</span></html>");
    JLabel attributes =  new JLabel("<html><span style='font-size:15px;color:black;'>"+"Symbol<br/><br/>Quantity<br/><br/>Price"+"</span></html>");
    JTextField symbol = new JTextField();
    JTextField Quantity = new JTextField();
    JTextField price = new JTextField();
    JButton sellButton = new JButton("Sell");
    JButton Reset = new JButton("Reset");
    JLabel commandMessage = new JLabel("<html><span style='font-size:15px;color:black;'>"+"Messages"+"</span></html>");
    JTextArea messages = new JTextArea();
    JScrollPane scroll = new JScrollPane(messages);
    JMenuBar menuBar = new JMenuBar();
    JMenu commands = new JMenu("Commands");
    JMenuItem buy = new JMenuItem("Buy");
    JMenuItem sell = new JMenuItem("Sell");
    JMenuItem update = new JMenuItem("Update");
    JMenuItem getGain = new JMenuItem("getGain");
    JMenuItem search = new JMenuItem("Search");
    JMenuItem quit = new JMenuItem("Quit");

    /**
     * The constructor is used to generate the interface for the Sell option
     */
    public Sell() {
        super("ePortfolio");
        sellWindow();
     }

     /**
      * This method creates the interface for the sell option
      */
     private void sellWindow(){// method used to create userinterface 
        setSize(820, 595); // set size for interface 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // add buttons to command label
        commands.add(buy);
        buy.addActionListener(this);

        commands.add(sell);
        sell.addActionListener(this);

        commands.add(update);
        update.addActionListener(this);

        commands.add(getGain);
        getGain.addActionListener(this);

        commands.add(search);
        search.addActionListener(this);

        commands.add(quit);
        quit.addActionListener(this);

        menuBar.add(commands);
        setJMenuBar(menuBar);

        // Set location of components of interface 
        sellMessage.setSize(300, 50);
        sellMessage.setLocation(20,0);

        attributes.setSize(100, 250);
        attributes.setLocation(50, 50);

        symbol.setSize(300, 40);
        symbol.setLocation(150,100);

        Quantity.setSize(300, 40);
        Quantity.setLocation(150,150);
    
        price.setSize(300, 40);
        price.setLocation(150, 200);

        Reset.setSize(100, 50);
        Reset.setLocation(600, 100);
        Reset.addActionListener(new Reset());

        sellButton.setSize(100,50);
        sellButton.setLocation(600, 200);
        sellButton.addActionListener(new sellInvestments());

        scroll.setSize(745,200);
        scroll.setLocation(50, 340);

        commandMessage.setSize(100,100);
        commandMessage.setLocation(50, 263);

        // add components to interface 
        add(sellMessage);
        add(attributes);
        add(symbol);
        add(Quantity);
        add(price);
        add(Reset);
        add(sellButton);
        add(scroll);
        add(commandMessage);
     }

     
      /** 
     * This method allows the user to move through different options 
     * @param e used to move through different option
     */
     public void actionPerformed(ActionEvent e){
        String option= e.getActionCommand();

        if(option.equals("Buy")){
          Buy buy = new Buy();
          buy.setVisible(true);
          dispose();
        }else if(option.equals("Sell")){
          Sell sell = new Sell();
          sell.setVisible(true);
          dispose();
        }else if(option.equals("Update")){
           Update update = new Update();
           update.setVisible(true);
           dispose();
        }else if(option.equals("getGain")){
           getGain getGain = new getGain();
           getGain.setVisible(true);
           dispose();
        }else if(option.equals("Search")){
          Search search = new Search();
          search.setVisible(true);
          dispose();
           
        }else if(option.equals("Quit")){
            System.exit(0);
        }
    }

     /**
     * This class is used for the reset button. It includes a method that implements the logic of the reset button
     */
    private class Reset implements ActionListener {
         /**
       * This method implements the logic for the reset button
       * @param e represents action event
       */
        public void actionPerformed(ActionEvent e) { // sets text area and fields to blank
            symbol.setText("");
            Quantity.setText("");
            price.setText("");
            messages.setText("");
            
        }
     }

     /**
      * This class is used for the Sell button. It includes a method that implements the logic for the sell button
      */
     private class sellInvestments implements ActionListener {
        /**
         * This method implements the logic for the sell button
         * @param e represents the action event
         */
        public void actionPerformed(ActionEvent e) {
           String symbolInvest = symbol.getText();

           if(symbolInvest.isBlank()){ // checks if symbol is empty 
              messages.setText("symbol cannot be empty. Must be entered");
              return;
           }

           for(int i = 0; i < ePortfolio.Investments.size(); i++){ 
              //Stock temp = new Stock(symbolInvest, "asdasd", 1, 1, 1);
            if (ePortfolio.Investments.get(i).equals(new Stock(symbolInvest, " ", 0, 0, 0))) { // checks if symbol is from a stock

               int sellQuantity = 0; // holds the selling quantity of the user
               double sellPrice = 0; // holds the selling price of the user
               double payment; // holds the payment value
               String nameStock = ePortfolio.Investments.get(i).getName();
               String pattern = "###.#";
               DecimalFormat df = new DecimalFormat(pattern); 

               // Error check price and quantity
               try {
                  sellQuantity = Integer.parseInt(Quantity.getText());
                  if(sellQuantity <= 0){
                     messages.setText("Quantity cannot be less than or equal to 0");
                     return;
                  }
               } catch (NumberFormatException x) {
                  messages.setText("Invalid quantity. Enter again");
                  return;
               }

               try {
                  sellPrice = Double.parseDouble(price.getText()); 
                  if(sellPrice <= 0){
                     messages.setText("Price cannot be less than or equal to 0");
                     return;
                  }
               } catch (NumberFormatException x) {
                  messages.setText("Invalid price. Enter again");
                  return;
               }

               if(sellQuantity > ePortfolio.Investments.get(i).getQuantity() || sellPrice <= 0 || sellQuantity <= 0){
                  messages.setText("Invalid value(s). Please enter again");
                  return;
               }
         
               if (ePortfolio.Investments.get(i).getQuantity() == sellQuantity) { // if the quantity the user enters is equal to the quantity of the
            
                  payment = (sellQuantity * sellPrice) - 9.99; // calculate payment
                  messages.setText("The payment you have recieved is: " + df.format(payment) + ". The stock will be removed from the list");
                  ePortfolio.Investments.remove(ePortfolio.Investments.get(i)); // remove investment 
                  return;
               }

               else{ // otherwise sell part of stock

               double existQuant = ePortfolio.Investments.get(i).getQuantity() - sellQuantity;
               double orgQuant = ePortfolio.Investments.get(i).getQuantity();
               double setBookVal;
               int sellQ = ePortfolio.Investments.get(i).getQuantity() - sellQuantity;

               try {
                  ePortfolio.Investments.get(i).setPrice(sellPrice); // set selling price 
               } catch (Exception t) {
                 messages.setText(t.getMessage());
               }

               setBookVal = ePortfolio.Investments.get(i).getBookValue() * (existQuant / orgQuant); // calculate new book value 

               try {
                  ePortfolio.Investments.get(i).setBookValue(setBookVal); // set bookvalue
               } catch (Exception t) {
                  messages.setText(t.getMessage());
               }

               try {
                  ePortfolio.Investments.get(i).setQuantity(sellQ); // set quantity
               } catch (Exception t) {
                  messages.setText(t.getMessage());
               }


               payment = (sellPrice * sellQuantity) - 9.99; // payment is calculated 

               messages.setText("The payment you have recieved is: " + df.format(payment) + ". The stock: " + ePortfolio.Investments.get(i).toString());
            }

         }
        // MutualFund temp = new MutualFund(symbolInvest, "asd", 1, 1, 1);
         else if(ePortfolio.Investments.get(i).equals(new MutualFund(symbolInvest, " ", 0, 0, 0))){
            int sellMQuant = 0; // holds the selling quantity of the user
            double sellMPrice = 0; // holds the selling price of the user
            double mPayment; // holds the payment value
            String nameStock = ePortfolio.Investments.get(i).getName();
            String pattern = "###.#";
            DecimalFormat df = new DecimalFormat(pattern); 

            // error check price and quantity
            try {
               sellMQuant = Integer.parseInt(Quantity.getText());
               if(sellMQuant <= 0){
                  messages.setText("Quantity cannot be less than or equal to 0");
                  return;
               }
            } catch (NumberFormatException x) {
               messages.setText("Invalid quantity. Enter again");
               return;
            }

            try {
               sellMPrice = Double.parseDouble(price.getText()); 
               if(sellMPrice <= 0){
                  messages.setText("Price cannot be less than or equal to 0");
                  return;
               }
            } catch (NumberFormatException x) {
               messages.setText("Invalid price. Enter again");
               return;
            }

            if(sellMQuant > ePortfolio.Investments.get(i).getQuantity() || sellMPrice <= 0 || sellMQuant <= 0){
               messages.setText("Invalid value(s). Please enter again");
               return;
            }
            
            if (ePortfolio.Investments.get(i).getQuantity() == sellMQuant) { // if the quantity the user enters is equal to the quantity of the
   
               mPayment = (sellMQuant * sellMPrice) - 45; // method for payment is called
               messages.setText("The payment you have recieved is: " + df.format(mPayment) + ". The Mutual fund will be removed from the list");
               ePortfolio.Investments.remove(ePortfolio.Investments.get(i)); // remove investment from list 
               return;
            }

            else{ // sell part of mutual fund

            double existQuant = ePortfolio.Investments.get(i).getQuantity() - sellMQuant;
            double orgQuant = ePortfolio.Investments.get(i).getQuantity();
            double setBookVal;
            int sellQ = ePortfolio.Investments.get(i).getQuantity() - sellMQuant;

            try {
               ePortfolio.Investments.get(i).setPrice(sellMPrice); // set selling price 
            } catch (Exception t) {
               messages.setText(t.getMessage());
            }

            setBookVal = ePortfolio.Investments.get(i).getBookValue() * (existQuant / orgQuant); // calculate new book value 

            try {
               ePortfolio.Investments.get(i).setBookValue(setBookVal); // set bookvalue
            } catch (Exception t) {
               messages.setText(t.getMessage());
            }

            try {
               ePortfolio.Investments.get(i).setQuantity(sellQ); // set quantity
            } catch (Exception t) {
               messages.setText(t.getMessage());
            }

            mPayment = (sellMQuant * sellMPrice) - 45; // method for payment is called
            // payment is calculated 

            messages.setText("The payment you have recieved is: " + df.format(mPayment) + ". The Mutual fund: " + ePortfolio.Investments.get(i).toString());
         }
      }

         

      }
   }

   }
}