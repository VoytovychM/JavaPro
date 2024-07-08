package start.incapsulation;

public class RobotMain {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Tom", "white", 2);
        Cat cat2 = new Cat("Vasya", "black", 1);
        cat1.sayHello();
        cat2.sayHello();

        System.out.println(cat1.isHungry());
        cat1.feed();
        System.out.println(cat1.isHungry());

        Robot.printTotalRobotCount();

        Robot robot1 = new Robot("Valuum cleaner", "Robot cleaner");
        Robot robot2 = new Robot("Washing mashine", "Robot to wash something");
        robot1.printCurrentRobotInfo();
        robot2.printCurrentRobotInfo();

//        robot1.printTotalRobotCount();
//        robot2.printTotalRobotCount();
        Robot.printTotalRobotCount();
    }


}