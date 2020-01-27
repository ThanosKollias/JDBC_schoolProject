package utils;

import com.sun.corba.se.impl.io.TypeMismatchException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @author Mr.Celosia
 */
public class JDBCutils {

    Connection con;

    public JDBCutils(Connection con) {
        this.con = con;
    }

    public static void insertIntoStudent() {
        PreparedStatement pst = null;

        String query = " INSERT INTO students(id, first_name, last_name, date_of_birth, tuition_fees) VALUES (?,?,?,?,?)";

        Scanner sc = new Scanner(System.in);

        System.out.println("Student ID :");
        int stid = GeneralUTILS.askForInt();

        System.out.println("Student name :");
        String stname = sc.next();

        System.out.println("Student surname :");
        String stsurname = sc.next();

        System.out.println("Student date of birth (YYYY/MM/DD) :");
        String stDOB = sc.next();

        System.out.println("Student tuition fees :");
        double tuitions = GeneralUTILS.askForDouble();

        try {
            pst = JDBConnection.con.prepareStatement(query);
            pst.setInt(1, stid);
            pst.setString(2, stname);
            pst.setString(3, stsurname);
            pst.setString(4, stDOB);
            pst.setDouble(5, tuitions);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCutils.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void insertIntoCourses() {
        PreparedStatement pst = null;

        String query = "INSERT INTO courses (id, title, stream, type_of_course, start_date, end_date) VALUES (?,?,?,?,?,?)";

        Scanner sc = new Scanner(System.in);
        System.out.print("Course ID :");
        int cID = GeneralUTILS.askForInt();

        System.out.print("Course title :");
        String cTitle = sc.next();
        System.out.print("Course stream :");
        String cStream = sc.next();
        System.out.print("Course type (FULL/PART) :");
        String cType = sc.next();
        System.out.print("Course Start Date (YYYY/MM/DD) : ");
        String cStartDate = sc.next();
        System.out.print("Course End Date (YYYY/MM/DD) : ");
        String cEndDate = sc.next();

        try {
            pst = JDBConnection.con.prepareStatement(query);
            pst.setInt(1, cID);
            pst.setString(2, cTitle);
            pst.setString(3, cStream);
            pst.setString(4, cType);
            pst.setString(5, cStartDate);
            pst.setString(6, cEndDate);
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(JDBCutils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void insertIntoTrainers() {
        PreparedStatement pst = null;
        String query = "INSERT INTO trainers(id, first_name, last_name, trainer_subject) VALUES (?,?,?,?)";

        Scanner sc = new Scanner(System.in);
        System.out.print("Trainer ID :");
        int trID = GeneralUTILS.askForInt();
        System.out.print("Trainer name :");
        String trName = sc.next();
        System.out.print("Trainer surname :");
        String trSurname = sc.next();
        System.out.print("Trainer subject :");
        String trSubject = sc.next();

        try {
            pst = JDBConnection.con.prepareStatement(query);
            pst.setInt(1, trID);
            pst.setString(2, trName);
            pst.setString(3, trSurname);
            pst.setString(4, trSubject);
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(JDBCutils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void insertIntoAssignment() {
        PreparedStatement pst = null;
        String query = "INSERT INTO assignments(id, tittle, as_description, submission, oral_mark, total_mark) VALUES (?,?,?,?,?,?)";
        Scanner sc = new Scanner(System.in);
        System.out.print("Assignment ID :");
        int assID = GeneralUTILS.askForInt();
        System.out.print("Assignment title :");
        String assTitle = sc.next();
        System.out.print("Assignment description :");
        String assDescr = sc.next();
        System.out.print("Assignment submit date (YYYY/MM/DD) :");
        String assSubmition = sc.next();
        System.out.print("Assignment Oral Mark :");
        double assOralMark = GeneralUTILS.askForDouble();
        System.out.print("Assignment Total Mark :");
        double assTotalMark = GeneralUTILS.askForDouble();

        try {
            pst = JDBConnection.con.prepareStatement(query);
            pst.setInt(1, assID);
            pst.setString(2, assTitle);
            pst.setString(3, assDescr);
            pst.setString(4, assSubmition);
            pst.setDouble(5, assOralMark);
            pst.setDouble(6, assTotalMark);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCutils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void insertIntoSPC() {
        String query = "INSERT INTO s_p_c (s_id, c_id) values (?,?)";
        PreparedStatement pst = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("Student's ID :");
        int sid = GeneralUTILS.askForInt();
        System.out.print("Course's ID :");
        int tid = GeneralUTILS.askForInt();

        try {
            pst = JDBConnection.con.prepareStatement(query);
            pst.setInt(1, sid);
            pst.setInt(2, tid);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCutils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void insertIntoAPC() {
        String query = "insert into a_p_c (a_id, c_id) values (?,?)";
        PreparedStatement pst = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("Assignment's ID :");
        int aid = GeneralUTILS.askForInt();
        System.out.print("Course's ID :");
        int cid = GeneralUTILS.askForInt();

        try {
            pst = JDBConnection.con.prepareStatement(query);
            pst.setInt(1, aid);
            pst.setInt(2, cid);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCutils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void insertIntoTPC() {
        String query = "insert into t_p_c (t_id, c_id) VALUES (?,?)";
        PreparedStatement pst = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("Trainer's ID :");
        int tid = GeneralUTILS.askForInt();
        System.out.print("Course's ID :");
        int cid = GeneralUTILS.askForInt();

        try {
            pst = JDBConnection.con.prepareStatement(query);
            pst.setInt(1, tid);
            pst.setInt(2, cid);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCutils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void insertIntoAPSPC() {
        String query = "insert into a_p_c_p_s(a1_id, c3_id, s1_id) values (?,?,?)";
        PreparedStatement pst = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("Assignment's ID :");
        int aid = GeneralUTILS.askForInt();
        System.out.print("Course's ID :");
        int cid = GeneralUTILS.askForInt();
        System.out.print("Student's ID :");
        int sid = GeneralUTILS.askForInt();

        try {
            pst = JDBConnection.con.prepareStatement(query);
            pst.setInt(1, aid);
            pst.setInt(2, cid);
            pst.setInt(3, sid);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCutils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void printStudents() {
        Statement st = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        String query = "select * from students";
        try {
            st = JDBConnection.con.createStatement();
            rst = st.executeQuery(query);
            while (rst.next()) {
                int id = rst.getInt(1);
                String name = rst.getString(2);
                String surname = rst.getString(3);
                String dob = rst.getString(4);
                double tuition = rst.getDouble(5);
                System.out.println(id + " " + name + " " + surname + " " + dob + " " + tuition);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCutils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void printTrainers() {
        Statement st = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        String query = "select * from trainers";
        try {
            st = JDBConnection.con.createStatement();
            rst = st.executeQuery(query);
            while (rst.next()) {
                int id = rst.getInt(1);
                String name = rst.getString(2);
                String surname = rst.getString(3);
                String sub = rst.getString(4);

                System.out.println(id + " " + name + " " + surname + " " + sub);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCutils.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void printCourses() {
        Statement st = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        String query = "select * from courses";
        try {
            st = JDBConnection.con.createStatement();
            rst = st.executeQuery(query);
            while (rst.next()) {
                int id = rst.getInt(1);
                String title = rst.getString(2);
                String stream = rst.getString(3);
                String toc = rst.getString(4);
                String sdate = rst.getString(5);
                String edate = rst.getString(6);

                System.out.println(id + " " + title + " " + stream + " " + toc + " " + sdate + " " + edate);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCutils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void printAssignments() {
        Statement st = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        String query = "select * from assignments";
        try {
            st = JDBConnection.con.createStatement();
            rst = st.executeQuery(query);
            while (rst.next()) {
                int id = rst.getInt(1);
                String title = rst.getString(2);
                String descr = rst.getString(3);
                String sub = rst.getString(4);
                double ormark = rst.getDouble(5);
                double totalmark = rst.getDouble(6);

                System.out.println("ASSIGNMENT ID: " +id + " " + title + " " + descr + " " + sub + " " + ormark + " " + totalmark);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCutils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void printSPC() {
        String query = "SELECT a.first_name,a.last_name,b.stream as COURSE from students a inner join s_p_c on a.id=s_p_c.s_id inner join courses b on s_p_c.c_id=b.id";
        Statement st = null;
        PreparedStatement pst = null;
        ResultSet rst = null;

        try {
            st = JDBConnection.con.createStatement();
            rst = st.executeQuery(query);
            while (rst.next()) {

                String name = rst.getString(1);
                String lastname = rst.getString(2);
                String course = rst.getString(3);

                System.out.println(name + " " + lastname + " " + course);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCutils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void printTPC() {
        String query = "SELECT t.first_name,t.last_name,b.stream from trainers t inner join t_p_c on t.id=t_p_c.t_id inner join courses b on t_p_c.c_id=b.id";
        Statement st = null;
        PreparedStatement pst = null;
        ResultSet rst = null;

        try {
            st = JDBConnection.con.createStatement();
            rst = st.executeQuery(query);
            while (rst.next()) {

                String name = rst.getString(1);
                String lastname = rst.getString(2);
                String stream = rst.getString(3);
                System.out.println("this is the list with all trainers per course :");
                System.out.println(" TRAINER :"+name + " " + lastname + " " + " COURSE :"+ stream);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCutils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void printAPC() {
        String query = "SELECT a.tittle,a.oral_mark,a.total_mark, b.stream as COURSE from assignments a inner join a_p_c on a.id=a_p_c.a_id \n"
                + "inner join \n"
                + "courses b on a_p_c.c_id=b.id;";
        Statement st = null;
        PreparedStatement pst = null;
        ResultSet rst = null;

        try {
            st = JDBConnection.con.createStatement();
            rst = st.executeQuery(query);
            while (rst.next()) {

                String title = rst.getString(1);
                double omark = rst.getDouble(2);
                double tmark = rst.getDouble(3);
                String course = rst.getString(4);
                System.out.println("this is the list with all the assignents per course :");

                System.out.println("ASSIGNMENR :" + " " +title + " " + omark + " " + tmark + " " + "COURSE :"+ course);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCutils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void printAPSPC() {
        String query = "use school;\n"
                + "SELECT s.first_name, s.last_name,c.title AS COURSE_TITLE,a.tittle AS ASSIGNMENT\n"
                + " \n"
                + " FROM ((students s INNER JOIN a_p_c_p_s w  ON s.id = w.s1_id)\n"
                + "  INNER JOIN courses c ON c.id = w.c3_id)\n"
                + "\n"
                + " INNER JOIN assignments a ON a.id = w.a1_id;";
        Statement st = null;
        PreparedStatement pst = null;
        ResultSet rst = null;

        try {
            st = JDBConnection.con.createStatement();
            rst = st.executeQuery(query);
            while (rst.next()) {

                String name = rst.getString(1);
                String lname = rst.getString(2);
                String course = rst.getString(3);
                String ass = rst.getString(4);
                System.out.println("this is the list with all assignments per student per course :");

                System.out.println("STUDENT :" + name + " " + lname + " " + "COURSE : "+ course + " " + "ASSIGNMENT :" + ass);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCutils.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void printStudentsWmorethanone() {
        String query = "select a.first_name, a.last_name, count(s_id) as NUMBER_OF_COURSES  from students a inner join s_p_c on a.id=s_p_c.s_id group by s_id having count(*)>1;";
        Statement st = null;
        PreparedStatement pst = null;
        ResultSet rst = null;

        try {
            st = JDBConnection.con.createStatement();
            rst = st.executeQuery(query);
            while (rst.next()) {

                String name = rst.getString(1);
                String lname = rst.getString(2);
                String course = rst.getString(3);
                System.out.println("students with more than 1 courses are the following :");

                System.out.println("STUDENT :" +name + " " + lname + " " +" with "+ course + " courses ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCutils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void printAllSPC() {
        String query = "SELECT a.id AS STUDENT_ID ,a.first_name,a.last_name,b.id AS COURSE_ID, b.stream as COURSES from students a inner join s_p_c on a.id=s_p_c.s_id inner join \n"
                + "courses b on s_p_c.c_id=b.id;";
        Statement st = null;
        PreparedStatement pst = null;
        ResultSet rst = null;

        try {
            st = JDBConnection.con.createStatement();
            rst = st.executeQuery(query);
            while (rst.next()) {

                int id = rst.getInt(1);
                String name = rst.getString(2);
                String lname = rst.getString(3);
                int cid = rst.getInt(4);
                String course = rst.getString(5);

                System.out.println("STUDENTS ID :" + " " + id + " " + name + " " + lname + "\n " + "COURSE ID" + " " + cid + " " + course);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCutils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void printAllTPC() {
        String query = "SELECT t.id AS TRAINER_ID, t.first_name,t.last_name, b.id AS COURSE_ID, b.stream from trainers t inner join t_p_c on t.id=t_p_c.t_id inner join courses b on t_p_c.c_id=b.id;";
        Statement st = null;
        PreparedStatement pst = null;
        ResultSet rst = null;

        try {
            st = JDBConnection.con.createStatement();
            rst = st.executeQuery(query);
            while (rst.next()) {

                int id = rst.getInt(1);
                String name = rst.getString(2);
                String lname = rst.getString(3);
                int cid = rst.getInt(4);
                String course = rst.getString(4);

                System.out.println("TRAINER ID :" + id + " " + name + " " + lname + "\n " + "COURSE ID :" + cid + " " + course);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCutils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void printAllAPC() {
        String query = "SELECT A.ID AS ASSIGNMENTS_ID, a.tittle,a.oral_mark,a.total_mark,B.ID AS COURSE_ID, b.stream as COURSE from assignments a inner join a_p_c on a.id=a_p_c.a_id \n"
                + "inner join \n"
                + "courses b on a_p_c.c_id=b.id;";
        Statement st = null;
        PreparedStatement pst = null;
        ResultSet rst = null;

        try {
            st = JDBConnection.con.createStatement();
            rst = st.executeQuery(query);
            while (rst.next()) {

                int id = rst.getInt(1);
                String title = rst.getString(2);
                double omark = rst.getDouble(3);
                double tmark = rst.getDouble(4);
                int cid = rst.getInt(5);
                String course = rst.getString(6);

                System.out.println("ASSIGNMENT ID:" + id + " " + title + " " + omark + " " + tmark + " \n" + "COURSE ID:" + cid + " " + course);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCutils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
