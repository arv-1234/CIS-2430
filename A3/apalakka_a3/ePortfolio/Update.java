package ePortfolio;
import javax.swing.*;
import java.awt.event.*;


/**
     * Update file for Update class 
     * @author Arvind palakkal
     * 
     */


public class Update extends JFrame implements ActionListener {


    JLabel command= new JLabel("<html><span style='font-size:20px;color:black'>"+"Commands"+"</span></html>");
    JLabel updateMessage = new JLabel("<html><span style='font-size:15px;color:black;'>"+"Updating investment"+"</span></html>");
    JLabel attributes =  new JLabel("<html><span style='font-size:15px;color:black;'>"+"Symbol<br/><br/>Name<br/><br/>Price"+"</span></html>");
    JTextField symbol = new JTextField();
    JTextField name = new JTextField();
    JTextField price = new JTextField();
    JButton prev = new JButton("Prev");
    JButton next = new JButton("Next");
    JButton save = new JButton("Save");
    JLabel commandMessage = new JLabel("<html><span style='font-size:15px;color:black;'>"+"Messages"+"</span></html>");
    JTextArea messages = new JTextArea();
    JScrollPane scroll = new JScrollPane(messages);
    private int listIndex = 0;
    JMenuBar menuBar = new JMenuBar();
    JMenu commands = new JMenu("Commands");
    JMenuItem buy = new JMenuItem("Buy");
    JMenuItem sell = new JMenuItem("Sell");
    JMenuItem update = new JMenuItem("Update");
    JMenuItem getGain = new JMenuItem("getGain");
    JMenuItem search = new JMenuItem("Search");
    JMenuItem quit = new JMenuItem("Quit");

    /**
     * The constructor is used to generate the user interface for Update 
     */
    public Update() {
        super("ePorfolio");
        updateWindow();

        if(ePortfolio.Investments.size() == 0){
         messages.setText("The arraylist is empty. Cant update any prices.");
         return;
       }

        symbol.setText(ePortfolio.Investments.get(listIndex).getSymbol());
        name.setText(ePortfolio.Investments.get(listIndex).getName());
     }

     /**
      * This method creates the user interface for for Update
      */
     private void updateWindow(){ // creates interface for update 
        setSize(820, 595);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // add option buttons to command menu
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

        // position components of interface 
        updateMessage.setSize(300, 50);
        updateMessage.setLocation(20,0);

        attributes.setSize(100, 250);
        attributes.setLocation(50, 50);

        symbol.setSize(300, 40);
        symbol.setLocation(150,100);
        symbol.setEnabled(false);

        name.setSize(300, 40);
        name.setLocation(150, 150);
        name.setEnabled(false);

        price.setSize(300, 40);
        price.setLocation(150, 200);

        prev.setSize(100,40);
        prev.setLocation(600, 100);
        prev.addActionListener(new prevBtn());

        next.setSize(100,40);
        next.setLocation(600, 200);
        next.addActionListener(new nextBtn());
    
        save.setSize(100,40);
        save.setLocation(600,150);
        save.addActionListener(new updatePrice());

        scroll.setSize(745,200);
        scroll.setLocation(50, 340);

        commandMessage.setSize(100,100);
        commandMessage.setLocation(50, 263);

        // add components to interface 
        add(updateMessage);
        add(attributes);
        add(symbol);
        add(name);
        add(price);
        add(prev);
        add(save);
        add(next);
        add(scroll);
        add(commandMessage);
     }

     /** 
     * This method allows the user to move through different options 
     * @param e used to move through different option
     */
     public void actionPerformed(ActionEvent e){
        String buttonString= e.getActionCommand();

        if(buttonString.equals("Buy")){
          Buy buy = new Buy();
          buy.setVisible(true);
          dispose();
        }else if(buttonString.equals("Sell")){
          Sell sell = new Sell();
          sell.setVisible(true);
          dispose();
        }else if(buttonString.equals("Update")){
           Update update = new Update();
           update.setVisible(true);
           dispose();
        }else if(buttonString.equals("getGain")){
           getGain getGain = new getGain();
           getGain.setVisible(true);
           dispose();
        }else if(buttonString.equals("Search")){
          Search search = new Search();
          search.setVisible(true);
          dispose();
           
        }else if(buttonString.equals("Quit")){
            System.exit(0);
        }
    }

    /**
     * This class is for the update button. It includes a method that implements the logic for the update button
     */
    private class updatePrice implements ActionListener {

       /**
        * This method implements the logic for the update button
        * @param e represents the action event
        */
       public void actionPerformed(ActionEvent e){
          String newInvestmentPrice = price.getText(); // holds price as string
          double newPriceInvest = 0; // holds price as double 

             try {
                newPriceInvest = Double.parseDouble(newInvestmentPrice); // set price as double 

                if(newPriceInvest > 0){

                  try {
                     ePortfolio.Investments.get(listIndex).setPrice(newPriceInvest);
                  } catch (Exception m) {
                     messages.setText(m.getMessage());
                  }
                  messages.setText(ePortfolio.Investments.get(listIndex).toString());
                }
                else{ // if price is less than or equal to 0
                  messages.setText("Price must Be greater or equal than 0");
                  return;  
                }
             } catch (NumberFormatException o) {
               messages.setText("Invalid Price");
             }

       }
    }

    /**
     * This class is used for the next button. It contains a method that implements the logic for the next button
     */
    private class nextBtn implements ActionListener{

       /**
        * This method implements the logic for the next button
        * @param e This represents the action event
        */
       public void actionPerformed(ActionEvent e){
         listIndex = listIndex + 1; // keeps track of index value 

         if(listIndex >= ePortfolio.Investments.size()-1){// prevents user from using next button if there are no more investments 

           listIndex = ePortfolio.Investments.size()-1;
           symbol.setText(ePortfolio.Investments.get(listIndex).getSymbol());
           name.setText(ePortfolio.Investments.get(listIndex).getName());
           next.setEnabled(false);
           prev.setEnabled(true);

         }
         else{ // otherwise user can use button to go to next investment
           symbol.setText(ePortfolio.Investments.get(listIndex).getSymbol());
           name.setText(ePortfolio.Investments.get(listIndex).getName());
           next.setEnabled(true);
           prev.setEnabled(true);
         }
       }
   }

   /**
    * This class is used for the previous button. It includes a method that implements the logic for the previous button
    * @param e This represents the action event
    */
   private class prevBtn implements ActionListener {
      public void actionPerformed(ActionEvent e) {

         listIndex = listIndex - 1;

         if(listIndex <= 0){ // prevents user from using previous button if there are no more  investments to go back to

           listIndex = 0;
           symbol.setText(ePortfolio.Investments.get(listIndex).getSymbol());
           name.setText(ePortfolio.Investments.get(listIndex).getName());
           prev.setEnabled(false);
           next.setEnabled(true);

         }else{ // otherwise use button to go back to previous investment 

           symbol.setText(ePortfolio.Investments.get(listIndex).getSymbol());
           name.setText(ePortfolio.Investments.get(listIndex).getName());
           prev.setEnabled(true);
           next.setEnabled(true);

         } 
      }
   }
} 