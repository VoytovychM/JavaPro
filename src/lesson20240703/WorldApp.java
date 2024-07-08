package lesson20240703;

import java.util.List;

public class WorldApp {

    private static void printCityDetails(City city) {
        System.out.println("ID: " + city.getId());
        System.out.println("Name: " + city.getName());
        System.out.println("Population: " + city.getPopulation());
        System.out.println("CountryCode: " + city.getCountryCode());
    }
    public static void main(String[] args) {
        CityDAO cityDAO = new CityDAO();

        City city = cityDAO.getById(1);
        System.out.println(city);

        City newCity = new City(231431, "Dream City", "USA", 1);
        cityDAO.save(newCity);

        List<City> cities = cityDAO.getAll();
        City addedCity = cities.stream().filter(cityInStream -> cityInStream.getName().equals("Dream City")).findFirst().get();
        cities.forEach(System.out::println);
        cityDAO.delete(addedCity.getId());

        List<City> citiesAfterDelete = cityDAO.getAll();
        System.out.println(citiesAfterDelete.size());
        City city2Update = cityDAO.getById(4079);
        city2Update.setPopulation(92021);
        cityDAO.update(city2Update);
        printCityDetails(city2Update);


        List<City> cityMoreThan = cityDAO.findCitiesWithPopulationMoreThan(1_000_000);
        cityMoreThan.forEach(System.out::println);

        cityDAO.printDetailedInfoById(4068);













    }



}