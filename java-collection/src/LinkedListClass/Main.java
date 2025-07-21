package LinkedListClass;

import java.sql.SQLOutput;
import java.util.LinkedList;
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

    }

}
