package start.LinkedListTask;

import java.util.List;

import static start.LinkedListTask.StudentNumber.countAmountWithName;
import static start.LinkedListTask.StudentNumber.countTotalAmount;

public class MainSchool {
 // Составить список студентов, распределенных по отдельным классам List<List<Student>> studentGrades
  //- Написать метод countTotalAmount(studentGrades), который считает общее число студентов
 //- Написать метод countAmountWithName(studentGrades, name),
 // который считает количество студентов в школе с заданным именем name.
    public static void main(String[] args) {

        List<Student> grade1 = List.of( new Student("Pasha", 9), new Student( "Max", 8), new Student("Lisa", 10));
        List<Student> grade2 = List.of(new Student("Ivan", 23), new Student("Petia", 20), new Student("Roma", 22));
        List<Student> grade3 = List.of(new Student("Vova", 21), new Student("Sasha", 20), new Student("Lena", 24), new Student("Vasia", 22));

        List<List <Student>> studentGrades = List.of(grade1, grade2, grade3);



        int totalAmount = countTotalAmount(studentGrades);
        System.out.println("Total amount of students: " + totalAmount);


        String nameToCount = "Lena";
        int amountWithName = countAmountWithName(studentGrades, nameToCount);
        System.out.println("Amount of student with specific name " + nameToCount + ": " + amountWithName);
    }
}

