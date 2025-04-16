package Comparable.task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Compare Animals by Weight (Comparable)
Create an Animal class with species and weight (double).
Use Comparable<Animal> to sort by weight ascending.
Sample Output:
[Animal{species='Cat', weight=4.5}, Animal{species='Dog', weight=8.0}, Animal{species='Horse', weight=600.0}]
 */
public class Main {

    public static void main(String[] args) {

        List<Animal> animals = new ArrayList<>();

        animals.add(new Animal("Cat", 8.0));
        animals.add(new Animal("Dog", 4.0));
        animals.add(new Animal("Horse", 150));

        System.out.println("before: " + animals);

        Collections.sort(animals);

        System.out.println("After: " + animals);


    }

}
