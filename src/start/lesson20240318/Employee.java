package start.lesson20240318;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Employee implements Comparable<Employee> {

    private String name;
    private String surname;
    private int age;
    private int workingHoursInMonth;

    public Employee(String name, String surname, int age, int workingHoursInMonth) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.workingHoursInMonth = workingHoursInMonth;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", workingHoursInMonth=" + workingHoursInMonth +
                '}';
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee("John", "Smith", 23, 40);
        Employee employee2 = new Employee("Jane", "Smith", 45, 30);
        Employee employee3 = new Employee("Inna", "Smith", 32, 20);
        Employee employee4 = new Employee("Mark", "Smith", 47, 40);
        Employee employee5 = new Employee("John", "Smith", 23, 40);
        Employee employee6 = new Employee("Inna", "Smith", 12, 20);
        List<Employee> employees = Arrays.asList(employee1, employee2, employee3, employee4, employee5, employee6);

        // a) - sort by age - Comparator
        System.out.println("Sort by age:");
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
//                return o1.age - o2.age;
                return Integer.compare(o1.age, o2.age);
            }
        });
        for (Employee e : employees){
            System.out.println(e);
        }

        // b) - sort by surname and name - Comparator
        System.out.println("Sort by surname and name:");
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.surname.compareTo(o2.surname) < 0) {
                    return -1;
                } else if (o1.surname.compareTo(o2.surname) > 0){
                    return 1;
                } else {
                    return o1.name.compareTo(o2.name);
                }
            }
        });
        for (Employee e : employees){
            System.out.println(e);
        }

        // c) - natural order by name, surname, age, workingHoursInMonth - Comparable
        System.out.println("Natural Sort by name, surname, age, workingHoursInMonth:");
        Collections.sort(employees);
        for (Employee e : employees){
            System.out.println(e);
        }

        // сортировка по рабочим часам и возрасту в обратном порядке
        System.out.println("Natural Sort by hours, age, reverse order:");
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int result = o2.workingHoursInMonth - o1.workingHoursInMonth;
                if (result == 0) result = o2.age - o1.age;
                return result;
            }
        });
        for (Employee e : employees){
            System.out.println(e);
        }

    }

    @Override
    public int compareTo(Employee o) {
        int result = this.name.compareTo(o.name);
        if (result == 0) result = this.surname.compareTo(o.surname);
        if (result == 0) result = this.age - o.age;
        if (result == 0) result = this.workingHoursInMonth - o.workingHoursInMonth;
        return result;
    }
}