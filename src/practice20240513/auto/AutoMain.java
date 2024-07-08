package practice20240513.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AutoMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Path path = Paths.get("vasya.dat");
        try (ObjectOutputStream oos = new ObjectOutputStream(
                Files.newOutputStream(path))) {
            Person person = new Person("Вася", "Пупкин",
                    new Address(7, "НашГород", "Бассейная") //auto
            );
            oos.writeObject(person);
        }

        // десериализация
        try (ObjectInputStream ois = new ObjectInputStream(
                Files.newInputStream(path))) {
            Person read = (Person) ois.readObject();
            System.out.printf("Read person: %s", read);
        }
    }
}

