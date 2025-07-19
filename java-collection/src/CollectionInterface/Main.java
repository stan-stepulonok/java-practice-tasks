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

/*      Task 11: Add and Display
        Description:
        Create a collection and add at least five different elements (e.g., strings, integers, or custom objects).
        Print the entire collection afterward.
        Output example:
        [cat, dog, parrot, hamster, rabbit]
        */
        System.out.println("Task 11: ");
        // Object
        String str1 = "Test 1";
        Integer int1 = 1;
        Collection<Object> coll111 = new ArrayList<>();
        coll111.add(str1);
        coll111.add(int1);
        System.out.println("Collection of objects: " + coll111);
        // String
        String str2 = "Test 2";
        Collection<String> coll112 = new ArrayList<>();
        coll112.add(str1);
        coll112.add(str2);
        System.out.println("Collection of strings: " + coll112);
        // CustomObject
        Main.CustomObject obj1 = new CustomObject("Test", 1);
        Main.CustomObject obj2 = new CustomObject("Test", 2);
        Collection<Main.CustomObject> coll113 = new ArrayList<>();
        coll113.add(obj1);
        coll113.add(obj2);
        System.out.println("Collection of custom objects: " + coll113);
        System.out.println();


/*        Task 12: Check Existence
        Description:
        Check if certain elements exist in the collection and print the result.
        Output example:
        Element "dog" exists: true
        Element "lion" exists: false
        */
        System.out.println("Task 12: ");
        String dog12 = "dog";
        String wolf12 = "wolf";
        Collection<String> coll12 = new ArrayList<>();
        coll12.add(dog12);
        coll12.add(wolf12);
        System.out.println("Collection 12: " + coll12);
        String checkString = "dog";
        System.out.println(checkString + " in the collection? ... " + coll12.contains(checkString));
        checkString = "lion";
        System.out.println(checkString + " in the collection? ... " + coll12.contains(checkString));
        System.out.println();

/*      Task 13: Remove Elements
        Description:
        Remove an existing element and try removing a non-existing one.
        Print the collection after each operation and show whether the removal was successful.
        Output example:
        Removing "dog": true
                [cat, parrot, hamster, rabbit]
        Removing "lion": false
                [cat, parrot, hamster, rabbit]
                */

        System.out.println("Task 13: ");
        Collection<String> coll13 = new ArrayList<>();
        coll13.add("cat");
        coll13.add("parrot");
        coll13.add("hamster");
        coll13.add("dog");
        coll13.add("rabbit");
        System.out.println("Collection 13 before: " + coll13);
        System.out.println("Removing dog -> " + coll13.remove("dog"));
        System.out.println("Collection 13 after removing dog: " + coll13);
        System.out.println("Removing non-existed -> " + coll13.remove("test"));
        System.out.println("Collection 13 after removing unexisting: " + coll13);
        System.out.println();

/*      Task 14: Bulk Add and Remove
        Description:
        Add a group of elements from another collection.
        Then remove all elements of a different collection from the original one.
        Display the result after each operation.
        Output example:
        After bulk add: [cat, parrot, hamster, rabbit, mouse, turtle]
        After bulk remove: [cat, parrot, rabbit, turtle]
        */
        System.out.println("Task 14: ");
        Collection<String> coll141 = new ArrayList<>();
        coll141.add("cat1");
        coll141.add("cat2");
        coll141.add("cat3");
        coll141.add("cat4");
        System.out.println("Before 1: " + coll141);
        Collection<String> coll142 = new ArrayList<>();
        coll142.add("dog1");
        coll142.add("dog2");
        coll142.add("dog3");
        coll142.add("dog4");
        System.out.println("Before 2: " + coll142);
        System.out.println("Add 1 into 2: " + coll142.addAll(coll141));
        System.out.println("After add 2: " + coll142);
        System.out.println("Remove 1 from 2: " + coll142.removeAll(coll141));
        System.out.println("After remove 2: " + coll142);
        System.out.println();

/*      Task 15: Retain Common Elements
        Description:
        Given two collections, retain only the elements that are common in both. Print the collection after the operation.
        Output example:
        Original: [apple, banana, cherry, date]
        Other: [banana, cherry, fig]
        After retain: [banana, cherry]
        */
        System.out.println("Task 15:");
        Collection<String> coll151 = new ArrayList<>();
        coll151.add("test1");
        coll151.add("test2");
        coll151.add("test3");
        coll151.add("test4");
        Collection<String> coll152 = new ArrayList<>();
        coll152.add("test3");
        coll152.add("test4");
        coll152.add("test5");
        coll152.add("test6");
        Collection<String> coll153 = new ArrayList<>();
        System.out.println("Retained before: " + coll153);
        coll153.addAll(coll151);
        System.out.println("Retained after copying 1: " + coll153);
        coll153.retainAll(coll152);
        System.out.println("Retained Collection: " + coll153);
        System.out.println();

/*      Task 16: Convert to Array
        Description:
        Convert the collection to an array and print the contents of the array.
        Output example:
        Array: [blue, red, green]
        */
        System.out.println("Task 16:");
        Collection<String> coll16 = new ArrayList<>();
        coll16.add("blue");
        coll16.add("red");
        coll16.add("green");
        String[] collectionToArray = new String[coll16.size()];
        collectionToArray = coll16.toArray(collectionToArray);
        System.out.println("Array: " + Arrays.toString(collectionToArray));
        System.out.println();

/*      Task 17: Clear and Check Empty
        Description:
        Clear all elements from the collection. Before and after clearing, check if the collection is empty.
        Output example:
        Is empty before clear: false
        Is empty after clear: true
        */
        System.out.println("Task 17:");
        Collection<String> coll17 = new ArrayList<>();
        coll17.add("test1");
        coll17.add("test2");
        coll17.add("test3");
        System.out.println("Before: " + coll17);
        System.out.println("Is empty? ... " + coll17.isEmpty());
        coll17.clear();
        System.out.println("After clear ... " + coll17);
        System.out.println("Is empty? ... " + coll17.isEmpty());
        System.out.println();

/*      Task 18: Size Tracking
        Description:
        Track the size of the collection before and after a series of additions and removals.
        Output example:
        Size before additions: 2
        Size after additions: 5
        Size after removals:
        */
        System.out.println("Task 18:");
        Collection<String> coll18 = new ArrayList<>();
        System.out.println(coll18.size());
        coll18.add("test1");
        System.out.println(coll18.size());
        coll18.remove("test1");
        System.out.println(coll18.size());
        System.out.println();


/*      Task 19: Iterate with for-each
        Description:
        Iterate over the collection using a for-each loop and print each element on a new line.
        Output example:
        Element: one
        Element: two
        Element: three
        */
        System.out.println("Task 19:");
        Collection<String> coll19 = new ArrayList<>();
        coll19.add("one");
        coll19.add("two");
        coll19.add("three");
        for(String s : coll19) {
            System.out.println("Element: " + s);
        }
        System.out.println();

    }

    static class CustomObject {
        String strProperty;
        Integer intProperty;
        CustomObject(String strProperty, Integer intProperty) {
            this.strProperty = strProperty;
            this.intProperty = intProperty;
        }
        @Override
        public String toString() {
            return strProperty + intProperty;
        }
    }

}
