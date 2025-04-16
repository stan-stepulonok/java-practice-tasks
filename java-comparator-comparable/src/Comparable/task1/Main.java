package Comparable.task1;

/*
Sort Students by Age (Comparable)
Create a Student class with name and age.
Implement Comparable<Student> to sort students by age in ascending order.
Sample Output:
[Student{name='Alice', age=19}, Student{name='Bob', age=22}, Student{name='Clara', age=24}]
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Student> listOfStudents = new ArrayList<>();
        Student s1 = new Student("XYZ", 30);
        Student s2 = new Student("CDE", 20);
        Student s3 = new Student("ABC", 25);
        listOfStudents.add(s1);
        listOfStudents.add(s2);
        listOfStudents.add(s3);

        System.out.println("Before: " + listOfStudents);

        Collections.sort(listOfStudents);

        System.out.println("After: " + listOfStudents);

    }

}
