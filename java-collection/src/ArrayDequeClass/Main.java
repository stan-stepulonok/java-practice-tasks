package ArrayDequeClass;

import java.util.ArrayDeque;

public class Main {

    public static void main(String[] args) {
        
/*
        Task 1 – Insert Elements at Both Ends
        Description:
        Add a few string elements to both the front and the back of the deque.
        Then, display the final content to verify their positions.
        Output Example:
        [Back1, Back2, Middle, Front1, Front2]
*/
        System.out.println("Task 1:");
        ArrayDeque<String> arrDeque1 = new ArrayDeque<>();
        // back
        arrDeque1.add("Back1");
        arrDeque1.addLast("Back2");
        arrDeque1.offer("Back3");
        arrDeque1.offerLast("Back4");
        // front
        arrDeque1.addFirst("Front1");
        arrDeque1.offerFirst("Front2");
        arrDeque1.push("Front3");
        System.out.println(arrDeque1);
        System.out.println();

/*
        Task 2 – Remove Elements from Both Ends
        Description:
        Starting with a deque containing several elements, remove elements from both the front and back, one at a time.
        Display the deque after each removal to observe the changes.
        Output Example:
        Original: [A, B, C, D, E]
        After removing front: [B, C, D, E]
        After removing back: [B, C, D]
*/
        System.out.println("Task 2:");
        ArrayDeque<String> arrDeque2 = new ArrayDeque<>();
        arrDeque2.offer("A");
        arrDeque2.offer("B");
        arrDeque2.offer("C");
        arrDeque2.offer("D");
        arrDeque2.offer("E");
        arrDeque2.offer("F");
        arrDeque2.offer("G");
        arrDeque2.offer("H");
        arrDeque2.offer("I");
        System.out.println("Original: " + arrDeque2);
        // front
        arrDeque2.remove();
        arrDeque2.removeFirst();
        arrDeque2.poll();
        arrDeque2.pollFirst();
        arrDeque2.pop();
        System.out.println("Removed A -> E: " + arrDeque2);
        // back
        arrDeque2.remove("I");
        arrDeque2.removeLast();
        arrDeque2.pollLast();
        System.out.println("Removed G, H, I: " + arrDeque2);
        System.out.println();

/*
        Task 3 – Simulate Stack Behavior
        Description:
        Use the deque to simulate stack behavior.
        Add a series of elements and remove them following LIFO order.
        Display the order in which elements are removed.
        Output Example:
        Pushed elements: [Item1, Item2, Item3]
        Popped elements: [Item3, Item2, Item1]
*/
        System.out.println("Task 3:");
        ArrayDeque<String> arrayDeque3 = new ArrayDeque<>();
        Main.stackAdd(arrayDeque3, "Test1");
        Main.stackAdd(arrayDeque3, "Test2");
        Main.stackAdd(arrayDeque3, "Test3");
        System.out.println("ArrayDeque: " + arrayDeque3);
        Main.stackRemove(arrayDeque3);
        Main.stackRemove(arrayDeque3);
        System.out.println("ArrayDeque: " + arrayDeque3);
        System.out.println();

/*
        Task 4 – Simulate Queue Behavior
        Description:
        Use the deque to simulate queue behavior.
        Add a series of elements and remove them following FIFO order.
        Display the order in which elements are removed.
        Output Example:
        Offered elements: [Item1, Item2, Item3]
        Polled elements: [Item1, Item2, Item3]
*/
        System.out.println("Task 4:");
        ArrayDeque<String> arrayDeque4 = new ArrayDeque<>();
        Main.queueAdd(arrayDeque4, "Test1");
        Main.queueAdd(arrayDeque4, "Test2");
        Main.queueAdd(arrayDeque4, "Test3");
        System.out.println("ArrayDeque: " + arrayDeque4);
        Main.queueRemove(arrayDeque4);
        Main.queueRemove(arrayDeque4);
        System.out.println("ArrayDeque: " + arrayDeque4);
        System.out.println();

/*
        Task 5 – Peek from Both Ends
        Description:
        After adding a few elements, inspect the element at the front and at the back without removing them.
        Show the elements that are returned and the unchanged deque.
        Output Example:
        Deque: [First, Middle, Last]
        Front: First
        Back: Last
        Unchanged deque: [First, Middle, Last]
*/
        System.out.println("Task 5:");
        ArrayDeque<String> arrDeque5 = new ArrayDeque<>();
        arrDeque5.offer("1");
        arrDeque5.offer("2");
        arrDeque5.offer("3");
        arrDeque5.offer("4");
        arrDeque5.offer("5");
        System.out.println("Deque: " + arrDeque5);
        // first
        System.out.println("Front: " + arrDeque5.peek());
        System.out.println("Front: " + arrDeque5.peekFirst());
        System.out.println("Front: " + arrDeque5.element());
        System.out.println("Front: " + arrDeque5.getFirst());
        // rear
        System.out.println("Rear: " + arrDeque5.peekLast());
        System.out.println("Rear: " + arrDeque5.getLast());
        System.out.println();

/*
        Task 6 – Clear and Reuse
        Description:
        Fill the deque with a few elements, then clear it.
        Verify that it's empty, and reuse it by adding new elements.
        Show both the empty and refilled state.
        Output Example:
        Before clear: [X, Y, Z]
        After clear: []
        After reuse: [New1, New2]
*/
        System.out.println("Task 6:");
        ArrayDeque<String> arrayDeque6 = new ArrayDeque<>();
        arrayDeque6.offer("Test");
        arrayDeque6.offer("Test");
        arrayDeque6.offer("Test");
        System.out.println("Array Deque: " + arrayDeque6);
        System.out.println("Is ArrayDeque empty? ... " + arrayDeque6.isEmpty());
        arrayDeque6.clear();
        System.out.println("Cleared ... ");
        System.out.println("Is ArrayDeque empty? ... " + arrayDeque6.isEmpty());
        arrayDeque6.offer("123");
        System.out.println("Array Deque Re-filled: " + arrayDeque6);
        System.out.println();

/*
        Task 7 – Handle Duplicate Elements
        Description:
        Add duplicate elements to the deque and remove one occurrence from either end.
        Display the deque to confirm the correct removal.
        Before removal: [Task, Task, Task]
        After one removal: [Task, Task]
*/
        System.out.println("Task 7:");
        ArrayDeque<String> arrDeque7 = new ArrayDeque<>();
        arrDeque7.offer("Test");
        arrDeque7.offer("/");
        arrDeque7.offer("Test");
        arrDeque7.offer("/");
        arrDeque7.offer("Test");
        arrDeque7.offer("/");
        arrDeque7.offer("Test");
        System.out.println("Duplicated deque: " + arrDeque7);
        arrDeque7.removeFirstOccurrence("Test");
        System.out.println("Removed first occurrence: " + arrDeque7);
        arrDeque7.removeLastOccurrence("Test");
        System.out.println("Removed last occurrence: " + arrDeque7);
        System.out.println();

/*
        Task 8 – Check for Presence and Size
        Description:
        After several insertions and deletions, check whether specific elements are present and display the current size of the deque.
        Output Example:
        Deque: [Read, Write, Execute]
        Contains 'Write': true
        Size: 3
*/
        System.out.println("Task 8:");
        ArrayDeque<String> arrDeque8 = new ArrayDeque<>();
        arrDeque8.offer("Read");
        arrDeque8.offer("Write");
        arrDeque8.offer("Execute");
        System.out.println("Array Deque: " + arrDeque8);
        System.out.println("\"Write\" is in the array deque? ... " + arrDeque8.contains("Write"));
        System.out.println("Array deque size: " + arrDeque8.size());
        System.out.println();

    }

    public static void stackAdd(ArrayDeque<String> deque, String str) {
        deque.offerFirst(str);
    }

    public static void stackRemove(ArrayDeque<String> deque) {
        deque.pollFirst();
    }

    public static void queueAdd(ArrayDeque<String> deque, String str) {
        deque.offerLast(str);
    }

    public static void queueRemove(ArrayDeque<String> deque) {
        deque.pollFirst();
    }

}
