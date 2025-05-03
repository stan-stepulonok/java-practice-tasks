package ArrayListClass;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

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




    }

}
