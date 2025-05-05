package LinkedListClass.InheritedListCollection;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*
        Task 1: Add and Print All Elements
        Input:
        Add elements: "Java", "Python", "C++"
        Output:
        [Java, Python, C++]
         */
        System.out.println("Task 1:");
        LinkedList<String> llist1 = new LinkedList<>();
        boolean addingResult1 = llist1.add("Java");
        System.out.println("Added to the end? ... " + addingResult1);
        llist1.add("Python");
        llist1.add("C++");
        System.out.println(llist1);
        System.out.println();

        /*
        Task 2: Insert at Specific Position
        Input:
        Initial: ["Apple", "Banana", "Cherry"]
        Insert "Avocado" at index 1
        Output:
        [Apple, Avocado, Banana, Cherry]
         */
        System.out.println("Task 2:");
        LinkedList<String> llist2 = new LinkedList<>();
        llist2.add("Apple"); // returns boolean
        llist2.add("Banana");
        llist2.add("Cherry");
        System.out.println("Original: " + llist2);
        llist2.add(1,"Avocado"); // void, nothing to print
        System.out.println("Added: " + llist2);
        System.out.println();

        /*
        Task 3: Replace an Element
        Input:
        Initial: ["Sun", "Moon", "Stars"]
        Replace index 2 with "Galaxy"
        Output:
        [Sun, Moon, Galaxy]
         */
        System.out.println("Task 3:");
        LinkedList<String> llist3 = new LinkedList<>();
        llist3.add("Sun");
        llist3.add("Moon");
        llist3.add("Stars");
        String replacement3 = "Galaxy";
        System.out.println("Original: " + llist3);
        String replaced3 = llist3.set(2, replacement3);
        System.out.printf("Replaces %s with %s, so the replaced list is: " + llist3 + "%n", replaced3, replacement3);
        System.out.println();

        /*
        Task 4: Remove an Element by Value
        Input:
        Initial: ["Dog", "Cat", "Fish", "Bird"]
        Remove "Fish"
        Output:
        [Dog, Cat, Bird]
         */
        System.out.println("Task 4:");
        LinkedList<String> llist4 = new LinkedList<>();
        llist4.add("Dog");
        llist4.add("Cat");
        llist4.add("Fish");
        llist4.add("Bird");
        System.out.println("Original: " + llist4);
        boolean removedResult4 = llist4.remove("Dog"); // remove by object returns boolean
        System.out.println("Removed? ... " + removedResult4);
        System.out.println("Removed \"Dog\": " + llist4);
        String removedElement4 = llist4.remove(0);
        System.out.printf("Removed %s at position 0 and saved result, so removed collection is: " + llist4 + "%n", removedElement4);
        System.out.println();

        /*
        Task 5: Sublist Extraction
        Input:
        Initial: ["A", "B", "C", "D", "E", "F"]
        Extract from index 2 to 5
        Output:
        [C, D, E]
         */
        System.out.println("Task 5:");
        LinkedList<String> llist5 = new LinkedList<>();
        llist5.add("A");
        llist5.add("B");
        llist5.add("C");
        llist5.add("D");
        llist5.add("E");
        llist5.add("F");
        System.out.println("Original: " + llist5);
        List<String> subList5 = new LinkedList<>();
        subList5 = llist5.subList(2, 5); // the static type is List, the dynamic is LinkedList
        System.out.println("Sublist: " + subList5);
        System.out.println();
    }

}
