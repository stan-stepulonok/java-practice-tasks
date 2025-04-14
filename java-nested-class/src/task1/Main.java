package task1;

/*

Here's a comprehensive task designed to help you practice the usage of Nested Classes in Java. This will cover:
Inner classes (non-static)
Static nested classes
Access to outer class members
Interaction between nested types
Inheritance from abstract class
Implementation of interfaces

You are building a simplified University Management System that models:
A University (outer class)
A non-static inner class Student
A static nested class Department
Abstract class Person
Interface Enrollable

Inner Class: Student
Inherits from Person
Implements Enrollable
Fields: studentId, course
Methods:
enroll(String course) – assign course name and print confirmation
displayInfo() – print all student info including university name

Static Nested Class: Department
Fields: departmentName, head
Method: printDetails() – print department info
Can be used without an instance of University

Main Class Tasks
Inside the main method:
Create a University object.
Create a Student object from the university instance.
Enroll the student in a course.
Call displayInfo() on the student.
Create a Department object and call printDetails().

Output:
University created: CodeTech University
Student enrolled in: Java Programming
Student Info:
Name: Alice, Age: 22, Student ID: 1001
Enrolled Course: Java Programming
University: CodeTech University
Department: Computer Science
Head: Dr. Smith

 */

public class Main {

    public static void main(String[] args) {

        University university1 = new University("UniversityName");

        University.Department dept1 = new University.Department("DeptName", "DeptHead");

        University.Student student1 = university1.new Student("StudentName", 999);
        student1.enroll("CourseName");

        System.out.println(university1);
        student1.displayStudentInfo();
        System.out.println(dept1);

    }

}
