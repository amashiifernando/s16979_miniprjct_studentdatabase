import java.sql.*;

public class CheckConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/student_database";
        String user = "root";
        String password = "DB_password";


        try {
            // 1. Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Create a connection
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Database Connected Successfully!");

            con.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
