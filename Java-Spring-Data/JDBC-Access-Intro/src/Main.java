import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "12345");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the salary: ");
        double salary = Double.parseDouble(sc.nextLine());

        PreparedStatement useStatement = connection.prepareStatement("USE soft_uni");
        useStatement.executeQuery();

        PreparedStatement selectEmployeesStmt = connection.prepareStatement("SELECT * FROM employees WHERE salary > ?");
        selectEmployeesStmt.setDouble(1, salary);

        ResultSet resultSet = selectEmployeesStmt.executeQuery();

        while (resultSet.next()) {
            System.out.printf("%s %s%n",
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"));
        }
    }
}
