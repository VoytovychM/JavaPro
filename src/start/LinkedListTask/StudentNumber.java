package start.LinkedListTask;

import java.util.List;

public class StudentNumber {
    public static int countTotalAmount(List<List<Student>> studentGrades) {
        int totalAmount = 0;
        for (List<Student> grade: studentGrades){
            totalAmount += grade.size();

        }
        return totalAmount;
    }
    public static int countAmountWithName(List<List<Student>> studentGrades, String name) {
        int amountWithName = 0;
        for (List<Student> grade: studentGrades) {
            for (Student student: grade) {
                if (student.getName().equals(name)) {
                    amountWithName++;
                }
            }
        }
        return amountWithName;
    }
}
