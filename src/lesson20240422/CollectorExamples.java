package lesson20240422;

import start.comparableExamples.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorExamples {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Tom", "Jane", "Martin", "Nik", "Edd", "Tom", "Jane", "Tom");
        Set<String> uniqueNames = names.stream().collect(Collectors.toSet());

        ArrayList<String> arrayList = names.stream().collect(Collectors.toCollection(ArrayList::new));

        Map<String, Integer> namesWithLength = names.stream().distinct().collect(Collectors.toMap(name -> name, String::length));
        System.out.println(namesWithLength);

        namesWithLength = names.stream().collect(Collectors.toMap(name -> name, String::length, (length1, length2) -> length1));
        System.out.println(namesWithLength);

        Map<String, Integer> namesCount = names.stream().collect(Collectors.toMap(name -> name, name -> 1, (el1, el2) -> el1 + el2));
        System.out.println(namesCount);

        // Создать список из экземпляров класса Employee.
        Employee employee1 = new Employee("Steven", "Rutschinsky", 23, true, 40,"Legal", 4500);
        Employee employee2 = new Employee("Jane", "Zimmermann", 45, false, 30,"Accounting", 3500);
        Employee employee3 = new Employee("Anna", "Smidt", 32, true, 20, "Sales", 5500);
        Employee employee4 = new Employee("Mark", "Kopetz", 47, false, 40, "Accounting", 3500);
        Employee employee5 = new Employee("John", "Voytovych", 23, true, 40, "Legal", 7500);
        Employee employee6 = new Employee("Inna", "Smith", 12, false, 20, "Sales", 4500);
        List<Employee> employees = Arrays.asList(employee1, employee2, employee3, employee4, employee5, employee6);

        //  С помощью коллекторов:
        // Map <Имя / Employee>
        Map<String, Employee> nameToEmployeeMap = employees.stream().collect(Collectors.toMap(Employee::getName, e -> e));
        System.out.println(nameToEmployeeMap);

        // Map <age / количество>
        Map<Integer, Integer> ageMap = employees.stream().collect(Collectors.toMap(Employee::getAge, age -> 1, Integer::sum));
        System.out.println(ageMap);
        Map<Integer, Long> ageMap2 = employees.stream().collect(Collectors.groupingBy(Employee::getAge, Collectors.counting()));
        System.out.println(ageMap2);

        // Map <age / список сотрудников>
        Map<Integer, List<Employee>> employeesByAge = employees.stream().collect(
                Collectors.groupingBy(Employee::getAge, Collectors.mapping(e -> e, Collectors.toList())));
        System.out.println(employeesByAge);

        // Map <isActive / количество>
        Map<Boolean, Long> isActiveMap = employees.stream().collect(Collectors.partitioningBy(Employee::isActive, Collectors.counting()));
        System.out.println(isActiveMap);

        // Map <Department / список сотрудников>
        Map<String, List<Employee>> employeebyDepartment = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(e->e, Collectors.toList())));
        System.out.println(employeebyDepartment);

        // Map <Department / общая сумма рабочих часов>
       Map<String, Integer> workingHours =  employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingInt(Employee::getWorkingHoursInMonth)));
        System.out.println(workingHours);

        String string = employees.stream().map(Employee::getName).collect(Collectors.joining(", "));
        String string2 = employees.stream().map(Employee::getName).reduce((s1, s2) -> s1 + "," +s2).orElse("");
        System.out.println(string);
        System.out.println(string2);
    }



}

