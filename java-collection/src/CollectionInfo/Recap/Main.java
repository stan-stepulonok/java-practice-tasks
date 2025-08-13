package CollectionInfo.Recap;

import java.util.*;

public class Main {

    public static void main(String[] args) {
/*
        Task 1 – Compare Element Insertion Order
        Focus: ArrayList, LinkedList, HashSet, LinkedHashSet, TreeSet
        Description:
        Add the same set of elements to each collection type in random order.
        Print each collection and analyze how insertion order is preserved (or not).
        Observe the ordering behavior of each class.
        Output Example:
        ArrayList: [Zebra, Apple, Mango, Banana]
        LinkedList: [Zebra, Apple, Mango, Banana]
        HashSet: [Apple, Banana, Mango, Zebra]
        LinkedHashSet: [Zebra, Apple, Mango, Banana]
        TreeSet: [Apple, Banana, Mango, Zebra]
        */
        System.out.println("Task 1:");
        String s1 = "B", s2 = "A", s3 = "D", s4 = "C";
        System.out.println("Insertion order: " + s1 + " " + s2 + " " + s3 + " " + s4);
        ArrayList<String> arrlist1 = new ArrayList<>();
        arrlist1.add(s1);
        arrlist1.add(s2);
        arrlist1.add(s3);
        arrlist1.add(s4);
        System.out.println("ArrayList: " + arrlist1); // insertion order
        LinkedList<String> llist1 = new LinkedList<>();
        llist1.add(s1);
        llist1.add(s2);
        llist1.add(s3);
        llist1.add(s4);
        System.out.println("LinkedList: " + llist1); // insertion order
        HashSet<String> hset1 = new HashSet<>();
        hset1.add(s1);
        hset1.add(s2);
        hset1.add(s3);
        hset1.add(s4);
        System.out.println("HashSet: " + hset1); // hash function results order (most likely abcd)
        LinkedHashSet<String> lhset1 = new LinkedHashSet<>();
        lhset1.add(s1);
        lhset1.add(s2);
        lhset1.add(s3);
        lhset1.add(s4);
        System.out.println("LinkedHashSet: " + lhset1); // insertion order
        TreeSet<String> tset1 = new TreeSet<>();
        tset1.add(s1);
        tset1.add(s2);
        tset1.add(s3);
        tset1.add(s4);
        System.out.println("TreeSet: " + tset1); // natural order, asc
        System.out.println();

/*
        Task 2 – Duplicate Handling Verification
        Focus: ArrayList, LinkedList, HashSet, LinkedHashSet, TreeSet
        Description:
        Insert duplicate elements into each collection. Observe and compare how duplicates are treated by different collection types.
        Output Example:
        ArrayList: [A, B, A, C]
        LinkedList: [A, B, A, C]
        HashSet: [A, B, C]
        LinkedHashSet: [A, B, C]
        TreeSet: [A, B, C]
*/
        System.out.println("Task 2:");
        ArrayList<String> arrlist2 = new ArrayList<>();
        arrlist2.add("A");
        arrlist2.add("B");
        arrlist2.add("B"); // duplicate
        System.out.println("ArrayList with duplicates: " + arrlist2); // allowed
        LinkedList<String> llist2 = new LinkedList<>();
        llist2.add("A");
        llist2.add("B");
        llist2.add("B"); // duplicate
        System.out.println("LinkedList with duplicates: " + llist2); // allowed
        HashSet<String> hset2 = new HashSet<>();
        hset2.add("A");
        hset2.add("B");
        hset2.add("B"); // duplicate
        System.out.println("HashSet with duplicates: " + hset2); // not allowed
        LinkedHashSet<String> lhset2 = new LinkedHashSet<>();
        lhset2.add("A");
        lhset2.add("B");
        lhset2.add("B"); // duplicate
        System.out.println("LinkedHashSet with duplicates: " + lhset2); // not allowed
        TreeSet<String> tset2 = new TreeSet<>();
        tset2.add("A");
        tset2.add("B");
        tset2.add("B"); // duplicate
        System.out.println("TreeSet with duplicates: " + tset2); // not allowed
        System.out.println();

/*
        Task 3 – Performance-Oriented Use Case
        Focus: ArrayList, LinkedList
        Description:
        Simulate a use case where frequent insertions are made at both the beginning and the end of a list.
        Compare the overall structure and performance suitability of each list implementation based on the task scenario.
        Output Example:
        Use case: Insert at both ends
        ArrayList: Less efficient
        LinkedList: More efficient
*/
        System.out.println("Task 3:");

        ArrayList<String> arrList3 = new ArrayList<>(20);
        arrList3.add("test");
        arrList3.add("test");
        arrList3.add("test");
        arrList3.add("test");

        LinkedList<String> llist3 = new LinkedList<>();
        llist3.add("test");
        llist3.add("test");
        llist3.add("test");
        llist3.add("test");

        long start, end, operationLength;

        System.out.println("Add first:");
        // ✅ Conclusion: Despite raw numbers, LinkedList scales better for many front-insertions. With more elements, the performance gap would widen in favor of LinkedList.
        // array - add
        start = System.nanoTime();
        arrList3.add(0, "1");
        end = System.nanoTime();
        operationLength = end - start;
        System.out.println("ArrayList - add(index): " + operationLength);
        // linked - add
        start = System.nanoTime();
        llist3.add(0,"1");
        end = System.nanoTime();
        operationLength = end - start;
        System.out.println("LinkedList - add(index): " + operationLength);
        // linked - addFirst
        start = System.nanoTime();
        llist3.addFirst("1");
        end = System.nanoTime();
        operationLength = end - start;
        System.out.println("LinkedList - addFirst(): " + operationLength);
        // linked - offerFirst
        start = System.nanoTime();
        llist3.offerFirst("1");
        end = System.nanoTime();
        operationLength = end - start;
        System.out.println("LinkedList - offerFirst(): " + operationLength);

        System.out.println("Add last:");
        // ✅ Conclusion: Both perform well at the end, but ArrayList wins slightly when growing in bulk thanks to better memory locality.
        // array - add
        start = System.nanoTime();
        arrList3.add(arrList3.size()-1, "999");
        end = System.nanoTime();
        operationLength = end - start;
        System.out.println("ArrayList - add(index): " + operationLength);
        // linked - add
        start = System.nanoTime();
        llist3.add(arrList3.size()-1,"999");
        end = System.nanoTime();
        operationLength = end - start;
        System.out.println("LinkedList - add(index): " + operationLength);
        // linked - addFirst
        start = System.nanoTime();
        llist3.addLast("999");
        end = System.nanoTime();
        operationLength = end - start;
        System.out.println("LinkedList - addLast(): " + operationLength);
        // linked - offerFirst
        start = System.nanoTime();
        llist3.offerLast("999");
        end = System.nanoTime();
        operationLength = end - start;
        System.out.println("LinkedList - offerLast(): " + operationLength);

        System.out.println("Add middle:");
        // array - add
        start = System.nanoTime();
        arrList3.add(arrList3.size()/2, "444");
        end = System.nanoTime();
        operationLength = end - start;
        System.out.println("ArrayList - add(index): " + operationLength);
        // linked - add
        start = System.nanoTime();
        llist3.add(arrList3.size()/2,"444");
        end = System.nanoTime();
        operationLength = end - start;
        System.out.println("LinkedList - add(index): " + operationLength);
        System.out.println();

/*
        Task 4 – Sort and Retrieve Extremes
        Focus: TreeSet, SortedSet, NavigableSet
        Description:
        Add a set of numerical or string values.
        Retrieve and print the smallest and largest elements.
        Also explore nearest higher and lower values to a given input.
        Output Example:
        TreeSet: [5, 10, 15, 20, 25]
        First: 5
        Last: 25
        Lower than 15: 10
        Higher than 15: 20
         */
        System.out.println("Task 4:");
        TreeSet<Integer> tset4 = new TreeSet<>();
        tset4.add(10);
        tset4.add(25);
        tset4.add(20);
        tset4.add(5);
        tset4.add(15);
        System.out.println("Tree set: " + tset4);
        System.out.println("First: " + tset4.first());
        System.out.println("First: " + tset4.first());
        System.out.println("Last: " + tset4.last());
        Integer intSearch = 14;
        System.out.println("Value to compare: " + intSearch);
        System.out.println("Lower: " + tset4.lower(intSearch));
        System.out.println("Floor: " + tset4.floor(intSearch));
        System.out.println("Higher: " + tset4.higher(intSearch));
        System.out.println("Ceiling: " + tset4.ceiling(intSearch));
        intSearch = 15;
        System.out.println("Value to compare: " + intSearch);
        System.out.println("Lower: " + tset4.lower(intSearch));
        System.out.println("Floor: " + tset4.floor(intSearch));
        System.out.println("Higher: " + tset4.higher(intSearch));
        System.out.println("Ceiling: " + tset4.ceiling(intSearch));
        System.out.println();

/*
        Task 5 – Positional vs. Non-Positional Access
        Focus: ArrayList, LinkedList, HashSet, TreeSet
        Description:
        Demonstrate access to a specific element by position (index-based access) versus collections that don't support this.
        Reflect on usability differences.
        Output Example:
        ArrayList (element at index 2): Mango
        LinkedList (element at index 2): Mango
        HashSet: Unsupported operation
        TreeSet: Unsupported operation
*/
        System.out.println("Task 5:");
        String s51 = "Test1";
        String s52 = "Test2";
        int searchIndex = 1;

        ArrayList<String> arrList5 = new ArrayList<>();
        arrList5.add(0, s51);
        arrList5.add(1, s52);
        System.out.println("ArrayList (index 1): " + arrList5.get(searchIndex));

        LinkedList<String> llist5 = new LinkedList<>();
        llist5.offer(s51);
        llist5.offer(s52);
        System.out.println("Linked (index 1): " + llist5.get(searchIndex));

        HashSet<String> hset5 = new HashSet<>();
        hset5.add(s51);
        hset5.add(s52);
        Iterator<String> hset5Iter = hset5.iterator();
        int counter = 0;
        while (hset5Iter.hasNext() && counter <= searchIndex) {
            if (counter == searchIndex) {
                System.out.println("HashSet (index 1 with iterator only): " + hset5Iter.next());
            }
            counter++;
        }

        TreeSet<String> tset5 = new TreeSet<>();
        tset5.add(s51);
        tset5.add(s52);
        counter = 0;
        Iterator<String> tset5Iter = tset5.iterator();
        while (tset5Iter.hasNext() && counter <= searchIndex) {
            if (counter == searchIndex) {
                System.out.println("HashSet (index 1 with iterator only): " + tset5Iter.next());
            }
            counter++;
        }

        System.out.println();

/*
        Task 6 – Conversion Between Collections
        Focus: ArrayList, HashSet, TreeSet, LinkedHashSet
        Description:
        Convert between different collection types (e.g., from List to Set, Set to List, etc.).
        Observe how duplicates are affected, and how ordering may change in each transformation.
        Output Example:
        Original ArrayList: [C, B, A, B, C]
        Converted to HashSet: [A, B, C]
        Converted to TreeSet: [A, B, C]
        Converted to LinkedHashSet: [C, B, A]
        */
        System.out.println("Task 6:");
        ArrayList<String> arrList6 = new ArrayList<>();
        arrList6.add("C");
        arrList6.add("A");
        arrList6.add("B");
        arrList6.add("C");
        arrList6.add("B");
        System.out.println("Array List -> " + arrList6);
        LinkedHashSet<String> lhs6 = new LinkedHashSet<>(arrList6);
        System.out.println("LinkedHashSet from ArrayList -> " + lhs6); // remove duplicates, order remained
        HashSet<String> hs6 = new HashSet<>(arrList6);
        System.out.println("HashSet from ArrayList -> " + hs6); // remove duplicates, order by hash function
        TreeSet<String> ts6 = new TreeSet<>(arrList6);
        System.out.println("TreeSet from ArrayList -> " + ts6); // remove duplicates, order by string comparable asc
        System.out.println();

/*
        Task 7 – Null Handling Behavior
        Focus: ArrayList, LinkedList, HashSet, LinkedHashSet, TreeSet
        Description:
        Attempt to add null values to each collection.
        Observe whether nulls are allowed and if so, how many and where they appear.
        Output Example:
        ArrayList: [null, A, B, null]
        LinkedList: [null, A, B, null]
        HashSet: [A, B, null]
        LinkedHashSet: [null, A, B]
        TreeSet: Throws NullPointerException
*/
        System.out.println("Task 7:");

        try {

            ArrayList<String> arrList7 = new ArrayList<>();
            arrList7.add("Test 1");
            arrList7.add(null);
            arrList7.add("Test 3");
            arrList7.add(null);
            System.out.println("ArrayList: " + arrList7);

            LinkedList<String> llist7 = new LinkedList<>();
            llist7.add("Test 1");
            llist7.add(null);
            llist7.add("Test 3");
            llist7.add(null);
            System.out.println("LinkedList: " + llist7);

            HashSet<String> hset7 = new HashSet<>();
            hset7.add("Test 1");
            hset7.add(null);
            hset7.add("Test 3");
            hset7.add(null);
            System.out.println("HashSet: " + hset7);

            TreeSet<String> tset7 = new TreeSet<>();
            tset7.add("Test 1");
            tset7.add(null);
            tset7.add("Test 3");
            tset7.add(null);
            System.out.println("TreeSet: " + tset7);

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        System.out.println();

/*
        Task 8 – Iteration Order Consistency
        Focus: HashSet, LinkedHashSet, TreeSet
        Description:
        Insert a set of items and iterate over them multiple times.
        Check if iteration order remains consistent and predictable in each type.
        Output Example:
        HashSet (iteration 1): [C, A, B]
        HashSet (iteration 2): [B, A, C]
        LinkedHashSet (both iterations): [A, B, C]
        TreeSet (both iterations): [A, B, C]
*/
        System.out.println("Task 8:");

        HashSet<String> hset8 = new HashSet<>();
        // When you iterate over a HashSet multiple times without modifying it, you will usually get the same order — within a single JVM execution.
        // This happens because:
        // The internal hash table structure remains stable as long as the set isn't changed.
        // The iteration order depends on the hash codes and how elements are arranged in the backing table.
        // Once constructed and not mutated, the internal structure doesn't change → same iteration order.
        hset8.add("A222");
        hset8.add("A223");
        hset8.add("A224");
        hset8.add("A225");
        hset8.add("A226");
        System.out.println("HashSet: " + hset8);
        Iterator<String> collectionIterator8 = hset8.iterator();
        System.out.println("HashSet (iteration 1):");
        while (collectionIterator8.hasNext()) {
            System.out.print(collectionIterator8.next() + " ");
        }
        System.out.println();
        collectionIterator8 = hset8.iterator();
        System.out.println("HashSet (iteration 2):");
        while (collectionIterator8.hasNext()) {
            System.out.print(collectionIterator8.next() + " ");
        }
        System.out.println("\n");

        LinkedHashSet<String> lhset8 = new LinkedHashSet<>();
        // always the same
        lhset8.add("B");
        lhset8.add("A");
        lhset8.add("C");
        System.out.println("LinkedHashSet: " + lhset8);
        collectionIterator8 = lhset8.iterator();
        System.out.println("LinkedHashSet (iteration 1):");
        while (collectionIterator8.hasNext()) {
            System.out.print(collectionIterator8.next() + " ");
        }
        System.out.println();
        collectionIterator8 = lhset8.iterator();
        System.out.println("LinkedHashSet (iteration 1):");
        while (collectionIterator8.hasNext()) {
            System.out.print(collectionIterator8.next() + " ");
        }
        System.out.println("\n");

        TreeSet<String> tset8 = new TreeSet<>();
        // always the same
        tset8.add("B");
        tset8.add("A");
        tset8.add("C");
        System.out.println("TreeSet: " + tset8);
        collectionIterator8 = tset8.iterator();
        System.out.println("TreeSet (iteration 1):");
        while (collectionIterator8.hasNext()) {
            System.out.print(collectionIterator8.next() + " ");
        }
        System.out.println();
        collectionIterator8 = tset8.iterator();
        System.out.println("TreeSet (iteration 1):");
        while (collectionIterator8.hasNext()) {
            System.out.print(collectionIterator8.next() + " ");
        }
        System.out.println("\n");

/*
        Task 9 – Insert at Specific Index
        Focus: ArrayList
        Description:
        Insert elements at specific positions in the list (e.g., start, middle, end). Check how the elements shift.
        Output Example:
        Initial ArrayList: [Apple, Orange]
        After insert at index 1: [Apple, Banana, Orange]
*/
        System.out.println("Task 9:");
        ArrayList<String> arrList9 = new ArrayList<>();
        arrList9.add("X");
        arrList9.add("X");
        arrList9.add("X");
        System.out.println("Initial list: " + arrList9);
        arrList9.add(0, "zero");
        arrList9.add(1, "one");
        arrList9.add(arrList9.size(), "last");
        System.out.println("Modified list: " + arrList9);
        System.out.println();
/*
        Task 10 – Add First and Last
        Focus: LinkedList
        Description:
        Use methods to insert elements explicitly at the start and end of the list. Verify how these methods behave compared to regular add operations.
        Output Example:
        Initial LinkedList: [B]
        After addFirst("A"): [A, B]
        After addLast("C"): [A, B, C]
        */
        System.out.println("Task 10:");
        LinkedList<String> llist10 = new LinkedList<>();
        llist10.add("X");
        llist10.add("X");
        llist10.add("X");
        llist10.add("X");
        System.out.println("Initial LinkedList: " + llist10);
        // first
        llist10.add(0, "First1");
        llist10.addFirst("First2");
        llist10.offerFirst("First3");
        System.out.println("Added First LinkedList: " + llist10);
        // last
        llist10.add("Last1");
        llist10.addLast("Last2");
        llist10.offerLast("Last3");
        System.out.println("Added Last LinkedList: " + llist10);
        System.out.println();

        /*
        Task 11 – Stack-like Behavior
        Focus: LinkedList
        Description:
        Treat the list as a stack.
        Push and pop elements.
        Observe how the elements are removed from the top of the structure.
        Output Example:
        Push A, B, C
        Pop → C
        Remaining: [A, B]
*/
        System.out.println("Task 11:");
        LinkedList<String> llist11 = new LinkedList<>();
        llist11.offer("A");
        llist11.offer("B");
        llist11.offer("C");
        llist11.offer("D");
        llist11.offer("E");
        System.out.println("Initial LinkedList: " + llist11);
        llist11.push("push"); // added to beginning of the list
        System.out.println("Pushed LinkedList: " + llist11);
        llist11.pop(); // removed from beginning of the list
        System.out.println("Popped LinkedList: " + llist11);
        // alternatives
        llist11.offerFirst("offer first"); // added to beginning of the list
        System.out.println("Pushed LinkedList: " + llist11);
        llist11.pollFirst();
        System.out.println("Popped LinkedList: " + llist11); // removed from beginning of the list
        System.out.println();

/*
        Task 12 – Queue-like Behavior
        Focus: LinkedList
        Description:
        Use poll, offer, and peek methods to treat the list like a queue. Check how elements are inserted and removed.
        Output Example:
        Offer: A, B, C
        Peek → A
        Poll → A
        Remaining: [B, C]
        */
        System.out.println("Task 12:");
        LinkedList<String> llist12 = new LinkedList<>();
        llist12.offer("A");
        llist12.offer("B");
        llist12.offer("C");
        llist12.offer("D");
        llist12.offer("E");
        System.out.println("Initial LinkedList: " + llist12);
        llist12.offerLast("queue last");
        System.out.println("Added to queue LinkedList: " + llist12);
        System.out.println("Last element: " + llist12.peekLast());
        System.out.println("First element: " + llist12.peekFirst());
        llist12.pollFirst();
        System.out.println("Removed from queue LinkedList: " + llist12);
        System.out.println();

/*
        Task 13 – Element Position Search
        Focus: ArrayList
        Description:
        Find the index of the first and last occurrence of specific elements.
        Handle duplicates appropriately.
        Output Example:
        List: [X, Y, Z, X, Y]
        First index of X: 0
        Last index of X: 3
        */
        System.out.println("Task 13:");
        ArrayList<String> arrlist13 = new ArrayList<>();
        arrlist13.add("A");
        arrlist13.add("B");
        arrlist13.add("C");
        arrlist13.add("A");
        arrlist13.add("D");
        arrlist13.add("E");
        System.out.println("Initial ArrayList: " + arrlist13);
        System.out.println("Index of first A: " + arrlist13.indexOf("A")) ;
        System.out.println("Index of last A: " + arrlist13.lastIndexOf("A"));
        System.out.println();

/*
        Task 14 – Remove Element by Index
        Focus: ArrayList, LinkedList
        Description:
        Remove elements by their index position and observe how the collection changes.
        Output Example:
        Before: [A, B, C, D]
        Remove at index 1 → [A, C, D]
*/
        System.out.println("Task 14:");
        ArrayList<String> arrlist14 = new ArrayList<>();
        arrlist14.add("0");
        arrlist14.add("1");
        arrlist14.add("2");
        arrlist14.add("3");
        System.out.println("Initial list: " + arrlist14);
        arrlist14.remove(1);
        System.out.println("Removed element at index 1: " + arrlist14);
        System.out.println();

/*
        Task 15 – Subset Views
        Focus: TreeSet
        Description:
        Create subviews like headSet, tailSet, and subSet based on range criteria. Observe changes in the views.
        Output Example:
        TreeSet: [10, 20, 30, 40, 50]
        headSet(30): [10, 20]
        tailSet(30): [30, 40, 50]
        subSet(20, 50): [20, 30, 40]
*/
        System.out.println("Task 15:");
        TreeSet<Integer> tset15 = new TreeSet<>();
        tset15.add(30);
        tset15.add(10);
        tset15.add(40);
        tset15.add(20);
        tset15.add(50);
        tset15.add(70);
        tset15.add(60);
        tset15.add(80);
        System.out.println("TreeSet: " + tset15);
        NavigableSet<Integer> subsetExcluding = tset15.subSet(20, false, 40, false); // NavigableSet View
        System.out.println("Subset 20-40 excluding: " + subsetExcluding);
        NavigableSet<Integer> headSetIncluding = tset15.headSet(30, true); // NavigableSet View
        System.out.println("Headset 30 including: " + headSetIncluding);
        NavigableSet<Integer> tailSetExcluding = tset15.tailSet(30, false); // NavigableSet View
        System.out.println("Tailset 30 excluding: " + tailSetExcluding);
        System.out.println();

/*
        Task 16 – Reverse Order View
        Focus: TreeSet
        Description:
        Create a descending view of the original TreeSet. Iterate and print elements in reverse order.
        Output Example:
        Original TreeSet: [A, B, C]
        Descending view: [C, B, A]
*/
        System.out.println("Task 16:");
        TreeSet<String> tset16 = new TreeSet<>();
        tset16.add("A");
        tset16.add("B");
        tset16.add("C");
        System.out.println("Original tree set: " + tset16);
        NavigableSet<String> tset16Rev = tset16.descendingSet(); // NavigableSet View
        System.out.println("Reversed view: " + tset16Rev);
        System.out.println();


    }

}
