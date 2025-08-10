package MapInfo;

public class Main {

    public static void main(String[] args) {

    }
/*
Associative array is a programming concept where data is stored as pairs of keys and values, allowing you to look up a value by its key quickly.
Think of it like a real-world dictionary, where a word (key) maps to its definition (value).

Dictionary data structure is another name for the same concept: a collection of key-value pairs.
In many languages (like Python), it’s called a dictionary. In Java, the Map interface models this idea.
 */


/*
Abstract class vs Interface

Map Interface
Map interface is like a blueprint of a vehicle — it says what functions the vehicle should have (drive, brake, steer).
It defines the contract — the methods any map implementation must provide.
Examples of methods:
- put(K key, V value)
- get(Object key)
- remove(Object key)
- containsKey(Object key)
- entrySet()
The interface only declares what operations are supported, not how they’re implemented.
It enables different implementations (like HashMap, TreeMap, LinkedHashMap) to be interchangeable.

AbstractMap abstract class
AbstractMap is like a partially built vehicle chassis — it provides some of the common mechanisms (like the frame and wheels), so the car maker only needs to add the engine and body style (specific map logic).
AbstractMap partially implements the Map interface, providing a base skeleton for most map implementations.
It reduces code duplication across different map classes by implementing common behaviors once.
For example, AbstractMap provides:
A default implementation of containsKey() using entrySet().
An implementation of equals(), hashCode(), and toString() based on entrySet().
It leaves some core methods abstract (like entrySet()) which must be implemented by subclasses.
*/

/*
------------------------------------------------------------------ 1. Map<K,V> Interface ------------------------------------------------------------------
Description:
- The Map interface in Java represents a collection of key-value pairs, where each key maps to exactly one value.
- It models the associative array or dictionary data structure.
- Map does NOT extend the Collection interface. !!!! it is a distinct interface, not a core (like List)
- Keys in a Map are unique; values may be duplicated.
- Maps allow efficient retrieval, insertion, and deletion of values based on keys.
- Element type: Key-Value pairs
- Primary access method: By key
- NO Iterator: Because Map is conceptually a mapping from keys to values, not a simple collection of elements. Direct iteration over the map without specifying keys, values, or entries would be ambiguous.

Basic Operations
- int size() - Returns the number of key-value mappings in the map.
- boolean isEmpty() - Returns true if the map contains no key-value mappings.
- boolean containsKey(Object key) - Returns true if the map contains a mapping for the specified key.
- boolean containsValue(Object value) - Returns true if the map maps one or more keys to the specified value.
- V get(Object key) - Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
- V put(K key, V value) - Associates the specified value with the specified key in this map. Returns the previous value associated with key, or null if there was no mapping.
- V remove(Object key) - Removes the mapping for a key from this map if present. Returns the previous value associated with the key, or null if there was no mapping.
- void putAll(Map<? extends K, ? extends V> m) - Copies all mappings from the specified map to this map.
- void clear() - Removes all mappings from this map.

View Collection Methods
- Set<K> keySet() - Returns a Set view of the keys contained in this map.
- Collection<V> values() - Returns a Collection view of the values contained in this map.
- Set<Map.Entry<K, V>> entrySet() - Returns a Set view of the key-value mappings contained in this map. Each element in the set is a Map.Entry object.

Default and Optional Methods (since Java 8+)
- V getOrDefault(Object key, V defaultValue) - Returns the value to which the specified key is mapped, or defaultValue if the map contains no mapping for the key.
- V putIfAbsent(K key, V value) - If the specified key is not already associated with a value (or is mapped to null), associates it with the given value.
- boolean remove(Object key, Object value) - Removes the entry for the specified key only if it is currently mapped to the specified value.
- boolean replace(K key, V oldValue, V newValue) - Replaces the entry for the specified key only if currently mapped to the specified value.
- V replace(K key, V value) - Replaces the entry for the specified key only if it is currently mapped to some value.

Map.Entry Interface (Inner Interface for entries)

- Represents a key-value pair inside the map.
- Map.Entry<K, V> is an inner interface inside Map that represents a key-value pair in the map.
- It is used to iterate over the map’s entries (key-value pairs) via entrySet() which returns a Set<Map.Entry<K, V>>.
- Because Map stores pairs, not just keys or values alone. The Map.Entry interface provides methods to get the key and value of each pair, and even modify the value if needed.
- Without Map.Entry, iterating over keys and values together would be cumbersome or less efficient.

interface Map.Entry<K, V> {
    K getKey();
    V getValue();
    V setValue(V value);
    boolean equals(Object o);
    int hashCode();
}

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

*/





}
