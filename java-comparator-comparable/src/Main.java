/*
Comparable: “Natural ordering”

Implemented by the class itself to define how it compares to other objects of the same type.

class Person implements Comparable<Person> {
    private int age;
    @Override
    public int compareTo(Person other) {
        return this.age - other.age;
    }
}

Defines default or natural ordering
You can only have one compareTo() method
Used by Collections.sort(list) and Arrays.sort(array)
Compares this object to other
 */

/*
Comparator: “Custom ordering”

Implemented outside the class to define how two objects should be compared (can be many ways).

class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getAge() - p2.getAge();
    }
}

You can create multiple comparators for different sorting rules
Doesn’t require modifying the class
Used with:
Collections.sort(list, comparator)
list.sort(comparator)
 */

/*
Feature	Comparable	Comparator
Package	java.lang	java.util
Method	compareTo(T o)	compare(T o1, T o2)
Used for	Natural (default) ordering	Custom (external) ordering
Defined in	The class itself	A separate class or lambda
Can sort by	One logic only	Multiple, flexible logics
Example	Sort people by name	Sort people by age, salary...

Can implement both: class Person implements Comparable<Person>, Comparator<Person> {}

Ascending order VS Descending order (age example):
#1:
@Override
public int compareTo(Student other) {
    return this.age - other.age; // 🔼 Ascending order
}
Comparator<Student> ageAscending = (s1, s2) -> s1.age - s2.age;
#2
@Override
public int compareTo(Student other) {
    return other.age - this.age; // 🔽 Descending
}
Comparator<Student> ageDescending = (s1, s2) -> s2.age - s1.age;
Comparison table:
Order	Comparable	Comparator
Ascending	this.age - other.age	(s1, s2) -> s1.age - s2.age
Descending	other.age - this.age	(s1, s2) -> s2.age - s1.age or .reversed()

Double has a built-in comparator via its static method: public static int compare(double d1, double d2)
String implements Comparable<String>: public int compareTo(String anotherString)
 */

/*
A generic is like a placeholder for a type.

Instead of hardcoding types (like int, String, Person), you can write code that works with any type, and Java will enforce type-safety for you.

No generic:
List names = new ArrayList();
names.add("Alice");
String name = (String) names.get(0); // needs casting

Generic:
List<String> names = new ArrayList<>();
names.add("Alice");
String name = names.get(0); // no cast needed
*/

public class Main {
    public static void main(String[] args) {
    }
}