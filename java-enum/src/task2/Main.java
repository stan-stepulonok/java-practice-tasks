package task2;

/*
Task 2: Traffic Light Colors
Create an enum TrafficLight with constants RED, YELLOW, and GREEN.
Each should have an associated time (in seconds).
Print the name, ordinal, and associated time for each color.
 */

public class Main {

    public static void main(String[] args) {

        System.out.println("----- Printed directly: -----");
        TrafficLight red = TrafficLight.RED;
        TrafficLight yellow = TrafficLight.YELLOW;
        TrafficLight green = TrafficLight.GREEN;
        System.out.println("Name: " + red.name());
        System.out.println("Ordinal: " + red.ordinal());
        System.out.println("Time: " + red.getTrafficLightTime());
        System.out.println();

        System.out.println("----- Printed from array: -----");
        TrafficLight[] lights = TrafficLight.values();
        for (int i = 0; i < lights.length; i++) {
            System.out.println("Name: " + lights[i].name());
            System.out.println("Ordinal: " + lights[i].ordinal());
            System.out.println("Time: " + lights[i].getTrafficLightTime());
        }

    }

}
