package task1;

public abstract class Person {

    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getPersonName() {
        return this.name;
    }

    public int getPersonAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return "Name: " + name + "; Age: " + age;
    }

}
