
import java.sql.*;

public class Insert {
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/student_database";
        String user = "root";
        String password = "DB_password";

        try(Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement()){

            String sql = "INSERT INTO students (name, GPA,Department,age) VALUES "
                    + "('Venura', 3.5,'Physics',21), "
                    + "('Keron', 2.8,'Chemistry',22), "
                    + "('Hiruni', 3.1,'Statistics',23), "
                    + "('Dulashi', 3.8,'Statistics',22)";
            int rows= stmt.executeUpdate(sql);

            System.out.println(" "+rows+ "records inserted");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
