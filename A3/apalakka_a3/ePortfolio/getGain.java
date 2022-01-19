package ePortfolio;
import javax.swing.*;

import java.awt.event.*;
import java.text.DecimalFormat;

/**
     * getGain file for getGain option 
     * @author Arvind palakkal
     * 
     */

public class getGain extends JFrame implements ActionListener{

    JLabel gainMessage = new JLabel("<html><span style='font-size:15px;color:black;'>"+"Getting total gain"+"</span></html>");
    JLabel totalGain =  new JLabel("<html><span style='font-size:15px;color:black;'>"+"Total gain"+"</span></html>");
    JTextField gain = new JTextField();
    JLabel commandMessage = new JLabel("<html><span style='font-size:15px;color:black;'>"+"Individual Gains"+"</span></html>");
    JTextArea messages = new JTextArea();
    JScrollPane text = new JScrollPane(messages);
    DecimalFormat df = new DecimalFormat("#.00");
    JMenuBar menuBar = new JMenuBar();
    JMenu commands = new JMenu("Commands");
    JMenuItem buy = new JMenuItem("Buy");
    JMenuItem sell = new JMenuItem("Sell");
    JMenuItem update = new JMenuItem("Update");
    JMenuItem getGain = new JMenuItem("getGain");
    JMenuItem search = new JMenuItem("Search");
    JMenuItem quit = new JMenuItem("Quit");
  

    /**
     * The constructor is used to generate the user interface for getGain
     */
    public getGain() {
        super("ePortfolio");
        getGainWindow();
        getGains();
    }

    /**
     * This method is used to create the user interface for getGain
     */
    private void getGainWindow(){ // create interface for get gain 
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

        // position components of interface 
        gainMessage.setSize(300, 50);
        gainMessage.setLocation(20,0);

        totalGain.setSize(200, 250);
        totalGain.setLocation(50, 50);

        gain.setSize(300,50);
        gain.setLocation(190, 150);
        gain.setEnabled(false);
       
        text.setSize(745,200);
        text.setLocation(50, 320);

        commandMessage.setSize(150,100);
        commandMessage.setLocation(50, 240);

        // add components to interface
        add(gainMessage);
        add(totalGain);
        add(gain);
        add(text);
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
     * Method is used to calculate the gain for stocks and mutual funds 
     */
    public void getGains(){
      double totalStockGain = 0; // holds the total gain from the stock
      double totalMutualGain = 0; // holds the total gain from the mutual fund
      double totalGain = 0;

      if(ePortfolio.Investments.size() == 0){ // if size of arraylist is 0 print message 
        messages.setText("ArrayList is empty cannot calculate gain");
        return;
      }

      for(int i = 0; i < ePortfolio.Investments.size(); i++){
        if (ePortfolio.Investments.get(i).equals(new Stock(ePortfolio.Investments.get(i).getSymbol(), " ", 0, 0, 0))){ // if investment is stock calculate gain of the stock

          Stock gainStock =  (Stock)ePortfolio.Investments.get(i); // stock object 
          totalStockGain = totalStockGain + gainStock.getGainStock(gainStock); // holds total gain for stock

          messages.append("Gain for " + gainStock.getSymbol() + ": " + totalStockGain + "\n"); // print gain for stock
        }
        else{ // if investment is a mutual fund calcuate gain for stock

          MutualFund gainMutual =  (MutualFund)ePortfolio.Investments.get(i); // mutual fund object 
          totalMutualGain = totalMutualGain + gainMutual.getGainMutual(gainMutual); // calculate gain for mutual fund

          messages.append("Gain for " + gainMutual.getSymbol() + ": " + totalMutualGain + "\n"); // print gain for mutual fund
        }
      }

      totalGain = totalMutualGain + totalStockGain;
      gain.setText("" + totalGain); // print total gain

    }
}