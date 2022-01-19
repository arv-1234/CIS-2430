package ePortfolio;

import javax.swing.*;

import java.util.*;
import java.awt.event.*;

/**
     * Buy file for Buy option 
     * @author Arvind palakkal
     * 
     */


public class Buy extends JFrame implements ActionListener{

    JLabel command= new JLabel("<html><span style='font-size:20px;color:black'>"+"Commands"+"</span></html>");
    JLabel buyMessage = new JLabel("<html><span style='font-size:15px;color:black;'>"+"Buying an investment"+"</span></html>");
    JLabel labels =  new JLabel("<html><span style='font-size:15px;color:black;'>"+"Type<br/><br/>Symbol<br/><br/>Name<br/><br/>Quantity<br/><br/>Price"+"</span></html>");
    JComboBox<String> box;
    JTextField symbol = new JTextField();
    JTextField name = new JTextField();
    JTextField Quantity = new JTextField();
    JTextField price = new JTextField();
    JButton buyButton = new JButton("Buy");
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
     * constructor used to generate interface for Buy option
     */
    public Buy() {
        super("ePortfolio");
        buyWindow();
    }

    /**
     * The method is used to create the Buy interface 
     */
    private void buyWindow(){ // Creates user interface 
        String [] typeOfInvestment = {"Stock", "Mutual Fund"}; // creates drop down menu for investments 
        setSize(820, 595);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Add buttons to command label
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

        // add command bar to menu
        menuBar.add(commands);
        setJMenuBar(menuBar);

        // position components of the interface
        buyMessage.setSize(300, 50);
        buyMessage.setLocation(20,0);

        labels.setSize(100, 250);
        labels.setLocation(50, 50);

        box = new JComboBox<>(typeOfInvestment);
        box.setSize(200, 35);
        box.setLocation(150, 60);

        symbol.setSize(300, 40);
        symbol.setLocation(150,100);

        name.setSize(300, 40);
        name.setLocation(150, 150);

        Quantity.setSize(300, 40);
        Quantity.setLocation(150,200);

        price.setSize(300, 40);
        price.setLocation(150, 250);

        Reset.setSize(100, 50);
        Reset.setLocation(600, 100);
        Reset.addActionListener(new Reset());

        buyButton.setSize(100,50);
        buyButton.setLocation(600, 200);
        buyButton.addActionListener(new buyInvestments());

        scroll.setSize(745,200);
        scroll.setLocation(50, 340);

        commandMessage.setSize(100,100);
        commandMessage.setLocation(50, 263);

        // add components of the interface
        add(buyMessage);
        add(labels);
        add(box);
        add(symbol);
        add(name);
        add(Quantity);
        add(price);
        add(Reset);
        add(buyButton);
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
        public void actionPerformed(ActionEvent e) {
            // makes all text fields and text area blank
            symbol.setText("");
            name.setText("");
            box.setSelectedIndex(0);
            Quantity.setText("");
            price.setText("");
            messages.setText("");
        }
     }

     /**
      * This class is used for the Buy button. It includes a method that implements the logic of the buy button
      */
     private class buyInvestments implements ActionListener{
       /**
        * This method implements the logic of the buy button
        * @param e represents the action event
        */
       public void actionPerformed(ActionEvent e){
         String investmentType = (String)box.getSelectedItem();

         if(investmentType.equals("Stock")){ // if user entered stock buy stock
          String stockSymbol = symbol.getText();
          String newName = name.getText();
          int newQuantity = Integer.parseInt(Quantity.getText());
          double newPrice = Double.parseDouble(price.getText());
          int existQuantity = Integer.parseInt(Quantity.getText());
          double existPrice = Double.parseDouble(price.getText());
          int setQuant;
          double existBook;
           int indexVal;
          ArrayList<Integer> indexValue = new ArrayList<Integer>();

          if(stockSymbol.isBlank()){
            messages.setText("They stock symbol cannot be empty. Input symbol again");
            return;
          }

          for(int i = 0; i < ePortfolio.Investments.size(); i++){ // checks if mutual fund has the same symbol
            //MutualFund temp = new MutualFund(stockSymbol, "asds", 1, 1, 1);
            if (ePortfolio.Investments.get(i).equals(new MutualFund(stockSymbol, " ", 0, 0, 0))) {
              messages.setText("This symbol already exisits for a mutual fund. Please try agian");
              return;
          }
        }

        for (int i = 0; i < ePortfolio.Investments.size(); i++){ // Otherwise create new stock

          if (ePortfolio.Investments.get(i).getSymbol().equalsIgnoreCase(stockSymbol)){

            try {
              existQuantity = Integer.parseInt(Quantity.getText());
              if(existQuantity <= 0){
                messages.setText("Quantity cannot be 0 or negative");
                return;
              }
            } catch (NumberFormatException r) {
              messages.setText("Invalid Quantity");
            }

            try {
              existPrice = Double.parseDouble(price.getText());
              if(existPrice <= 0){
                messages.setText("The Price cannot be negative");
                return;
              }

            } catch (NumberFormatException r) {
              messages.setText("Invalid Price");
            }

            try {
              ePortfolio.Investments.get(i).setPrice(existPrice);
            } catch (Exception x) {
              messages.setText(x.getMessage());
            }

            setQuant = ePortfolio.Investments.get(i).getQuantity() + existQuantity;
            existBook = ((existPrice * existQuantity) + 9.99) + ePortfolio.Investments.get(i).getBookValue();
            

            try {
              ePortfolio.Investments.get(i).setBookValue(existBook);
            } catch (Exception x) {
              messages.setText(x.getMessage());
            }

            try {
              ePortfolio.Investments.get(i).setQuantity(setQuant);
            } catch (Exception x) {
              messages.setText(x.getMessage());
            }
            messages.setText(ePortfolio.Investments.get(i).toString());
            return;
          }
        }

        try {
          if(newName.isBlank()){
            messages.setText("They name of the stock be empty. Input name again");
            return;
          }
        } catch (Exception r) {
          messages.setText("name cannot be blank");
        }

        try {
          newQuantity = Integer.parseInt(Quantity.getText());
          if(newQuantity <= 0){
            messages.setText("Quantity cannot be less than or equal to 0");
            return;
          }
        } catch (NumberFormatException r) {
          messages.setText("Invalid Quantity");
        }

        
        try {
          newPrice = Double.parseDouble(price.getText());

          if(newPrice <= 0){
            messages.setText("price cannot be less than or equal to 0");
            return;
          }
        } catch (NumberFormatException r) {
          messages.setText("Invalid Price");
        }

        double newBookVal = (newPrice * newQuantity) + 9.99; // Bookvalue is calculated using price and quantity

        Stock newStock = new Stock(stockSymbol, newName, newQuantity, newPrice, newBookVal);
        ePortfolio.Investments.add(newStock);
        messages.setText(ePortfolio.Investments.toString());

        String keyWord[] = newName.split(" "); // for hash map

      indexVal = ePortfolio.Investments.size() - 1;

      for(int i = 0; i < keyWord.length; i++){ // adds words in anme to hash map
        String word = keyWord[i].toLowerCase();
        if(ePortfolio.index.containsKey(word)){
            indexValue = ePortfolio.index.get(word);
            indexValue.add(indexVal);
        }
        else{
            indexValue = new ArrayList<>();
            indexValue.add(indexVal);
            ePortfolio.index.put(word, indexValue);
        }
      }
    }
    else{ // buy mutual fund 
      String mutualSymbol = symbol.getText();
      String newName = name.getText();
      int newQuantity = Integer.parseInt(Quantity.getText());
      double newPrice = Double.parseDouble(price.getText());
      int existQuantity = 0;
      double existPrice = 0;
      int setQuant;
      double existBook;
      int indexVal;
      ArrayList<Integer> indexValue = new ArrayList<Integer>();

      if(mutualSymbol.isBlank()){
        messages.setText("They stock symbol cannot be empty. Input symbol again");
        return;
      }

      for(int i = 0; i < ePortfolio.Investments.size(); i++){ // check if stock with same symbol exists
       // Stock temp = new Stock(mutualSymbol, "asd", 1, 1, 1);
        if (ePortfolio.Investments.get(i).equals(new Stock(mutualSymbol, " ", 0, 0, 0))) {
          messages.setText("This symbol already exisits for a Stock. Please try agian");
          return;
      }
    }

    for (int i = 0; i < ePortfolio.Investments.size(); i++){

      if (ePortfolio.Investments.get(i).getSymbol().equalsIgnoreCase(mutualSymbol)){

        try {
          existQuantity = Integer.parseInt(Quantity.getText());
          if(existQuantity <= 0){
            messages.setText("Quantity cannot be less than or equal to 0");
            return;
          }
        } catch (NumberFormatException r) {
          messages.setText("Invalid Quantity");
        }

        try {
          existPrice = Double.parseDouble(price.getText());
          if(existPrice <= 0){
            messages.setText("Price cannot be less than or equal to 0");
            return;
          }
        } catch (NumberFormatException r) {
          messages.setText("Invalid Price");
        }

        try {
          ePortfolio.Investments.get(i).setPrice(existPrice);
        } catch (Exception x) {
          messages.setText(x.getMessage());
        }

        setQuant = ePortfolio.Investments.get(i).getQuantity() + existQuantity;

        try {
          ePortfolio.Investments.get(i).setQuantity(setQuant);
        } catch (Exception w) {
          messages.setText(w.getMessage());
        }

        existBook = ePortfolio.Investments.get(i).getBookValue() + (existPrice * existQuantity);

        try {
          ePortfolio.Investments.get(i).setBookValue(existBook);
        } catch (Exception w) {
          messages.setText(w.getMessage());
        }
        messages.setText(ePortfolio.Investments.get(i).toString());
        return;
      }
    }

    if(newName.isBlank()){
      messages.setText("The name of the Mutual Fund cannot be empty. Input name again");
      return;
    }

    try {
      newQuantity = Integer.parseInt(Quantity.getText());
      if(newQuantity <= 0){
        messages.setText("Quantity cannot be less than or equal to 0");
        return;
      }
    } catch (NumberFormatException r) {
      messages.setText("Invalid Quantity");
    }

    
    try {
      newPrice = Double.parseDouble(price.getText());
      if(newPrice <= 0){
        messages.setText("Price cannot be less than or equal to 0");
        return;
      }
    } catch (NumberFormatException r) {
      messages.setText("Invalid Price");
    }

    double newBookVal = newPrice * newQuantity;  // Bookvalue is calculated using price and quantity

    MutualFund newMutual = new MutualFund(mutualSymbol, newName, newQuantity, newPrice, newBookVal);
    ePortfolio.Investments.add(newMutual);
    messages.setText(ePortfolio.Investments.toString());

    String keyWord[] = newName.split(" ");

    indexVal = ePortfolio.Investments.size() - 1;

    for(int i = 0; i < keyWord.length; i++){ // add words in name to hash map
        String word = keyWord[i].toLowerCase();
        if(ePortfolio.index.containsKey(word)){
            indexValue = ePortfolio.index.get(word);
            indexValue.add(indexVal);
        }
        else{
            indexValue = new ArrayList<>();
            indexValue.add(indexVal);
            ePortfolio.index.put(word, indexValue);
        }
      }
    }
  }
 }
}