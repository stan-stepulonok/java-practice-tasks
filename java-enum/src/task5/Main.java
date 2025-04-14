package task5;

/*
Task 5: Animal Types
Create an enum Animal where each animal constant has a sound and average lifespan.
Override a method in each constant that prints a fun fact about the animal.
 */
public class Main {

    public static void main(String[] args) {

        Animal cat = Animal.CAT;
        cat.makeVoice();
        cat.showFunFact();

    }

}
