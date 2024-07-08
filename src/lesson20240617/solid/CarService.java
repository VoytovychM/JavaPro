package lesson20240617.solid;

public interface CarService {

    default void service(Car car) {
        System.out.println("Default actions");
    }

}