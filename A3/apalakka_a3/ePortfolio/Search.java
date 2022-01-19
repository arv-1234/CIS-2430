package ePortfolio;
import javax.swing.*;
import java.awt.event.*;

/**
     * Search file for Search option 
     * @author Arvind palakkal
     * 
     */

public class Search extends JFrame implements ActionListener{

    JLabel command= new JLabel("<html><span style='font-size:20px;color:black'>"+"Commands"+"</span></html>");
    JLabel searchMessage = new JLabel("<html><span style='font-size:15px;color:black;'>"+"Searching Investments"+"</span></html>");
    JLabel attributes =  new JLabel("<html><span style='font-size:15px;color:black;'>"+"Symbol<br/><br/>keyWords KeyWords<br/><br/>Low price<br/><br/>High price"+"</span></html>");
    JTextField symbol = new JTextField();
    JTextField keyWords = new JTextField();
    JTextField lowPrice = new JTextField();
    JTextField highPrice = new JTextField();
    JButton submit = new JButton("Search");
    JButton Reset = new JButton("Reset");
    JLabel commandMessage = new JLabel("<html><span style='font-size:15px;color:black;'>"+"Searching results"+"</span></html>");
    JTextArea output = new JTextArea();
    JScrollPane scroll = new JScrollPane(output);
    JMenuBar menuBar = new JMenuBar();
    JMenu commands = new JMenu("Commands");
    JMenuItem buy = new JMenuItem("Buy");
    JMenuItem sell = new JMenuItem("Sell");
    JMenuItem update = new JMenuItem("Update");
    JMenuItem getGain = new JMenuItem("getGain");
    JMenuItem search = new JMenuItem("Search");
    JMenuItem quit = new JMenuItem("Quit");

    /**
     * The constructor is used to generate the Search interface
     */
    public Search() {
        super("ePortfolio ");
        searchWindow();
        
    }

    /**
     * This method is used to create the search interface 
     */
    private void searchWindow(){
        setSize(820, 595);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // add option buttons to menu
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

        // add menu to menu bar 
        menuBar.add(commands);
        setJMenuBar(menuBar);

        // position components of gui
        searchMessage.setSize(300, 50);
        searchMessage.setLocation(20,0);

        attributes.setSize(170, 250);
        attributes.setLocation(50, 50);

        symbol.setSize(300, 40);
        symbol.setLocation(150,80);

        keyWords.setSize(300, 40);
        keyWords.setLocation(170, 140);

        lowPrice.setSize(300,40);
        lowPrice.setLocation(170, 190);

        highPrice.setSize(300,40);
        highPrice.setLocation(170, 238);

        Reset.setSize(100, 50);
        Reset.setLocation(600, 100);
        Reset.addActionListener(new Reset());

        submit.setSize(100,50);
        submit.setLocation(600, 200);
        submit.addActionListener(new searchBtn());

        scroll.setSize(745,200);
        scroll.setLocation(50, 330);

        commandMessage.setSize(100,100);
        commandMessage.setLocation(50, 263);

        // add components to gui
        add(searchMessage);
        add(attributes);
        add(symbol);
        add(keyWords);
        add(lowPrice);
        add(highPrice);
        add(Reset);
        add(submit);
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
     * This class is for the reset button. It implements the logic for the reset button
     */
    private class Reset implements ActionListener {
        /**
         * This method implements the logic for the reset button
         * @param e represents action event
         */
        public void actionPerformed(ActionEvent e) { // makes all text fileds blank
            symbol.setText("");
            keyWords.setText("");
            lowPrice.setText("");
            highPrice.setText("");
            output.setText("");
            
        }
     }

  /**
   * This class is for the search button. it implements the logic for the search button
   * */   
  private class searchBtn implements ActionListener {
    /**
     * This method is used to implement the logic for the search button
     * @param e represents the action event
     */
    public void actionPerformed(ActionEvent e) {
      String searchSymbol = " ";
      String searchKey = " ";
      double low = 0;
      double high = 0;
      String lowP = " ";
      String highP = " ";

      try { // error checks symbol
        if(symbol.getText().equals(" ")) {
          searchSymbol = " ";
        }
        else{
          searchSymbol = symbol.getText();
        }
      } catch (Exception x) {
        output.setText(x.getMessage());
      }

      try { // error check key words 
        if(keyWords.getText().equals(" ")){
          searchKey = " ";
        }
        else{
          searchKey = keyWords.getText();
        }
      } catch (Exception x) {
        output.setText(x.getMessage());
      }

      try { // error check low price
        if(lowPrice.getText().equals(" ")){
          lowP = " ";
        }

        if(Double.parseDouble(lowPrice.getText()) >= 0){
          low = Double.parseDouble(lowPrice.getText());
        }
        else{
          output.setText("Number cannot be negative");
          return;
        }
      } catch (Exception x) {
        output.setText(x.getMessage());
      }

      try { // error check high price 

        if(highPrice.getText().equals(" ")){
          highP = " ";
        }

        if(Double.parseDouble(highPrice.getText()) >= 0){
          high = Double.parseDouble(highPrice.getText());
        }
        else{
          output.setText("Number cannot be negative");
          return;
        }
      } catch (Exception x) {
        output.setText(x.getMessage());
      }
      
      if((searchSymbol.isBlank() == true) && (searchSymbol.isBlank() == true) && (lowP.isBlank() == true) && (highP.isBlank() == true)){ // If all 3 fields are blank then display all the investments 
            
        for(int i = 0; i < ePortfolio.Investments.size(); i++){ // displays all  invesments 
            output.append(ePortfolio.Investments.get(i).toString() + "\n");
        }
     }

     else if(searchSymbol.isBlank() == false){ // if symbol is not blank display the investment with specific symbol

      for(int i = 0; i < ePortfolio.Investments.size(); i++){
        if(ePortfolio.Investments.get(i).getSymbol().equalsIgnoreCase(searchSymbol)){
            output.append(ePortfolio.Investments.get(i).toString());
        }
      }

    }

    else if(low >= 0){ // if low price is entered display investments that have a price gerater than or equal to the low price 
      for(int i = 0; i < ePortfolio.Investments.size(); i++){
        if(ePortfolio.Investments.get(i).getPrice() >= low){
            output.append(ePortfolio.Investments.get(i).toString());
        }
      }
    }

    else if(high >= 0){ // if high price is entered display investments that have a price less than or equal to the low price 
      for(int i = 0; i < ePortfolio.Investments.size(); i++){
        if(ePortfolio.Investments.get(i).getPrice() <= high){
            output.append(ePortfolio.Investments.get(i).toString());
        }
      }
    }

    else if(low >= 0 && high >= 0){ // if both low and high are entered display investments with in the price range 
      for(int i = 0; i < ePortfolio.Investments.size(); i++){
        if(ePortfolio.Investments.get(i).getPrice() >= low && ePortfolio.Investments.get(i).getPrice() <= high){
            output.append(ePortfolio.Investments.get(i).toString());
        }
      }
    }

    else if(searchSymbol.isBlank() == false && low >= 0){ // if symbol and low is entered display investment with symbol and greater than or equal to low price 
      for(int i = 0; i < ePortfolio.Investments.size(); i++){
        if(ePortfolio.Investments.get(i).getSymbol().equalsIgnoreCase(searchSymbol) && ePortfolio.Investments.get(i).getPrice() >= low){
            output.append(ePortfolio.Investments.get(i).toString());
        }
      }
    }

    else if(searchSymbol.isBlank() == false && high >= 0){ // if symbol and high is entered display investment with symbol and less than or equal to low price 
      for(int i = 0; i < ePortfolio.Investments.size(); i++){
        if(ePortfolio.Investments.get(i).getPrice() <= high && ePortfolio.Investments.get(i).getSymbol().equalsIgnoreCase(searchSymbol)){
            output.append(ePortfolio.Investments.get(i).toString());
        }
      }
    }

   }
  }
}