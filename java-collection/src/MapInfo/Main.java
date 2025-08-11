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

Map.of(...) is a static factory method added in Java 9 to quickly create a small, immutable map without having to write boilerplate new HashMap<>() + put() calls.
// No entries
static <K, V> Map<K, V> of()
// One entry
static <K, V> Map<K, V> of(K k1, V v1)
// Two entries
static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2)


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

------------------------------------------------------------------ 2.1 HashMap<K, V> class ------------------------------------------------------------------
Description:
- implementation of the Map interface
- uses a hash table as its underlying data structure, allowing for fast insertion, retrieval, and deletion operations O(1)
- permits one null key
- does not guarantee any ordering
- uses hashCode() and equals() methods of keys to organize entries

Methods inherited from Map interface:
- V put(K key, V value); - Associates the specified value with the specified key in this map. If the map previously contained a mapping for the key, the old value is replaced and returned.
- V get(Object key); - Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
- V remove(Object key); - Removes the mapping for the specified key if present. Returns the previous value associated with the key or null if there was no mapping.
- boolean containsKey(Object key); - Returns true if this map contains a mapping for the specified key.
- boolean containsValue(Object value); - Returns true if this map maps one or more keys to the specified value.
- void putAll(Map<? extends K, ? extends V> m); - Copies all of the mappings from the specified map to this map.
- oid clear(); - Removes all of the mappings from this map.
- int size(); - Returns the number of key-value mappings in this map.
- boolean isEmpty(); - Returns true if this map contains no key-value mappings.
- Set<K> keySet(); - Returns a Set view of the keys contained in this map.
- Collection<V> values(); - Returns a Collection view of the values contained in this map.
- Set<Map.Entry<K, V>> entrySet(); - Returns a Set view of the mappings contained in this map.

Unique Methods of HashMap:
- HashMap(); - Constructor. Creates a new, empty HashMap with the default initial capacity (16) and load factor (0.75).
- HashMap(int initialCapacity); - Constructor. Creates a new, empty HashMap with the specified initial capacity and default load factor.
- HashMap(int initialCapacity, float loadFactor); - Constructor. Creates a new, empty HashMap with the specified initial capacity and load factor.
- HashMap(Map<? extends K, ? extends V> m); - Constructor. Creates a new HashMap with the same mappings as the specified map.
- V getOrDefault(Object key, V defaultValue); - Returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key.
- V putIfAbsent(K key, V value); - If the specified key is not already associated with a value (or is mapped to null), associates it with the given value and returns null; otherwise, returns the current value.
- boolean remove(Object key, Object value); - Removes the entry for the specified key only if it is currently mapped to the specified value. Returns true if removed.
- boolean replace(K key, V oldValue, V newValue); - Replaces the entry for the specified key only if currently mapped to the specified value. Returns true if replaced.
- V replace(K key, V value); - Replaces the entry for the specified key only if it is currently mapped to some value. Returns the previous value or null if no mapping existed.
- void forEach(BiConsumer<? super K, ? super V> action); - Performs the given action for each entry in the map until all entries have been processed or the action throws an exception.
- void replaceAll(BiFunction<? super K, ? super V, ? extends V> function); - Replaces each entry’s value with the result of applying the given function to that entry until all entries have been processed or the function throws an exception.
- putAll(Map<? extends K, ? extends V> m) - convenience method to copy all mappings from another map into the current map. If the current map already has a key, it replaces the value. If m is null, it throws a NullPointerException.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

------------------------------------------------------------------ 3.1 LinkedHashMap ------------------------------------------------------------------
Description:
- Extends HashMap
- Guarantees insertion order

Unique methods:
- protected boolean removeEldestEntry(Map.Entry<K,V> eldest)
Lets you decide whether to remove the eldest entry each time a new one is inserted.

protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
    return false;
}

Should be overriden:
LinkedHashMap<Integer, String> map = new LinkedHashMap<>() {
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
        return size() > 2;
    }
};

Map.Entry<Integer, String> eldest -> represents the eldest entry in the map at the time removeEldestEntry() is called:
- If the map is insertion-ordered → the first element you inserted that is still in the map.
- If the map is access-ordered (created with the special constructor) → the least recently accessed entry.
You do not fetch it yourself — the LinkedHashMap internals hand it to your overridden method.

Insertion-ordered LinkedHashMap (default):
- new LinkedHashMap<>();
- new LinkedHashMap<>(initialCapacity, loadFactor, false);

Access-ordered LinkedHashMap:
Entries are iterated in the order of most recently accessed last.
"Access" means either calling get(key) or inserting/updating a key.
- new LinkedHashMap<>(16, 0.75f, true);

LinkedHashMap<Integer, String> map = new LinkedHashMap<>(16, 0.75f, true);
map.put(1, "One");
map.put(2, "Two");
map.put(3, "Three");

System.out.println(map.keySet());
// Output: [1, 2, 3]

map.get(1); // access key 1
System.out.println(map.keySet());
// Output: [2, 3, 1]  — key 1 moved to the end

map.put(2, "Two updated"); // access via put()
System.out.println(map.keySet());
// Output: [3, 1, 2] — key 2 now at end

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

------------------------------------------------------------------ 2.2 EnumMap ------------------------------------------------------------------
Description:
- EnumMap<K extends Enum<K>, V> is a specialized implementation of the Map interface for use with enum type keys.
- Keys must be of a single enum type, specified at map creation.
- Maintains natural order of the enum keys (the order in which enum constants are declared).

Unique methods - Constructors:
!!! The keyType parameter is the Class object of the enum type used as keys. !!!
- EnumMap(Class<K> keyType) - Constructs a new, empty enum map with the specified key type.
- EnumMap(EnumMap<K, ? extends V> m) - Constructs a new enum map with the same key type as the specified enum map, initially containing the same mappings.
- EnumMap(Map<K, ? extends V> m) - Constructs a new enum map initialized from the specified map. The key type is inferred from the keys in the map.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

*/





}
