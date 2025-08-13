package CollectionInfo.SortedSetInterface;

import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
/*
        Task 1 – Add Elements and Verify Natural Ordering
        Description:
        Create a sorted set of string elements representing fruit names. Add several values in arbitrary order.
        Display the set to confirm that elements are stored in their natural sorted order.
        Output Example:
        [Apple, Banana, Kiwi, Orange, Pear]
        */
        System.out.println("Task 1:");
        SortedSet<String> sset1 = new TreeSet<>();
        sset1.add("Orange");
        sset1.add("Banana");
        sset1.add("Pear");
        sset1.add("Apple");
        sset1.add("Kiwi");
        sset1.add("Kiwi"); // duplicate
        System.out.println("Order of adding elements was: Orange -> Banana -> Pear -> Apple -> Kiwi -> Kiwi (dupe)");
        System.out.println("Sorted set: " + sset1);
        System.out.println();

/*
        Task 2 – Retrieve First and Last Elements
        Description:
        Using the same set of fruits, retrieve and display the first and last elements in the set according to natural ordering.
        Output Example:
        First element: Apple
        Last element: Pear
*/
        System.out.println("Task 2:");
        SortedSet<String> sset2 = new TreeSet<>();
        sset2.add("Orange");
        sset2.add("Banana");
        sset2.add("Pear");
        sset2.add("Apple");
        sset2.add("Kiwi");
        sset2.add("Kiwi"); // duplicate
        System.out.println("Order of adding elements was: Orange -> Banana -> Pear -> Apple -> Kiwi -> Kiwi (dupe)");
        System.out.println("Sorted set: " + sset2);
        System.out.println("First Element: " + sset2.first());
        System.out.println("Last Element: " + sset2.last());
        System.out.println();

/*
        Task 3 – Extract a Subset Within a Range
        Description:
        Display a view of the set that includes only elements between two given values (inclusive of lower, exclusive of upper bound).
        Use alphabetical values that have results in between.
        Output Example:
        Subset from Banana to Orange: [Banana, Kiwi]
*/
        System.out.println("Task 3:");
        SortedSet<String> sset3 = new TreeSet<>();
        sset3.add("Orange");
        sset3.add("Banana");
        sset3.add("Pear");
        sset3.add("Apple");
        sset3.add("Kiwi");
        sset3.add("Kiwi"); // duplicate
        System.out.println("Order of adding elements was: Orange -> Banana -> Pear -> Apple -> Kiwi -> Kiwi (dupe)");
        System.out.println("Sorted set: " + sset3);
        SortedSet<String> sset3Subset = sset3.subSet("Banana", "Orange");
        System.out.println("Subset (view): " + sset3Subset);
        sset3Subset.remove(sset3Subset.first()); // removed from view
        System.out.println("Subset (view): " + sset3Subset);
        System.out.println("Sorted set: " + sset3);
        System.out.println();

/*
        Task 4 – Head Set and Tail Set Views
        Description:
        Display a view of the set that includes:
        All elements strictly less than a given value
        All elements greater than or equal to a given value
        Output Example:
        Head set before Kiwi: [Apple, Banana]
        Tail set from Kiwi: [Kiwi, Orange, Pear]
*/
        System.out.println("Task 4:");
        SortedSet<Integer> sset4 = new TreeSet<>();
        sset4.add(4);
        sset4.add(2);
        sset4.add(3);
        sset4.add(1);
        sset4.add(5);
        System.out.println("Sorted Set: " + sset4);
        SortedSet<Integer> headView = sset4.headSet(3); // up to
        System.out.println("Head set: " + headView);
        SortedSet<Integer> tailView = sset4.tailSet(3); // start from
        System.out.println("Tail set: " + tailView);
        System.out.println();

/*
        Task 5 – Use a Custom Class with Natural Ordering
        Description:
        Create a sorted set of custom objects (e.g., persons with a name and age). Ensure they sort based on natural ordering defined in the class (e.g., name ascending). Add several elements and print the set.
        Output Example:
        [Anna(23), Bob(31), Charlie(19)]
*/
        System.out.println("Task 5:");

        Person p1 = new Person("A", 20);
        Person p2 = new Person("A", 40);
        Person p3 = new Person("B", 22);
        Person p4 = new Person("D", 30);

        SortedSet<Person> sset5Comparable = new TreeSet<>();
        sset5Comparable.add(p4);
        sset5Comparable.add(p1);
        sset5Comparable.add(p3);
        sset5Comparable.add(p2);
        System.out.println("Set sorted by comparable age: " + sset5Comparable);

        Comparator<Person> custComp5 = new Comparator<>() {
            @Override
            public int compare(Person p1, Person p2) {
                int nameCompResult = p1.getName().compareTo(p2.getName());
                if (nameCompResult == 0) {
                    return p1.compareTo(p2);
                }
                return nameCompResult;
            }
        };

        SortedSet<Person> sset5Comparator = new TreeSet<>(custComp5);
        sset5Comparator.add(p4);
        sset5Comparator.add(p1);
        sset5Comparator.add(p3);
        sset5Comparator.add(p2);
        System.out.println("Set sorted by comparator name -> age: " + sset5Comparator);
        System.out.println();

/*
        Task 6 – Iterate in Ascending and Descending Order
        Description:
        Display all elements in the sorted set in natural order and then in reverse order.
        Output Example:
        Ascending: [Apple, Banana, Kiwi, Orange, Pear]
        Descending: [Pear, Orange, Kiwi, Banana, Apple]
*/
        System.out.println("Task 6:");
        SortedSet<String> sset6Default = new TreeSet<>();
        sset6Default.add("Kiwi");
        sset6Default.add("Pear");
        sset6Default.add("Orange");
        sset6Default.add("Apple");
        sset6Default.add("Banana");
        System.out.println("Default sorted set: " + sset6Default);
        Iterator<String> iter61 = sset6Default.iterator();
        while (iter61.hasNext()) {
            System.out.print(iter61.next() + " ");
        }
        System.out.println();

        Comparator<String> custComp6 = new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                int nameCompResult = s2.compareTo(s1);
                return nameCompResult;
            }
        };
        SortedSet<String> sset6Custom = new TreeSet<>(custComp6);
        sset6Custom.add("Kiwi");
        sset6Custom.add("Pear");
        sset6Custom.add("Orange");
        sset6Custom.add("Apple");
        sset6Custom.add("Banana");
        System.out.println("Reversed sorted set: " + sset6Custom);
        Iterator<String> iter62 = sset6Custom.iterator();
        while (iter62.hasNext()) {
            System.out.print(iter62.next() + " ");
        }
        System.out.println("\n");

/*
        Task 7 – Remove a Range of Elements
        Description:
        Remove a range of elements from the sorted set using a view that includes a specific subset range. Then display the set to confirm changes.
        Output Example:
        Before: [Apple, Banana, Kiwi, Orange, Pear]
        After removing Banana to Orange: [Apple, Orange, Pear]
*/
        System.out.println("Task 7:");
        SortedSet<String> sset7 = new TreeSet<>();
        sset7.add("Test5");
        sset7.add("Test4");
        sset7.add("Test1");
        sset7.add("Test3");
        sset7.add("Test2");
        System.out.println("Sorted Set: " + sset7);
        SortedSet<String> sset7ViewToRemove = sset7.subSet("Test2" , "Test4");
        System.out.println("View to remove: " + sset7ViewToRemove);
        // sset7.removeAll(sset7ViewToRemove); // ConcurrentModificationException
        SortedSet<String> sset7Copy = new TreeSet<>();
        sset7Copy.addAll(sset7);
        sset7Copy.removeAll(sset7ViewToRemove);
        sset7 = sset7Copy;
        System.out.println("Sorted Set Removed: " + sset7);
        System.out.println();


    }

}
