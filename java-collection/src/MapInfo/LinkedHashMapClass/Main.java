package MapInfo.LinkedHashMapClass;

import java.util.*;

public class Main {

    public static void main(String[] args) {
/*

        Tasks with the Focus on Map Methods

        Task 1 – Employee Directory Management
        Create an employee directory where each employee has a unique ID and a name.
        Perform the following steps in order:
        Add at least five employees.
        Display all IDs and names.
        Check if a certain ID exists and print the result.
        Check if a certain name exists and print the result.
        Retrieve and display the name of an employee by their ID.
        Remove an employee by ID and display the removed employee’s details.
        Replace the name of an employee for a given ID.
        Display the final list of employees and the total number of entries.
        Output example:
        Initial directory: {101=Alice, 102=Bob, 103=Charlie, 104=David, 105=Eve}
        Contains ID 103: true
        Contains name "Zara": false
        Employee with ID 104: David
        Removed employee: 102=Bob
        Updated employee with ID 105: Eve -> Evelyn
        Final directory: {101=Alice, 103=Charlie, 104=David, 105=Evelyn}
        Total entries: 4
*/
        System.out.println("Task 1:");
        LinkedHashMap<Integer,String> lhmap1 = new LinkedHashMap<>();
        // Add at least five employees.
        lhmap1.put(1, "Emp1");
        lhmap1.put(2, "Emp2");
        lhmap1.put(3, "Emp3");
        lhmap1.put(4, "Emp4");
        lhmap1.put(5, "Emp5");
        System.out.println("Original map: " + lhmap1);
        // Display all IDs and names.
        Set<Integer> empIds = lhmap1.keySet();
        System.out.println("Employee IDs: " + empIds);
        Collection<String> empNames = lhmap1.values();
        System.out.println("Employee names: " + empNames);
        // Check if a certain ID exists and print the result.
        Integer idToCheck = 4;
        System.out.println("Is employee with id " + idToCheck + " exists? ... " + lhmap1.containsKey(idToCheck));
        // Check if a certain name exists and print the result.
        String nameToCheck = "Emp3";
        System.out.println("Is employee with name " + nameToCheck + " exists? ... " + lhmap1.containsValue(nameToCheck));
        // Retrieve and display the name of an employee by their ID.
        System.out.println("Employee with id " + idToCheck + " has the name: " + lhmap1.get(idToCheck));
        // Replace the name of an employee for a given ID.
        System.out.println("Modify name of employee " + idToCheck + ":");
        lhmap1.put(idToCheck, "Renamed4");
        System.out.println("Employee after renaming: " + lhmap1.get(idToCheck));
        // Display the final list of employees and the total number of entries.
        System.out.println("Modified Map: " + lhmap1);
        System.out.println("Map size: " + lhmap1.size());
        System.out.println();


        /*
        Tasks with the Focus on HashMap Methods

        Task 2 – Bulk Operations and Default Retrievals
        Create a product catalog where keys are product codes and values are product names.
        Perform the following actions:
        Initialize the catalog with at least four products in a single operation.
        Retrieve the name for a code that does not exist, providing a default message.
        Add a product only if the given code is not already present.
        Merge two catalogs into one.
        Remove a product only if both the code and name match the ones provided.
        Compute a new value for an existing product code.
        Display the final catalog.
         */
        System.out.println("Task 2:");
        // Initialize the catalog with at least four products in a single operation.
        LinkedHashMap<Integer, String> lhm2 = new LinkedHashMap<>(Map.of(
                1, "Pr1",
                2, "Pr2",
                3, "Pr3",
                4, "Pr4"
        ));
        System.out.println("Original map: " + lhm2);
        // Retrieve the name for a code that does not exist, providing a default message.
        System.out.println(lhm2.getOrDefault(1, "Product doesn't exist")); // exists
        System.out.println(lhm2.getOrDefault(999, "Product doesn't exist")); // doesn't exist
        // Add a product only if the given code is not already present.
        System.out.println(lhm2.putIfAbsent(1, "Pr5")); // not absent, fail
        System.out.println(lhm2.putIfAbsent(5, "Pr5")); // absent, success
        // Merge two catalogs into one.
        LinkedHashMap<Integer, String> lhm2Extra = new LinkedHashMap<>();
        lhm2Extra.put(6, "Pr6");
        lhm2.putAll(lhm2Extra);
        System.out.println("New map: " + lhm2Extra);
        System.out.println("Merged map: " + lhm2);
        // Remove a product only if both the code and name match the ones provided.
        lhm2.remove(1, "Pr1");
        System.out.println("Removed product 1: " + lhm2);
        // Compute a new value for an existing product code.
        lhm2.replace(6, "Pr666");
        System.out.println("Modified: " + lhm2);
        System.out.println();


        // Tasks with the Focus on removeEldestEntry and Access-Ordered / Insertion-Ordered

/*
        Task 3 – Insertion-Ordered Access Log
        Create an access log for users visiting a system.
        Add visits from at least five different users in sequence.
        Display the log to confirm insertion order.
        Access one of the earlier entries and display the log again to show that order is unchanged.
        Output example:
        Initial log: {U01=Alice, U02=Bob, U03=Charlie, U04=David, U05=Eve}
        Accessed user U02: Bob
        Log after access (insertion-ordered): {U01=Alice, U02=Bob, U03=Charlie, U04=David, U05=Eve}
*/
        System.out.println("Task 3:");
        LinkedHashMap<Integer,String> lhm3 = new LinkedHashMap<>();
        lhm3.put(1,"Us1");
        lhm3.put(2,"Us2");
        lhm3.put(3,"Us3");
        System.out.println("Insertion ordered map: " + lhm3);
        System.out.println("Get eldest: " + lhm3.get(1)); // get operation
        System.out.println("Insertion order not changed: " + lhm3);
        System.out.println();

/*
        Task 4 – Access-Ordered Cache with Size Limit
        Create a small cache for recently accessed documents, configured to reorder entries on access and automatically remove the oldest entry when size exceeds 3.
        Add four documents in sequence.
        Display the cache after each insertion.
        Access one of the earlier documents and display the cache to show reordering.
        Add another document and display the cache to confirm that the oldest is removed.
        Output example:
        After adding D01: {D01=Doc1}
        After adding D02: {D01=Doc1, D02=Doc2}
        After adding D03: {D01=Doc1, D02=Doc2, D03=Doc3}
        After adding D04 (removal triggered): {D02=Doc2, D03=Doc3, D04=Doc4}
        Accessed D02: Doc2
        Cache after access: {D03=Doc3, D04=Doc4, D02=Doc2}
        After adding D05 (removal triggered): {D04=Doc4, D02=Doc2, D05=Doc5}
*/
        System.out.println("Task 4:");
        LinkedHashMap<Integer,String> lhm4 = new LinkedHashMap<>(5, 1,true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, String> eldestEntry) {
                return this.size() > 5;
            }
        };
        System.out.println("Initial state of Access-Ordered map: " + lhm4);
        lhm4.put(1, "Log1");
        System.out.println("After first insertion: " + lhm4);
        lhm4.put(2, "Log2");
        System.out.println("After second insertion: " + lhm4);
        lhm4.put(3, "Log3");
        System.out.println("After third insertion: " + lhm4);
        System.out.println("Get first element: " + lhm4.get(1)); // get operation
        System.out.println("After get 1 operation: " + lhm4);


    }

}
