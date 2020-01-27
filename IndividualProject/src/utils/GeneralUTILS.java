package utils;

import java.util.Scanner;
import sun.net.www.content.audio.x_aiff;

/*
 * @author Mr.Celosia
 */
public class GeneralUTILS {

    public static boolean isDouble(String str) {
        try {
            // check if it can be parsed as any double
            double x = Double.parseDouble(str);
            // check if the double can be converted without loss to an int
            if (x == (int) x) // if yes, this is an int, thus return false
            {
                return true;
            }
            // otherwise, this cannot be converted to an int (e.g. "1.2")
            return true;
            // short version: return x != (int) x;
        } catch (NumberFormatException e) {
            return false;
        }

    }
    
    

    public static int askForInt() {
        Scanner sc = new Scanner(System.in);
        int x = 0;
        boolean y = true;

        while(y){
        
            String z = sc.nextLine();
            if (z.matches("^\\d+(\\.\\d+)?$")) {
                x = Integer.parseInt(z);
                y = false;
                return x;
            } else {
                System.out.println("invalid option");
                System.out.println("Try again. Please type only digits");
            }
    
        }
        return x;
    }
    
    
    
    public static double askForDouble() {
        Scanner sc = new Scanner(System.in);
        double x = 0;
        boolean y = true;

        while(y){
        
            String z = sc.nextLine();
            if (z.matches("^\\d+(\\.\\d+)?$")) {
                x = Double.parseDouble(z);
                y = false;
                return x;
            } else {
                System.out.println("invalid option");
                System.out.println("Try again. Please type only digits");
            }
    
        }
        return x;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
