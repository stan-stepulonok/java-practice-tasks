package CollectionsUtilityClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        /*
        Task 1: Sort a List
        Goal: Sort a list of integers in ascending order.
        Input: [5, 2, 8, 1, 3]
        Expected Output: [1, 2, 3, 5, 8]
         */
        System.out.println("Task 1: ");
        ArrayList<Integer> arrlist1 = new ArrayList<>();
        arrlist1.add(5);
        arrlist1.add(2);
        arrlist1.add(8);
        arrlist1.add(1);
        arrlist1.add(3);
        System.out.println("Original list: " + arrlist1);
        // Comparable from Integer
        Collections.sort(arrlist1);
        System.out.println("Sorted list default comparable implementation (asc): " + arrlist1);
        // Custom Comparator
        Comparator<Integer> compar1 = new Comparator<>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2.compareTo(i1);
            }
        };
        Collections.sort(arrlist1, compar1);
        System.out.println("Sorted list custom comparator implementation (desc): " + arrlist1);
        System.out.println();

        /*
        Task 2: Reverse a List
        Goal: Reverse the order of elements in a list.
        Input: ["a", "b", "c", "d"]
        Expected Output: ["d", "c", "b", "a"]
         */
        System.out.println("Task 2:");
        ArrayList<String> arrlist2 = new ArrayList<>();
        arrlist2.add("a");
        arrlist2.add("b");
        arrlist2.add("c");
        arrlist2.add("d");
        System.out.println("Original list: " + arrlist2);
        Collections.reverse(arrlist2);
        System.out.println("Reversed list: " + arrlist2);
        System.out.println();

        /*
        Task 3: Find Max and Min
        Goal: Find the maximum and minimum values in a list.
        Input: [10, 40, 20, 70, 30]
        Expected Output: Max = 70, Min = 10
         */
        System.out.println("Task 3: ");
        ArrayList<Integer> arrlist3 = new ArrayList<>();
        arrlist3.add(10);
        arrlist3.add(40);
        arrlist3.add(20);
        arrlist3.add(70);
        arrlist3.add(30);
        System.out.println("ArrayList: " + arrlist3);
        // work for the objects whose classes implement Comparable or Comparator
        // Integer uses Comparable
        Integer max = Collections.max(arrlist3);
        Integer min = Collections.min(arrlist3);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        // Use custom Comparator and reverse the result
        Comparator<Integer> comp2 = new Comparator<>() {
          @Override
          public int compare(Integer i1, Integer i2) {
              return i2.compareTo(i1);
          }
        };
        Integer maxReversed = Collections.max(arrlist3, comp2);
        Integer minReversed = Collections.min(arrlist3, comp2);
        System.out.println("Max (in fact min): " + maxReversed);
        System.out.println("Min (in fact max): " + minReversed);
        System.out.println();

        /*
        Task 4: Fill a List with a Single Value
        Goal: Replace all elements of a list with the same value.
        Input: [1, 2, 3, 4], Fill with 0
        Expected Output: [0, 0, 0, 0]
         */
        System.out.println("Task 4:");
        ArrayList<Integer> arrlist4 = new ArrayList<>();
        arrlist4.add(1);
        arrlist4.add(2);
        arrlist4.add(3);
        arrlist4.add(4);
        System.out.println("Original list: " + arrlist4);
        Collections.swap(arrlist4, 1, 0);
        System.out.println("Filled with 0 list: " + arrlist4);
        System.out.println();

        /*
        Task 5: Shuffle a List
        Goal: Randomly shuffle elements in a list.
        Input: [1, 2, 3, 4, 5]
        Expected Output: A shuffled version like [3, 1, 5, 2, 4] (output will vary)
         */
        System.out.println("Task 5: ");
        ArrayList<Integer> arrlist5 = new ArrayList<>();
        arrlist5.add(1);
        arrlist5.add(2);
        arrlist5.add(3);
        arrlist5.add(4);
        arrlist5.add(5);
        System.out.println("Original: " + arrlist5);
        Collections.shuffle(arrlist5);
        System.out.println("Shuffled: " + arrlist5);
        System.out.println();

        /*
        Task 6: Frequency Count
        Goal: Count how many times a specific value appears in a list.
        Input: ["apple", "banana", "apple", "orange"], Check: "apple"
        Expected Output: 2
         */
        System.out.println("Task 6: ");
        ArrayList<String> arrlist6 = new ArrayList<>();
        arrlist6.add("apple");
        arrlist6.add("banana");
        arrlist6.add("apple");
        arrlist6.add("orange");
        System.out.println("ArrayList: " + arrlist6);
        int frequency = Collections.frequency(arrlist6, new String("apple"));
        System.out.println("\"apple\" present in the list: " + frequency);
        System.out.println();

        /*
        Task 7: Replace All Occurrences
        Goal: Replace all occurrences of a value in a list.
        Input: [1, 2, 1, 3, 1], Replace 1 with 9
        Expected Output: [9, 2, 9, 3, 9]
        Method: Collections.replaceAll(List, oldVal, newVal)
         */
        System.out.println("Task 7: ");
        Integer replace = 1;
        Integer replacement = 9;
        ArrayList<Integer> arrlist7 = new ArrayList<>();
        arrlist7.add(1);
        arrlist7.add(2);
        arrlist7.add(1);
        arrlist7.add(3);
        arrlist7.add(1);
        System.out.println("Original: " + arrlist7);
        Collections.replaceAll(arrlist7, replace, replacement);
        System.out.println("Replaced: " + arrlist7);
        System.out.println();

    }

}
