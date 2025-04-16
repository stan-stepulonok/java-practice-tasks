package Comparable.task1;

public class Student implements Comparable<Student> {

    private String name;

    private int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return "Student info -> Name: " + name + "; Age: " + age;
    }

    @Override
    public int compareTo(Student studentToCompare) {
        return this.age - studentToCompare.age;
    }
}
