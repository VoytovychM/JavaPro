package practice20240415;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Work {
    public static void main(String[] args) {
        Consumer<String> task = (s) -> System.out.println(s + " loads breaks");
        task.accept("Vasya");
        task =(s) -> System.out.println(s + " digs");
        task.accept("Vasya");

        List<Consumer<String>> dailyTasks = new ArrayList<>();
        dailyTasks.add((s) -> System.out.println(s + " , load trash"));
        dailyTasks.add((s) -> System.out.println(s + " , dig hole"));
        dailyTasks.add((s) -> System.out.println(s + " , mix concrete"));

        dailyTasks.forEach(task1 -> task1.accept("Vasya"));
        dailyTasks.remove(0);
        dailyTasks.add(0, new Consumer<String>() {
            @Override
            public void accept(String string) {
                System.out.println(string + ", load track with sand");
            }
        });

        dailyTasks.forEach(task1 -> task1.accept("Vasya"));
        work("Vasya", s -> System.out.println(s + " eats pizza"));
        work("Vasya", new NewJob());

    }

    public static void work(String name, Consumer<String> work){
        System.out.println("My name is " + name);
        work.accept(name);

    }
}
 class NewJob implements Consumer<String>{

     @Override
     public void accept(String string) {
         System.out.println(string + " loads bricks");
     }

 }