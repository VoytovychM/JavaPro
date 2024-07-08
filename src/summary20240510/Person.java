package summary20240510;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
    private String name;

    private String surname;

    private int age;

    private Address address;

    public Person(String name, String surname, int age, Address address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Person person = (Person) object;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(address, person.address);
    }


}
