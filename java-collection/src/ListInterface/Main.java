package ListInterface;

import java.util.ArrayList;
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

    }

}
