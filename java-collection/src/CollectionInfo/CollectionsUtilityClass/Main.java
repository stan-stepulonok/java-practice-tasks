package CollectionInfo.CollectionsUtilityClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

/*      Task 8: Reverse a List
        Description:
        Create a list with at least five elements in a specific order. Reverse the order of the elements and print the list.
        Output Example:
        Original list: [apple, banana, cherry, date, elderberry]
        Reversed list: [elderberry, date, cherry, banana, apple]
        */
        System.out.println("Task 8:");
        List<String> list8 = new ArrayList<>();
        list8.add("apple");
        list8.add("banana");
        list8.add("cherry");
        list8.add("date");
        list8.add("elderberry");
        System.out.println("Before reverse: " + list8);
        Collections.reverse(list8);
        System.out.println("After reverse: " + list8);
        System.out.println();

/*      Task 9: Sort a List of Strings
        Description:
        Create a list containing at least five string elements in random order. Sort the list in ascending order and display the result.
        Output Example:
        Original list: [zebra, apple, lemon, banana, mango]
        Sorted list: [apple, banana, lemon, mango, zebra]
        */
        System.out.println("Task 9:");
        List<String> list9 = new ArrayList<>();
        list9.add("zebra");
        list9.add("apple");
        list9.add("lemon");
        list9.add("banana");
        list9.add("mango");
        System.out.println("Before sorting: " + list9);
        Collections.sort(list9);
        System.out.println("After sorting: " + list9);
        System.out.println();

/*        Task 10: Find Maximum and Minimum Values
        Description:
        Create a list of integers. Find and display both the minimum and maximum values in the list.
        Output Example:
        List: [42, 7, 19, 85, 23]
        Min: 7, Max: 85
        */
        System.out.println("Task 10:");
        List<Integer> list10 = new ArrayList<>();
        list10.add(42);
        list10.add(7);
        list10.add(19);
        list10.add(85);
        list10.add(23);
        int max10 = Collections.max(list10);
        int min10 = Collections.min(list10);
        System.out.println("Collection: " + list10);
        System.out.println("Min: " + min10+ ", Max: " + max10);
        System.out.println();

/*        Task 11: Shuffle a List
        Description:
        Create a list with several elements in order. Shuffle the list randomly and print the result.
        Output Example:
        Original list: [1, 2, 3, 4, 5, 6]
        Shuffled list: [3, 6, 1, 5, 4, 2]
        */
        System.out.println("Task 11:");
        List<Integer> list11 = new ArrayList<>();
        list11.add(1);
        list11.add(2);
        list11.add(3);
        list11.add(4);
        list11.add(5);
        list11.add(6);
        System.out.println("Original list: " + list11);
        Collections.shuffle(list11);
        System.out.println("Shuffled list: " + list11);
        System.out.println();

/*
        Task 12: Fill a List with a Specific Element
        Description:
        Create a list with a certain number of elements and replace all elements in the list with the same value.
        Output Example:
        Original list: [1, 2, 3, 4, 5]
        Filled list: [0, 0, 0, 0, 0]
*/
        System.out.println("Task 12:");
        List<Integer> list12 = new ArrayList<>();
        list12.add(1);
        list12.add(2);
        list12.add(3);
        list12.add(4);
        list12.add(5);
        System.out.println("Original list: " + list12);
        Collections.fill(list12, 0);
        System.out.println("Filled list: " + list12);
        System.out.println();

        /*
        Task 13: Replace All Occurrences of an Element
        Description:
        Create a list with repeated elements. Replace all occurrences of a specific element with a new one.
        Output Example:
        Original list: [dog, cat, dog, rabbit, dog]
        After replacement: [wolf, cat, wolf, rabbit, wolf]
        */
        System.out.println("Task 13:");
        List<String> list13 = new ArrayList<>();
        list13.add("dog");
        list13.add("cat");
        list13.add("dog");
        list13.add("rabbit");
        list13.add("dog");
        System.out.println("Original list: " + list13);
        boolean replacement13 = Collections.replaceAll(list13, "dog", "wolf");
        System.out.println("Replaced? ... " + replacement13);
        System.out.println("After replacement: " + list13);
        System.out.println();

/*
        Task 14: Copy Elements from One List to Another
        Description:
        Create two lists: a source and a destination. Copy the elements from the source list into the destination list and print both lists.
        Output Example:
        Source: [A, B, C]
        Destination before: [X, Y, Z]
        Destination after: [A, B, C]
*/
        System.out.println("Task 14:");
        List<String> source13 = new ArrayList<>();
        source13.add("A");
        source13.add("B");
        source13.add("C");
        System.out.println("Source: " + source13);
        List<String> destination13 = new ArrayList<>();
        destination13.add("X");
        destination13.add("Y");
        destination13.add("Z");
        System.out.println("Destination before: " + destination13);
        Collections.copy(destination13, source13);
        System.out.println("Destination after: " + destination13);
        // !!!! both collections should be of the same size !!!!

/*
        Task 15: Frequency of an Element
        Description:
        Create a list with some elements repeated. Count how many times a specific element appears in the list.
        Output Example:
        List: [red, blue, red, green, red, blue]
        Frequency of "red": 3
*/
        System.out.println("Task 15:");
        List<String> list15 = new ArrayList<>();
        list15.add("red");
        list15.add("blue");
        list15.add("red");
        list15.add("green");
        list15.add("red");
        list15.add("blue");
        System.out.println("List: " + list15);
        String findFrequency15 = "red";
        int frequency15 = Collections.frequency(list15, findFrequency15);
        System.out.println("Frequency of \"" + findFrequency15 + "\": " + frequency15);
        System.out.println();

/*
        Task 16: Binary Search on a Sorted List
        Description:
        Create a sorted list and search for the index of a specific element using binary search.
        Output Example:
        Sorted list: [10, 20, 30, 40, 50]
        Index of 30: 2
*/
        System.out.println("Task 16:");
        List<Integer> list16 = new ArrayList<>();
        list16.add(70);
        list16.add(20);
        list16.add(40);
        list16.add(10);
        list16.add(50);
        list16.add(20);
        System.out.println("Original list: " + list16);
        // int indexOfElement = Collections.binarySearch(list16, 20); // will work but gives invalid result
        Collections.sort(list16);
        System.out.println("Sorted list: " + list16);

        Integer searchedElement = 20;
        int indexOfElement = Collections.binarySearch(list16, searchedElement);
        System.out.println("Index of " + searchedElement + ": " + indexOfElement); // could return either 1 or 2 because elements repeated

        searchedElement = 50;
        indexOfElement = Collections.binarySearch(list16, searchedElement);
        System.out.println("Index of " + searchedElement + ": " + indexOfElement);
        System.out.println();

/*
        Task 17: Make a List Unmodifiable
        Description:
        Create a modifiable list, then convert it to an unmodifiable version and try to add an element (should trigger an error or be impossible). Print the list.
        Output Example:
        List before making unmodifiable: [1, 2, 3]
        Attempt to add 4: UnsupportedOperationException
        Final list: [1, 2, 3]
*/
        System.out.println("Task 17:");
        List<Integer> list17Mod = new ArrayList<>();
        list17Mod.add(1);
        list17Mod.add(2);
        list17Mod.add(3);
        System.out.println(list17Mod);
        List<Integer> list17Unmod = Collections.unmodifiableList(list17Mod);
        try {
            list17Unmod.add(4);
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        }
        list17Mod.add(4);
        System.out.println(list17Mod);
        System.out.println();



    }

}
