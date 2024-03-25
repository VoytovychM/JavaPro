package summary.task;

import java.util.*;

public class Student {

    public String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {

        List<Student> studentsList = new ArrayList<>(Arrays.asList());
        studentsList.add (new Student("Arsen"));
        studentsList.add(new Student("Vova"));
        studentsList.add(new Student("Vasia"));
        studentsList.add(new Student("Masha"));
        studentsList.add(new Student("Anja"));
        studentsList.add(new Student("Valja"));
        studentsList.add(new Student("Harry"));
        studentsList.add(new Student("Garry"));
        studentsList.add(new Student("Mark"));
        studentsList.add(new Student("Peter"));
        studentsList.add(new Student("Veronyka"));


        System.out.println(studentsList);

        Collections.sort(studentsList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }

        });
        System.out.println(getThreeGroups(studentsList));

    }


    public static List<List<Student>> getThreeGroups (List<Student> studentsList){
        List<List<Student>> result = new ArrayList<>();


        int groupLength = studentsList.size() / 3;

        int leftOver = studentsList.size() % 3;
        int counter = 0;

        List<Student> current = new ArrayList<>();



        for (int i = 0; i < studentsList.size(); i++) {
            if(leftOver > 0 && i == 0) {
                current.add(studentsList.get(i));
                continue;
            }
            if(result.size() < 2 && counter == groupLength){
                result.add(current);
                current = new ArrayList<>();
                counter = 1;
            } else {
                counter++;
            }
            current.add(studentsList.get(i));


        }

        result.add(current);


        return result;

    }
}
