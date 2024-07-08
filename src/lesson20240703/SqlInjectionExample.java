package lesson20240703;

import java.sql.*;
import java.util.Scanner;

public class SqlInjectionExample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//      Class.forName("com.mysql.cj.jdbc.Driver");
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "Navuhodonosori4pPLa/K1!");
                Statement statement = connection.createStatement();
        ) {

            statement.setFetchSize(5);
            System.out.println("Enter city id..");
            Scanner scsnner = new Scanner (System.in);
            String id = scsnner.nextLine();
            ResultSet resultSet = statement.executeQuery("select city.name, city.population from city where city.id = " + id);//haker method
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getString(i) + ", ");
                }

                System.out.println("/n");
            }


        }
    }
}



