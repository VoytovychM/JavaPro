package start.comparableExamples;

public class Employee implements Comparable <Employee>{

    private String name;
    private String surname;
    private int age;
    private String department;
    private int salary;
    private boolean isActive;


    private int workingHoursInMonth;



    public Employee(String name, String surname, int age, boolean isActive, int workingHoursInMonth, String department, int salary) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.isActive = isActive;
        this.workingHoursInMonth = workingHoursInMonth;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWorkingHoursInMonth() {
        return workingHoursInMonth;
    }

    public void setWorkingHoursInMonth(int workingHoursInMonth) {
        this.workingHoursInMonth = workingHoursInMonth;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", isActive=" + isActive +
                ", workingHoursInMonth=" + workingHoursInMonth +
                '}';
    }

    @Override
    public int compareTo(Employee another) {
        int result = this.name.compareTo(another.name);
        if (result == 0) {
            result = this.surname.compareTo(another.surname);
            if (result == 0) {
                result = Integer.compare(this.age, another.age);
                if (result == 0) {
                    result = Integer.compare(this.workingHoursInMonth, another.workingHoursInMonth);
                }
            }
        }
        return result;
    }

}


