package practice20240417;

import start.comparableExamples.Employee;
import summary20240410.Manager;

import java.util.*;
import java.util.stream.Collectors;

public class MainEmp {
    public static void main(String[] args) {

        Employee employee1 = new Employee("John", "Rutschinsky", 23, true, 40,"Legal", 4500);
        Employee employee2 = new Employee("Jane", "Zimmermann", 45, false, 30,"Accounting", 3500);
        Employee employee3 = new Employee("Inna", "Smidt", 32, true, 20, "Sales", 5500);
        Employee employee4 = new Employee("Mark", "Kopetz", 47, false, 40, "Accounting", 3500);
        Employee employee5 = new Employee("John", "Voytovych", 23, true, 40, "Legal", 7500);
        Employee employee6 = new Employee("Inna", "Smith", 12, false, 20, "Sales", 4500);
        Employee employee7 = new Employee("Eric", "Samus", 40, true, 40, "Management", 10000);

        List<Employee> employeeList = List.of(employee1, employee2, employee3, employee4, employee5, employee6, employee7);
        employeeList.forEach(System.out::println);
        List<Employee> salary = employeeList.stream().filter(employee -> employee.getSalary() >= 5000).toList();
        System.out.println(salary);

        OptionalDouble avarageSalary = employeeList.stream().mapToInt(Employee::getSalary).average();
        System.out.println(avarageSalary.orElse(0));
        System.out.println(avarageSalary.isPresent());
        System.out.println(avarageSalary.isEmpty());

        System.out.println(employeeList.stream().filter(employee -> employee.getDepartment().equals("Accounting")).peek(employee -> employee.setSalary((int) (employee.getSalary() * 1.15))).toList());
        System.out.println(employeeList.stream().min(Comparator.comparing(Employee::getSalary)));

        System.out.println(employeeList.stream().mapToDouble(Employee::getSalary).max().getAsDouble());
        System.out.println(employeeList.stream().max(Comparator.comparing(Employee::getSalary)));


        System.out.println("Max salary in the specific department");
        Map<Object, Optional<Employee>> employeetEithMaxSalary = employeeList.stream().collect(Collectors.groupingBy(department -> department.getDepartment(), Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))));
        System.out.println(employeetEithMaxSalary);

        System.out.println("Group employees by department");
        Map<String, List<Employee>> departments = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));

        for(Map.Entry entry : departments.entrySet()){
            System.out.println(entry);
        }

        System.out.println("The generalised information");
        Map<String, IntSummaryStatistics> summarisingMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summarizingInt(Employee::getSalary)));

        System.out.println("Max Salary by one department : " + summarisingMap.get("Accounting").getMax());
        System.out.println("Max Salary by one department : " + summarisingMap.get("Accounting").getAverage());

        System.out.println(employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary))));
//        System.out.println(employeeList.stream().collect(Collectors.groupingBy(Employee::getName, Collectors.joining(",", " { ", "}" ))));
        System.out.println(employeeList.stream().collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.mapping(Employee::getSurname, Collectors.toList()))));

    }

    }

