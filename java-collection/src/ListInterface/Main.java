package ListInterface;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {

                /*
        Task 1 – Insert Element at Position
        Input:
        List: ["apple", "banana", "cherry"]
        Element to insert: "orange"
        Position: 1
        Expected Output:
        ["apple", "orange", "banana", "cherry"]
         */
        System.out.println("Task 1: ");
        List<String> list1 = new ArrayList<>();
        list1.add("apple"); // add to the end
        list1.add("banana"); // add to the end
        list1.add("cherry"); // add to the end
        System.out.println("Original: " + list1);
        list1.add(1, "orange");
        System.out.println("Added \"orange\" to 1: " + list1);
        System.out.println();

        /*
        Task 2 – Replace an Element
        Input:
        List: ["cat", "dog", "fish"]
        Replace element at index 2 with "parrot"
        Expected Output:
        ["cat", "dog", "parrot"]
         */
        System.out.println("Task 2: ");
        List<String> list2 = new ArrayList<>();
        list2.add("cat");
        list2.add("dog");
        list2.add("fish");
        System.out.println("Original: " + list2);
        list2.set(2, "parrot");
        System.out.println("Replaced \"fish\" with \"parrot\": " + list2);
        System.out.println();

        /*
        Task 3 – Remove by Index
        Input:
        List: [1, 2, 3, 4]
        Remove element at index 1
        Expected Output:
        [100, 300, 400]
         */
        System.out.println("Task 3: ");
        List<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(2);
        list3.add(3);
        list3.add(4);
        System.out.println("Original: " + list3);
        list3.remove(1); // remove by index, not by object
        System.out.println("Removed 2 at index 1: " + list3);
        System.out.println();

        /*
        Task 4 – Get Element by Index
        Input:
        List: ["Monday", "Tuesday", "Wednesday"]
        Get the element at index 2
        Expected Output:
        "Wednesday"
         */
        System.out.println("Task 4: ");
        List<String> list4 = new ArrayList<>();
        list4.add("Monday");
        list4.add("Tuesday");
        list4.add("Wednesday");
        System.out.println("Original: " + list4);
        String elementByIndex = list4.get(2);
        System.out.println("Element at index 2: " + elementByIndex);
        System.out.println();

        /*
        Task 5 – Find First and Last Occurrence
        Input:
        List: ["pen", "pencil", "eraser", "pen", "marker"]
        Element: "pen"
        Expected Output:
        First occurrence index: 0
        Last occurrence index: 3
         */
        System.out.println("Task 5: ");
        List<String> list5 = new ArrayList<>();
        list5.add("pen");
        list5.add("pencil");
        list5.add("eraser");
        list5.add("pen");
        list5.add("marker");
        System.out.println("Original: " + list5);
        int firstInd = list5.indexOf("pen");
        System.out.println("First Index of \"pen\": " + firstInd);
        int lastInd = list5.lastIndexOf("pen");
        System.out.println("First Index of \"pen\": " + lastInd);
        System.out.println();

        /*
        Task 6 – Insert a Sublist at a Specific Index
        Input:
        List: [1, 2, 3, 7, 8]
        Insert [4, 5, 6] at index 3
        Expected Output:
        [1, 2, 3, 4, 5, 6, 7, 8]
         */
        System.out.println("Task 6: ");
        List<Integer> list6 = new ArrayList<>();
        list6.add(1);
        list6.add(2);
        list6.add(3);
        list6.add(7);
        list6.add(8);
        System.out.println("Original: " + list6);
        List<Integer> list6ToInsert = new ArrayList<>();
        list6ToInsert.add(4);
        list6ToInsert.add(5);
        list6ToInsert.add(6);
        boolean isAdded = list6.addAll(3, list6ToInsert);
        System.out.println("Added? ... " + isAdded);
        System.out.println("Modified: " + list6);
        System.out.println();

        /*
        Task 7 – Create a Sublist
        Input:
        List: ["Test1", "Test2", "Test3", "Test4", "Test5"]
        Get sublist from index 1 to 4 (exclusive)
         */
        System.out.println("Task 7: ");
        List<String> list7 = new ArrayList<>();
        list7.add("Test1");
        list7.add("Test2");
        list7.add("Test3");
        list7.add("Test4");
        list7.add("Test5");
        System.out.println("Original: " + list7);
        List<String> list7View = list7.subList(1, 4);
        System.out.println("Sublist view: " + list7View);
        System.out.println("Modifying object from original: " + list7.set(1, "ModifiedTest2"));
        System.out.println("Original: " + list7);
        System.out.println("Sublist view: " + list7View);
        System.out.println("Modifying object from sublist: " + list7View.set(0, "ModifiedTest22"));
        System.out.println("Original: " + list7);
        System.out.println("Sublist view: " + list7View);
        System.out.println();

        /*
        Task 8 – Iterate Forward and Backward
        Input:
        List: ["A", "B", "C"]
        Expected Output
        Forward: A B C
        Backward: C B A
        (Note: Use one object to move both directions)
         */
        System.out.println("Task 8: ");
        List<String> list8 = new ArrayList<>();
        list8.add("A");
        list8.add("B");
        list8.add("C");
        System.out.println("Original: " + list8);
        ListIterator<String> literator8 = list8.listIterator();
        System.out.println("Direct order: ");
        while (literator8.hasNext()) {
            System.out.print(literator8.next() + " ");
        }
        System.out.println("\nReversed  order: ");
        while (literator8.hasPrevious()) {
            System.out.print(literator8.previous() + " ");
        }
        System.out.println("\n");

        /*
        Task 9 – Remove All Elements of Another List
        Input:
        List A: [1, 2, 3, 4, 5]
        List B: [2, 4]
        Expected Output:
        Result: [1, 3, 5]
         */
        System.out.println("Task 9: ");
        List<Integer> list9A = new ArrayList<>();
        list9A.add(1);
        list9A.add(2);
        list9A.add(3);
        list9A.add(4);
        list9A.add(5);
        System.out.println("ListA: " + list9A);
        List<Integer> list9B = new ArrayList<>();
        list9B.add(2);
        list9B.add(4);
        System.out.println("ListB: " + list9B);
        list9A.removeAll(list9B);
        System.out.println("ListA after removing matching elements from ListB: " + list9A);
        System.out.println();

        /*
        Task 10 – Retain Only Common Elements
        Input:
        List A: ["x", "y", "z"]
        List B: ["y", "z", "w"]
        Expected Output:
        Result: ["y", "z"]
         */
        System.out.println("Task 10: ");
        List<String> list10A = new ArrayList<>();
        list10A.add("x");
        list10A.add("y");
        list10A.add("z");
        System.out.println("ListA:" + list10A);
        List<String> list10B = new ArrayList<>();
        list10B.add("y");
        list10B.add("z");
        list10B.add("w");
        System.out.println("ListB:" + list10B);
        list10A.retainAll(list10B);
        System.out.println("ListA retained items from ListB: " + list10A);
        System.out.println();

/*
        Task 11: Add Elements at Specific Positions
        Description:
        Create an empty list and add several elements at specific positions to form a desired order.
        Output example:
        [Alpha, Beta, Gamma, Delta]
        */
        System.out.println("Task 11:");
        List<String> list11 = new ArrayList<>();
        list11.add("Alpha");
        System.out.println(list11);
        list11.add(1, "Beta");
        System.out.println(list11);
        list11.add(2, "Gamma");
        System.out.println(list11);
        list11.add(3, "Delta");
        System.out.println(list11);
        // should be added 1-2-3-4 not in random order
        System.out.println();

/*
        Task 12: Replace Elements
        Description:
        Initialize a list with at least five elements. Replace the second and fourth elements with new values.
        Output example:
        [One, Replaced, Three, Replaced, Five]
*/
        System.out.println("Task 12:");
        List<String> list12 = new ArrayList<>();
        list12.add("One");
        list12.add("Two");
        list12.add("Three");
        list12.add("Four");
        list12.add("Five");
        System.out.println("Before: " + list12);
        String replacement12 = "Replaced";
        list12.set(1, replacement12);
        list12.set(3, replacement12);
        System.out.println("After replacement: " + list12);
        System.out.println();

/*
        Task 13: Remove by Index
        Description:
        Create a list with at least five elements. Remove the element at index 2 and index 4.
        Output example:
        [A, B, D]
        */
        System.out.println("Task 13:");
        List<String> list13 = new ArrayList<>();
        list13.add("One");
        list13.add("Two");
        list13.add("Three");
        list13.add("Four");
        list13.add("Five");
        System.out.println("Before: " + list13);
        String removedValue = list13.remove(2);
        System.out.println("Removed and saved \"" + removedValue + "\" from the list.");
        System.out.println("After removal: " + list13);
        System.out.println();

/*
        Task 14: Get Elements by Index
        Description:
        Create a list and retrieve the values at the first, middle, and last index. Print them.
        Output example:
        First: Apple, Middle: Banana, Last: Cherry
    */
        System.out.println("Task 14:");
        List<String> list14 = new ArrayList<>();
        list14.add("One");
        list14.add("Two");
        list14.add("Three");
        list14.add("Four");
        list14.add("Five");
        System.out.println("List: " + list14);
        String retrivedString14 = list14.get(0);
        System.out.println("First -> " + retrivedString14);
        retrivedString14 = list14.get(list14.size()/2);
        System.out.println("Middle -> " + retrivedString14);
        retrivedString14 = list14.get(list14.size()-1);
        System.out.println("Last -> " + retrivedString14);
        System.out.println();

        /*
        Task 15: Search by Index and Value
        Description:
        Create a list with some duplicate elements. Print the index of the first and last occurrence of a specific value.
        Output example:
        First index of "X": 1, Last index of "X": 4
*/
        System.out.println("Task 15:");
        List<String> list15 = new ArrayList<>();
        list15.add("Test1");
        list15.add("Test2");
        list15.add("Test3");
        list15.add("Test1");
        list15.add("Test1");
        list15.add("Test3");
        System.out.println("List: " + list15);
        int firstIndexOf, lastIndexOf;
        String entryToSearch15 = "Test1";
        firstIndexOf = list15.indexOf(entryToSearch15);
        lastIndexOf = list15.lastIndexOf(entryToSearch15);
        System.out.println("First index of Test1: " + firstIndexOf);
        System.out.println("Last index of Test1: " + lastIndexOf);
        System.out.println();

/*
        Task 16: Sublist Creation
        Description:
        Create a list with at least six elements. Create and print a sublist containing elements from index 2 to 5.
        Output example:
        Sublist: [C, D, E, F]
*/
        System.out.println("Task 16:");
        List<String> list16 = new ArrayList<>();
        list16.add("A");
        list16.add("B");
        list16.add("C");
        list16.add("D");
        list16.add("E");
        list16.add("F");
        list16.add("G");
        System.out.println("Original: " + list16);
        List<String> list16Sub = list16.subList(2, 6); // 2 - including, 6 - excluding
        System.out.println("Sublist: " + list16Sub);
        System.out.println();

/*
        Task 17: Iterate Using Indices
        Description:
        Create a list with at least four elements. Print all elements in reverse order using indices.
        Output example:
        Z, Y, X, W
*/
        System.out.println("Task 17:");
        List<Integer> list17 = new ArrayList<>();
        list17.add(1);
        list17.add(2);
        list17.add(3);
        list17.add(4);
        list17.add(5);
        System.out.println("List: " + list17);
        System.out.println("Reversed print: ");
        for (int i = list17.size()-1; i >= 0; i--) {
            System.out.println(list17.get(i));
        }
        System.out.println();

/*
        Task 18: Compare Two Lists by Elements
        Description:
        Create two lists with overlapping and unique elements. Compare them element-by-element by index and print which positions have matching values.
        Output example:
        Index 0: match, Index 1: no match, Index 2: match
*/
        System.out.println("Task 18:");

        List<String> list181 = new ArrayList<>();
        list181.add("Test1");
        list181.add("Test2");
        list181.add("Test3");
        list181.add("Test4");
        System.out.println("List 1: " + list181);

        List<String> list182 = new ArrayList<>();
        list182.add("Test1");
        list182.add("Test99");
        list182.add("Test3");
        System.out.println("List 2: " + list182);

        Iterator<String> iter181 = list181.iterator();
        Iterator<String> iter182 = list182.iterator();
        int lastCheckedIndex = 0;
        while (iter181.hasNext() && iter182.hasNext()) {
            boolean compResult = iter181.next().equals(iter182.next());
            System.out.println("Index " + lastCheckedIndex + ": " + (compResult ? "" : "no ") + "match");
            lastCheckedIndex++;
        }
        System.out.println();

/*
        Task 19: Insert All Elements from Another List at Specific Index
        Description:
        Create two lists. Insert all elements of the second list into the first list starting at index 2.
        Output example:
        [1, 2, A, B, C, 3, 4]
*/
        System.out.println("Task 19:");
        List<Object> list191 = new ArrayList<>();
        list191.add("1");
        list191.add("2");
        list191.add("3");
        list191.add("4");
        System.out.println("List 1: " + list191);

        List<String> list192 = new ArrayList<>();
        list192.add("A");
        list192.add("B");
        list192.add("C");
        System.out.println("List 2: " + list192);

        list191.addAll(2, list192);
        System.out.println("List 1 added: " + list191);
        System.out.println();

/*
        Task 20: Clear and Reuse List
        Description:
        Create a list, add some elements, clear it completely, then reuse the same list to add different elements and print the result.
        Output example:
        After clearing: []
        After reusing: [New1, New2, New3]
        */
        System.out.println("Task 20:");
        List<String> list20 = new ArrayList<>();
        list20.add(0, "Test1");
        list20.add(1, "Test2");
        list20.add(2, "Test3");
        System.out.println("List: " + list20);
        list20.clear();
        System.out.println("List cleared: " + list20);
        list20.add(0, "Test4");
        list20.add(1, "Test5");
        list20.add(2, "Test6");
        System.out.println("List updated: " + list20);
        System.out.println();

    }

}
