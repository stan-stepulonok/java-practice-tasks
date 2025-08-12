package MapInfo.TreeMapClass;

import java.util.*;

public class Main {

    public static void main(String[] args) {
/*
        Methods inherited from Map

        Task 1 – Employee Directory Management
        Description:
        Create a TreeMap of employee IDs and their names, ordered in reverse numeric order of IDs.
        Add multiple employees to the directory.
        Check if certain employee IDs and names exist in the directory.
        Retrieve and display the total number of employees.
        Remove one employee and replace the name for another existing ID.
        Display the full directory before and after modifications.
        Output example:
        Initial directory: {105=Sarah, 102=Alex, 101=Emma, 100=David}
        Contains ID 102? true
        Contains name 'John'? false
        Total employees: 4
        After removal and replacement: {105=Sarah, 102=Alex, 101=John}
        */

        System.out.println("Task 1:");
        // Create a TreeMap of employee IDs and their names, ordered in reverse numeric order of IDs.
        Comparator<Integer> comp1 = new Comparator<>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2.compareTo(i1);
            }
        };
        TreeMap<Integer,String> tmap1 = new TreeMap<>(comp1);
        // Add multiple employees to the directory.
        tmap1.put(105,"Sarah");
        tmap1.put(102,"Alex");
        tmap1.put(101,"Emma");
        tmap1.put(100,"David");
        System.out.println("Initial map with reversed comparator: " + tmap1);
        // Check if certain employee IDs and names exist in the directory.
        Integer idToCheck1 = 101;
        System.out.println("Employee with id " + idToCheck1 + " exists? ... " + tmap1.containsKey(idToCheck1));
        // Retrieve and display the total number of employees.
        int employeeNumber1 = tmap1.size();
        System.out.println("Total number of employees: " + employeeNumber1);
        // Remove one employee and replace the name for another existing ID.
        System.out.println("Removed id 100 -> " + tmap1.remove(100));
        System.out.println("Updated id 105 -> " + tmap1.put(105,"SarahRenamed"));
        // Display the full directory before and after modifications.
        System.out.println("Updated map: " + tmap1);
        System.out.println();

/*
        Methods inherited from SortedMap

        Task 2 – Student Score Rankings
        Description:
        Create a TreeMap of student names and their scores, ordered alphabetically ignoring case.
        Add at least 6 students.
        Display the first and last student in alphabetical order.
        Extract a portion of the map containing students whose names fall between two given names.
        Display the submap and confirm that the original TreeMap remains unchanged.
        Output example:
        All students: {alice=88, Ben=92, Charlie=75, daniel=85, Eve=90, frank=78}
        First student: alice=88
        Last student: frank=78
        Submap (Ben to Eve): {Ben=92, Charlie=75, daniel=85, Eve=90}
        Original map unchanged: {alice=88, Ben=92, Charlie=75, daniel=85, Eve=90, frank=78}
*/
        System.out.println("Task 2:");
        // Create a TreeMap of student names and their scores, ordered alphabetically ignoring case.
        Comparator<String> comp2 = new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.toLowerCase().compareTo(s2.toLowerCase());
            }
        };
        TreeMap<String,Integer> tmap2 = new TreeMap<>(comp2);
        // Add at least 6 students.
        tmap2.put("Charlie", 75);
        tmap2.put("alice", 88);
        tmap2.put("Ben", 92);
        tmap2.put("Eve", 90);
        tmap2.put("Alisa", 35);
        tmap2.put("daniel", 85);
        System.out.println("Original map: " + tmap2);
        //  Display the first and last student in alphabetical order.
        Map.Entry<String,Integer> firstEntry = tmap2.firstEntry();
        System.out.println("First Entry: " + firstEntry);
        Map.Entry<String,Integer> lastEntry = tmap2.lastEntry();
        System.out.println("Last Entry: " + lastEntry);
        // Extract a portion of the map containing students whose names fall between two given names.
        SortedMap<String,Integer> submap2 = tmap2.subMap("alice","Charlie");
        System.out.println("Submap view alice - Charlie: " + submap2);
        System.out.println("Original map x2: " + tmap2);
        System.out.println();
/*
        Methods inherited from NavigableMap

        Task 3 – Product Price Lookup
        Description:
        Create a TreeMap of product names and their prices, ordered by price in ascending order, but if prices are equal, order by product name.
        Add at least 7 products.
        Given a price, find the product just cheaper and the product just more expensive than that price.
        Retrieve and display the first and last product in the price list.
        Display products equal to or cheaper than a given price, and products equal to or more expensive than another price.
        Output example:
        All products: {Pen=1.20, Pencil=1.20, Notebook=2.50, Ruler=3.00, Eraser=3.00, Marker=4.50, Bag=12.00}
        Just cheaper than 3.00: Notebook=2.50
        Just more expensive than 3.00: Marker=4.50
        First product: Pen=1.20
        Last product: Bag=12.00
        Cheaper or equal to 3.00: {Pen=1.20, Pencil=1.20, Notebook=2.50, Ruler=3.00, Eraser=3.00}
        More expensive or equal to 4.50: {Marker=4.50, Bag=12.00}
        */
        System.out.println("Task 3:");
        // Create a TreeMap of product names and their prices, ordered by price in ascending order, but if prices are equal, order by product name.
        Comparator<Product> comp3 = new Comparator<>() {
            @Override
            public int compare(Product p1, Product p2) {
                int compResult = p1.compareTo(p2);
                if (compResult == 0) {
                    return p1.name.compareTo(p2.name);
                } else return compResult;
            }
        };
        TreeMap<Product,Integer> tmap3 = new TreeMap<>(comp3);
        // Add at least 7 products.
        tmap3.put(new Product("P1", 100), 10);
        tmap3.put(new Product("P2", 999), 99);
        tmap3.put(new Product("P2", 300), 20);
        tmap3.put(new Product("P3", 300), 30);
        tmap3.put(new Product("P4", 400), 40);
        tmap3.put(new Product("P5", 500), 50);
        tmap3.put(new Product("P6", 600), 60);
        System.out.println("TreeMap: " + tmap3);
        // Given a price, find the product just cheaper and the product just more expensive than that price.
        System.out.println("More expensive than 400: " + tmap3.higherEntry(new Product("", 400))); // More expensive than 400: P4 400=40 ??? why ??? not a ceiling
        System.out.println("Cheaper than 400: " + tmap3.lowerEntry(new Product("", 400)));
        // Display products equal to or cheaper than a given price, and products equal to or more expensive than another price.
        NavigableMap<Product,Integer> nmap = tmap3.headMap(new Product("", 400), true);
        System.out.println("Cheaper and 400: " + nmap);
        nmap = tmap3.tailMap(new Product("", 400), true);
        System.out.println("More expensive and 400: " + nmap);
        System.out.println();

    }

}
