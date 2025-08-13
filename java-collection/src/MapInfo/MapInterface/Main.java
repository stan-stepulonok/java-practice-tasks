package MapInfo.MapInterface;

import java.util.*;

public class Main {

    public static void main(String[] args) {

/*
        Task 1 – Add and Retrieve Elements in a Map
        Description:
        Create a map that stores employee IDs (Integer) as keys and their names (String) as values.
        Add at least 5 entries.
        Retrieve and print the name of an employee by a given ID.
        Also, check and print if a particular employee ID exists in the map.
        Output example:
        Employee with ID 102: Alice
        Map contains employee ID 105: true
*/
        System.out.println("Task 1:");
        Map<Integer, String> map1 = new HashMap<>();

        Integer id1 = 100;
        String employee1 = "Employee1";
        map1.put(id1, employee1);
        map1.put(101, "Employee2");
        map1.put(102, "Employee3");
        map1.put(103, "Employee4");
        map1.put(104, "Employee5");

        System.out.println("Map of " + map1.size() + ": " + map1);

        Integer empIdSearch = 103;
        System.out.println("Employee with an id " + empIdSearch + " exists? ... " + map1.containsKey(empIdSearch));
        System.out.println("Employee with an id " + empIdSearch + ": " + map1.get(empIdSearch));

        String empNameSearch = "Employee4";
        System.out.println("Employee with name " + empNameSearch + " exists? ... " + map1.containsValue(empNameSearch));

        System.out.println();

/*
        Task 2 – Update and Remove Entries
        Description:
        Using the map of employee IDs and names, update the name of a specific employee by their ID.
        Then remove an employee entry by ID.
        Print the map before and after these operations to observe the changes.
        Output example:
        Before update and removal: {101=John, 102=Alice, 103=Bob, 104=Mary}
        After update and removal: {101=John, 102=Alicia, 104=Mary}
*/
        System.out.println("Task 2:");
        Map<Integer, String> map2 = new HashMap<>();
        map2.put(0, "Test0");
        map2.put(1, "Test1");
        map2.put(2, "Test2");
        System.out.println("Original map: " + map2);
        System.out.println("Updating entry with id 0 ... " + map2.put(0, "Test000")); // returns element
        System.out.println("Modified map: " + map2);
        System.out.println("Removing entry with id 0 ... " + map2.remove(0)); // returns element
        System.out.println("Modified map: " + map2);
        System.out.println("Removing entry with id 2 ... " + map2.remove(2, "Test2")); // returns boolean
        System.out.println("Modified map: " + map2);
        System.out.println();

/*
        Task 3 – Iterate Over Keys and Values Separately
        Description:
        Iterate over the map’s keys and print them.
        Then iterate over the map’s values and print them.
        This task helps to understand how to access keys and values independently.
        Output example:
        Employee IDs: 101, 102, 103, 104
        Employee Names: John, Alice, Bob, Mary
*/
        System.out.println("Task 3:");
        Map<Integer, String> map3 = new HashMap<>();
        map3.put(1, "Test1");
        map3.put(2, "Test2");
        map3.put(3, "Test3");
        map3.put(4, "Test3");
        System.out.println("Original map: " + map3);

        Set<Integer> keySet3 = map3.keySet();
        System.out.println("Set of keys: " + keySet3);
        Iterator<Integer> iter31 = keySet3.iterator();
        while (iter31.hasNext()) {
            System.out.println(iter31.next());
        }

        Collection<String> valueCollection3 = map3.values();
        System.out.println("Collection of values: " + valueCollection3);
        Iterator<String> iter32 = valueCollection3.iterator();
        while (iter32.hasNext()) {
            System.out.println(iter32.next());
        }

        System.out.println();

/*
        Task 4 – Iterate Using Map.Entry
        Description:
        Iterate through the map entries using the Map.
        Entry interface and print both the keys and values in the format "ID = Name".
        This exercise focuses on working with Map.Entry objects.
        Output example:
        101 = John
        102 = Alice
        103 = Bob
        104 = Mary
*/
        System.out.println("Task 4:");
        Map<Integer, String> map4 = new HashMap<>();
        map4.put(1, "Test1");
        map4.put(2, "Test2");
        map4.put(3, "Test3");
        System.out.println("Original map: " + map4);
        Set< Map.Entry<Integer, String> > entrySet4 = map4.entrySet();
        System.out.println("EntrySet from map: " + entrySet4);
        Iterator<Map.Entry<Integer, String>> iter4 = entrySet4.iterator();
        while (iter4.hasNext()) {
            Map.Entry<Integer, String> entry = iter4.next();
            System.out.println("Entry: " + entry);
            System.out.println("Key: " + entry.getKey());
            System.out.println("Value: " + entry.getValue());
        }
        System.out.println();

/*
        Task 5 – Check for Presence of Key or Value
        Description:
        Check if the map contains a specific employee ID as a key and a specific employee name as a value.
        Print appropriate messages indicating whether they are present or not.
        Output example:
        Map contains employee ID 105: false
        Map contains employee name 'Bob': true
*/
        System.out.println("Task 5:");
        Map<Integer, String> map5 = new HashMap<>();
        map5.put(1, "Test1");
        map5.put(2, "Test2");
        map5.put(3, "Test3");
        System.out.println("Original map: " + map5);
        Integer key5 = 2;
        String value5 = "Test1";
        System.out.println("Entry with key " + key5 + " exists? ..." + map5.containsKey(key5));
        System.out.println("Entry with value " + value5 + " exists? ..." + map5.containsValue(value5));
        System.out.println();

/*
        Task 6 – Clear Map and Check If Empty
        Description:
        Clear all entries from the map.
        Then check if the map is empty and print the result.
        Output example:
        Map cleared. Is map empty? true
*/
        System.out.println("Task 6:");
        Map<String, String> map6 = new HashMap<>();
        map6.put("Key1", "Value1");
        map6.put("Key2", "Value2");
        map6.put("Key3", "Value3");
        System.out.println("Original map: " + map6);
        System.out.println("Clearing the map ... ");
        map6.clear();
        System.out.println("Cleared map: " + map6);
        System.out.println("Is map empty? ... " + map6.isEmpty());
        System.out.println();

/*
        Task 7 – Size of Map
        Description:
        Print the size of the map (number of entries) before and after adding and removing elements.
        Output example:
        Initial map size: 4
        Map size after adding an entry: 5
        Map size after removing an entry: 4
*/
        System.out.println("Task 7:");
        Map<String, String> map7 = new HashMap<>();
        map7.put("K1", "V1");
        map7.put("K2", "V2");
        map7.put("K3", "V3");
        System.out.println("Map: " + map7);
        System.out.println("Map size: " + map7.size());
        map7.put("K4", "V4");
        System.out.println("Map + 1: " + map7);
        System.out.println("Map size + 1: " + map7.size());
        map7.remove("K4", "V4");
        System.out.println("Map - 1: " + map7);
        System.out.println("Map size - 1: " + map7.size());
        System.out.println();

    }



}
