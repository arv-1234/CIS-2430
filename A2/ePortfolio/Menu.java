package ePortfolio;



import java.util.Scanner;


    /**
     * Menu file 
     * @author Arvind palakkal
     * 
     */
public class Menu {

    
    /** 
     * This is the file for the menu loop. All the options that are present in this assignment are in this file 
     * @param args used for command line arguments but we do not use them
     */
    public static void main(String[] args){
        ePortfolio ePortfolio = new ePortfolio(); 
        Scanner input = new Scanner(System.in);
        String option;
        int doLoop = 0;

        for(int i = 0; i<args.length; i++) {
            System.out.println("args[" + i + "]: " + args[i]);
         }

         if(args.length == 0){

         }

         ePortfolio.openFile(args[0]);
         
        do{
            System.out.println("\n----Menu----\n");
            System.out.println("(1) Buy");
            System.out.println("(2) Sell");
            System.out.println("(3) Update");
            System.out.println("(4) getGain");
            System.out.println("(5) Search");
            System.out.println("(6) Quit");
            System.out.println("------------");
            System.out.println();

            System.out.print("Enter menu option: ");
            option = input.nextLine();

            if(option.equalsIgnoreCase("s")){ // if user enters they will be reprompted since Sell and search start with s
                System.out.println();
                System.out.println("Since there are two options that start with S you must enter the full name of the option");
                System.out.println();
                continue;
            }

            if(option.equalsIgnoreCase("Buy") || option.equalsIgnoreCase("B")){ // the buy method is executed if the following option is picked 
                ePortfolio.Buy(input);
                String tempLine = input.nextLine();
            }
            if(option.equalsIgnoreCase("Sell")){ // the sell method is executed if the following option is picked 
                ePortfolio.sell(input);
                String tempLineTwo = input.nextLine();
            }
            if(option.equalsIgnoreCase("Update") || option.equalsIgnoreCase("U")){ // the update method is executed if the following option is picked 
                ePortfolio.update(input);
                String tempLineThree = input.nextLine();
            }
            if(option.equalsIgnoreCase("getGain") || option.equalsIgnoreCase("G")){ // the gain method is executed if the following option is picked 
                ePortfolio.getGain(input);
                String tempLineFour = input.nextLine();
            }
            if(option.equalsIgnoreCase("Search")){ // the search  method is executed if the following option is picked 
                ePortfolio.search(input);
            }
            if(option.equalsIgnoreCase("Quit") || option.equalsIgnoreCase("Q")){ // Will exit program
                System.out.println("Exiting program........");
                ePortfolio.saveFile(args[0]);
                doLoop = 1;
                break;
            }
            else{
                System.out.println("Invalid option type valid option");
            }
        }while(doLoop == 0);
    }
}
