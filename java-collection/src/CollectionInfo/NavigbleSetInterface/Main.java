package CollectionInfo.NavigbleSetInterface;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
/*
        Task 1 – Explore Lower and Higher
        Description:
        Add a set of integer elements to a NavigableSet.
        Given a target number, retrieve and display the closest lower and higher elements relative to the target.
        Output Example:
        Elements: [5, 10, 15, 20, 25]
        Target: 18
        Lower than 18: 15
        Higher than 18: 20
        */
        System.out.println("Task 1:");
        NavigableSet<Integer> navSet1 = new TreeSet<>();
        navSet1.add(15);
        navSet1.add(5);
        navSet1.add(10);
        navSet1.add(18);
        navSet1.add(20);
        navSet1.add(25);
        navSet1.add(25); // duplicate, will not be inserted
        System.out.println("Insertion order was: 15 -> 5 -> 10 -> 18 -> 20 -> 25 -> 25 (dupe)");
        System.out.println("Navigable set: " + navSet1);
        Integer target1 = 18;
        System.out.printf("Lower than %d: %d\n", target1, navSet1.lower(target1)); //15
        System.out.printf("Higher than %d: %d\n", target1, navSet1.higher(target1)); // 20
        System.out.println();

/*
        Task 2 – Explore Floor and Ceiling
        Description:
        Insert several string elements into a NavigableSet. For a given query string, find and display the closest floor and ceiling values.
        Output Example:
        Elements: [Apple, Banana, Cherry, Mango, Peach]
        Query: Blueberry
        Floor: Banana
        Ceiling: Cherry
*/
        System.out.println("Task 2:");
        NavigableSet<String> navSet2 = new TreeSet<>();
        navSet2.add("Banana");
        navSet2.add("Peach");
        navSet2.add("Cherry");
        navSet2.add("Apple");
        navSet2.add("Mango");
        System.out.println("Navigable set: " + navSet2);
        String query = "Blueberry"; // not in the set !!!
        System.out.println("Floor for Blueberry -> " + navSet2.floor(query)); // Banana
        System.out.println("Ceiling for Blueberry -> " + navSet2.ceiling(query)); // Cherry
        navSet2.add(query);
        System.out.println("Floor for Blueberry -> " + navSet2.floor(query)); // Blueberry
        System.out.println("Ceiling for Blueberry -> " + navSet2.floor(query)); // Blueberry
        System.out.println();

/*
        Task 3 – Reverse Order View
        Description:
        Populate a NavigableSet with several double values. Display the elements in reverse order.
        Output Example:
        Original set: [1.5, 2.0, 2.5, 3.0, 3.5]
        Descending view: [3.5, 3.0, 2.5, 2.0, 1.5]
*/
        System.out.println("Task 3:");
        NavigableSet<Double> navSet3 = new TreeSet<>();
        navSet3.add(3.0);
        navSet3.add(2.0);
        navSet3.add(1.5);
        navSet3.add(3.5);
        navSet3.add(2.5);
        System.out.println("Original set: " + navSet3);
        NavigableSet<Double> navSetReversed = navSet3.descendingSet();
        System.out.println("Reversed (descending) set: " + navSetReversed);
        System.out.println();
/*
        Task 4 – Remove and Show Extremes
        Description:
        Create a NavigableSet of characters.
        Repeatedly remove and display the lowest and highest elements until the set is empty.
        Output Example:
        Original set: [A, C, E, G, I]
        Poll first: A
        Poll last: I
        Remaining: [C, E, G]
        Poll first: C
        Poll last: G
        Remaining: [E]
        Poll first: E
        Poll last: E
        Remaining: []
*/
        System.out.println("Task 4:");
        NavigableSet<String> navset4 = new TreeSet<>();
        navset4.add("A");
        navset4.add("B");
        navset4.add("C");
        navset4.add("D");
        navset4.add("E"); // middle, last iteration
        navset4.add("F");
        navset4.add("G");
        navset4.add("H");
        navset4.add("I");
        System.out.println("Navset: " + navset4);
        int size4 = navset4.size();
        while (size4 > 0) {
            System.out.println("Iteration done:");
            System.out.println("First: " + navset4.pollFirst());
            System.out.println("Last: " + navset4.pollLast());
            size4 = navset4.size();
        }
        System.out.println();

/*
        Task 5 – Range Views with SubSet
        Description:
        Insert integer elements into a NavigableSet. Display subsets based on a range with inclusive and exclusive bounds.
        Do this for different combinations of bounds.
        Output Example:
        Elements: [10, 20, 30, 40, 50]
        Subset (20 to 50, inclusive): [20, 30, 40]
        Subset (20 to 50, exclusive): [30, 40]
        */
        System.out.println("Task5:");
        NavigableSet<Integer> navset5 = new TreeSet<>();
        navset5.add(20);
        navset5.add(10);
        navset5.add(40);
        navset5.add(50);
        navset5.add(30);
        System.out.println("Navigable set: " + navset5);
        System.out.println("View 20, 30, 40: " + navset5.subSet(20, true, 40, true));
        System.out.println("View 30, 40: " + navset5.subSet(20, false, 50, false));
        System.out.println();

/*
        Task 6 – HeadSet and TailSet Variations
        Description:
        Add several strings to a NavigableSet.
        Display the head and tail sets for a given boundary with different inclusivity options.
        Output Example:
        Elements: [Alpha, Beta, Delta, Gamma, Omega]
        HeadSet before "Gamma" (exclusive): [Alpha, Beta, Delta]
        HeadSet before "Gamma" (inclusive): [Alpha, Beta, Delta, Gamma]
        TailSet from "Delta" (exclusive): [Gamma, Omega]
        TailSet from "Delta" (inclusive): [Delta, Gamma, Omega]
*/
        System.out.println("Task 6:");
        NavigableSet<String> navset6 = new TreeSet<>();
        navset6.add("Delta");
        navset6.add("Omega");
        navset6.add("Gamma");
        navset6.add("Beta");
        navset6.add("Alpha");
        System.out.println("Navigable set: " + navset6);
        System.out.println("HeadSet before \"Gamma\" (exclusive): " + navset6.headSet("Gamma", false)); // up to Gamma excl
        System.out.println("HeadSet before \"Gamma\" (inclusive): " + navset6.headSet("Gamma", true)); // up to Gamma incl
        System.out.println("TailSet before \"Delta\" (exclusive): " + navset6.tailSet("Delta", false)); // from Delta excl
        System.out.println("TailSet before \"Delta\" (inclusive): " + navset6.tailSet("Delta", true)); // from Delta incl
        System.out.println();
/*
        Task 7 – Iterate in Descending Order
        Description:
        Add various string values representing city names. Use descending iteration to print them from highest to lowest in natural order.
        Output Example:
        Edit
        Cities: [Berlin, London, Madrid, Paris, Vienna]
        Descending iteration: [Vienna, Paris, Madrid, London, Berlin]
*/
        System.out.println("Task 7:");
        NavigableSet<String> navset7 = new TreeSet<>();
        navset7.add("Berlin");
        navset7.add("Paris");
        navset7.add("Vienna");
        navset7.add("London");
        navset7.add("Madrid");
        System.out.println("Original set: " + navset7);
        Iterator<String> forwardIterator = navset7.iterator();
        while (forwardIterator.hasNext()) {
            System.out.println(forwardIterator.next());
        }
        System.out.println(".....................");
        Iterator<String> descIterator = navset7.descendingIterator();
        while (descIterator.hasNext()) {
            System.out.println(descIterator.next());
        }
        System.out.println();


    }

}
