package MapInfo.SortedMapInterface;

import java.util.*;

public class Main {

    public static void main(String[] args) {
/*
        Task 1 – Student Rankings
        Create a program that stores students' names with their scores in ascending order of scores.
        Display the student with the lowest score and the student with the highest score.
        Output example:
        Lowest score: Alice - 45
        Highest score: David - 98
        */
        System.out.println("Task 1:");
        SortedMap<String,Integer> smap1 = new TreeMap<>();
        smap1.put("S4", 94);
        smap1.put("S3", 78);
        smap1.put("S1", 85);
        smap1.put("S2", 98);
        System.out.println("Insertion order was: \"S4\", 94 -> \"S3\", 78 -> \"S1\", 85 -> \"S2\", 98");
        System.out.println("Sorted map by key: " + smap1);
        System.out.println("Lowest score: " + smap1.firstKey() + " - " + smap1.get(smap1.firstKey()));
        System.out.println("Highest score: " + smap1.lastKey() + " - " + smap1.get(smap1.lastKey()));
        System.out.println();

/*
        Task 2 – Product Price Range
        Manage a price list of products.
        Show all products whose prices fall between two given prices (inclusive).
        Output example:
        Products in the price range 15 to 50:
        Bread - 15
        Milk - 20
        Eggs - 35
        Cheese - 50
*/
        System.out.println("Task 2:");
        SortedMap<String,Integer> smap2 = new TreeMap<>();
        smap2.put("Bread", 15);
        smap2.put("Milk", 20);
        smap2.put("Bacon", 65);
        smap2.put("Eggs", 35);
        smap2.put("Cheese", 50);
        smap2.put("Flour", 10);
        System.out.println("Sorted Map: " + smap2);
        SortedMap<String,Integer> smap2Shortened = new TreeMap<>();
        Set<Map.Entry<String,Integer>> eset2 = smap2.entrySet();
        Iterator iter2 = eset2.iterator();
        while (iter2.hasNext()) {
            Map.Entry<String,Integer> entry2 = (Map.Entry<String,Integer>)iter2.next();
            if (entry2.getValue() >= 15 && entry2.getValue() <= 50) {
                smap2Shortened.put(entry2.getKey(),entry2.getValue());
            }
        }
        System.out.println("Products withing the price-range: " + smap2Shortened);
        System.out.println();

        System.out.println("Alternative:");
        SortedMap<Integer, String> smap2Alt = new TreeMap<>();
        smap2Alt.put(15,"Bread");
        smap2Alt.put(20, "Milk");
        smap2Alt.put(65,"Bacon");
        smap2Alt.put(35, "Eggs");
        smap2Alt.put(50, "Cheese");
        smap2Alt.put(10, "Flour");
        System.out.println("Sorted Map: " + smap2Alt);
        SortedMap<Integer, String> smap2Shortened1 = smap2Alt.subMap(15, 51);
        System.out.println("Alt submap: " + smap2Shortened1);
        System.out.println();

/*
        Task 3 – Ordered Book List
        Keep a list of books with their ISBN numbers in sorted order.
        Show all books from the start of the list up to (but not including) a given ISBN.
        Output example:
        Books before ISBN 978-83-950198-2-4:
        978-83-940099-0-2 - "Data Structures in Java"
        978-83-943299-7-5 - "Clean Code"
*/
        System.out.println("Task 3:");
        SortedMap<String,String> smap3 = new TreeMap<>();
        smap3.put("978-83-950198-2-4", "Data Structures in Java");
        smap3.put("978-83-953128-2-4", "1Java 1Java");
        smap3.put("978-83-943299-7-5", "Clean Code");
        smap3.put("978-83-935688-1-8", "Head First Java");
        smap3.put("978-83-923488-1-1", "Java Java");
        System.out.println("Original: " + smap3);
        SortedMap<String,String> headMap = smap3.headMap("978-83-950198-2-4");
        System.out.println("Head map: " + headMap);
        System.out.println();

/*
        Task 4 – Event Schedule
        Store events with their start times in ascending order.
        Show all events starting from a given time to the end of the schedule.
        Output example:
        Events from 14:00 onwards:
        14:00 - Lunch & Networking
        15:30 - Workshop: AI in Practice
        17:00 - Closing Remarks
        */
        System.out.println("Task 4:");
        SortedMap<String,String> smap4 = new TreeMap<>();
        smap4.put("17:00", "Closing Remarks");
        smap4.put("14:00", "Lunch & Networking");
        smap4.put("15:30", "Workshop: AI in Practice");
        System.out.println("Sorted map: " + smap4);
        SortedMap<String,String> tailmap4 = smap4.tailMap("15:30");
        System.out.println("TailMap: " + tailmap4);
        System.out.println();

/*
        Task 5 – City Directory
        Keep a list of cities with their postal codes sorted by the code.
        Get the city with the postal code that is the smallest greater than or equal to a given code.
        Output example:
        Nearest city with postal code ≥ 23000:
        23145 - Springfield
*/
        System.out.println("Task 5:");
        SortedMap<Integer,String> smap5 = new TreeMap<>();
        smap5.put(13145, "T1");
        smap5.put(23000, "T2");
        smap5.put(27564, "T3");
        smap5.put(36786, "T4");
        smap5.put(18953, "T5");
        System.out.println("Sorted Map: " + smap5);
        Integer codeToComp = 23000;
        SortedMap<Integer,String> smap5Shortened = smap5.tailMap(23000);
        System.out.println("Nearest: " + smap5Shortened.firstKey() + " - " + smap5Shortened.get(smap5Shortened.firstKey()));
        System.out.println();


    }
}
