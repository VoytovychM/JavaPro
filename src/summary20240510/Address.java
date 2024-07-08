package summary20240510;

import java.io.Serializable;
import java.util.Objects;

public class Address implements Serializable {

    private String country;

    private String city;

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Address address = (Address) object;
        return Objects.equals(country, address.country) && Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city);
    }
}