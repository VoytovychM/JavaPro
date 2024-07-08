package start.comparableExamples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Tasks {
  ////   a) - sort by age - Comparator
    //// b) - sort by surname and name - Comparator
    //// c) - natural order by name, surname, age, workingHoursInMonth - Comparable
  public static void main(String[] args) {
          List<Employee> employees = new ArrayList<>();
          employees.add(new Employee("Vova", "Abrahaam", 33, true, 40, "Sales", 3000));
          employees.add(new Employee("Masha", "Voytovych",38, true, 30, "Accounting", 2000 ));
          employees.add(new Employee("Katya", "Morozova",37,true, 20, "Legal", 2500));


          Collections.sort(employees, new Comparator<Employee>() {
              @Override
              public int compare(Employee e1, Employee e2) {
                  return Integer.compare(e1.getAge(), e2.getAge());
              }
          });

          for (Employee employee : employees) {
              System.out.println(employee);
          }

          Collections.sort(employees, new Comparator<Employee>() {
          @Override
          public int compare(Employee e1, Employee e2) {
              int result = e1.getSurname().compareTo(e2.getSurname());
              if (result == 0) {
                  return e1.getName().compareTo(e2.getName());
              }
              return result;
          }
      });

      for (Employee employee : employees) {
          System.out.println(employee);
      }

      System.out.println("Natural order:");
      Collections.sort(employees);
      for(Employee employee: employees){
          System.out.println(employee);
      }
      Employee firstName = EmployeeMethod.getFirstByName(employees);
      System.out.println("First employee by name: " + firstName);

      Employee lastName = EmployeeMethod.getLastByName(employees);
      System.out.println("Last employee by name: " + lastName);
  }
}

