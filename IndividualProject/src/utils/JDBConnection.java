

package utils;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @author Mr.Celosia
 */
public class JDBConnection {


    public static Connection con = null;
    
    public static Connection createConection(){
     Scanner sc = new Scanner(System.in);
        System.out.println("LOGIN SYSTEM LOADING....");
        System.out.println("please type your  username and password that you use in your SQL editor (like workbench) ");
        System.out.println("");
        try {
            String MYSQLURL = "jdbc:mysql://localhost:3306/school?zeroDateTimeBehavior=CONVERT_TO_NULL"
                    + "&useUnicode=true"
                    + "&useJDBCCompliantTimezoneShift=true"
                    + "&useLegacyDatetimeCode=false"
                    + "&serverTimezone=UTC"
                    + "&allowPublicKeyRetrieval=true"
                    + "&useSSL=false";
            System.out.print("USERNAME:");
            String USERNAME = sc.nextLine();
            System.out.print("PASS:");
            String PASS = sc.nextLine();
            
         return  con = DriverManager.getConnection(MYSQLURL, USERNAME, PASS);
        } catch (SQLException ex) {
            Logger.getLogger(JDBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

