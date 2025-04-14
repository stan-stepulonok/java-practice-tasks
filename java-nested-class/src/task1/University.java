package task1;

import java.util.ArrayList;
import java.util.ListIterator;

public class University {

    private static int lastStudentId = 0;

    private String name;

    private ArrayList<Student> students = new ArrayList<>();

    public University(String name) {
        this.name = name;
    }

    public String getUniversityName() {
        return this.name;
    }

    public ArrayList<Student> getStudentsList() {
        return this.students;
    }

    @Override
    public String toString() {
        return "University: " + this.name;
    }

    class Student extends Person implements Enrollable {

        private int studentId;
        public ArrayList<String> enrolledCourses;

        Student(String name, int age) {
            super(name, age);
            lastStudentId++;
            this.studentId = lastStudentId;
            enrolledCourses = new ArrayList<>();
        }

        public int getStudentId() {
            return this.studentId;
        }

        @Override
        public void enroll(String course) {
            this.enrolledCourses.add(course);
        }

        @Override
        public String toString() {
            return super.toString() + "; Student ID: " + studentId;
        }

        public void displayStudentInfo() {
            System.out.println(this);
            System.out.println("Enrolled Course: ");
            ListIterator<String> literator = enrolledCourses.listIterator();
            while (literator.hasNext()) {
                System.out.print(literator.next() + ", ");
            }
            System.out.println();
            System.out.println("University: " + University.this.getUniversityName());
        }
    }

    public static class Department {
        private String deptName;
        private String headOfDepartment;

        Department(String deptName, String headOfDepartment) {
            this.deptName = deptName;
            this.headOfDepartment = headOfDepartment;
        }

        @Override
        public String toString() {
            return "Department: " + this.deptName + "\nHead: " + this.headOfDepartment;
        }

    }


}
