package CollectionInfo.DequeInterface;

import java.util.*;

public class Main {

    public static void main(String[] args) {

/*
        Task 1 – Add Elements to Both Ends
        Description:
        Add several string elements to the deque from both the front and the back. Then display the deque to verify the order of elements.
        Output example:
        [EndTask1, MiddleTask, FrontTask1]
        */
        System.out.println("Task 1:");
        Deque<String> deque1 = new LinkedList<>();
        deque1.add("start");
        System.out.println(deque1);
        deque1.add("1. add(E)"); // Collection
        System.out.println(deque1);
        deque1.offer("2. offer(E)"); // Queue
        System.out.println(deque1);
        deque1.addFirst("3. addFirst(E)"); // Deque
        System.out.println(deque1);
        deque1.addLast("4. addLast(E)"); // Deque
        System.out.println(deque1);
        deque1.offerFirst("5. offerFirst(E)"); // Deque
        System.out.println(deque1);
        deque1.offerLast("6. offerLast(E)"); // Deque
        System.out.println(deque1);
        deque1.push("7. push(E)"); // Deque
        System.out.println(deque1);
        System.out.println();

/*
        Task 2 – Remove Elements from Both Ends
        Description:
        Remove one element from the front and one from the back of the deque. Display the deque before and after removal to observe the changes.
        Output example:
        Before: [Task1, Task2, Task3, Task4]
        After: [Task2, Task3]
*/
        System.out.println("Task 2:");
        Deque<String> dequeue2 = new LinkedList<>();
        dequeue2.offer("Str1");
        dequeue2.offer("Str2");
        dequeue2.offer("Str3");
        dequeue2.offer("Str4");
        dequeue2.offer("Str5");
        dequeue2.offer("Str6");
        dequeue2.offer("Duplicate");
        dequeue2.offer("Str7");
        dequeue2.offer("Duplicate");
        dequeue2.offer("Str8");
        dequeue2.offer("Duplicate");
        dequeue2.offer("Str9");
        dequeue2.offer("Str10");
        System.out.println("Original deque: " + dequeue2);
        try {
            dequeue2.remove(); // throws
            System.out.println("remove(): " + dequeue2);
            dequeue2.poll();
            System.out.println("poll(): " + dequeue2);
            dequeue2.remove("Str6"); // throws
            System.out.println("remove(Str6): " + dequeue2);
            dequeue2.pollFirst(); // throws
            System.out.println("pollFirst(): " + dequeue2);
            dequeue2.removeFirst(); // throws
            System.out.println("removeFirst(): " + dequeue2);
            dequeue2.pollLast();
            System.out.println("pollLast(): " + dequeue2);
            dequeue2.pollLast();
            System.out.println("removeLast(): " + dequeue2);
            dequeue2.removeFirstOccurrence("Duplicate"); // throws
            System.out.println("removeFirstOccurrence(Duplicate): " + dequeue2);
            dequeue2.removeLastOccurrence("Duplicate"); // throws
            System.out.println("removeLastOccurrence(Duplicate): " + dequeue2);
            dequeue2.pop();
            System.out.println("pop(): " + dequeue2);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        System.out.println();

/*
        Task 3 – Stack Simulation Using Deque
        Description:
        Use the deque to simulate stack behavior by pushing several elements and then popping a few. Show the state of the deque after each operation.
        Output example:
        Pushed: [TaskC, TaskB, TaskA]
        Popped: TaskC
        Current Deque: [TaskB, TaskA]
*/
        System.out.println("Task 3:");
        Deque<String> deque3 = new LinkedList<>();
        System.out.println("Original: " + deque3);
        deque3.push("1");
        System.out.println("Push 1: " + deque3); // 1
        deque3.push("2");
        System.out.println("Push 2: " + deque3); // 2, 1
        deque3.push("3");
        System.out.println("Push 3: " + deque3); // 3, 2, 1
        deque3.pop();
        System.out.println("Pop: " + deque3); // 2, 1
        System.out.println();

/*
        Task 4 – Peek from Both Ends
        Description:
        Insert multiple elements, then retrieve (but do not remove) the first and last elements. Display the deque and the peeked values.
        Output example:
        Deque: [First, Middle, Last]
        First element: First
        Last element: Last
*/
        System.out.println("Task 4:");
        Deque<String> deque4 = new LinkedList<>();
        deque4.offer("Test1");
        deque4.offer("Test2");
        deque4.offer("Test3");
        System.out.println("Deque: " + deque4);
        try {
            System.out.println("peek() -> " + deque4.peek());
            System.out.println("element() -> " + deque4.element()); // throws
            System.out.println("peekFirst() -> " + deque4.peekFirst());
            System.out.println("peekLast() -> " + deque4.peekLast());
            System.out.println("getFirst() -> " + deque4.getFirst()); // throws
            System.out.println("getLast() -> " + deque4.getLast()); // throws
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        System.out.println();

/*
        Task 5 – Offer/Push Null Elements Handling
        Description:
        Try to insert a null element into the deque and observe what happens. Catch and report any exceptions or unusual behavior.
        Output example:
        Null elements are not permitted – NullPointerException thrown
*/
        System.out.println("Task 5:");
        Deque<String> dequeue5 = new LinkedList<>();
        String nullStr = null;
        try {
            System.out.println("Add");
            dequeue5.add(nullStr);
            dequeue5.addFirst(nullStr);
            dequeue5.addLast(nullStr);
        } catch (NullPointerException e) {
            System.out.println("Exception");
            e.printStackTrace();
        }
        System.out.println("Size: " + dequeue5.size());

        try {
            System.out.println("Offer");
            dequeue5.offer(nullStr);
            dequeue5.offerFirst(nullStr);
            dequeue5.offerLast(nullStr);
        } catch (NullPointerException e) {
            System.out.println("Exception");
            e.printStackTrace();
        }
        System.out.println("Size: " + dequeue5.size());

        try {
            System.out.println("Push");
            dequeue5.push(nullStr);
        } catch (NullPointerException e) {
            System.out.println("Exception");
            e.printStackTrace();
        }
        System.out.println("Size: " + dequeue5.size());

        System.out.println();

/*
        Task 6 – Iterate in Reverse Order
        Description:
        Populate the deque with several elements. Then iterate through the elements from back to front and display them.
        Output example:
        Deque: [One, Two, Three]
        Reverse iteration: Three Two One
*/
        System.out.println("Task 6:");
        Deque<String> deque6 = new LinkedList<>();
        deque6.offer("Test1");
        deque6.offer("Test2");
        deque6.offer("Test3");
        deque6.offer("Test4");
        System.out.println("Deque: " + deque6);
        Iterator<String> iter6Forward = deque6.iterator();
        System.out.println("Regular iterator: ");
        while (iter6Forward.hasNext()) {
            System.out.println(iter6Forward.next());
        }
        System.out.println("Descending iterator:");
        Iterator<String> iter6Reversed = deque6.descendingIterator();
        while (iter6Reversed.hasNext()) {
            System.out.println(iter6Reversed.next());
        }
        System.out.println();

/*
        Task 7 – Use as Circular Buffer
        Description:
        Simulate a fixed-capacity circular buffer: insert elements until full, then remove from the opposite end as new ones are added. Display the deque at each step.
        Output example:
        Step 1: [A, B, C]
        Step 2 (added D, removed A): [B, C, D]
*/
        System.out.println("Task 7:");
        int bufferSize = 3;
        int iterations = 5;
        Deque<String> deque7 = new LinkedList<>();
        for (int i = 0; i < iterations; i++) {
            String element = "Base".concat(Integer.toString(i));
            if (deque7.size() == bufferSize) {
                deque7.pollFirst();
            }
            deque7.offerLast(element);
            System.out.println("Deque: " + deque7);
        }
        System.out.println();

    }

}
