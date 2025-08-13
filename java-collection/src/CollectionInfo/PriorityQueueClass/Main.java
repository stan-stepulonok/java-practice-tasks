package CollectionInfo.PriorityQueueClass;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {

        // !!! NOT A SORTED LIST !!!

/*
        Task 1 – Add Elements and Observe Priority Order
        Description:
        Insert a set of string or integer elements into a priority queue.
        Display the queue to observe how it orders elements internally (via iteration or polling).
        Output Example:
        [Apple, Banana, Mango, Cherry]
        Polled order: Apple, Banana, Cherry, Mango
*/
        System.out.println("Task 1:");
        PriorityQueue<String> prqueue1 = new PriorityQueue<>();
        prqueue1.add("Mango"); // add
        System.out.println("Added Mango: " + prqueue1);
        prqueue1.offer("Banana"); // offer
        System.out.println("Added Banana: " + prqueue1);
        prqueue1.offer("Cherry"); // offer
        System.out.println("Added Cherry: " + prqueue1);
        prqueue1.offer("Apple"); // offer
        System.out.println("Added Apple: " + prqueue1);
        System.out.println("Final priority queue of Strings: " + prqueue1);
        System.out.println();

/*
        Task 2 – Custom Ordering Using Comparator
        Description:
        Create a priority queue that orders elements in reverse or by length (for strings).
        Add a few elements and display how they are retrieved based on custom logic.
        Output Example:
        Input elements: [one, three, two, four]
        Polled order by length: [one, two, four, three]
*/
        System.out.println("Task 2:");
        Comparator<String> comp2 = new Comparator<>(){
            @Override
            public int compare (String s1, String s2) {
                return s1.length() - s2.length();
            }
        };
        PriorityQueue<String> prqueue2 = new PriorityQueue<>(comp2);
        prqueue2.offer("one");
        System.out.println(prqueue2);
        prqueue2.offer("three");
        System.out.println(prqueue2);
        prqueue2.offer("two");
        System.out.println(prqueue2);
        prqueue2.offer("four");
        System.out.println(prqueue2);
        System.out.println();

        /*
        Task 3 – Peek and Poll Behavior
        Description:
        Add several elements, then use methods to inspect and remove elements. Track and display changes after each operation.
        Output Example:
        Queue after additions: [1, 3, 2, 4]
        Peek: 1
        Poll: 1
        Queue after poll: [2, 3, 4]
*/
        System.out.println("Task 3:");
        PriorityQueue<Integer> prqueue3 = new PriorityQueue<>();
        prqueue3.offer(4);
        prqueue3.offer(3);
        prqueue3.offer(1);
        prqueue3.offer(2);
        System.out.println("Priority queue before: " + prqueue3);
        System.out.println("Peek: " + prqueue3.peek()); // 1
        System.out.println("Poll: " + prqueue3.poll()); // 1
        System.out.println("Queue: " + prqueue3);
        System.out.println("Peek: " + prqueue3.peek()); // 2
        System.out.println("Poll: " + prqueue3.poll()); // 2
        System.out.println("Queue: " + prqueue3);
        System.out.println();

/*
        Task 4 – Remove Arbitrary Element
        Description:
        Add a mix of elements and remove a specific one (not the head). Display whether the removal was successful and the updated state of the queue.
        Output Example:
        Initial queue: [10, 20, 15, 30]
        Remove 20 → true
        Queue after removal: [10, 30, 15]
        */
        System.out.println("Task 4:");
        PriorityQueue<Integer> prqueue4 = new PriorityQueue<>();
        prqueue4.offer(15);
        prqueue4.offer(10);
        prqueue4.offer(30);
        prqueue4.offer(20);
        System.out.println("Queue before: " + prqueue4);
        boolean removeResult = prqueue4.remove(20);
        System.out.println("Removed 20 from the queue? ... " + removeResult);
        System.out.println("Queue after: " + prqueue4);
        Integer head4 = prqueue4.poll();
        System.out.println("Removed head -> " + head4);
        System.out.println("Queue after: " + prqueue4);
        System.out.println();

/*
        Task 5 – Use with Duplicates
        Description:
        Insert duplicate elements into the queue and remove one of them. Observe how duplicates are treated and which element is removed.
        Output Example:
        Queue with duplicates: [5, 3, 3, 4]
        Remove 3 → true
        Queue after removal: [3, 5, 4]
*/
        System.out.println("Task 5:");
        PriorityQueue<Integer> prqueue5 = new PriorityQueue<>();
        prqueue5.offer(5);
        prqueue5.offer(3);
        prqueue5.offer(3);
        prqueue5.offer(4);
        System.out.println("Duplicated min element queue: " + prqueue5);
        System.out.println("Removing the head ... ");
        System.out.println("Removed: " + prqueue5.poll());
        System.out.println("No dupes head queue: " + prqueue5);
        System.out.println();

/*
        Task 6 – Clear and Check Emptiness
        Description:
        Fill the queue with elements, clear it, and check if it is empty using appropriate methods.
        Output Example:
        Queue before clear: [2, 1, 4]
        Cleared.
        Is empty? true
*/
        System.out.println("Task 6: ");
        PriorityQueue<Integer> prqueue6 = new PriorityQueue<>();
        prqueue6.offer(2);
        prqueue6.offer(1);
        prqueue6.offer(4);
        System.out.println("Before clear: " + prqueue6);
        prqueue6.clear();
        System.out.println("After clear: " + prqueue6);
        System.out.println("Is empty? ... " + prqueue6.isEmpty());
        System.out.println();

/*
        Task 7 – Convert to Array or Iterate
        Description:
        Add elements, convert the queue to an array or iterate over it. Print the resulting view and explain the difference from polling.
        Output Example:
        Iteration result: [2, 3, 1]
        Poll order: [1, 2, 3]
*/
        System.out.println("Task 7:");
        PriorityQueue<Integer> prqueue7 = new PriorityQueue<>();
        prqueue7.add(2);
        prqueue7.add(3);
        prqueue7.add(1);
        System.out.println("Queue: " + prqueue7);
        Object[] arrOfIntegers = prqueue7.toArray();
        System.out.println(Arrays.toString(arrOfIntegers));
        System.out.println();

/*
        Task 8 – PriorityQueue with Custom Class
        Description:
        Create a priority queue of custom objects (e.g., tasks with priority), and define a sorting rule based on a field. Poll to verify ordering.
        Output Example:
        Tasks added: [Task C: priority 3, Task A: priority 1, Task B: priority 2]
        Polled tasks: Task A, Task B, Task C
*/
        System.out.println("Task 8:");

        Comparator<Task> comp8 = new Comparator<>() {
            @Override
            public int compare (Task t1, Task t2) {
                int compResult = t1.getPriority().compareTo(t2.getPriority());
                if (compResult == 0) {
                    return t1.getName().compareTo(t2.getName());
                } else {
                    return compResult;
                }
            }
        };

        PriorityQueue<Task> prqueue8 = new PriorityQueue<>(comp8);
        prqueue8.offer(new Task("C", 3));
        prqueue8.offer(new Task("A", 1));
        prqueue8.offer(new Task("B", 2));
        System.out.println("Queue: " + prqueue8);



    }

}
