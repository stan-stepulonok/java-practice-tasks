package TreeSetClass;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        /*
    Task 1 – Verify Natural Ordering with Strings
    Description:
    Create a TreeSet of several strings (e.g., country names) in random order.
    Check the final order and determine how TreeSet sorts them by default.
    Output Example:
    [Africa, Asia, Europe, North America, Oceania, South America]
    */
        System.out.println("Task 1:");
        TreeSet<String> tset1 = new TreeSet<>();
        tset1.add("North America");
        tset1.add("South America");
        tset1.add("Asia");
        tset1.add("Africa");
        tset1.add("Europe");
        tset1.add("Oceania");
        System.out.println("Insertion order: North America -> South America -> Asia -> Africa -> Europe -> Oceania");
        System.out.println("Tree set: " + tset1);
        System.out.println();

/*
        Task 2 – Custom Comparator for Reverse Alphabetical Order
        Description:
        Create a TreeSet with a custom comparator that stores elements in reverse alphabetical order.
        Add several words and display the final order.
        Output Example:
        [Zebra, Snake, Lion, Elephant, Ant]
        */
        System.out.println("Task 2:");
        Comparator<String> descStrComparator2 = new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.compareTo(s1);
            }
        };

        TreeSet<String> tset2 = new TreeSet<>(descStrComparator2);
        tset2.add("North America");
        tset2.add("South America");
        tset2.add("Asia");
        tset2.add("Africa");
        tset2.add("Europe");
        tset2.add("Oceania");
        System.out.println("Insertion order: North America -> South America -> Asia -> Africa -> Europe -> Oceania");
        System.out.println("Tree set (reversed comparator): " + tset2);
        System.out.println();

/*
        Task 3 – Integers Ordered by Absolute Value (Custom Comparator)
        Description:
        Use a custom comparator to sort a set of integers by their absolute values.
        Add both positive and negative values.
        Output Example:
        [0, -1, 1, -2, 2, -3, 3]
*/
        System.out.println("Task 3:");
        Comparator<Integer> intAbsComp3 = new Comparator<>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                Integer sum = i1 + i2;
                if (sum == 0) {
                    return i1.compareTo(i2);
                }
                else {
                    i1 = Math.abs(i1);
                    i2 = Math.abs(i2);
                    return i1.compareTo(i2);
                }
            }
        };

        TreeSet<Integer> tset3 = new TreeSet<>(intAbsComp3);
        tset3.add(-3);
        tset3.add(-2);
        tset3.add(1);
        tset3.add(2);
        tset3.add(3);
        tset3.add(0);
        tset3.add(-1);
        System.out.println("Tree set absolute values: " + tset3);
        System.out.println();

/*
        Task 4 – Retrieve First and Last Elements
        Description:
        Add several integer values to a TreeSet.
        Determine the smallest and largest elements using appropriate methods.
        Output Example:
        First element: 3
        Last element: 97
        */
        System.out.println("Task 4:");
        TreeSet<Integer> tset4 = new TreeSet<>();
        tset4.add(33);
        tset4.add(11);
        tset4.add(99);
        tset4.add(44);
        System.out.println("Tree set: " + tset4);
        System.out.println("Smallest element (first): " + tset4.first()); // OR getFirst()
        System.out.println("Biggest element (last): " + tset4.last()); // OR getLast()
        System.out.println();
/*
        Task 5 – Subset from a Range (Inclusive and Exclusive)
        Description:
        Create a TreeSet of characters or numbers.
        Extract a subset between two values, experimenting with inclusive and exclusive boundaries.
        Output Example:
        Original set: [a, b, c, d, e, f, g]
        Subset from 'b' (inclusive) to 'f' (exclusive): [b, c, d, e]
        Get a view of elements less than and greater than (or equal to) a given value (HeadSet and TailSet)
*/
        System.out.println("Task 5:");
        TreeSet<Integer> tset5 = new TreeSet<>();
        tset5.add(9);
        tset5.add(1);
        tset5.add(4);
        tset5.add(3);
        tset5.add(6);
        tset5.add(7);
        tset5.add(10);
        tset5.add(8);
        tset5.add(2);
        tset5.add(5);
        System.out.println("TreeSet: " + tset5);

        SortedSet<Integer> heeadSet5 = tset5.headSet(5); // sorted
        System.out.println("SortedSet - headSet 5 default: " + heeadSet5);
        SortedSet<Integer> tailSet5 = tset5.tailSet(5); // sorted
        System.out.println("SortedSet - tailSet 5 default: " + tailSet5);

        NavigableSet<Integer> headSetIncl = tset5.headSet(5, true); // navigable
        System.out.println("NavigableSet - headSet 5 inclusive: " + headSetIncl);
        NavigableSet<Integer> tailSetExcl = tset5.tailSet(5, false); // navigable
        System.out.println("NavigableSet - tailSet 5 exclusive: " + tailSetExcl);

        NavigableSet<Integer> subSetIncl = tset5.subSet(2, true, 5, true); // navigable
        System.out.println("NavigableSet - 2-5 inclusive: " + subSetIncl);
        NavigableSet<Integer> subSetExcl = tset5.subSet(2, false, 5, false); // navigable
        System.out.println("NavigableSet - 2-5 exclusive: " + subSetExcl);

        System.out.println();

/*
        Task 6 – Navigating with Lower, Floor, Ceiling, Higher
        Description:
        Using a TreeSet of integers, find:
        The largest element less than a given value
        The largest element less than or equal to a value
        The smallest element greater than or equal to a value
        The smallest element greater than a value
        Output Example:
        Given: 25
        Lower: 20
        Floor: 20
        Ceiling: 30
        Higher: 30
*/
        System.out.println("Task 6:");
        TreeSet<Integer> tset6 = new TreeSet<>();
        tset6.add(9);
        tset6.add(1);
        tset6.add(4);
        tset6.add(3);
        tset6.add(6);
        tset6.add(7);
        tset6.add(10);
        tset6.add(8);
        tset6.add(2);
        System.out.println("TreeSet: " + tset6);
        Integer intComp = 5;
        System.out.println("Compare integer: " + intComp);
        System.out.println("Higher: " + tset6.higher(intComp));
        System.out.println("Ceiling: " + tset6.ceiling(intComp));
        System.out.println("Lower: " + tset6.lower(intComp));
        System.out.println("Floor: " + tset6.floor(intComp));
        System.out.println("---- Adding 5 .... ----");
        tset6.add(intComp);
        System.out.println("TreeSet: " + tset6);
        System.out.println("Compare integer: " + intComp);
        System.out.println("Higher: " + tset6.higher(intComp));
        System.out.println("Ceiling: " + tset6.ceiling(intComp));
        System.out.println("Lower: " + tset6.lower(intComp));
        System.out.println("Floor: " + tset6.floor(intComp));
        System.out.println();
/*
        Task 7 – Polling First and Last Elements
        Description:
        Create a set with multiple integers.
        Remove the smallest and largest elements using appropriate methods.
        Display the set before and after polling.
        Output Example:
        Original: [10, 20, 30, 40, 50]
        Polled First: 10
        Polled Last: 50
        Remaining: [20, 30, 40]
        */
        System.out.println("Task 7:");
        TreeSet<Integer> tset7 = new TreeSet<>();
        tset7.add(10);
        tset7.add(20);
        tset7.add(30);
        tset7.add(40);
        tset7.add(50);
        System.out.println("Original set: " + tset7);
        System.out.println("Polling first: " + tset7.pollFirst());
        System.out.println("Tree set after polling first: " + tset7);
        System.out.println("Polling last: " + tset7.pollLast());
        System.out.println("Tree set after polling last: " + tset7);
        System.out.println();

/*
        Task 8 – Descending Order View
        Description:
        Create a TreeSet of strings or integers.
        Generate a descending view of the set.
        Output Example:
        Original: [100, 200, 300, 400]
        Descending: [400, 300, 200, 100]
        */
        System.out.println("Task 8:");
        TreeSet<Integer> tset8 = new TreeSet<>();
        tset8.add(100);
        tset8.add(200);
        tset8.add(300);
        tset8.add(400);
        System.out.println("Original set: " + tset8);
        TreeSet<Integer> tsetDescView = (TreeSet<Integer>)tset8.descendingSet(); // nav set
        System.out.println("Descending view: " + tsetDescView);
        System.out.println();

/*
        Task 9 – Comparator vs Natural Order
        Description:
        Create two TreeSets:
        One using natural ordering
        Another using a custom comparator (e.g., by string length or reverse order)
        Add same elements to both and compare the order.
        Output Example:
        Natural order: [Ant, Cat, Dog, Elephant, Gorilla]
        Length-based: [Cat, Dog, Ant, Elephant, Gorilla]
*/
        System.out.println("Task 9:");
        String s1 = "AAA", s2 = "BB", s3 = "C";
        TreeSet<String> natOrderSet9 = new TreeSet<>();
        natOrderSet9.add(s1);
        natOrderSet9.add(s2);
        natOrderSet9.add(s3);
        System.out.println("Natural order set: " + natOrderSet9);

        Comparator<String> comp9 = new Comparator<>() {
            @Override
            public int compare (String s1, String s2) {
                return s1.length() - s2.length();
            }
        };
        TreeSet<String> comparOrderSet9 = new TreeSet<>(comp9);
        comparOrderSet9.add(s1);
        comparOrderSet9.add(s2);
        comparOrderSet9.add(s3);
        System.out.println("Ordered by length: " + comparOrderSet9);
        System.out.println();




    }


}
