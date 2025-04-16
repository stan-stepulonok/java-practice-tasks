package Comparator.task3;

import java.util.Comparator;

public class Employees {

    private String name;
    private int salary;

    public static Comparator<Employees> nameComparator = new Comparator<>() {
        @Override
        public int compare(Employees employee1, Employees employee2) {
            return employee1.name.compareTo(employee2.name);
        }
    };

    public Employees(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

}
