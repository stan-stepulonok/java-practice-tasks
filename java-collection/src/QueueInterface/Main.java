package QueueInterface;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
/*
        Task 1 – Add Elements and Display Queue Order
        Description:
        Add several string elements representing task names to the queue. Display the queue to observe the order of elements.
        Output example:
        [Email, Review, Coding, Meeting]
        */
        System.out.println("Task 1:");
        Queue<String> queue1 = new LinkedList<>();
        // add
        queue1.add("1. Email");
        // offer
        queue1.offer("2. Review");
        queue1.offer("3. Coding");
        queue1.offer("4. Meeting");
        System.out.println("Queue: " + queue1);
        System.out.println();

/*
        Task 2 – Retrieve Head Without Removing
        Description:
        Peek at the element at the head of the queue without removing it. Display the result and the queue afterward.
        Output example:
        Head: Email
        Queue: [Email, Review, Coding, Meeting]
*/
        System.out.println("Task 2:");
        Queue<String> queue2 = new LinkedList<>();
        queue2.offer("1. Email");
        queue2.offer("2. Review");
        queue2.offer("3. Coding");
        queue2.offer("4. Meeting");
        System.out.println("Queue: " + queue2);
        // peek
        String element2 = queue2.peek();
        System.out.println("Head: " + element2);
        // element
        try {
            element2 = queue2.element();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        System.out.println("Head: " + element2);
        System.out.println();

/*
        Task 3 – Remove Head Element
        Description:
        Remove the element at the head of the queue. Display the removed element and the queue afterward.
        Output example:
        Removed: Email
        Queue: [Review, Coding, Meeting]
*/
        System.out.println("Task 3:");
        Queue<String> queue3 = new LinkedList<>();
        queue3.offer("1. Email");
        queue3.offer("2. Review");
        queue3.offer("3. Coding");
        queue3.offer("4. Meeting");
        System.out.println("Queue before: " + queue3);
        String element3;
        // poll
        try {
            element3 = queue3.remove();
            System.out.println("Removed element: " + element3);
            System.out.println("Queue after: " + queue3);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        // remove
        element3 = queue3.remove();
        System.out.println("Removed element: " + element3);
        System.out.println("Queue after: " + queue3);
        System.out.println();

/*
        Task 4 – Offer and Observe Order
        Description:
        Offer new elements to the queue and verify that they are placed according to the queue's ordering logic.
        Output example:
        Queue after offering: [BugFix, CodeReview, Deployment, Testing]
*/
        System.out.println("Task 4:");
        Queue<String> queue4 = new LinkedList<>();
        System.out.println("Original queue: " + queue4);
        String[] arrayOfelements4 = new String[] {"BugFix", "CodeReview", "Deployment", "Testing"};
        for (int i = 0; i < arrayOfelements4.length; i++) {
            System.out.println("Element added? ... " + queue4.offer(arrayOfelements4[i]));
        }
        System.out.println("Filled queue: " + queue4);
        boolean orderMatch = false;
        Iterator<String> queueIterator4 = queue4.iterator();
        for (int i = 0; i < arrayOfelements4.length; i++) {
            String arrayElementTemp = arrayOfelements4[i];
            String queueElementTemp = queueIterator4.next();
            if (arrayElementTemp.equals(queueElementTemp)) {
                orderMatch = true;
            }
            else {
                orderMatch = false;
                System.out.println("Inserted order is incorrect!");
            }
        }
        if (orderMatch) System.out.println("Inserted order is correct!");
        System.out.println();

/*
        Task 5 – Process All Elements in Queue
        Description:
        Continuously retrieve and remove the head of the queue until it is empty. Print each retrieved element.
        Output example:
        Processing: BugFix
        Processing: CodeReview
        Processing: Deployment
        Processing: Testing
        Queue is now empty
*/
        System.out.println("Task 5:");
        Queue<String> queue5 = new LinkedList<>();
        queue5.offer("BugFix");
        queue5.offer("CodeReview");
        queue5.offer("Deployment");
        queue5.offer("Testing");
        Iterator<String> queue5Iter = queue5.iterator();
        while (queue5Iter.hasNext()) {
            System.out.println("Processing: " + queue5.poll());
        }
        if (queue5.isEmpty()) System.out.println("Queue is now empty");
        System.out.println();

/*
        Task 6 – Handle Empty Queue on Retrieval
        Description:
        Try retrieving or removing the head element from an empty queue and observe the result. Compare behavior of different retrieval methods.
        Output example:
        Head: null
        Removed: null
        Queue: []
*/
        System.out.println("Task 6:");
        Queue<String> queue6 = new LinkedList<>();

        String getElement6;

        // get
        // peek -> null
        getElement6 = queue6.peek();
        System.out.println(getElement6);
        // element -> exception
        try {
            getElement6 = queue6.element();
            System.out.println(getElement6);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("Exception caught - element()");
        }

        // delete
        // poll
        getElement6 = queue6.poll();
        System.out.println(getElement6);
        // remove -> exception
        try {
            getElement6 = queue6.remove();
            System.out.println(getElement6);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("Exception caught - remove()");
        }
        System.out.println();

/*
        Task 7 – Compare Queue and List Behavior
        Description:
        Add the same elements to both a Queue and a List. Retrieve and remove the first element from both. Display how the behavior differs.
        Output example:
        Queue removed: Alpha
        List removed: Alpha
        Queue after removal: [Beta, Gamma]
        List after removal: [Beta, Gamma]
        (Note any order difference or behavior during removal)
*/
        System.out.println("Task 7:");
        String el1 = "Alpha", el2 = "Beta", el3 = "Gamma";
        String temp;
        long operationStart, operationend, duration;
        LinkedList<String> llist7 = new LinkedList<>();
        ArrayList<String> alist7 = new ArrayList<>();
        Queue<String> queue7 = new LinkedList<>();

        // linked list
        operationStart = System.nanoTime();
        llist7.add(el1);
        llist7.add(el2);
        llist7.add(el3);
        temp = llist7.get(0);
        llist7.remove(0);
        operationend = System.nanoTime();
        duration = operationend - operationStart;
        System.out.println("Linked list operations: " + duration);

        // array list
        operationStart = System.nanoTime();
        alist7.add(el1);
        alist7.add(el2);
        alist7.add(el3);
        temp = alist7.get(0);
        alist7.remove(0);
        operationend = System.nanoTime();
        duration = operationend - operationStart;
        System.out.println("Array list operations: " + duration);

        // queue
        operationStart = System.nanoTime();
        queue7.offer(el1);
        queue7.offer(el2);
        queue7.offer(el3);
        temp = queue7.peek();
        queue7.poll();
        operationend = System.nanoTime();
        duration = operationend - operationStart;
        System.out.println("Queue operations: " + duration);
        System.out.println();







    }

}
