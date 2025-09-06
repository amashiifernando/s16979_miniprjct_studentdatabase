import java.sql.*;
public class CreateTable {
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/student_database";
        String user = "root";
        String password = "DB_password";

        try(Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement()){

            String sql = "CREATE TABLE IF NOT EXISTS students (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(50)," + "GPA DECIMAL(3,2)," + "Department VARCHAR(50),"+
                    "age INT)";

            stmt.executeUpdate(sql);
            System.out.println("Table created successfully.");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

