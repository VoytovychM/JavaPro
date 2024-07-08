package lesson20240617.solid;

import lombok.ToString;

@ToString
public abstract class Car {

    public abstract void move();

    public abstract CarService getCarService();

//    public void service(){
//        System.out.println("Default actions");
//    }


}



