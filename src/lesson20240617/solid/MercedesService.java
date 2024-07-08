package lesson20240617.solid;

public class MercedesService implements CarService {
@Override
    public void service (Car car){
        System.out.println("Servicing mercedes " + car);

    }

}
