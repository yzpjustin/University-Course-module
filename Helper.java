
package assignment2;
import java.util.Scanner;

/**
 * Helper class for Assignment 2, this class will provide basic helper methods 
 * @author      yin zhanpeng    
 * @version     1.0          (current version number of program)
 * Assignment 1
 * this program have functions that finds the coin value of the a person and display it, as well as 
 * providing a summary of all the coins in it 
 */

public class Helper {

    /**
     * constructor 
     */
    public Helper(){}
  
    /**
     * get integer
     * @param msg the display message
     * @return int 
     */
    public static int getInt(String msg){
            boolean carryOn = true;
            int n = 0;
            while(carryOn){
                System.out.println(msg);
                Scanner kb = new Scanner(System.in);
                if(kb.hasNextInt()){
                    n = kb.nextInt();
                    carryOn = false;
                }else{
                    System.out.println("please only enter integer ");
                }
            }
            return n;
        }

    /**
     * get string
     * @param msg the display message
     * @return string
     */
    public static String getString(String msg){
            System.out.println(msg);
            Scanner kb = new Scanner(System.in);
            String n = kb.nextLine();
            return n;
        }

    /**
     * print message in new line
     * @param msg message
     */
    public static void println(String msg){
            System.out.println(msg);
        }

    /**
     * print message
     * @param msg message
     */
    public static void print(String msg){
            System.out.print(msg);
        }


        /*
        public static void main (String[] args){
            // testing 
            int test = getInt("please enter the int ");
            System.out.println(test);
            String tests = getString("please enter the string");
            System.out.println(tests);
            println("testing println");
            print("testing print");
            System.out.println(ngativenum(-50)); 
            System.out.println(validateCoinInput(3));
            System.out.println(roundOffCoinValue(3));
            System.out.println(validateName("john tim"));
            String [] name = {"tim","john", "tom", "katty"};
            System.out.println(duplicateName("katty", name));
            
            
            
        }*/
    
}
