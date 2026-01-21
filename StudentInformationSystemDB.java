import java.sql.*;
import java.util.Scanner;

public class StudentInformationSystemDB {

    static final String URL = "jdbc:mysql://localhost:3306/student_db";
    static final String USER = "root";
    static final String PASSWORD = "Satyam@1617";

    static Connection con;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to MySQL Database");

            int choice;
            do {
                System.out.println("\n1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Search Student");
                System.out.println("4. Update Student");
                System.out.println("5. Delete Student");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");

                choice = sc.nextInt();

                switch (choice) {
                    case 1: addStudent(); break;
                    case 2: viewStudents(); break;
                    case 3: searchStudent(); break;
                    case 4: updateStudent(); break;
                    case 5: deleteStudent(); break;
                    case 6: System.out.println("Exit"); break;
                    default: System.out.println("Invalid choice");
                }
            } while (choice != 6);

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void addStudent() throws SQLException {
        System.out.print("ID: ");
        int id = sc.nextInt(); sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Age: ");
        int age = sc.nextInt(); sc.nextLine();

        System.out.print("Grade: ");
        String grade = sc.nextLine();

        System.out.print("Contact: ");
        String contact = sc.nextLine();

        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO students VALUES (?, ?, ?, ?, ?)");
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setInt(3, age);
        ps.setString(4, grade);
        ps.setString(5, contact);

        ps.executeUpdate();
        System.out.println("Student added");
    }

    static void viewStudents() throws SQLException {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM students");

        while (rs.next()) {
            System.out.println(
                rs.getInt(1) + " " +
                rs.getString(2) + " " +
                rs.getInt(3) + " " +
                rs.getString(4) + " " +
                rs.getString(5)
            );
        }
    }

    static void searchStudent() throws SQLException {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM students WHERE student_id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next())
            System.out.println("Found: " + rs.getString("name"));
        else
            System.out.println("Not found");
    }

    static void updateStudent() throws SQLException {
        System.out.print("Enter ID: ");
        int id = sc.nextInt(); sc.nextLine();

        System.out.print("New Name: ");
        String name = sc.nextLine();

        PreparedStatement ps = con.prepareStatement(
                "UPDATE students SET name=? WHERE student_id=?");
        ps.setString(1, name);
        ps.setInt(2, id);
        ps.executeUpdate();
        System.out.println("Updated");
    }

    static void deleteStudent() throws SQLException {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        PreparedStatement ps = con.prepareStatement(
                "DELETE FROM students WHERE student_id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
        System.out.println("Deleted");
    }
}
