package LinkedListClass;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
/*
        Task 1 – Add Elements at the Beginning and End
        Description:
        Create a linked list and insert elements at both the beginning and the end.
        Use methods that are specific to LinkedList (or overridden from Deque).
        Output example:
        [start, middle, end]
        */
        System.out.println("Task 1:");
        LinkedList<String> llist1 = new LinkedList<>();
        llist1.add("test");
        llist1.add("test");
        llist1.add("test");
        llist1.add("test");
        llist1.add("test");
        long startNano = System.nanoTime();
        llist1.add(0, "start");
        long endNano = System.nanoTime();
        long diff = endNano - startNano;
        System.out.println("Adding to the start (nano): " + diff);
        startNano = System.nanoTime();
        llist1.add(llist1.size()/2, "middle");
        endNano = System.nanoTime();
        diff = endNano - startNano;
        System.out.println("Adding to the middle (nano): " + diff);
        startNano = System.nanoTime();
        llist1.add(llist1.size()-1, "end");
        endNano = System.nanoTime();
        diff = endNano - startNano;
        System.out.println("Adding to the end (nano): " + diff);
        System.out.println();

/*
Task 2 – Remove by Index and by Object
Description:
Remove one element by index and another by value.
Track the size and content of the list after each operation.
Output example:
Removed at index 1: true
Removed "apple": true
Remaining list: [orange, banana]
*/
        System.out.println("Task 2:");
        LinkedList<String> llist2 = new LinkedList<>();
        llist2.add("apple");
        llist2.add("test");
        llist2.add("orange");
        llist2.add("test");
        llist2.add("banana");
        startNano = System.nanoTime();
        llist2.remove(0);
        endNano = System.nanoTime();
        diff = endNano - startNano;
        System.out.println("Removing from the start (nano): " + diff + "; and the size of collection is " + llist2.size());
        startNano = System.nanoTime();
        llist2.remove(llist2.size()/2);
        endNano = System.nanoTime();
        diff = endNano - startNano;
        System.out.println("Removing from the middle (nano): " + diff + "; and the size of collection is " + llist2.size());
        startNano = System.nanoTime();
        llist2.remove(llist2.size() - 1);
        endNano = System.nanoTime();
        diff = endNano - startNano;
        System.out.println("Removing from the end (nano): " + diff + "; and the size of collection is " + llist2.size());
        System.out.println();

/*
        Task 3 – Replace an Element
        Description:
        Replace an element at a specific index with a new value.
        Return the old element and print the updated list.
        Output example:
        Replaced "b" with "x"
        [a, x, c]
*/
        System.out.println("Task 3:");
        LinkedList<String> llist3 = new LinkedList<>();
        llist3.add("test1");
        llist3.add("test2");
        llist3.add("test3");
        llist3.add("test4");
        String tempReplaced = llist3.set(2, "test999");
        System.out.println("Replaced item: " + tempReplaced);
        System.out.println();

/*
        Task 4 – Retrieve First and Last with List Methods
        Description:
        Get the first and last elements using index-based access.
        Avoid methods that come from Deque.
        Output example:
        First: alpha
        Last: omega
*/
        System.out.println("Task 4:");
        LinkedList<String> llist4 = new LinkedList<>();
        llist4.add("alpha");
        llist4.add("test");
        llist4.add("test");
        llist4.add("omega");
        System.out.println(llist4.get(0));
        System.out.println(llist4.get(llist4.size() - 1));
        System.out.println();

/*
        Task 5 – Iterate Using ListIterator
        Description:
        Traverse the LinkedList using a ListIterator in both directions.
        Track elements in forward and reverse order.
        Output example:
        Forward: [a, b, c]
        Backward: [c, b, a]
*/
        System.out.println("Task 5:");
        LinkedList<String> llist5 = new LinkedList<>();
        llist5.add("a");
        llist5.add("b");
        llist5.add("c");
        ListIterator<String> literator5 = llist5.listIterator();
        System.out.println("Next:");
        while(literator5.hasNext()) {
            System.out.println(literator5.next());
        }
        System.out.println("Previous:");
        while(literator5.hasPrevious()) {
            System.out.println(literator5.previous());
        }
        System.out.println();

                /*
        Task 6: Add and Print All Elements
        Input:
        Add elements: "Java", "Python", "C++"
        Output:
        [Java, Python, C++]
         */
        System.out.println("Task 6:");
        LinkedList<String> llist6 = new LinkedList<>();
        boolean addingResult1 = llist6.add("Java");
        System.out.println("Added to the end? ... " + addingResult1);
        llist6.add("Python");
        llist6.add("C++");
        System.out.println(llist6);
        System.out.println();

        /*
        Task 7: Insert at Specific Position
        Input:
        Initial: ["Apple", "Banana", "Cherry"]
        Insert "Avocado" at index 1
        Output:
        [Apple, Avocado, Banana, Cherry]
         */
        System.out.println("Task 7:");
        LinkedList<String> llist7 = new LinkedList<>();
        llist7.add("Apple"); // returns boolean
        llist7.add("Banana");
        llist7.add("Cherry");
        System.out.println("Original: " + llist7);
        llist2.add(1,"Avocado"); // void, nothing to print
        System.out.println("Added: " + llist7);
        System.out.println();

        /*
        Task 8: Replace an Element
        Input:
        Initial: ["Sun", "Moon", "Stars"]
        Replace index 2 with "Galaxy"
        Output:
        [Sun, Moon, Galaxy]
         */
        System.out.println("Task 8:");
        LinkedList<String> llist8 = new LinkedList<>();
        llist8.add("Sun");
        llist8.add("Moon");
        llist8.add("Stars");
        String replacement3 = "Galaxy";
        System.out.println("Original: " + llist8);
        String replaced3 = llist8.set(2, replacement3);
        System.out.printf("Replaces %s with %s, so the replaced list is: " + llist8 + "%n", replaced3, replacement3);
        System.out.println();

        /*
        Task 9: Remove an Element by Value
        Input:
        Initial: ["Dog", "Cat", "Fish", "Bird"]
        Remove "Fish"
        Output:
        [Dog, Cat, Bird]
         */
        System.out.println("Task 9:");
        LinkedList<String> llist9 = new LinkedList<>();
        llist9.add("Dog");
        llist9.add("Cat");
        llist9.add("Fish");
        llist9.add("Bird");
        System.out.println("Original: " + llist9);
        boolean removedResult4 = llist9.remove("Dog"); // remove by object returns boolean
        System.out.println("Removed? ... " + removedResult4);
        System.out.println("Removed \"Dog\": " + llist9);
        String removedElement4 = llist9.remove(0);
        System.out.printf("Removed %s at position 0 and saved result, so removed collection is: " + llist9 + "%n", removedElement4);
        System.out.println();

        /*
        Task 10: Sublist Extraction
        Input:
        Initial: ["A", "B", "C", "D", "E", "F"]
        Extract from index 2 to 5
        Output:
        [C, D, E]
         */
        System.out.println("Task 10:");
        LinkedList<String> llist10 = new LinkedList<>();
        llist5.add("A");
        llist5.add("B");
        llist5.add("C");
        llist5.add("D");
        llist5.add("E");
        llist5.add("F");
        System.out.println("Original: " + llist10);
        List<String> subList10 = new LinkedList<>();
        subList10 = llist10.subList(2, 5); // the static type is List, the dynamic is LinkedList
        System.out.println("Sublist: " + subList10);
        System.out.println();

    }

}
