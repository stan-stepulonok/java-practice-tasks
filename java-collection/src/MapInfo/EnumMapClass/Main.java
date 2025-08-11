package MapInfo.EnumMapClass;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
/*
        Task 1:

        Create an enum called OrderStatus representing different stages of an order in an e-commerce system.

        The enum should have:
        A field description (String) that holds a short explanation of the status.
        A constructor to initialize the description.
        A method getDescription() to return the description.

        Override the toString() method to return the status name with its description, e.g. "PENDING (Order received, waiting for processing)".

        Then, create an EnumMap<OrderStatus, Integer> to track the count of orders currently in each status.

        Perform the following operations on the map:
        Initialize the map with all enum constants as keys, and set their counts to zero.
        Simulate processing incoming order updates by updating counts for some statuses.
        Display all statuses with their counts and descriptions.
        Check if there are any orders with status SHIPPED and output the result.
        Remove the count entry for the CANCELLED status from the map.
        Add a new entry for a status and set its count.
        Retrieve and print the count of orders for DELIVERED status.
        Display the size of the map.
        Clear the map and confirm if it is empty.
       */

        System.out.println("Task 1:");

        EnumMap<OrderStatus, Integer> eMap1 = new EnumMap<>(OrderStatus.class);
        // Initialize the map with all enum constants as keys, and set their counts to zero.
        eMap1.put(OrderStatus.PENDING, 0);
        eMap1.put(OrderStatus.PROCESSING, 0);
        eMap1.put(OrderStatus.SHIPPED, 0);
        eMap1.put(OrderStatus.CANCELLED, 0);
        // Simulate processing incoming order updates by updating counts for some statuses.
        eMap1.put(OrderStatus.PENDING,(int)(Math.random()*99));
        eMap1.put(OrderStatus.PROCESSING,(int)(Math.random()*99));
        eMap1.put(OrderStatus.SHIPPED,(int)(Math.random()*99));
        eMap1.put(OrderStatus.CANCELLED,(int)(Math.random()*99));
        // Display all statuses with their counts and descriptions.
        System.out.println("Order statuses per category:");
        Set<Map.Entry<OrderStatus, Integer>> orders = eMap1.entrySet();
        Iterator setIter = orders.iterator();
        while (setIter.hasNext()) {
            System.out.println(setIter.next());
        }
        // Check if there are any orders with status SHIPPED and output the result.
        int quantityTemp = eMap1.get(OrderStatus.SHIPPED);
        if (quantityTemp != 0) {
            System.out.println("There are " + quantityTemp + " orders being " + OrderStatus.SHIPPED.name().toLowerCase());
        } else System.out.println("There are no orders being " + OrderStatus.SHIPPED.name().toLowerCase());
        // Remove the count entry for the CANCELLED status from the map.
        eMap1.put(OrderStatus.CANCELLED, 0);
        // Add a new entry for a status and set its count.
        eMap1.put(OrderStatus.DELIVERED,(int)(Math.random()*99));
        // Retrieve and print the count of orders for DELIVERED status.
        System.out.println("Delivered orders: " + eMap1.get(OrderStatus.DELIVERED));
        // Display the size of the map.
        System.out.println("Total number of available statuses: " + eMap1.size());
        // Clear the map and confirm if it is empty.
        eMap1.clear();
        System.out.println("Is order list empty? ... " + eMap1.isEmpty());
        System.out.println();
    }

}
