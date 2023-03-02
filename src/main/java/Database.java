import java.sql.*;
import java.util.ArrayList;

public class Database {

    private ArrayList<Supplier> suppliers = new ArrayList<>();

    public Connection connectionSQL() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/coffee_db", "root", "password");
    }

    public void getCoffeeNames() {
        try (Connection connection = connectionSQL()) {
            String sql = "SELECT cof_name FROM coffees";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("cof_name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getCoffeesAboveNine() {
        try (Connection connection = connectionSQL()) {
            String sql = "SELECT cof_name, price FROM coffees WHERE price >= ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,9);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getDouble(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createSuppliers() {
        try (Connection connection = connectionSQL()) {
            String sql = "SELECT street, zip, city, state FROM suppliers";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Supplier supplier = new Supplier(resultSet.getString(1),
                        resultSet.getInt(2),
                        resultSet.getString(3),
                        resultSet.getString(4));
                suppliers.add(supplier);

                /*System.out.println(resultSet.getString(1) + ", " +
                        resultSet.getInt(2) + ", " +
                        resultSet.getString(3) + ", " +
                        resultSet.getString(4));*/
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Supplier> getSuppliers() {
        return suppliers;
    }



}
