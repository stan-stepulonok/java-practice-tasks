package task8;

/*
Task 8: Planets and Gravity
Define an enum Planet that stores mass and radius.
Implement a method to calculate gravitational pull.
Add a static field to track how many planets have been printed.
 */

public class Main {

    public static void main(String[] args) {

        Planet earth = Planet.EARH;
        System.out.println(Planet.planetCount);
        System.out.println(earth.calculateGravity());

        Planet pluto = Planet.PLUTO;
        System.out.println(Planet.planetCount);
        System.out.println(pluto.calculateGravity());

    }

}
