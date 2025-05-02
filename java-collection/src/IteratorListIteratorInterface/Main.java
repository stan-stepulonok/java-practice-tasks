package IteratorListIteratorInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {

        /*
        Task 1: Remove All Even Numbers Using Iterator
        Input: [10, 15, 20, 25, 30]
        Expected Output: [15, 25]
         */
        System.out.println("Task 1:");
        ArrayList<Integer> arrlist1 = new ArrayList<>();
        arrlist1.add(10);
        arrlist1.add(15);
        arrlist1.add(20);
        arrlist1.add(25);
        arrlist1.add(30);
        System.out.println("Original: " + arrlist1);
        Iterator<Integer> iter1 = arrlist1.iterator();
        while(iter1.hasNext()) {
            Integer temp1 = iter1.next();
            if (temp1 % 2 == 0) {
                System.out.println("Even number removed -> " + temp1);
                iter1.remove();
            }
        }
        System.out.println("Odd only: " + arrlist1);
        System.out.println();

        /*
        Task 2: Replace All "x" With "z" Using ListIterator
        Input: ["a", "x", "b", "x", "c"]
        Expected Output: ["a", "z", "b", "z", "c"]
         */
        System.out.println("Task 2: ");
        ArrayList<String> arrlist2 = new ArrayList<>();
        arrlist2.add("a");
        arrlist2.add("x");
        arrlist2.add("b");
        arrlist2.add("x");
        arrlist2.add("c");
        System.out.println("Original: " + arrlist2);
        ListIterator<String> literator2 = arrlist2.listIterator();
        String replace = "x", replacement = "z";
        while (literator2.hasNext()) {
            String temp2 = literator2.next();
            if (temp2.equals(replace)) {
                System.out.println("Replaced '" + replace + "' with '" + replacement + "'.");
                literator2.set(replacement);
            }
        }
        System.out.println("Replaced: " + arrlist2);
        System.out.println();

        /*
        Task 3: Iterate Forward and Backward Through a List
        Input: [1, 2, 3, 4]
        Expected Output (Forward): 1 2 3 4
        Expected Output (Backward): 4 3 2 1
         */
        System.out.println("Task 3: ");

        ArrayList<Integer> arrlist3 = new ArrayList<>();
        arrlist3.add(1);
        arrlist3.add(2);
        arrlist3.add(3);
        arrlist3.add(4);
        System.out.println("Original: " + arrlist3);

        ArrayList<Integer> arrlist3Reversed = new ArrayList<>();

        ListIterator<Integer> literator3 = arrlist3.listIterator();
        while (literator3.hasNext()) {
            literator3.next();
            System.out.println("Moving the cursor to the end...");
        }
        System.out.println("The cursor is at the end.");
        while (literator3.hasPrevious()) {
            Integer temp3 = literator3.previous();
            arrlist3Reversed.add(temp3);
        }

        System.out.println("New reversed array list: " + arrlist3Reversed);

        // Collections method reverse()
        Collections.reverse(arrlist3);
        System.out.println("Original reversed: " + arrlist3);
        System.out.println();

        /*
        Task 4: Use ListIterator to Add "X" After Every Element
        Input: ["A", "B", "C"]
        Expected Output: ["A", "X", "B", "X", "C", "X"]
         */
        System.out.println("Task 4:");
        ArrayList<String> arrlist4 = new ArrayList<>();
        arrlist4.add("A");
        arrlist4.add("B");
        arrlist4.add("C");
        System.out.println("Original: " + arrlist4);
        String addition = "X";
        ListIterator<String> literator4 = arrlist4.listIterator();
        while (literator4.hasNext()) {
            String temp = literator4.next().concat(addition);
            literator4.set(temp);
            System.out.println("Concatenation completed.");
        }
        System.out.println("Updated: " + arrlist4);
        System.out.println();

        /*
        Task 5: Count Occurrences of an Element Using Iterator
        Input: ["apple", "banana", "apple", "cherry", "apple"], Element to count: "apple"
        Expected Output: 3
         */
        System.out.println("Task 5:");
        ArrayList<String> arrlist5 = new ArrayList<>();
        arrlist5.add("apple");
        arrlist5.add("banana");
        arrlist5.add("apple");
        arrlist5.add("cherry");
        arrlist5.add("apple");
        System.out.println("Original: " + arrlist5);
        int count = 0;
        String countString = "apple";
        ListIterator<String> literator5 = arrlist5.listIterator();
        while(literator5.hasNext()) {
            String temp5 = literator5.next();
            if (temp5.equals(countString)) count++;
        }
        System.out.printf("'%s' count is: " + count + "\n", countString);
        System.out.println();

        /*
        Task 6: Sort a List Then Iterate With Iterator
        Input: [9, 1, 5, 3, 7]
        Expected Output (Sorted): [1, 3, 5, 7, 9]
        Expected Output (Iterator traversal): 1 3 5 7 9
         */
        System.out.println("Task 6:");
        ArrayList<Integer> arrList6 = new ArrayList<>();
        arrList6.add(9);
        arrList6.add(1);
        arrList6.add(5);
        arrList6.add(3);
        arrList6.add(7);
        System.out.println("Original: " + arrList6);
        Collections.sort(arrList6);
        System.out.println("Sorted: " + arrList6);
        Iterator<Integer> iter6 = arrList6.iterator();
        while (iter6.hasNext()) {
            System.out.print(iter6.next() + " ");
        }
        System.out.println();

        /*
        Task 7: Fill the List With 0s and Iterate Using ListIterator
        Input: [4, 5, 6, 7]
        Expected Output: [0, 0, 0, 0]
         */
        System.out.println("Task 7:");
        ArrayList<Integer> arrlist7 = new ArrayList<>();
        arrlist7.add(4);
        arrlist7.add(5);
        arrlist7.add(6);
        arrlist7.add(7);
        System.out.println("Original: " + arrlist7);
        Integer replacement7 = 0;
        // Collections method
        Collections.fill(arrlist7, 1);
        System.out.println("Replaced with 1 (Collections): " + arrlist7);
        // ListIterator
        ListIterator<Integer> literator7 = arrlist7.listIterator();
        while(literator7.hasNext()) {
            literator7.next();
            literator7.set(replacement7);
            System.out.println("Replacememnt done.");
        }
        System.out.println("Replaced with 0 (ListIterator: " + arrlist7);
        System.out.println();

        /*
        Task 8: Swap First and Last Elements Then Iterate
        Input: [10, 20, 30, 40, 50]
        Expected Output After Swap: [50, 20, 30, 40, 10]
        Expected Output (Iterator): 50 20 30 40 10
         */
        System.out.println("Task 8:");
        ArrayList<Integer> arrlist8 = new ArrayList<>();
        arrlist8.add(10);
        arrlist8.add(20);
        arrlist8.add(30);
        arrlist8.add(40);
        arrlist8.add(50);
        System.out.println("Original: " + arrlist8);
        ListIterator<Integer> literator8 = arrlist8.listIterator();
        int startIndex = literator8.nextIndex();
        while(literator8.hasNext()) {
            literator8.next();
        }
        int endIndex = literator8.previousIndex();
        Collections.swap(arrlist8, startIndex, endIndex);
        System.out.println("Swapped: " + arrlist8);
        System.out.println();

        /*
        Task 9: Traverse Backward Using ListIterator
        Input: [10, 20, 30, 40]
        Expected Output (reverse): 40 30 20 10
         */










    }

}
