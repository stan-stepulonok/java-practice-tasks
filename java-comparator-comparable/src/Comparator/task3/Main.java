package Comparator.task3;

/*
Sort Employees by Name (Anonymous Comparator)
Create an Employee class with name and salary.
Use an anonymous class to sort employees by name.
Sample Output:
[Employee{name='Anna'}, Employee{name='John'}, Employee{name='Zack'}]
 */


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Employees emp1 = new Employees("BCD", 300);
        Employees emp2 = new Employees("ABC", 200);
        Employees emp3 = new Employees("CDE", 400);

        List<Employees> employees = new ArrayList<>();

        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

        System.out.println("Before: " + employees);

        employees.sort(Employees.nameComparator);
        System.out.println("After: " + employees);

    }

}
