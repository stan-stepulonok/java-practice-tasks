package ArrayListClass;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        /*
        Task 1 – Basic List Operations
        Description:
        Work with adding, removing, and modifying elements in a List<String>.
        Input/Output Example:
        Input: ["Alice", "Bob", "Charlie", "David", "Eve"]
        After removing index 2: ["Alice", "Bob", "David", "Eve"]
        After replacing index 1: ["Alice", "Beatrice", "David", "Eve"]
        Size: 4
        Contains "Eve"? true
         */
        System.out.println("Task 1:");
        ArrayList<String> arrlist1 = new ArrayList<>();
        arrlist1.add("Bob");
        arrlist1.add("Charlie");
        arrlist1.add("David");
        arrlist1.add("Eve");
        System.out.println("Original: " + arrlist1);

        System.out.println("Adding to 0 index: ");
        arrlist1.add(0,"Alice");
        System.out.println("Added \"Alice\" to 0: " + arrlist1);

        System.out.println("Removing at index 2: ");
        String removedElement = arrlist1.remove(2);
        System.out.printf("Removed %s from arrayList: " + arrlist1 + " \n", removedElement);

        System.out.println("Replacing at index 1: ");
        String replacedElement = arrlist1.set(1, "Replacement");
        System.out.printf("Replaced %s at position 1: " + arrlist1 + " \n", replacedElement);

        int arrList1Size = arrlist1.size();
        System.out.println("Size: " + arrList1Size);

        String elementToFind = "Eve";
        boolean containsResult = arrlist1.contains(elementToFind);
        System.out.printf("%s is in the list? ... " + containsResult + "\n", elementToFind);

        System.out.println();

        /*
        Task 2 – List with Integers and SubLists
        Description:
        Operate on a List<Integer> with range values and sublists.
        Input/Output Example:
        Original List: [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
        Index of 50: 4
        Contains 25? false
        Sublist from index 3 to 6: [40, 50, 60]
        List cleared: []
        Is empty? true
         */
        System.out.println("Task 2:");
        ArrayList<Integer> arrlist2 = new ArrayList<>();
        arrlist2.add(10);
        arrlist2.add(20);
        arrlist2.add(30);
        arrlist2.add(40);
        arrlist2.add(50);
        arrlist2.add(60);
        arrlist2.add(70);
        arrlist2.add(80);
        arrlist2.add(90);
        arrlist2.add(100);
        System.out.println("Original: " + arrlist2);

        int searchIndexOf = 50;
        int firstIndexOf50 = arrlist2.indexOf(searchIndexOf);
        int lastIndexOf50 = arrlist2.lastIndexOf(searchIndexOf);
        System.out.printf("First index of %d is " + firstIndexOf50 + " and the last index of is " + lastIndexOf50 + "\n", searchIndexOf);

        int containsval = 25;
        boolean containsResult2 = arrlist2.contains(containsval);
        System.out.printf("%d is in the list? ... %b%n", containsval, containsResult2);

        List<Integer> arrList2Sublist = arrlist2.subList(3, 6); // returns List !!!
        ArrayList<Integer> arrList2SublistArr = new ArrayList<>(arrList2Sublist); // create ArrayList from List !!!
        System.out.println("Sublist 3->6: " + arrList2SublistArr);

        arrList2SublistArr.clear();
        System.out.println("Cleared sublist: " + arrList2SublistArr);

        boolean isEmpty = arrList2SublistArr.isEmpty();
        System.out.printf("Sublist empty? ... %b%n", isEmpty);
        System.out.println();

        /*
        Task 3 – Performance: Add at End vs. Start
        Description:
        Compare the performance difference when inserting at the end vs. at the beginning of an ArrayList.
        Input/Output Example:
        Inserting 999 at index 0 took: 2131 ms
        Inserting 999 at the end took: 1 ms
         */
        System.out.println("Task 3:");
        ArrayList<String> arrlist3 = new ArrayList<>();
        for (int i = 0; i < 99999999; i++) {
            arrlist3.add(i, "String");
        }
        String strToAdd3 = "Inserted";

        Instant instFirstPositionStart = Instant.now();
        arrlist3.add(0, strToAdd3);
        Instant instFirstPositionEnd = Instant.now();
        Duration durFirstPosition = Duration.between(instFirstPositionStart, instFirstPositionEnd);
        long nanoFirstPosition = durFirstPosition.toNanos();
        System.out.printf("Adding to the start: %d%n", nanoFirstPosition);

        Instant instLastPositionStart = Instant.now();
        arrlist3.add(strToAdd3);
        Instant instLastPositionEnd = Instant.now();
        Duration durLastPosition = Duration.between(instLastPositionStart, instLastPositionEnd);
        long nanoLastPosition = durLastPosition.toNanos();
        System.out.printf("Adding to the end: %d%n", nanoLastPosition);

        int comparResult = durFirstPosition.compareTo(durLastPosition);
        if (comparResult > 0) System.out.println("Adding to end is faster.");
        else if (comparResult < 0) System.out.println("Adding to start is faster.");
        else System.out.println("Operations took the same time to complete.");

        System.out.println();

        /*
        Task 4 – Capacity Management with trimToSize()
        Description:
        Explore internal capacity handling and simulate memory optimization.
        Input/Output Example:
        Initial size: 1000
        After removing 990 elements: size = 10
        Called trimToSize() – internal capacity now matches size (if observable)
         */
        System.out.println("Task 4:");
        ArrayList<String> arrlist4 = new ArrayList<>(1000);
        System.out.println("Size (empty): " + arrlist4.size());
        for (int i = 0; i < 1000; i++) {
            arrlist4.add("String");
        }
        System.out.println("Size (filled with 1000): " + arrlist4.size());
        for (int i = 0; i < 10; i++) {
            arrlist4.remove(i);
        }
        System.out.println("Size (after removal 990): " + arrlist4.size());
        arrlist4.trimToSize();
        System.out.println("Trimmed to size.");
        System.out.println();

        /*
        Task 5 – Working with Custom Objects
        Description:
        Use an ArrayList<Book> to practice with object storage and replacement.
        Input/Output Example:
        Accessed book at index 1: "The Hobbit" by Tolkien
        Replaced book at index 2 with "Dune" by Herbert
        Updated List:
        [Book1, Book2, Book3, Dune, Book5]
         */
        System.out.println("Task 5: ");
        Book book1 = new Book("The Dark Tower", "King");
        Book book2 = new Book("The Hobbit", "Tolkien");
        Book book3 = new Book("Replace", "Replace");
        Book book3Replacement = new Book("Dune", "Herbert");
        ArrayList<Book> books5 = new ArrayList<>();
        books5.add(book1);
        books5.add(book2);
        books5.add(book3);
        System.out.println("Original list: " + books5);
        System.out.println("Obtained book: " + books5.get(1));
        System.out.println("Replaced book: " + books5.set(2, book3Replacement));
        System.out.println("Updated collection: " + books5);
        System.out.println();

/*
        Task 6 – Ensure Capacity
        Description:
        Create an ArrayList with a small initial capacity. Increase its capacity in advance to accommodate at least 1000 elements efficiently.
        Output example:
        No visible output expected unless you're monitoring performance or debugging internal capacity.
*/
        System.out.println("Task 6:");
        ArrayList<Integer> arrList6def = new ArrayList<>();
        ArrayList<Integer> arrList6ExtraCapacity = new ArrayList<>(100);

        long startDef = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            arrList6def.add(i);
        }
        long endDef = System.nanoTime();
        long durationDef = endDef - startDef;
        System.out.println("Default capacity duration (nanoseconds): " + durationDef);

        long startExtra = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            arrList6ExtraCapacity.add(i);
        }
        long endExtra = System.nanoTime();
        long durationExtra = endExtra - startExtra;
        System.out.println("Default capacity duration (nanoseconds): " + durationExtra);

        System.out.println("Working with " + (
                (durationDef > durationExtra) ? "extra capacity" :
                        (durationDef < durationExtra) ? "default capacity" : "both arrays")
                + " is efficient!");
        System.out.println();

/*
        Task 7 – Trim Capacity
        Description:
        Populate an ArrayList with multiple elements. Remove a large number of them, and then trim the capacity to fit the current size.

        Output example:
        Original size: 100
        Trimmed size: 25
*/
        System.out.println("Task 7:");
        ArrayList<Integer> arrList7 = new ArrayList<>(100);
        arrList7.add(0, 999);
        arrList7.add(1, 999);
        arrList7.add(2, 999);
        System.out.println("Size: " + arrList7.size());
        arrList7.trimToSize();
        System.out.println();

/*
        Task 8 – Direct Access and Replacement
        Description:
        Access elements at specific positions and replace them with new values. Do this for the first, middle, and last element.
        Output example:
        Original list: [10, 20, 30, 40, 50]
        After replacement: [100, 20, 300, 40, 500]
        (⚠️ Uses inherited get() and set() methods from List)
*/
        System.out.println("Task 8:");
        ArrayList<Integer> arrList8 = new ArrayList<>();
        arrList8.add(10);
        arrList8.add(1, 20);
        arrList8.add(2, 30);
        arrList8.add(3, 40);
        arrList8.add(4, 50);
        System.out.println("Original array list: " + arrList8);
        int index8 = 0;
        System.out.println("Replaced element start: " + arrList8.set(index8, arrList8.get(index8)*10));
        System.out.println("New element: " + arrList8.get(index8));
        index8 = arrList8.size()/2;
        System.out.println("Replaced element middle: " + arrList8.set(index8, arrList8.get(index8)*10));
        System.out.println("New element: " + arrList8.get(index8));
        index8 = arrList8.size() - 1;
        System.out.println("Replaced element end: " + arrList8.set(index8, arrList8.get(index8)*10));
        System.out.println("New element: " + arrList8.get(index8));
        System.out.println("Modified array list: " + arrList8);
        System.out.println();

/*
        Task 9 – Index-based Insertion
        Description:
        Insert elements at various valid indexes, including the beginning, middle, and end of the ArrayList.
        Output example:
        Original list: [A, B, D]
        After insertions: [A, B, C, D, E]
        (⚠️ Uses inherited add(int, E) method from List)
*/
        System.out.println("Task 9:");
        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(0);
        arrList.add(0);
        arrList.add(0);
        arrList.add(0);

        long start9 = System.nanoTime();
        arrList.add(0, 999);
        long end9 = System.nanoTime();
        long result = end9 - start9;
        System.out.println("Inserting at the beginning requires (nano): " + result);

        start9 = System.nanoTime();
        arrList.add(2, 999);
        end9 = System.nanoTime();
        result = end9 - start9;
        System.out.println("Inserting in the middle requires (nano): " + result);

        start9 = System.nanoTime();
        arrList.add(arrList.size()-1, 999);
        end9 = System.nanoTime();
        result = end9 - start9;
        System.out.println("Inserting at the end requires (nano): " + result);
        System.out.println();
        
/*
        Task 10 – Index Lookup
        Description:
        Find the first and last index of duplicate elements in an ArrayList.
        Output example:
        List: [a, b, c, a, d, a]
        First index of 'a': 0
        Last index of 'a': 5
*/
        System.out.println("Task 10:");
        ArrayList<String> arrList10 = new ArrayList<>();
        arrList10.add("a");
        arrList10.add("b");
        arrList10.add("c");
        arrList10.add("a");
        arrList10.add("d");
        arrList10.add("a");
        System.out.println("Array List: " + arrList10);
        HashSet<String> arrList10CheckedElements = new HashSet<>();
        for (int i = 0; i < arrList10.size(); i++) {
            String element10 = arrList10.get(i);
            if (!arrList10CheckedElements.contains(element10)) {
                for (int j = 0; j < arrList10.size(); j++) {
                    if (i == j) continue;
                    if (arrList10.get(j).equals(element10)) {
                        System.out.println("First index of \'" + element10 + "\': " + arrList10.indexOf(element10));
                        System.out.println("Last index of \'" + element10 + "\': " + arrList10.lastIndexOf(element10));
                        break;
                    }
                }
            }
            arrList10CheckedElements.add(element10);
        }
        System.out.println();

/*
        Task 11 – Create a Sublist
        Description:
        Generate a sublist from an ArrayList that includes a middle portion of the elements.
        Output example:
        Original list: [10, 20, 30, 40, 50, 60]
        Sublist (from index 2 to 4): [30, 40]
        */
        System.out.println("Task 11:");
        // !!! sublist is a view, not a copy !!!
        ArrayList<Integer> arrlist11Main = new ArrayList<>();
        arrlist11Main.add(10);
        arrlist11Main.add(20);
        arrlist11Main.add(30);
        arrlist11Main.add(40);
        arrlist11Main.add(50);
        System.out.println("Original: " + arrlist11Main);
        List<Integer> arrlist11View = new ArrayList<>();
        arrlist11View = arrlist11Main.subList(2, 4);
        System.out.println("View: " + arrlist11View);
        System.out.println("Modifying view ...");
        arrlist11View.set(0, 999);
        System.out.println("Original: " + arrlist11Main);
        System.out.println("View: " + arrlist11View);
        System.out.println();

        /*
        Task 12 – Bulk Insert via Another List
        Description:
        Insert all elements from one ArrayList into another at a specific index.
        Output example:
        List A: [1, 2, 3]
        List B: [8, 9]
        After insertion: [1, 2, 8, 9, 3]
*/
        System.out.println("Task 12:");
        ArrayList<Integer> arrList12A = new ArrayList<>();
        arrList12A.add(1);
        arrList12A.add(2);
        arrList12A.add(3);
        System.out.println("ArrayList A: " + arrList12A);
        ArrayList<Integer> arrList12B = new ArrayList<>();
        arrList12B.add(8);
        arrList12B.add(9);
        System.out.println("ArrayList B: " + arrList12B);
        arrList12A.addAll(2, arrList12B);
        System.out.println("ArrayList A modified: " + arrList12A);
        System.out.println();

        /*
        Task 13 – Resize by Removing a Range
        Description:
        Remove a specific range of elements from the list using an index-based loop.
        Output example:
        Original list: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        After removing indexes 3–6: [0, 1, 2, 7, 8, 9]
*/
        System.out.println("Task 13:");
        ArrayList<Integer> arrList13 = new ArrayList<>();
        arrList13.add(0);
        arrList13.add(1);
        arrList13.add(2);
        arrList13.add(3);
        arrList13.add(4);
        arrList13.add(5);
        arrList13.add(6);
        arrList13.add(7);
        arrList13.add(8);
        arrList13.add(9);
        System.out.println("Original: " + arrList13);
        int indexStart13 = 3, indexEnd14 = 6;
        List<Integer> arrList13Subl = arrList13.subList(indexStart13,indexEnd14+1);
        arrList13.removeAll(arrList13Subl); // arrList13.subList(indexStart13, indexEnd14 + 1).clear();
        System.out.println("Modified: " + arrList13);
        System.out.println();

/*
        Task 14 – Clone the List
        Description:
        Clone an ArrayList and verify changes to one list do not affect the other.
        Output example:
        Original: [apple, banana]
        Clone before change: [apple, banana]
        Original after change: [apple, banana, cherry]
        Clone after change: [apple, banana]
*/
        System.out.println("Task 14:");
        ArrayList<String> arrList14 = new ArrayList<>();
        arrList14.add("apple");
        arrList14.add("banana");
        ArrayList<String> arrList14Cloned = new ArrayList<>();
        arrList14Cloned = (ArrayList<String>) arrList14.clone();
        arrList14.add("test");
        System.out.println("Original: " + arrList14);
        System.out.println("Cloned: " + arrList14Cloned);
        System.out.println();

        /*
        Task 15 – Conversion to Array
        Description:
        Convert the ArrayList into a regular array and print its elements.
        Output example:
        Array contents: [cat, dog, rabbit]
*/
        System.out.println("Task 15:");
        ArrayList<String> arrList15 = new ArrayList<>();
        arrList15.add("cat");
        arrList15.add("dog");
        arrList15.add("rabbit");
        Object[] arrFromList15 = new String[arrList15.size()];
        arrFromList15 = arrList15.toArray();
        System.out.println(Arrays.toString(arrFromList15));
        System.out.println();


    }

}
