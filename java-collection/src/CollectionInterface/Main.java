package CollectionInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        /*
        Task 1:
        Create a collection of integers. Add some numbers to it. Then, remove all even numbers.
        Input: 1, 2, 3, 4, 5, 6
        Expected Output: 1, 3, 5
         */
        System.out.println("Task 1:");
        Collection<Integer> coll1 = new ArrayList<>();
        System.out.println("Initial: " + coll1 + " " + coll1.size());
        coll1.add(1);
        coll1.add(2);
        coll1.add(3);
        coll1.add(4);
        coll1.add(5);
        coll1.add(6);
        System.out.println("Filled: " + coll1 + " " + coll1.size());
        Iterator<Integer> iter1 = coll1.iterator();
        while (iter1.hasNext()) {
            Integer int1 = iter1.next();
            if (int1 % 2 == 0) {
                iter1.remove(); // alternatively, write indices into collection and use Collection method remove() to remove elements with these indices
            }
        }
        System.out.println("Modified: " + coll1 + " " + coll1.size());
        System.out.println();

        /*
        Task 2:
        Initialize a collection with 5 unique strings. Then, check if a given word is present in the collection.
        Input: ["apple", "banana", "cherry", "date", "fig"], Search: "banana"
        Expected Output: true
         */
        System.out.println("Task 2:");
        Collection<String> coll2 = new ArrayList<>();
        coll2.add("apple");
        coll2.add("banana");
        coll2.add("cherry");
        coll2.add("date");
        coll2.add("fig");
        System.out.println("Collection: " + coll2);
        String wordToCheck = "banana";
        boolean result2 = coll2.contains(wordToCheck);
        System.out.println("Is '" + wordToCheck + "' present in collection? ... " + result2);
        if (result2) {
            int index = 0;
            Iterator<String> iter2 = coll2.iterator();
            while (iter2.hasNext()) {
                if(iter2.next().equals(wordToCheck)) break;
                index++;
            }
            System.out.println("The index of this word is: " + index);
        }
        System.out.println();

        /*
        Task 3:
        Create a collection of student names. Remove all names shorter than 5 characters.
        Input: ["Tom", "Emily", "Max", "Anna", "Charles"]
        Expected Output: ["Emily", "Charles"]
         */
        System.out.println("Task 3: ");
        Collection<String> coll3 = new ArrayList<>();
        coll3.add("Tom");
        coll3.add("Emily");
        coll3.add("Max");
        coll3.add("Anna");
        coll3.add("Charles");
        System.out.println("Original Collection: " + coll3);
        int charLimit = 5;
        Iterator<String> iter3 = coll3.iterator();
        while(iter3.hasNext()) {
            String name3 = iter3.next();
            if (name3.length() < 5) {
                iter3.remove();
                System.out.println("Removed -> " + name3);
            }
        }
        System.out.println("Modified Collection: " + coll3);
        System.out.println();

        /*
        Task 4:
        Create two separate collections of strings. Then, check whether all elements from one collection exist in the other.
        Input:
        Collection A: ["a", "b", "c"]
        Collection B: ["a", "b"]
        Expected Output: true
         */
        System.out.println("Task 4: ");
        Collection<String> coll4A = new ArrayList<>();
        coll4A.add("a");
        coll4A.add("b");
        coll4A.add("c");
        System.out.println("Collection A: " + coll4A);
        Collection<String> coll4B = new ArrayList<>();
        coll4B.add("a");
        coll4B.add("b");
        System.out.println("Collection B: " + coll4B);
        System.out.println("A contains all from B? ... " + coll4A.containsAll(coll4B));
        System.out.println();

        /*
        Task 5:
        Create a collection of integers. Replace its contents with only the elements from another collection.
        Input:
        Collection A: 1, 2, 3, 4
        Collection B: 3, 4, 5, 6
        Expected Output for A: 3, 4
         */
        System.out.println("Task 5:");

        Collection<Integer> coll5A = new ArrayList<>();
        coll5A.add(1);
        coll5A.add(2);
        coll5A.add(3);
        coll5A.add(4);
        System.out.println("Collection A: " + coll5A);

        Collection<Integer> coll5B = new ArrayList<>();
        coll5B.add(3);
        coll5B.add(4);
        coll5B.add(5);
        coll5B.add(6);
        System.out.println("Collection B: " + coll5B);

        Iterator<Integer> iter5A = coll5A.iterator();
        while(iter5A.hasNext()) {
            Integer item5 = iter5A.next();
            boolean contains5 = coll5B.contains(item5);
            if (!contains5) iter5A.remove();
        }
        System.out.println("Collection B Modified: " + coll5B);
        System.out.println();

        /*
        Task 6:
        Populate a collection with 10 random strings. Then clear all elements. Print the collection afterward.
        Expected Output: []
         */
        System.out.println("Task 6: ");
        Collection<String> coll6 = new ArrayList<>();
        System.out.println("Original collection: " + coll6);
        int iterations6 = 10;
        for (int i = 0; i < iterations6; i++) {
            StringBuilder sb6 = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                char randChar = (char)(65 + Math.random() * 25);
                sb6.append(randChar);
            }
            String random6 = new String(sb6);
            coll6.add(random6);
        }
        System.out.println("Filled collection: " + coll6);
        coll6.clear();
        System.out.println("Cleared collection: " + coll6);
        System.out.println();

        /*
        Task 7:
        Create a collection of words. Add duplicates. Print the size of the collection and check whether it contains a specific word multiple times.
        Input: ["cat", "dog", "cat", "bird", "dog"], Check: "dog"
        Expected Output: Size: 5, Contains "dog": true
         */
        System.out.println("Task 7: ");
        String wordToCheck7 = "dog";
        Collection<String> coll7 = new ArrayList<>();
        coll7.add("cat");
        coll7.add("dog");
        coll7.add("cat");
        coll7.add("bird");
        coll7.add("dog");
        System.out.println("Collection: " + coll7);
        System.out.println("Size: " + coll7.size());
        Iterator<String> iter7 = coll7.iterator();
        boolean multipleEntries7 = false;
        int entriesCount7 = 0;
        while (iter7.hasNext()) {
            String entry7 = iter7.next();
            if (entry7.equals(wordToCheck7)) {
                entriesCount7++;
            }
            if (entriesCount7 == 2) multipleEntries7 = true;
        }
        if(multipleEntries7) {
            System.out.println("The word '" + wordToCheck7 + "' appeared " + entriesCount7 + " times!");
        } else if (entriesCount7 == 1) System.out.println("The word '" + wordToCheck7 + "' appeared only once!");
        else System.out.println("The word '" + wordToCheck7 + "' is not in the collection!");
        System.out.println();

        /*
        Task 8:
        Take a collection of numbers. Check if it's empty, then add elements until it contains exactly 5 items.
        Expected Output (after additions): Collection contains 5 items
         */
        System.out.println("Task 8:");
        Collection<Integer> coll8 = new ArrayList<>();
        boolean isEmpty8 = coll8.isEmpty();
        System.out.println("Is collection empty? ... " + isEmpty8);
        int itemsToAdd8 = 5;
        for (int i = 0; i < itemsToAdd8; i++) {
            coll8.add((int)(Math.random() * 999));
        }
        isEmpty8 = coll8.isEmpty();
        System.out.println("Is collection empty? ... " + isEmpty8);
        System.out.println("Collection: " + coll8);
        System.out.printf("Collection contains %d items", coll8.size());
        System.out.println();

        /*
        Task 9:
        Create a collection of strings. Try removing all elements that match a given set of forbidden words.
        Input:
        Initial: ["sun", "moon", "star", "sky", "cloud"]
        Forbidden: ["moon", "sky"]
        Expected Output: ["sun", "star", "cloud"]
         */
        System.out.println("Task 9: ");
        Collection<String> coll9 = new ArrayList<>();
        coll9.add("sun");
        coll9.add("moon");
        coll9.add("star");
        coll9.add("sky");
        coll9.add("cloud");
        Iterator<String> iter9 = coll9.iterator();
        System.out.println("Original collection: " + coll9);
        Collection<String> forbiddenColl9 = new ArrayList<>();
        forbiddenColl9.add("moon");
        forbiddenColl9.add("sky");
        System.out.println("Forbidden words: " + forbiddenColl9);
        while (iter9.hasNext()) {
            String entry9 = iter9.next();
            if (forbiddenColl9.contains(entry9)) {
                iter9.remove();
            }
        }
        System.out.println("Refined collection: " + coll9);
        System.out.println();

        /*
        Task 10:
        Create a collection with at least 7 elements. Convert the collection to an array and print each element in uppercase.
        Input: ["blue", "red", "green", "yellow", "orange", "white", "black"]
        Expected Output: ["BLUE", "RED", "GREEN", "YELLOW", "ORANGE", "WHITE", "BLACK"]
         */
        System.out.println("Task 10: ");
        Collection<String> coll10 = new ArrayList<>();
        coll10.add("blue");
        coll10.add("red");
        coll10.add("green");
        coll10.add("yellow");
        coll10.add("orange");
        coll10.add("white");
        coll10.add("black");
        System.out.println("Collection: " + coll10);
        // Use "<T> T[] toArray(T[] a)" and not "Object[] toArray()"
        String[] strArray10 = coll10.toArray(new String[coll10.size()]);
        for (int i = 0; i < strArray10.length; i++) {
            strArray10[i] = strArray10[i].toUpperCase();
        }
        System.out.println(Arrays.toString(strArray10));
        System.out.println();

    }

}
