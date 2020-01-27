

package individualproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import usercontrol.MrCelosia;
import utils.GeneralUTILS;
import utils.JDBConnection;
import utils.JDBCutils;

/*
 * @author Mr.Celosia
 */
public class IndividualProject {

    
    public static void main(String[] args) {
    Connection con =   JDBConnection.createConection();
    MrCelosia.lets_Get_Started(con);
    

}
}