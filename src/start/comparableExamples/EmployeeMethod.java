package start.comparableExamples;

import java.util.List;

public class EmployeeMethod {
    public static Employee getFirstByName(List<Employee> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }

        Employee firstEmployee = list.get(0);
        for (Employee employee : list) {
            if (employee.getName().compareTo(firstEmployee.getName()) < 0) {
                firstEmployee = employee;
            }
        }
        return firstEmployee;
    }

    public static Employee getLastByName(List<Employee> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }

        Employee lastEmployee = list.get(0);
        for (Employee employee : list) {
            if (employee.getName().compareTo(lastEmployee.getName()) > 0) {
                lastEmployee = employee;
            }
        }
        return lastEmployee;
    }
}

