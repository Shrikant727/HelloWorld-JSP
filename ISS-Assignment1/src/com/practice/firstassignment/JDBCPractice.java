/**
 * 
 */
package com.practice.firstassignment;

/**
 * @author Shrikant_Bhadgaonkar
 * 11.JDBC
 */
import java.sql.*;

public class JDBCPractice {
    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/zoo";
    private static final String USERNAME = "shrikant";
    private static final String PASSWORD = "Shrikant@123";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            createTable(connection);

            // Insert a new animal
            int newAnimalId = createAnimal(connection, "Leo", "Lion", 5);

            // Retrieve and display all animals
            displayAllAnimals(connection);

            // Update the age of the inserted animal
            updateAnimalAge(connection, newAnimalId, 6);

            // Retrieve and display all animals after the update
            displayAllAnimals(connection);

            // Delete the inserted animal
            deleteAnimal(connection, newAnimalId);

            // Retrieve and display all animals after the delete
            displayAllAnimals(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS animals (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(50)," +
                "species VARCHAR(50)," +
                "age INT)";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTableSQL);
        }
    }

    private static int createAnimal(Connection connection, String name, String species, int age) throws SQLException {
        String insertSQL = "INSERT INTO animals (name, species, age) VALUES (?, ?, ?)";
        int generatedId = -1;

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, species);
            preparedStatement.setInt(3, age);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                    if (resultSet.next()) {
                        generatedId = resultSet.getInt(1);
                    }
                }
            }
        }

        return generatedId;
    }

    private static void displayAllAnimals(Connection connection) throws SQLException {
        String selectSQL = "SELECT * FROM animals";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {

            System.out.println("All Animals in the Zoo:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String species = resultSet.getString("species");
                int age = resultSet.getInt("age");

                System.out.println("ID: " + id + ", Name: " + name + ", Species: " + species + ", Age: " + age);
            }
            System.out.println();
        }
    }

    private static void updateAnimalAge(Connection connection, int animalId, int newAge) throws SQLException {
        String updateSQL = "UPDATE animals SET age = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {
            preparedStatement.setInt(1, newAge);
            preparedStatement.setInt(2, animalId);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Animal with ID " + animalId + " age updated successfully.\n");
            } else {
                System.out.println("No such animal found with ID " + animalId + ". Update failed.\n");
            }
        }
    }

    private static void deleteAnimal(Connection connection, int animalId) throws SQLException {
        String deleteSQL = "DELETE FROM animals WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setInt(1, animalId);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Animal with ID " + animalId + " deleted successfully.\n");
            } else {
                System.out.println("No such animal found with ID " + animalId + ". Deletion failed.\n");
            }
        }
    }
}
