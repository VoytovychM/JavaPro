package lesson20240320.cards.house;

import java.util.Comparator;

public class House {
    int area;
    int price;
    String city;
    boolean hasFurniture;

    public House(int area, int price, String city, boolean hasFurniture) {
        this.area = area;
        this.price = price;
        this.city = city;
        this.hasFurniture = hasFurniture;
    }

    @Override
    public String toString() {
        return "House{" +
                "area=" + area +
                ", price=" + price +
                ", city='" + city + '\'' +
                ", hasFurniture=" + hasFurniture +
                '}';
    }

    public int getArea() {
        return area;
    }

    public int getPrice() {
        return price;
    }

    public String getCity() {
        return city;
    }

    public boolean isHasFurniture() {
        return hasFurniture;
    }

    static class CityPriceComparator implements Comparator<House>{

        @Override
        public int compare(House house1, House house2) {
            int cityComparison = house1.getCity().compareTo(house2.getCity());
            if (cityComparison != 0) {
                return cityComparison;
            } else {
                return Integer.compare(house1.getPrice(), house2.getPrice());
            }
        }
    }
    static class CityAreaComparator implements Comparator<House> {
        public int compare(House house1, House house2) {
            int cityComparison = house1.getCity().compareTo(house2.getCity());
            if (cityComparison != 0) {
                return cityComparison;
            } else {
                return Double.compare(house1.getArea(), house2.getArea());
            }
        }
    }

}
