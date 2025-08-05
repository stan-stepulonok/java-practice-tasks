package Set_HashSet_LinkedHashSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Main {

    public static void main(String[] args) {
/*
        Task 1 – Add Elements and Observe Behavior
        Description:
        Create a set and add multiple elements, including some duplicates.
        Observe and print the resulting set to verify how duplicates are handled and whether order is preserved.
        Output Example:
        [Banana, Apple, Orange]
        */
        System.out.println("Task 1:");

        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("999");
        hashSet1.add("123");
        hashSet1.add("567");
        System.out.println("HashSet before: " + hashSet1);
        hashSet1.add("567");
        System.out.println("HashSet + duplicate: " + hashSet1);

        LinkedHashSet<String> linkedHashSet1 = new LinkedHashSet<>();
        linkedHashSet1.add("999");
        linkedHashSet1.add("123");
        linkedHashSet1.add("567");
        System.out.println("LinkedHashSet before: " + linkedHashSet1);
        linkedHashSet1.add("567");
        System.out.println("LinkedHashSet + duplicate: " + linkedHashSet1);

        System.out.println();
/*
        Task 2 – Check Element Presence
        Description:
        Add a few string elements to a set. Then check whether specific elements are present and display the results.
        Output Example:
        Apple is in the set: true
        Mango is in the set: false
*/
        System.out.println("Task 2:");

        String strToCheck2 = "Test";

        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("999");
        hashSet2.add("123");
        hashSet2.add("567");
        hashSet2.add("Test");
        System.out.println("HashSet: " + hashSet2);
        System.out.println(strToCheck2 + " is in the set: " + hashSet2.contains(strToCheck2));

        LinkedHashSet<String> linkedHashSet2 = new LinkedHashSet<>();
        linkedHashSet2.add("999");
        linkedHashSet2.add("123");
        linkedHashSet2.add("567");
        System.out.println("LinkedHashSet: " + linkedHashSet2);
        System.out.println(strToCheck2 + " is in the set: " + linkedHashSet2.contains(strToCheck2));

        System.out.println();

/*
        Task 3 – Remove Elements from the Set
        Description:
        Add several elements, then remove some of them.
        Print the set after each removal to verify the updates.
        Output Example:
        Before removal: [Apple, Banana, Orange]
        After removing Banana: [Apple, Orange]
*/
        System.out.println("Task 3:");

        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("999");
        hashSet3.add("123");
        hashSet3.add("567");
        System.out.println("HashSet before: " + hashSet3);
        hashSet3.remove("567");
        System.out.println("HashSet after removing 567: " + hashSet3);

        LinkedHashSet<String> linkedHashSet3 = new LinkedHashSet<>();
        linkedHashSet3.add("999");
        linkedHashSet3.add("123");
        linkedHashSet3.add("567");
        System.out.println("LinkedHashSet before: " + linkedHashSet3);
        linkedHashSet3.remove("567");
        System.out.println("LinkedHashSet after removing 567: " + linkedHashSet3);

        System.out.println();

/*
        Task 4 – Iterate Over Elements
        Description:
        Add multiple elements to a set, then iterate through it and print each element.
        Repeat the same task using both HashSet and LinkedHashSet to observe differences in iteration order.
        Output Example (HashSet):
        Iteration order: [Banana, Apple, Orange]
        Output Example (LinkedHashSet):
        Iteration order: [Apple, Banana, Orange]
*/
        System.out.println("Task 4:");

        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("999");
        hashSet4.add("123");
        hashSet4.add("567");
        System.out.println("HashSet: " + hashSet4);
        Iterator<String> hashSet4Iter = hashSet4.iterator();
        while (hashSet4Iter.hasNext()) {
            System.out.print(hashSet4Iter.next() + " ");
        }
        System.out.println();

        // DOESN'T PROVIDE LISTITERATOR

        LinkedHashSet<String> linkedHashSet4 = new LinkedHashSet<>();
        linkedHashSet4.add("999");
        linkedHashSet4.add("123");
        linkedHashSet4.add("567");
        System.out.println("LinkedHashSet: " + linkedHashSet4);
        Iterator<String> linkedHashSet4Iter = linkedHashSet4.iterator();
        while (linkedHashSet4Iter.hasNext()) {
            System.out.print(linkedHashSet4Iter.next() + " ");
        }
        System.out.println("\n");

/*
        Task 5 – Set Operations: Union and Intersection
        Description:
        Create two sets with some overlapping elements. Perform union and intersection operations and print the results.
        Output Example:
        Set 1: [Apple, Banana, Orange]
        Set 2: [Banana, Mango, Orange]
        Union: [Apple, Banana, Orange, Mango]
        Intersection: [Banana, Orange]
*/
        System.out.println("Task 5:");

        HashSet<String> hashSet51 = new HashSet<>();
        hashSet51.add("3");
        hashSet51.add("2");
        hashSet51.add("1");
        hashSet51.add("3"); // duplicate not inserted
        System.out.println("HashSet1: " + hashSet51);
        HashSet<String> hashSet52 = new HashSet<>();
        hashSet52.add("5");
        hashSet52.add("4");
        hashSet52.add("3");
        hashSet52.add("2");
        System.out.println("HashSet2: " + hashSet52);
        HashSet<String> hashSet5Union = new HashSet<>();
        hashSet5Union.addAll(hashSet51);
        hashSet5Union.addAll(hashSet52);
        System.out.println("Union hash set: " + hashSet5Union);
        HashSet<String> hashSet5Intersect = new HashSet<>();
        hashSet5Intersect.addAll(hashSet51);
        hashSet5Intersect.retainAll(hashSet52);
        System.out.println("Intersection hash set: " + hashSet5Intersect);

        LinkedHashSet<String> linkedHashSet51 = new LinkedHashSet<>();
        linkedHashSet51.add("3");
        linkedHashSet51.add("2");
        linkedHashSet51.add("1");
        linkedHashSet51.add("3"); // duplicate not inserted
        System.out.println("LinkedHashSet1: " + linkedHashSet51);
        LinkedHashSet<String> linkedHashSet52 = new LinkedHashSet<>();
        linkedHashSet52.add("5");
        linkedHashSet52.add("4");
        linkedHashSet52.add("3");
        linkedHashSet52.add("2");
        System.out.println("LinkedHashSet2: " + linkedHashSet52);
        LinkedHashSet<String> linkedHashSet5Union = new LinkedHashSet<>();
        linkedHashSet5Union.addAll(linkedHashSet51);
        linkedHashSet5Union.addAll(linkedHashSet52);
        System.out.println("Union linked hash set: " + linkedHashSet5Union);
        LinkedHashSet<String> linkedHashSet5Intersect = new LinkedHashSet<>();
        linkedHashSet5Intersect.addAll(linkedHashSet51);
        linkedHashSet5Intersect.retainAll(linkedHashSet52);
        System.out.println("Intersection linked hash set: " + linkedHashSet5Intersect);

/*
        Task 6 – Clear and Check If Empty
        Description:
        Add elements to a set, then clear it and check whether it is empty.
        Output Example:
        Before clear: [Apple, Banana]
        After clear: []
        Is empty: true
*/
        System.out.println("Task 6");

        HashSet<String> hashSet6 = new HashSet<>();
        hashSet6.add("3");
        hashSet6.add("2");
        hashSet6.add("1");
        System.out.println("HashSet: " + hashSet6);
        System.out.println("HashSet size: " + hashSet6.size());
        hashSet6.clear();
        System.out.println("HashSet cleared: " + hashSet6);
        System.out.println("HashSet empty? ... " + hashSet6.isEmpty());

        LinkedHashSet<String> linkedHashSet6 = new LinkedHashSet<>();
        linkedHashSet6.add("3");
        linkedHashSet6.add("2");
        linkedHashSet6.add("1");
        System.out.println("LinkedHashSet: " + linkedHashSet6);
        System.out.println("LinkedHashSet size: " + linkedHashSet6.size());
        linkedHashSet6.clear();
        System.out.println("LinkedHashSet cleared: " + linkedHashSet6);
        System.out.println("LinkedHashSet empty? ... " + linkedHashSet6.isEmpty());
        System.out.println();

    }

}
