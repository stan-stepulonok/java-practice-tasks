/*
------------------------------------------------------------------ Structure ------------------------------------------------------------------

java.util
├── interface Collection<E>
│   ├── interface List<E>         // Ordered, duplicates allowed
│   │   ├── class ArrayList<E>
│   │   ├── class LinkedList<E>
│   │   └── class Vector<E>
│   │       └── class Stack<E>
│   │
│   ├── interface Set<E>          // No duplicates
│   │   ├── interface SortedSet<E>
│   │   │   └── interface NavigableSet<E>
│   │   │       └── class TreeSet<E>
│   │   └── class HashSet<E>
│   │       └── class LinkedHashSet<E>
│   │
│   ├── interface Queue<E>        // FIFO or priority-based
│   │   └── interface Deque<E>    // Double-ended queue
│   │       ├── class ArrayDeque<E>
│   │       └── class LinkedList<E> (also implements List<E>)
│   │
│   └── interface BlockingQueue<E> (from `java.util.concurrent`)
│       └── interface BlockingDeque<E>
│           ├── class LinkedBlockingDeque<E>
│           └── class LinkedBlockingQueue<E>

├── interface Map<K, V>           // Not part of Collection hierarchy
// Do Map and Collection share similar methods? - Yes, there are similarities in naming and behavior, but they are not inherited from Collection<E>.
│   ├── interface SortedMap<K, V>
│   │   └── interface NavigableMap<K, V>
│   │       └── class TreeMap<K, V>
│   ├── class HashMap<K, V>
│   │   └── class LinkedHashMap<K, V>
│   └── class WeakHashMap<K, V>
│       └── class IdentityHashMap<K, V>
│
├── abstract class AbstractCollection<E>
│   ├── abstract class AbstractList<E>
│   │   ├── class ArrayList<E>
│   │   └── class AbstractSequentialList<E>
│   │       └── class LinkedList<E>
│   │
│   ├── abstract class AbstractSet<E>
│   │   ├── class HashSet<E>
│   │   └── class TreeSet<E>
│   │
│   └── abstract class AbstractQueue<E>
│       └── class PriorityQueue<E>
│
└── final class Collections       // Utility class (static methods only)

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

------------------------------------------------------------------ java.util.Collections Utility Class ------------------------------------------------------------------

Final Utility Class that provides static utility methods to work with Collection objects — like sorting, shuffling, synchronizing, creating unmodifiable versions, etc.

Constructors:
private Collections() - The constructor is private, meaning you cannot instantiate this class. It's a utility class with only static methods.

Methods:
1. Sorting and Shuffling
public static <T extends Comparable<? super T>> void sort(List<T> list)
public static <T> void sort(List<T> list, Comparator<? super T> c)
public static void reverse(List<?> list)
public static void shuffle(List<?> list)
public static void shuffle(List<?> list, Random rnd)
public static void rotate(List<?> list, int distance)
public static void swap(List<?> list, int i, int j)
public static void fill(List<? super T> list, T obj)
public static <T> void copy(List<? super T> dest, List<? extends T> src)

2. Searching and Min/Max
public static int binarySearch(List<?> list, Object key)
public static <T> int binarySearch(List<? extends Comparable<? super T>> list, T key)
public static <T> int binarySearch(List<? extends T> list, T key, Comparator<? super T> c)
public static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll)
public static <T> T max(Collection<? extends T> coll, Comparator<? super T> comp)
public static <T extends Object & Comparable<? super T>> T min(Collection<? extends T> coll)
public static <T> T min(Collection<? extends T> coll, Comparator<? super T> comp)

3. Synchronization Wrappers
public static <T> Collection<T> synchronizedCollection(Collection<T> c)
public static <T> List<T> synchronizedList(List<T> list)
public static <K, V> Map<K, V> synchronizedMap(Map<K, V> m)
public static <T> Set<T> synchronizedSet(Set<T> s)
public static <K, V> SortedMap<K, V> synchronizedSortedMap(SortedMap<K, V> m)
public static <T> SortedSet<T> synchronizedSortedSet(SortedSet<T> s)
public static <K, V> NavigableMap<K, V> synchronizedNavigableMap(NavigableMap<K, V> m)
public static <T> NavigableSet<T> synchronizedNavigableSet(NavigableSet<T> s)

4. Unmodifiable Wrappers
public static <T> Collection<T> unmodifiableCollection(Collection<? extends T> c)
public static <T> List<T> unmodifiableList(List<? extends T> list)
public static <K, V> Map<K, V> unmodifiableMap(Map<? extends K, ? extends V> m)
public static <T> Set<T> unmodifiableSet(Set<? extends T> s)
public static <K, V> SortedMap<K, V> unmodifiableSortedMap(SortedMap<K, ? extends V> m)
public static <T> SortedSet<T> unmodifiableSortedSet(SortedSet<? extends T> s)
public static <K, V> NavigableMap<K, V> unmodifiableNavigableMap(NavigableMap<K, ? extends V> m)
public static <T> NavigableSet<T> unmodifiableNavigableSet(NavigableSet<? extends T> s)

5. Singleton, Empty, nCopies
public static <T> Set<T> singleton(T o)
public static <T> List<T> singletonList(T o)
public static <K, V> Map<K, V> singletonMap(K key, V value)
public static final <T> List<T> emptyList()
public static final <T> Set<T> emptySet()
public static final <K, V> Map<K, V> emptyMap()
public static <T> List<T> nCopies(int n, T o)

6. Frequency and Disjoint
public static int frequency(Collection<?> c, Object o)
public static boolean disjoint(Collection<?> c1, Collection<?> c2)

7. Checked Wrappers (for runtime type safety)
public static <E> Collection<E> checkedCollection(Collection<E> c, Class<E> type)
public static <E> List<E> checkedList(List<E> list, Class<E> type)
public static <E> Set<E> checkedSet(Set<E> s, Class<E> type)
public static <K, V> Map<K, V> checkedMap(Map<K, V> m, Class<K> keyType, Class<V> valueType)
public static <E> SortedSet<E> checkedSortedSet(SortedSet<E> s, Class<E> type)
public static <K, V> SortedMap<K, V> checkedSortedMap(SortedMap<K, V> m, Class<K> keyType, Class<V> valueType)
public static <E> NavigableSet<E> checkedNavigableSet(NavigableSet<E> s, Class<E> type)
public static <K, V> NavigableMap<K, V> checkedNavigableMap(NavigableMap<K, V> m, Class<K> keyType, Class<V> valueType)
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

------------------------------------------------------------------ java.util.Collection<E> Interface ------------------------------------------------------------------
This is the Interface that defines the core methods (like add(), remove(), size(), etc.) that all collection types (like List, Set, Queue) must implement.
Subinterfaces: List<E>, Set<E>, Queue<E>, Deque<E> and so on ...
Implemented by: ArrayList, HashSet, LinkedList, PriorityQueue ...

Methods:
1. int size() - Description: Returns the number of elements in the collection. Returns: The number of elements.
2. boolean isEmpty() - Description: Checks if the collection is empty. Returns: true if the collection contains no elements.
3. boolean contains(Object o) - Description: Checks if the collection contains the specified element. Parameters: o – element whose presence is to be tested. Returns: true if the collection contains the specified element.
4. Iterator<E> iterator() - Description: Returns an iterator over the elements in this collection. Returns: An Iterator for the elements.
5. Object[] toArray() - Description: Returns an array containing all elements in the collection. Returns: An array containing all elements.
6. <T> T[] toArray(T[] a) - Description: Returns an array containing all elements, using the provided array's runtime type. Parameters: a – the array into which the elements are to be stored. Returns: An array containing the elements of the collection.
7. boolean add(E e) - Description: Adds the specified element to the collection (optional operation). Parameters: e – the element to be added. Returns: true if the collection changed as a result.
8. boolean remove(Object o) - Description: Removes a single instance of the specified element (if present). Parameters: o – element to be removed. Returns: true if an element was removed.
9. boolean containsAll(Collection<?> c) - Description: Checks if the collection contains all elements in the specified collection. Parameters: c – collection to check for containment. Returns: true if this collection contains all elements in c.
10. boolean addAll(Collection<? extends E> c) - Description: Adds all elements from the specified collection (optional operation). Parameters: c – collection of elements to be added. Returns: true if the collection changed as a result.
11. boolean removeAll(Collection<?> c) - Description: Removes all elements from this collection that are also in the specified collection. Parameters: c – elements to be removed. Returns: true if the collection changed.
12. boolean retainAll(Collection<?> c) - Description: Retains only the elements that are also in the specified collection. Parameters: c – elements to be retained. Returns: true if the collection changed.
13. void clear() - Description: Removes all elements from the collection.
14. boolean equals(Object o) - Description: Compares the specified object with this collection for equality. Parameters: o – object to be compared. Returns: true if the collections are equal.
15. int hashCode() - Description: Returns the hash code value for this collection.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 */
public class Main {
    public static void main(String[] args) {
    }
}