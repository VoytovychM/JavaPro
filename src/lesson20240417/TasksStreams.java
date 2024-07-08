package lesson20240417;

import start.comparableExamples.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TasksStreams {
    public static void main(String[] args) {
//        1. Отсортировать с помощью стримов список из строк
//- по алфавиту
//- в обратном порядке

        List<String> listOfFruits = Arrays.asList("Banana", "Mango", "Apple", "Peach");
        listOfFruits.stream().sorted().forEach(System.out::println);
        listOfFruits.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

//        2. Из списка чисел типа Integer с помощью стримов создать список их строковых представлений
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<String> stringNumbers = numbers.stream().map(Object::toString).collect(Collectors.toList());
        System.out.println(stringNumbers);

        Employee employee1 = new Employee("John", "Smith", 23, true, 40,"Legal", 2500);
        Employee employee2 = new Employee("Jane", "Smith", 45, false, 30,"Legal", 2500);
        Employee employee3 = new Employee("Inna", "Smith", 32, true, 20, "Legal", 2500);
        Employee employee4 = new Employee("Mark", "Smith", 47, false, 40, "Legal", 2500);
        Employee employee5 = new Employee("John", "Smith", 23, true, 40, "Legal", 2500);
        Employee employee6 = new Employee("Inna", "Smith", 12, false, 20, "Legal", 2500);
        List<Employee> employees = Arrays.asList(employee1, employee2, employee3, employee4, employee5, employee6);

//       3. Создать список из экземпляров класса Employee. С помощью стримов:
//- вывести список активных сотрудников старше 20 лет
//- вывести список сотрудников, работающих более 30 часов, с именем, начинающимся на J
//- вывести список фамилий сотрудников с именем John
//- вывести список всех уникальных имен сотрудников


       List<Employee> activeEmployees = employees.stream().filter(Employee::isActive).filter(employee -> employee.getAge()>20).toList();
        System.out.println(activeEmployees);

        List<Employee> employeeWorkingMore30WithJ = employees.stream().filter(employee -> employee.getWorkingHoursInMonth() > 30 && employee.getName().startsWith("J")).toList();
        System.out.println(employeeWorkingMore30WithJ);

        List<String> employeeWithNameJohn = employees.stream().filter(employee -> employee.getName().startsWith("John")).map(Employee::getSurname).toList();
        System.out.println(employeeWithNameJohn);

        List<String> employeeWithUniqueNames = employees.stream().map(Employee::getName).distinct().toList();
        System.out.println(employeeWithUniqueNames);

    }
}
