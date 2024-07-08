package practice20240617;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@BadCode(name = "Masha", comment = "Incorrect class")
public class Student {

    private String name;
    private String group;
    @BadCode(name = "Masha", comment = "Incorrect format ")
    private int age;

    public Student(String name, String group, int age) {
        this.name = name;
        this.group = group;
        this.age = age;
    }

    @BadCode(name = "Masha", comment = "Incorrect condition")
    public void introduction() {
        System.out.println("Hello! My name is " + name + ". My group is " + group + ". I am " + age);
    }

    private boolean isDrinking() {
        return age >= 21;
    }

    @BadCode(name = "Masha", comment = "Discrimination by age")
    void party() {
        System.out.println(isDrinking() ? "Is he allowed to drink?" : "Not allowed to drink");
    }

    public static void main(String[] args) {
        Student student = new Student("Vova", "21_11", 19);
        Class<?> studentClass = student.getClass();
        if (studentClass.isAnnotationPresent(BadCode.class)) {
            System.out.println(studentClass.getSimpleName() + "; ");
            BadCode badCode = studentClass.getAnnotation(BadCode.class);
            System.out.println(badCode.name() + ";" + badCode.comment());
        }
        Field[] declaredField = studentClass.getDeclaredFields();
        for (Field field : declaredField) {
            if (field.isAnnotationPresent(BadCode.class)) {
                System.out.println(field.getName() + "; ");
                BadCode badCode = field.getAnnotation(BadCode.class);
                System.out.println(badCode.name() + "; " + badCode.comment());
            }

            Method[] declaredMethods = studentClass.getDeclaredMethods();
            for (Method method : declaredMethods) {
                if (method.isAnnotationPresent(BadCode.class)) {
                    System.out.println(method.getName() + "; ");
                    BadCode badCode = method.getAnnotation(BadCode.class);
                    System.out.println(badCode.name() + "; " + badCode.comment());
                }
            }
        }
    }
}