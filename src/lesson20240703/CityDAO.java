package lesson20240703;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDAO implements WorldDAO<City, Integer> {

    private static final String GET_ALL = "SELECT * FROM city";
    private static final String GET_BY_ID = "SELECT * FROM city WHERE city.id = ?";
    private static final String SAVE_CITY = "INSERT INTO city (city.name, city.population, city.countrycode) VALUES (?, ?, ?)";
    private static final String DELETE_CITY = "DELETE FROM city WHERE city.id = ?";
    private static final String UPDATE_CITY = "UPDATE city SET city.name = ?, city.population = ?, city.countrycode = ? WHERE city.id = ?";
    private static final String FIND_CITY_WITH_POPULATION_MORE_THAN = "SELECT * FROM city WHERE city.population > ?";
    private static final String PRINT_DETAILED_INFO_BY_ID =
            "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population, " +
                    "country.Name as CountryName, country.Continent as Continent " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.Code " +
                    "WHERE city.ID = ?";


    private ConnectorDB connectorDB = new ConnectorDB();


    @Override
    public List<City> getAll() {
        List<City> cities = new ArrayList<>();
        try (
                Connection connection = connectorDB.makeConnection();
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(GET_ALL);
            while (resultSet.next()) {
                City city = getCityFromResultSet(resultSet);
                cities.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }

    private City getCityFromResultSet(ResultSet resultSet) throws SQLException {
        City city = new City();
        city.setId(resultSet.getInt("ID"));
        city.setName(resultSet.getString("Name"));
        city.setCountryCode(resultSet.getString("CountryCode"));
        city.setPopulation(resultSet.getInt("Population"));
        return city;
    }

    @Override
    public City getById(Integer id) {
        try (
                Connection connection = connectorDB.makeConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID);
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            City city = getCityFromResultSet(resultSet);
            return city;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(City city) {
        try (
                Connection connection = connectorDB.makeConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SAVE_CITY);
        ) {
            preparedStatement.setString(1, city.getName());
            preparedStatement.setInt(2, city.getPopulation());
            preparedStatement.setString(3, city.getCountryCode());
            int updated = preparedStatement.executeUpdate();
            System.out.println("Update successful: " + updated);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Integer id) {
        try (
                Connection connection = connectorDB.makeConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CITY);
        ) {
            preparedStatement.setInt(1, id);
            int deletedCity = preparedStatement.executeUpdate();
            System.out.println("Delete sucessfull: " + deletedCity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(City city) {
        try (
                Connection connection = connectorDB.makeConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CITY);

        ) {
            preparedStatement.setString(1, city.getName());
            preparedStatement.setInt(2, city.getPopulation());
            preparedStatement.setString(3, city.getCountryCode());
            preparedStatement.setInt(4, city.getId());
            int updatedCity = preparedStatement.executeUpdate();
            System.out.println("Update successful: " + updatedCity);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<City> findCitiesWithPopulationMoreThan(Integer population)  {
        List<City> cities = new ArrayList<>();
        try (
                Connection connection = connectorDB.makeConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(FIND_CITY_WITH_POPULATION_MORE_THAN);
        ) {
            preparedStatement.setInt(1, population);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                City city = getCityFromResultSet(resultSet);
                cities.add(city);
            }
            return cities;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    //printDetailedInfoById(Integer id), который напечатает всю информацию о городе с данным id,
    //а также информацию о стране города - имя страны и имя континента.
    
    public void printDetailedInfoById(Integer id) {

        try (
                Connection connection = connectorDB.makeConnection();
                PreparedStatement statement = connection.prepareStatement(PRINT_DETAILED_INFO_BY_ID);
        ) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String  cityName = resultSet.getString("Name");
                String countryCode = resultSet.getString("CountryCode");
                String district = resultSet.getString("District");
                int population = resultSet.getInt("Population");
                String countryName= resultSet.getString("CountryName");
                String continent = resultSet.getString("Continent");
               CityWithCountryAndContinent city = new CityWithCountryAndContinent()
               city.setId(ID);
               city.setName(cityName);
               city.setCountryCode(countryCode);
               city.setDistrict (district);
               city.setPopulation(population);
               city.setCountryName(countryName);
               city.setContinent(continent);
                System.out.println(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
}