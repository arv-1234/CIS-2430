package ePortfolio;
import javax.swing.*;

//import ePortfolio.*;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;

/**
     * GUI file for Menu option 
     * @author Arvind palakkal
     * 
     */

public class Main extends JFrame implements ActionListener{
    JLabel welcome = new JLabel("<html><span style='font-size:16px;color:black;'>"+"Welcome to ePortfolio"+"</span></html>");
    JLabel welcomeDes = new JLabel("<html><span style='font-size:16px;color:black'>"+"Choose a command from the \"Commands\"menu to buy for sell an investment,update prices for all investments,getgain for the portfolio,search for relavant investments,or quit the program"+"</span></html>",SwingConstants.CENTER);
    JMenuBar menuBar = new JMenuBar();
    JMenu commands = new JMenu("Commands");
    JMenuItem buy = new JMenuItem("Buy");
    JMenuItem sell = new JMenuItem("Sell");
    JMenuItem update = new JMenuItem("Update");
    JMenuItem getGain = new JMenuItem("getGain");
    JMenuItem search = new JMenuItem("Search");
    JMenuItem quit = new JMenuItem("Quit");

    /**
     * Generates interface 
     */
    public Main(){
        super("ePortfolio");
        prepareGUI();
    }

    /**
     * creates starting interface
     */
    private void prepareGUI(){
        setSize(820, 595);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        
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

        welcomeDes.setSize(600, 300);
        welcomeDes.setLocation(100,100);

        welcome.setSize(1055, 50);
        welcome.setLocation(50,150);

        add(welcomeDes);
        add(welcome);

    }

    /**
     * Allows to move to different options 
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
     * This is the file for the menu. All the options that are present in this assignment are in this file 
     * @param args used for command line arguments I dont read or write files 
     */
    public static void main(String[] args) {
        Main layout = new Main();
        layout.setVisible(true);
     }
}
