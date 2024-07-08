package lesson20240410.functionalinterface;

import start.comparableExamples.Employee;

import java.util.*;

public class SortWithLambda {
    public static void main(String[] args) {
        Employee employee1 = new Employee("John", "Smith", 23, true, 40, "Legal", 2500);
        Employee employee2 = new Employee("Jane", "Smith", 45, false, 30, "Legal", 2500);
        Employee employee3 = new Employee("Inna", "Smith", 32, true, 20, "Legal", 2500);
        Employee employee4 = new Employee("Mark", "Smith", 47, false, 40, "Legal", 2500);
        Employee employee5 = new Employee("John", "Smith", 23, true, 40, "Legal", 2500);
        Employee employee6 = new Employee("Inna", "Smith", 12, false, 20, "Legal", 2500);
        List<Employee> employees = Arrays.asList(employee1, employee2, employee3, employee4, employee5, employee6);


        Collections.sort(employees, (o1, o2) -> o1.getAge() - o2.getAge());
//        Collections.sort(employees, Comparator.comparingInt(Employee::getAge));
//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return o1.getAge() - o2.getAge();
//            }
//        });
        System.out.println(employees);
    }

}

