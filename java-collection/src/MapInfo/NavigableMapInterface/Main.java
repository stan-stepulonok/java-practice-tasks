package MapInfo.NavigableMapInterface;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
/*
        Task 1 – Nearest Lower and Higher Keys
        Description:
        Create a sorted collection of product IDs and their names.
        Given a target product ID, display:
        the product with the closest smaller ID
        the product with the closest larger ID
        Output example:
        Target product ID: 105
        Closest smaller: 102 - "Laptop Stand"
        Closest larger: 110 - "Wireless Mouse"
        */
        System.out.println("Task 1:");
        NavigableMap<Integer,String> nmap1 = new TreeMap<>();
        nmap1.put(1, "P1");
        nmap1.put(5, "P5");
        nmap1.put(4, "P4");
        nmap1.put(2, "P2");
        nmap1.put(3, "P3");
        System.out.println("Navigable Map: " + nmap1);
        Integer idToCompare1 = 4;

        Map.Entry<Integer,String> lowerEntry = nmap1.lowerEntry(idToCompare1);
        System.out.println("Lower entry: " + lowerEntry); // 3, "P3"
        System.out.println("Floor entry: " + nmap1.floorEntry(idToCompare1)); // 4, "P4"

        System.out.println("Higher Entry: " + nmap1.higherEntry(idToCompare1)); // 5, "P5"
        System.out.println("Ceiling Entry: " + nmap1.ceilingEntry(idToCompare1)); // 4, "P4"

        System.out.println();

/*
        Task 2 – First and Last Entry
        Description:
        Maintain a schedule of flights sorted by departure time (in hours).
        Display:
        the earliest flight (time and destination)
        the latest flight (time and destination)
        Output example:
        Earliest flight: 06:15 - "Paris"
        Latest flight: 22:40 - "Tokyo"
*/
        System.out.println("Task 2:");
        NavigableMap<String,String> nmap2 = new TreeMap<>();
        nmap2.put("06:15", "Paris");
        nmap2.put("12:00", "Rome");
        nmap2.put("16:15", "Barcelona");
        nmap2.put("05:10", "Venice");
        nmap2.put("20:25", "Ankara");
        System.out.println("Navigable map: " + nmap2);
        Map.Entry<String,String> earliestFlight = nmap2.firstEntry();
        System.out.println("Earliest flight: " + earliestFlight); // "05:10", "Venice"
        Map.Entry<String,String> latestFlight = nmap2.lastEntry();
        System.out.println("Latest flight: " + latestFlight); // "20:25", "Ankara"
        System.out.println();

/*
        Task 3 – Remove and Return Boundary Entries
        Description:
        Keep a sorted list of high scores in a game.
        Remove and display:
        the current lowest score
        the current highest score
        Then show the updated list of scores.
        Output example:
        Removed lowest: 45 - "Player8"
        Removed highest: 980 - "Player1"
        Updated scores: [125, 210, 450, 600, 870]
*/
        System.out.println("Task 3:");
        NavigableMap<Integer, String> nmap3 = new TreeMap<>();
        nmap3.put(210, "P1");
        nmap3.put(450, "P2");
        nmap3.put(125, "P3");
        nmap3.put(600, "P4");
        nmap3.put(870, "P5");
        System.out.println("Original map: " + nmap3);
        Map.Entry<Integer, String> polledEntry = nmap3.pollFirstEntry();
        System.out.println("Polled first entry: " + polledEntry);
        polledEntry = nmap3.pollLastEntry();
        System.out.println("Polled last entry: " + polledEntry);
        System.out.println("Polled map: " + nmap3);
        System.out.println();

/*
        Task 4 – Reverse Order View
        Description:
        Store city names with their population counts, sorted alphabetically.
        Display the same collection in reverse alphabetical order.
        Output example:
        Cities in reverse order:
        Zurich - 434,000
        Warsaw - 1,765,000
        Paris - 2,148,000
        London - 8,982,000
        Berlin - 3,769,000
*/
        System.out.println("Task 4:");
        NavigableMap<String, Integer> nmap4 = new TreeMap<>();
        nmap4.put("London", 8982000);
        nmap4.put("Warsaw", 1765000);
        nmap4.put("Berlin", 3769000);
        nmap4.put("Paris", 2148000);
        nmap4.put("Zurich", 434000);
        System.out.println("Navigable map direct: " + nmap4);
        NavigableMap<String, Integer> nmap4Reversed = nmap4.descendingMap();
        System.out.println("Navigable map reversed: " + nmap4Reversed);
        System.out.println();

/*
        Task 5 – Navigable Key Sets
        Description:
        Create a sorted collection of car models and their release years.
        Display:
        all models in ascending order of names
        all models in descending order of names
        Output example:
        Ascending: [Accord, Camry, Civic, Corolla, Model S]
        Descending: [Model S, Corolla, Civic, Camry, Accord]
*/
        System.out.println("Task 5:");
        NavigableMap<String,Integer> nmap5 = new TreeMap<>();
        nmap5.put("Accord", 1999);
        nmap5.put("Civic", 2002);
        nmap5.put("Model S", 2012);
        nmap5.put("Corolla", 1968);
        nmap5.put("Camry", 2003);
        System.out.println("Navigable map asc: " + nmap5);
        System.out.println("Keys asc: " + nmap5.keySet());
        System.out.println("Navigable map desc: " + nmap5.descendingMap());
        System.out.println("Keys desc: " + nmap5.descendingKeySet());
        System.out.println();

/*
        Task 6 – Subrange with Inclusivity
        Description:
        Store exam scores of students sorted by score.
        Given a lower bound and an upper bound, display the students whose scores fall within that range.
        The range boundaries should include or exclude the bound scores based on specified inclusivity.
        Output example:
        Score range: 70 to 90 (inclusive on lower bound, exclusive on upper bound)
        Students in range:
        James - 70
        Maria - 80
        Helen - 50
*/
        System.out.println("Task 6:");
        NavigableMap<Integer, String> nmap6 = new TreeMap<>();
        nmap6.put(70, "James");
        nmap6.put(50, "Helen");
        nmap6.put(30, "John");
        nmap6.put(80, "Maria");
        nmap6.put(20, "Kate");
        System.out.println("Navigable map: " + nmap6);
        NavigableMap<Integer,String> nmapIncl = nmap6.subMap(30, true, 70, true);
        System.out.println("Map 30-70 including both: " + nmapIncl);
        NavigableMap<Integer,String> nmapExcl = nmap6.subMap(30, false, 70, false);
        System.out.println("Map 30-70 excluding both: " + nmapExcl);
        NavigableMap<Integer,String> nmapTail = nmap6.tailMap(70, false);
        System.out.println("Tail Map 70 excluding: " + nmapTail);
        NavigableMap<Integer,String> nmapHead = nmap6.headMap(70, true);
        System.out.println("Head Map 70 including: " + nmapHead);
        System.out.println();






    }

}
