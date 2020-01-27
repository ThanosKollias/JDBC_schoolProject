

package usercontrol;

import java.sql.*;
import java.util.Scanner;
import utils.GeneralUTILS;
import utils.JDBConnection;
import utils.JDBCutils;

/*
 * @author Mr.Celosia
 */
public class MrCelosia {

    public static void lets_Get_Started(Connection con){
       Scanner sc = new Scanner(System.in);
       int first;
       boolean first1 = true;
       
       do{
        System.out.println("PRESS :");
        System.out.println("[1]-Registration");
        System.out.println("[2]-SHOW INFO");
        System.out.println("[0]-EXIT");
        System.out.print("-> :");
        first=GeneralUTILS.askForInt();
        switch(first){
            case 1:
                boolean bool=true;
                do{
                System.out.println("REGISTRATION MENU");
                System.out.println("PRESS:");
                System.out.println("[1]-INSERT STUDENT");
                System.out.println("[2]-INSERT ASSIGNMENT");
                System.out.println("[3]-INSERT TRAINER");
                System.out.println("[4]-INSERT COURSE");
                System.out.println("[5]-INSERT STUDENT TO A COURSE");
                System.out.println("[6]-INSERT TRAINER TO A COURSE");
                System.out.println("[7]-INSERT ASSIGNMENT TO A COURSE");
                System.out.println("[8]-INSERT ASSIGNMENT TO A STUDENT TO A COURSE");
                System.out.println("[0]-EXIT");
                System.out.print("-> :");
                int choice = GeneralUTILS.askForInt();
                switch (choice){
                    case 1:
                        JDBCutils.insertIntoStudent();
                        System.out.println("");
                        
                        break;
                    case 2:
                        JDBCutils.insertIntoAssignment();
                        System.out.println("");
                        break;
                    case 3:
                        JDBCutils.insertIntoTrainers();
                        System.out.println("");
                        break;
                    case 4:
                        JDBCutils.insertIntoCourses();
                        System.out.println(" ");
                        break;
                    case 5:
                        JDBCutils.printStudents();
                        JDBCutils.printCourses();
                        JDBCutils.insertIntoSPC();
                        System.out.println("");
                        break;
                    case 6:
                        JDBCutils.printTrainers();
                        JDBCutils.printCourses();
                        JDBCutils.insertIntoTPC();
                        System.out.println("");
                        break;
                    case 7:
                        JDBCutils.printAssignments();
                        System.out.println(" *** ");
                        JDBCutils.printCourses();
                        System.out.println(" *** ");
                        JDBCutils.insertIntoAPC();
                        System.out.println("");
                        break;
                    case 8:
                        JDBCutils.printAssignments();
                        System.out.println(" *** ");
                        JDBCutils.printStudents();
                        System.out.println(" *** ");
                        JDBCutils.printCourses();
                        System.out.println(" *** ");
                        System.out.println("");
                        JDBCutils.insertIntoAPSPC();
                    case 0:
                        System.out.println(" back to menu...");
                        System.out.println("");
                        bool =false;
                        break;
                    default :
                        System.out.println(" invalid option");
                        System.out.println("");
                        break;
                }
                }while(bool);
                break;
            case 2:
                boolean bool1 = true;
            do{
                System.out.println("INFORMATION SYSTEM");
                System.out.println("PRES :");
                System.out.println("[1]ALL STUDENTS");
                System.out.println("[2]ALL COURSES");
                System.out.println("[3]ALL TRAINERS");
                System.out.println("[4]ALL ASSIGNMENTS");
                System.out.println("[5]ALL STUDENTS PER COURSE");
                System.out.println("[6]ALL TRAINERS PER COURSE");
                System.out.println("[7]ALL ASSIGNMENTS PER COURSE");
                System.out.println("[8]ALL ASSIGNMENTS PER STUDENT");
                System.out.println("[9]STUDENTS WITH MORE THAN ONE COURSES");
                System.out.println("[0]Back to menu");
                System.out.print("-> :");
                int choice = sc.nextInt();
                switch (choice){
                    case 1:
                        JDBCutils.printStudents();
                        System.out.println("");
                        break;
                    case 2:
                        JDBCutils.printCourses();
                        System.out.println("");
                        break;
                    case 3:
                        JDBCutils.printTrainers();
                        System.out.println("");
                        break;
                    case 4:
                        JDBCutils.printAssignments();
                        System.out.println("");
                        break;
                    case 5:
                        JDBCutils.printSPC();
                        System.out.println("");
                        break;
                    case 6:
                        JDBCutils.printTPC();
                        System.out.println("");
                        break;
                    case 7:
                        JDBCutils.printAPC();
                        System.out.println("");
                        break;
                    case 8:
                        JDBCutils.printAPSPC();
                        System.out.println("");
                        break;                        
                    case 9:
                        JDBCutils.printStudentsWmorethanone();
                        System.out.println("");
                        break;
                    case 0:
                        System.out.println("back to menu");
                        System.out.println("");
                        bool1=false;
                        break;
                        
                    default:
                        System.out.println("invalid option");
                        System.out.println("");
                         break;   
                }
            }while(bool1);
                break;
          
            case 0:
                System.out.println("Exit...");
                System.out.println("");
                first1=false;
                break;
            default :
                System.out.println("invalid");
                System.out.println("");
                break;
        }
    }while(first1);
        
    }
}

