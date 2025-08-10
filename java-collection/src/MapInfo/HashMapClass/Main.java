package MapInfo.HashMapClass;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
/*
        Task 1 – Verify Default Behavior of Empty HashMap
        Description:
        Create an empty HashMap and check its initial characteristics such as size and whether it contains any entries.
        Populate it with a small number of key–value pairs and recheck those characteristics.
        Output example:
        Initial size: 0
        Is empty: true
        Size after adding elements: 3
        Is empty after adding elements: false
        */
        System.out.println("Task 1:");
        HashMap<Integer, String> hmap1 = new HashMap<>();
        System.out.println("Initial size: " + hmap1.size());
        System.out.println("Is empty? ... " + hmap1.isEmpty());
        hmap1.put(1, "V1");
        hmap1.put(2, "V2");
        hmap1.put(3, "V3");
        System.out.println("Filled map: " + hmap1);
        System.out.println("Filled size: " + hmap1.size());
        System.out.println("Is empty? ... " + hmap1.isEmpty());
        System.out.println();

/*
        Task 2 – Explore clone() Behavior
        Description:
        Fill a HashMap with a few entries, clone it, and check whether:
        Both maps contain the same entries.
        Changes in the cloned map affect the original (or not).
        Output example:
        Original map: {A=1, B=2}
        Cloned map: {A=1, B=2}
        After modifying cloned map:
        Original map: {A=1, B=2}
        Cloned map: {A=1, B=99}
        */

        // Returns Object (so you need to cast back to HashMap<K, V>).
        // Creates a shallow copy of the map.
        // The structure (the internal buckets and entries) is duplicated.
        // The keys and values references are copied, not the actual objects.
        // This means both maps point to the same object instances for their keys and values.

        System.out.println("Task 2:");
        HashMap<String, String> hmap2 = new HashMap<>();
        hmap2.put("K1", "V1");
        hmap2.put("K2", "V2");
        hmap2.put("K3", "V3");
        System.out.println("Original map: " + hmap2);
        HashMap<String, String> hmap2Cloned = (HashMap<String, String>)hmap2.clone(); // casting
        System.out.println("Cloned map: " + hmap2Cloned);
        hmap2Cloned.put("K4", "V4");
        hmap2Cloned.put("K1", "V111");
        System.out.println("Cloned map after modification: " + hmap2Cloned);
        System.out.println("Original map after clone was modified: " + hmap2);
        System.out.println();

/*
        Task 3 – Observe putAll() with Overlapping Keys
        Description:
        Create two HashMaps. Fill both with some entries where a few keys overlap and others are unique.
        Use putAll() to merge one into the other and observe how values for overlapping keys are handled.
        Output example:
        First map: {ID1=Alice, ID2=Bob}
        Second map: {ID2=Charlie, ID3=David}
        After putAll:
        First map: {ID1=Alice, ID2=Charlie, ID3=David}
*/
        System.out.println("Task 3:");

        HashMap<String, String> hmap31 = new HashMap<>();
        hmap31.put("K1", "V1");
        hmap31.put("K2", "V2");
        hmap31.put("K3", "V3");
        System.out.println("Map 1: " + hmap31);

        HashMap<String, String> hmap32 = new HashMap<>();
        hmap32.put("K4", "V4");
        hmap32.put("K1", "V999");
        System.out.println("Map 2: " + hmap32);

        hmap31.putAll(hmap32);
        System.out.println("Map 1 putAll Map 2: " + hmap31);

        System.out.println();

/*
        Task 4 – Test isEmpty() After clear()
        Description:
        Fill a HashMap with entries, call clear(), then check whether the map is empty and its size.
        Before clear: size=4, isEmpty=false
        After clear: size=0, isEmpty=true
*/
        System.out.println("Task 4:");
        HashMap<Integer, String> hmap4 = new HashMap<>();
        hmap4.put(1, "Test1");
        hmap4.put(2, "Test2");
        System.out.println("Hash Map: " + hmap4);
        System.out.println("Is empty? ... " + hmap4.isEmpty());
        System.out.println("Size: " + hmap4.size());
        hmap4.clear();
        System.out.println("Hash Map cleared: " + hmap4);
        System.out.println("Is empty? ... " + hmap4.isEmpty());
        System.out.println("Size: " + hmap4.size());
        System.out.println();

/*
        Task 5 – Observe Iteration Order
        Description:
        Add several key–value pairs to a HashMap and print them in the order returned by iteration.
        Repeat the run multiple times to see if the order changes.
        Run 1: {ID2=Bob, ID1=Alice, ID3=Charlie}
        Run 2: {ID3=Charlie, ID1=Alice, ID2=Bob}
*/
        System.out.println("Task 5:");
        HashMap<String, String> hmap5 = new HashMap<>();
        hmap5.put("A11", "1");
        hmap5.put("A12", "2");
        hmap5.put("A13", "3");
        System.out.println("Map iteration 1:" + hmap5); // Map iteration 1:{A11=1, A12=2, A13=3}
        System.out.println("Map iteration 2:" + hmap5); // Map iteration 2:{A11=1, A12=2, A13=3}
        System.out.println("Map iteration 3:" + hmap5); // Map iteration 3:{A11=1, A12=2, A13=3}
        // order is not changed, but should have, collection too small maybe
        System.out.println();

        /*
        Task 6 – Compare equals() Between HashMaps
        Description:
        Create two HashMaps with identical entries (possibly added in a different order).
        Check if they are considered equal and then modify one to see how equality changes.
        Output example:
        Map1: {A=1, B=2, C=3}
        Map2: {C=3, B=2, A=1}
        Are equal: true
        After changing Map2:
        Are equal: false
         */
        System.out.println("Task 6:");
        HashMap<String, String> hmap61 = new HashMap<>();
        hmap61.put("K1", "V1");
        hmap61.put("K2", "V2");
        System.out.println("Map 1: " + hmap61);
        HashMap<String, String> hmap62 = new HashMap<>();
        hmap62.put("K1", "V1");
        hmap62.put("K2", "V2");
        System.out.println("Map 2: " + hmap62);
        System.out.println("Maps equals()? ... " + hmap61.equals(hmap62));
        hmap61.put("K1", "V111");
        System.out.println("Map 1 modified: " + hmap61);
        System.out.println("Maps equals()? ... " + hmap61.equals(hmap62));
        System.out.println();

/*
        Task 7 — Retrieve with a fallback value
        Description:
        Create a map of items to numeric counts.
        Retrieve the count for an existing key and for a missing key — when the key is missing, return a provided fallback value instead of null.
        Verify the map itself is not modified by the retrieval.
        Output example:
        Count for 'apple': 10
        Count for 'banana' (fallback 0): 0
        Map after retrieval: {apple=10, orange=5}
*/
        System.out.println("Task 7:");
        HashMap<String,String> hmap7 = new HashMap<>();
        hmap7.put("K1", "V1");
        hmap7.put("K2", "V2");
        System.out.println("Original: " + hmap7);
        System.out.println("Positive case: " + hmap7.getOrDefault("K1", "Not found"));
        System.out.println("Negative case: " + hmap7.getOrDefault("K999", "Not found"));
        System.out.println();

/*
        Task 8 — Insert only when absent (including null-valued entries)
        Description:
        Start with a map that contains some keys (one of them explicitly mapped to null).
        Try three insert attempts: one for a key that is absent, one for a key that already has a value, and one for a key that is present but currently mapped to null.
        For each attempt, record what the operation returned (the previous value, if any) and show the map after the attempts.
        Output example:
        Initial map: {A=1, B=2, C=null}
        Insert for 'D' -> previous value: null
        Insert for 'A' -> previous value: 1
        Insert for 'C' -> previous value: null
        Map after inserts: {A=1, B=2, C=3, D=4}
*/
        System.out.println("Task 8:");
        HashMap<String,String> hmap8 = new HashMap<>();
        hmap8.put("K1", "V1");
        hmap8.put("K2", "V2");
        System.out.println("Original map: " + hmap8);
        System.out.println(hmap8.putIfAbsent("K3", "V3"));
        System.out.println("Modified (put, absent) map: " + hmap8);
        System.out.println(hmap8.putIfAbsent("K3", "V4")); // same key, return existing value
        System.out.println("Modified (put, not absent) map: " + hmap8);
        System.out.println();

/*
        Task 9 — Remove only if key maps to an expected value
        Description:
        Build a map and perform conditional removals: attempt to remove one entry where the expected value matches (should succeed) and another where the expected value does not match (should fail).
        Report the boolean result of each removal and the final map.
        Output example:
        Initial map: {X=10, Y=20, Z=30}
        Remove X with expected value 10 -> removed: true
        Remove Y with expected value 999 -> removed: false
        Map after removals: {Y=20, Z=30}
*/
        System.out.println("Task 9:");
        HashMap<String,String> hmap9 = new HashMap<>();
        hmap9.put("K1", "V1");
        hmap9.put("K2", "V2");
        hmap9.put("K3", "V3");
        hmap9.put("K4", "V5");
        System.out.println("HashMap: " + hmap9);
        System.out.println("remove by key: " + hmap9.remove("K1"));
        System.out.println("remove by key + val: " + hmap9.remove("K2", "V2"));
        System.out.println("remove non existing key: " + hmap9.remove("K99"));
        System.out.println("remove non existing value: " + hmap9.remove("K3", "V4"));
        System.out.println();

/*
        Task 10 — Replace a value only if it matches an expected old value
        Description:
        Prepare a map and try conditional replacements: one where the current value matches the expected old value (should replace), one where it does not (should not replace), and one where the key is absent (should not replace).
        For each attempt, report the boolean result and show the final map.
        Output example:
        Initial map: {K1=old, K2=unchanged}
        Replace K1 from 'old' to 'new' -> replaced: true
        Replace K2 from 'wrong' to 'new2' -> replaced: false
        Replace K3 from 'anything' to 'value' -> replaced: false
        Map after replacements: {K1=new, K2=unchanged}
*/
        System.out.println("Task 10:");
        HashMap<String, String> hmap10 = new HashMap<>();
        hmap10.put("K1", "V1");
        hmap10.put("K2", "V2");
        hmap10.put("K3", "V3");
        System.out.println("Original: " + hmap10);
        System.out.println(hmap10.replace("K1", "V1", "V111")); // success
        System.out.println("Replaced (success): " + hmap10);
        System.out.println(hmap10.replace("K2", "V1", "V222")); // fail
        System.out.println("Replaced (fail): " + hmap10);
        System.out.println();


    }

}
