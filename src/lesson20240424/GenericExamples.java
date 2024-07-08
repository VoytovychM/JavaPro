package lesson20240424;

import start.comparableExamples.Employee;

import java.util.ArrayList;
import java.util.List;

public class GenericExamples {
    public static void main(String[] args) {

        Object o;
        o = 2;
        o = "String";

        System.out.println(((String) o).toUpperCase());

        List list = new ArrayList();

        List<String> stringList = new ArrayList<String>();
        new ArrayList<String>().add("123");

        GenericClass<Integer, Object> genericClass1 = new GenericClass<>(123);
        genericClass1.process("input1");

        GenericClass<String, Employee> genericClass2 = new GenericClass<>("string data");
        genericClass2.process("input2");

        System.out.println(genericClass1.function(10));
        System.out.println(genericClass2.function("sting value"));

        Object object = genericClass1.methodWithM(new Object());
        Employee employee = genericClass2.methodWithM(new Employee("Tom", "Smith", 43, true, 40, "Legal", 1000));


        staticGenericMethod(123);
        staticGenericMethod("string");

        // o1, o2 ---> List of o1,o2
         List<Integer> integerList = makeListFromTwoElements (1,2);
        List<String> strings = makeListFromTwoElements ("A", "B");
        System.out.println(strings);
        System.out.println(integerList);
    }

    private static <T>  List<T> makeListFromTwoElements(T t1, T t2) {
//        List<T> list = new ArrayList<>();
//        list.add(t1);
//        list.add(t2);
//        return list;
        return List.of(t1,t2);
    }

    public static <T> void staticGenericMethod(T t1){
        T t2 = null;
        System.out.println(t1);
        System.out.println(t2);


    }

}
