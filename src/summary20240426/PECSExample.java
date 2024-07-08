package summary20240426;

import java.util.Arrays;
import java.util.List;

public class PECSExample {
    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("A", "B", "C");
        List<Object> objectList = List.of(1, "Hello", 1.0);


        List<Object> objects = objectList;
//        objects = stringList;
        List<?> otherList = stringList;
        otherList = objectList;


        // Producer Extends Consumer Super (PECS)
        List<Tesla> teslas = List.of(new Tesla(), new Tesla());
        List<Car> cars = List.of(new BMW(), new Tesla(), new Mercedes());
        List<TeslaModification> teslaModificationCars = List.of(new TeslaModification());

        List<? extends Car> list; // Producer Extends
        list = cars;
        list = teslas;

        Car car = list.get(0);
//        list.add(new Tesla());
//        list.add(new Car());

        List<? super TeslaModification> list2; // Consumer super
        list2 = cars;
        list2 = teslas;
        list2 = teslaModificationCars;
//        list2 = new ArrayList<BMW>();
        Object object = list2.get(0); // can be done, but useless
        list2.add(new TeslaModification());
//        list2.add(new Tesla());
//        list2.add(new Car());

        method(list);


    }

    private static void method(List<? extends Car> list) { // list as producer
        Car car = list.get(0);
        // do something with car
//        list.add(new Car());
    }

    private static void method2(List<? super Car> list) { // list as consumer
//        Car car = list.get(0);
        list.add(new Car());
    }


}

