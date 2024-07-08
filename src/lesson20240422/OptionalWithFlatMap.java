package lesson20240422;

import java.util.Optional;

public class OptionalWithFlatMap {
    public static void main(String[] args) {
        Insurance insurance = new Insurance("Insurance");
        Car car = new Car(insurance);

//        String name = car.getInsurance().get().getName().get(); // unsave

        String name = car.getInsurance().flatMap(Insurance::getName).orElse("no insurance");
        System.out.println(name);

        insurance = new Insurance();
        car = new Car(insurance);

        name = car.getInsurance().flatMap(Insurance::getName).orElse("no insurance");
        System.out.println(name);

        car = new Car();
        name = car.getInsurance().flatMap(Insurance::getName).orElse("no insurance");
        System.out.println(name);

        Optional<Optional<String>> optional = Optional.of(Optional.of("Data"));
//        Optional<String> optionalString = optional.map(e -> e).get();
        String data = optional.flatMap(e -> e).orElse("No data");
        System.out.println(data);

    }

    static class Car {
        private Optional<Insurance> insurance;

        public Car() {
            this.insurance = Optional.empty();
        }

        public Car(Insurance insurance) {
            this.insurance = Optional.of(insurance);
        }

        public Optional<Insurance> getInsurance() {
            return insurance;
        }
    }

    static class Insurance {
        private Optional<String> name;

        public Insurance() {
            this.name = Optional.empty();
        }

        public Insurance(String name) {
            this.name = Optional.of(name);
        }

        public Optional<String> getName() {
            return name;
        }
    }

}

