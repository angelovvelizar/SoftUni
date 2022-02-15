import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;

public class Main {

    private static final String CONNECTION_PATH = "jdbc:mysql://localhost:3306/minions_db";
    private static Connection connection;
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws SQLException, IOException {

        connection = getConnection();

        System.out.println("Enter exercise number: ");
        int exNumber = Integer.parseInt(reader.readLine());
        switch (exNumber) {
            case 2:
                exerciseTwo();
                break;
            case 3:
                exerciseThree();
                break;
            case 4:
                exerciseFour();
                break;
            case 5:
                exerciseFive();
                break;
            case 6:
                exerciseSix();
                break;
            case 7:
                exerciseSeven();
                break;
            case 8:
                exerciseEight();
                break;
            case 9:
                exerciseNine();
                break;
        }
    }

    private static void exerciseSix() throws IOException, SQLException {
        System.out.println("Enter villain ID: ");
        int villainId = Integer.parseInt(reader.readLine());

        String villainName = "";
        try {
            villainName = getVillainNameById(villainId);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        String villainOutput = deleteVillain(villainName);
        System.out.println(villainOutput);

        String minionsOutput = deleteMinions(villainId);
        System.out.println(minionsOutput);
    }

    private static String deleteMinions(int villainId) throws SQLException {
        PreparedStatement deleteMinionsStatement = connection.prepareStatement("DELETE FROM minions_villains WHERE villain_id = ?");
        deleteMinionsStatement.setInt(1, villainId);
        int affectedRows = deleteMinionsStatement.executeUpdate();

        return String.format("%d minions released", affectedRows);

    }

    private static String deleteVillain(String villainName) throws SQLException {
        PreparedStatement deleteVillainStatement = connection.prepareStatement("DELETE FROM villains WHERE name = ?");
        deleteVillainStatement.setString(1, villainName);
        deleteVillainStatement.execute();
        return String.format("%s was deleted", villainName);
    }

    private static void exerciseEight() throws IOException, SQLException {
        System.out.println("Enter minions IDs: ");
        int[] minionsIds = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int minionsId : minionsIds) {
            incrementMinionAge(minionsId);
        }

        PreparedStatement selectMinions = connection.prepareStatement("SELECT name, age FROM minions;");
        ResultSet resultSet = selectMinions.executeQuery();

        while (resultSet.next()) {
            System.out.printf("%s %d%n", resultSet.getString(1), resultSet.getInt(2));
        }
    }

    private static void incrementMinionAge(int minionsId) throws SQLException {
        PreparedStatement incrementAgeStatement = connection.prepareStatement("UPDATE minions SET age = age + 1, name = LOWER(name) WHERE id = ?;");
        incrementAgeStatement.setInt(1, minionsId);
        incrementAgeStatement.execute();
    }

    private static void exerciseSeven() throws SQLException {
        PreparedStatement selectMinionsStatement = connection.prepareStatement("SELECT  DISTINCT name FROM minions;");
        ResultSet resultSet = selectMinionsStatement.executeQuery();

        ArrayDeque<String> minions = new ArrayDeque<>();
        while (resultSet.next()) {
            minions.add(resultSet.getString(1));
        }

        while (!minions.isEmpty()) {
            System.out.println(minions.removeFirst());
            if (!minions.isEmpty()) {
                System.out.println(minions.removeLast());
            }
        }


    }

    private static void exerciseNine() throws IOException, SQLException {
        System.out.println("Enter minion id: ");
        int id = Integer.parseInt(reader.readLine());

        CallableStatement callableStatement = connection.prepareCall("CALL usp_get_older(?)");
        callableStatement.setInt(1, id);

        callableStatement.executeUpdate();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT name, age FROM minions WHERE id = ?");
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        System.out.println(resultSet.getString(1));
        System.out.println(resultSet.getInt(2));

    }

    private static void exerciseFive() throws IOException, SQLException {
        System.out.println("Enter country: ");
        String countryName = reader.readLine();

        PreparedStatement updateTownsStatement = connection.prepareStatement("UPDATE towns SET name = UPPER(name) WHERE country = ?;");
        updateTownsStatement.setString(1, countryName);

        int affectedRows = updateTownsStatement.executeUpdate();

        if (affectedRows > 0) {
            String[] towns = getTowns(countryName, affectedRows);
            System.out.println(Arrays.toString(towns));
        } else {
            System.out.println("No town names were affected.");
        }

    }

    private static String[] getTowns(String countryName, int affectedRows) throws SQLException {
        System.out.println(affectedRows + " town names were affected.");
        PreparedStatement selectTownsStatement = connection.prepareStatement("SELECT name FROM towns WHERE country = ?;");
        selectTownsStatement.setString(1, countryName);
        ResultSet resultSet = selectTownsStatement.executeQuery();

        String[] towns = new String[affectedRows];
        int counter = 0;
        while (resultSet.next()) {
            towns[counter++] = resultSet.getString("name");
        }
        return towns;
    }

    private static void exerciseFour() throws IOException, SQLException {
        System.out.println("Enter minion information: ");
        System.out.print("Minion: ");

        String[] minionInfo = reader.readLine().split("\\s+");
        String minionName = minionInfo[0];
        int minionAge = Integer.parseInt(minionInfo[1]);
        insertMinion(minionName, minionAge);

        String townName = minionInfo[2];
        String townOutput = addTown(townName);

        System.out.println("Enter villain name: ");
        System.out.print("Villain: ");
        String villainName = reader.readLine();
        String villainOutput = addVillain(villainName);

        System.out.println(townOutput);
        System.out.println(villainOutput);

        System.out.println(addMinionToVillain(minionName, villainName));

    }

    private static String addMinionToVillain(String minionName, String villainName) throws SQLException {
        PreparedStatement addMinionToVillainStatement = connection.prepareStatement("INSERT INTO minions_villains\n" +
                "SELECT m.id, v.id FROM minions AS m\n" +
                "JOIN minions_villains mv on m.id = mv.minion_id\n" +
                "JOIN villains v on mv.villain_id = v.id\n" +
                "WHERE m.name = ? AND v.name = ?;");

        addMinionToVillainStatement.setString(1, minionName);
        addMinionToVillainStatement.setString(2, villainName);

        addMinionToVillainStatement.execute();

        return String.format("Successfully added %s to be minion of %s", minionName, villainName);
    }

    private static String addVillain(String villainName) throws SQLException {
        PreparedStatement selectVillainStatement = connection.prepareStatement("SELECT name FROM villains WHERE name = ?");
        selectVillainStatement.setString(1, villainName);
        ResultSet resultSet = selectVillainStatement.executeQuery();

        if (!resultSet.isBeforeFirst()) {
            PreparedStatement insertVillainStatement = connection.prepareStatement("INSERT INTO villains(name,evilness_factor)\n" +
                    "VALUES(?,?);");
            insertVillainStatement.setString(1, villainName);
            insertVillainStatement.setString(2, "evil");
            return String.format("Villain %s was added to the database.", villainName);
        }

        return "";
    }

    private static String addTown(String townName) throws SQLException {
        PreparedStatement selectTownStatement = connection.prepareStatement("SELECT name FROM towns WHERE name = ?;");
        selectTownStatement.setString(1, townName);
        ResultSet resultSet = selectTownStatement.executeQuery();

        if (!resultSet.isBeforeFirst()) {
            PreparedStatement insertTownStatement = connection.prepareStatement("INSERT INTO towns(name)\n" +
                    "VALUES(?);");
            insertTownStatement.setString(1, townName);
            insertTownStatement.execute();
            return String.format("Town %s was added to the database.", townName);
        }
        return "";
    }

    private static void insertMinion(String minionName, int minionAge) throws SQLException {
        PreparedStatement insertMinionStatement = connection.prepareStatement("INSERT INTO minions(name,age)\n" +
                "VALUES(?,?)");
        insertMinionStatement.setString(1, minionName);
        insertMinionStatement.setInt(2, minionAge);
        insertMinionStatement.execute();
    }

    private static void exerciseThree() throws IOException, SQLException {
        System.out.println("Enter villain id: ");
        int id = Integer.parseInt(reader.readLine());

        String villainName = getVillainNameById(id);
        System.out.println(villainName);

        List<Minion> minions = getMinions(id);
        printMinionsInfo(minions);
    }

    private static void printMinionsInfo(List<Minion> minions) {
        for (int i = 0; i < minions.size(); i++) {
            System.out.printf("%d. %s %d%n", i + 1, minions.get(i).getName(), minions.get(i).getAge());
        }
    }

    private static List<Minion> getMinions(int id) throws SQLException {
        PreparedStatement selectMinionsInfo = connection.prepareStatement("SELECT DISTINCT m.name, m.age FROM minions AS m\n" +
                "JOIN minions_villains mv on m.id = mv.minion_id\n" +
                "JOIN villains v on mv.villain_id = v.id\n" +
                "WHERE v.id = ?;");
        selectMinionsInfo.setInt(1, id);
        ResultSet resultSet = selectMinionsInfo.executeQuery();

        List<Minion> minions = new ArrayList<>();
        while (resultSet.next()) {
            Minion currentMinion = new Minion(resultSet.getString("m.name"), resultSet.getInt("m.age"));
            minions.add(currentMinion);
        }

        return minions;
    }

    private static String getVillainNameById(int id) throws SQLException {
        PreparedStatement selectVillainName = connection.prepareStatement("SELECT name FROM villains WHERE id = ?");
        selectVillainName.setInt(1, id);
        ResultSet resultSet = selectVillainName.executeQuery();

        if (!resultSet.isBeforeFirst()) {
            throw new IllegalArgumentException(String.format("No villain with ID %d exists in the database.", id));
        }

        resultSet.next();
        return String.format("Villain: %s", resultSet.getString("name"));
    }

    private static void exerciseTwo() throws SQLException {
        PreparedStatement selectVillainsStatement = connection.prepareStatement("SELECT v.name, COUNT(DISTINCT mv.minion_id) AS count FROM villains AS v\n" +
                "JOIN minions_villains mv on v.id = mv.villain_id\n" +
                "GROUP BY v.name\n" +
                "HAVING count > 15\n" +
                "ORDER BY count DESC;");

        ResultSet resultSet = selectVillainsStatement.executeQuery();

        while (resultSet.next()) {
            String villainName = resultSet.getString("name");
            int countOfMinions = resultSet.getInt("count");

            System.out.printf("%s %d%n", villainName, countOfMinions);
        }
    }

    private static Connection getConnection() throws SQLException {
        Properties properties = new Properties();

        //TODO check credentials and enter your password
        properties.setProperty("user", "root");
        properties.setProperty("password", "12345");
        return DriverManager.getConnection(CONNECTION_PATH, properties);
    }
}
