import java.sql.*;
import java.util.Scanner;

public class Insert {
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/student_database";
        String user = "root";
        String password = "DB_password";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connected to database!");


            String sql1 = "INSERT INTO students (name, GPA, Department, age) VALUES "
                    + "('Venura', 3.5,'Physics',21), "
                    + "('Keron', 2.8,'Chemistry',22), "
                    + "('Hiruni', 3.1,'Statistics',23), "
                    + "('Dulashi', 3.8,'Statistics',22)";
            try (Statement stmt = con.createStatement()) {
                int rows = stmt.executeUpdate(sql1);
                System.out.println(rows + " records inserted (predefined).");
            }


            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            System.out.print("Enter GPA: ");
            double gpa = scanner.nextDouble();
            scanner.nextLine(); 

            System.out.print("Enter Department: ");
            String dept = scanner.nextLine();

            System.out.print("Enter Age: ");
            int age = scanner.nextInt();

            String sql2 = "INSERT INTO students (name, GPA, Department, age) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = con.prepareStatement(sql2)) {
                pstmt.setString(1, name);
                pstmt.setDouble(2, gpa);
                pstmt.setString(3, dept);
                pstmt.setInt(4, age);

                int rows2 = pstmt.executeUpdate();
                System.out.println(rows2 + " student record inserted (from input).");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
