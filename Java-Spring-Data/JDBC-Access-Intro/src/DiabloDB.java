import java.sql.*;
import java.util.Scanner;

public class DiabloDB {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "12345");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the player username: ");
        String username = sc.nextLine();

        PreparedStatement useStatement = connection.prepareStatement("USE diablo");
        useStatement.execute();

        PreparedStatement selectStatement = connection.prepareStatement("SELECT u.user_name, u.first_name, u.last_name, COUNT(ug.user_id) AS count\n" +
                "FROM users As u\n" +
                "JOIN users_games ug on u.id = ug.user_id\n" +
                "WHERE u.user_name = ?\n" +
                "GROUP BY ug.user_id");

        selectStatement.setString(1, username);

        ResultSet resultSet = selectStatement.executeQuery();

        if (!resultSet.isBeforeFirst()) {
            System.out.println("No such user exists");
        } else {
            while (resultSet.next()) {
                System.out.printf("User: %s%n%s %s has played %d games",
                        resultSet.getString("user_name"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("count"));
            }
        }
    }
}
