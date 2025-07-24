import java.util.ArrayList;
import java.util.List;

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

------------------------------------------------------------------ Level 1: java.util.Collections Utility Class ------------------------------------------------------------------

Final Utility Class that provides static utility methods to work with Collection objects — like sorting, shuffling, synchronizing, creating unmodifiable versions, etc.

Constructors:
private Collections() - The constructor is private, meaning you cannot instantiate this class. It's a utility class with only static methods.

Methods:
1. Sorting & Shuffling
 - sort(List<T> list) - void - Sorts the list in natural order (T must implement Comparable).
 - sort(List<T> list, Comparator<? super T> c) - void - Sorts the list using the given comparator.
 - shuffle(List<?> list) - void - Randomly permutes the list.
 - shuffle(List<?> list, Random rnd) - void - Shuffles using the provided Random object.
 - reverse(List<?> list) - void - Reverses the order of the list.
 - rotate(List<?> list, int distance) - void - Rotates elements by the given distance.
 - swap(List<?> list, int i, int j) - void - Swaps elements at positions i and j.

2. Searching & Finding
 - binarySearch(List<? extends Comparable<? super T>> list, T key) - int - Searches for key using binary search (must be sorted).
 - binarySearch(List<? extends T> list, T key, Comparator<? super T> c) - int - Binary search using comparator.
 - max(Collection<? extends T> coll) - T - Returns the maximum element (natural order).
 - max(Collection<? extends T> coll, Comparator<? super T> comp) - T - Returns the maximum element using comparator.
 - min(Collection<? extends T> coll) - T - Returns the minimum element (natural order).
 - min(Collection<? extends T> coll, Comparator<? super T> comp) - T - Returns the minimum element using comparator.
 - frequency(Collection<?> c, Object o) - int - Counts how many times o occurs in the collection.
 - indexOfSubList(List<?> source, List<?> target) - int - Index of first sublist occurrence.
 - lastIndexOfSubList(List<?> source, List<?> target) - int - Index of last sublist occurrence.

3. Wrappers (Unmodifiable / Synchronized / Checked)
 - unmodifiableList(List<? extends T> list) - List<T> - Returns an unmodifiable view of the list.
 - unmodifiableSet(Set<? extends T> set) - Set<T> - Same for set.
 - unmodifiableMap(Map<? extends K, ? extends V> m) - Map<K, V> - Same for map.
 - synchronizedList(List<T> list) - List<T> - Thread-safe wrapper for list.
 - synchronizedSet(Set<T> s) - Set<T> - Thread-safe wrapper for set.
 - synchronizedMap(Map<K, V> m) - Map<K, V> - Thread-safe wrapper for map.
 - checkedList(List<E> list, Class<E> type) - List<E> - Runtime type-safe wrapper (legacy compatibility).

4. Filling, Copying, Replacing
 - fill(List<? super T> list, T obj) - void - Replaces all elements with the given object.
 - copy(List<? super T> dest, List<? extends T> src) - void - Copies elements from src to dest.
 - replaceAll(List<T> list, T oldVal, T newVal) - boolean - Replaces all occurrences of oldVal with newVal.

5. Other Utilities
 - addAll(Collection<? super T> c, T... elements) - boolean - Adds all elements to the collection.
 - disjoint(Collection<?> c1, Collection<?> c2) - boolean - Returns true if collections have no common elements.
 - nCopies(int n, T o) - List<T> - Immutable list of n copies of o.
 - singleton(T o) - Set<T> - Immutable set containing only o.
 - emptyList() - List<Object> - Immutable empty list.
 - emptySet() - Set<Object> - Immutable empty set.
 - emptyMap() - Map<Object, Object> - Immutable empty map.
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

------------------------------------------------------------------ java.util.Iterator<E> Interface and ListIterator<E> Interface (subinterface) ------------------------------------------------------------------
ListIterator is bidirectional, unlike Iterator, which is forward-only.

ListIterator is typically obtained from List objects like ArrayList via:
ListIterator<String> it = list.listIterator();        // from start
ListIterator<String> it = list.listIterator(index);   // from specific index

1. Iterator
 - boolean hasNext() - Returns true if the iteration has more elements.
 - E next() - Returns the next element in the iteration. Throws NoSuchElementException if no more elements.
 - void remove() - Removes the last element returned by this iterator. Can only be called once per call to next(). Optional operation (may throw UnsupportedOperationException).

2. ListIterator
 - boolean hasPrevious() - Returns true if there are elements before the current position in the list.
 - E previous() - Returns the previous element and moves the cursor backward. Throws NoSuchElementException if no previous element.
 - int nextIndex() - Returns the index of the element that would be returned by a call to next(). Returns list size if at the end.
 - int previousIndex() - Returns the index of the element that would be returned by a call to previous(). Returns -1 if at the beginning.
 - void set(E e) - Replaces the last element returned by next() or previous() with the specified element. Can only be called if neither remove() nor add() was called after the last next() or previous().
 - void add(E e) - Inserts the specified element into the list at the current cursor position. The element is inserted before the element that would be returned by next(), and after the one that would be returned by previous().
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

------------------------------------------------------------------ Level 2: Interface List<E> ------------------------------------------------------------------

List<E> is a subinterface of Collection<E> and part of the Java Collections Framework.
It represents an ordered collection (also known as a sequence).
It provides positional access, search, iteration, and range-view operations.
- Duplicates are allowed
- Elements are ordered by insertion
- Elements can be accessed by their integer index (position)

You cannot instantiate an interface directly,but can use classes that implement the interface:
List<String> list1 = new ArrayList<>();

Methods Unique to List<E> or Overridden from Collection<E>
 - void add(int index, E element) - Inserts the specified element at the specified position.
 - E get(int index) - Returns the element at the specified position.
 - E set(int index, E element) - Replaces the element at the specified position with the specified element.
 - E remove(int index) - Removes the element at the specified position and returns it.
 - int indexOf(Object o) - Returns the index of the first occurrence of the specified element, or -1 if not found.
 - int lastIndexOf(Object o) - Returns the index of the last occurrence of the specified element, or -1 if not found.

Iterators (specialized for lists)
 - ListIterator<E> listIterator() - Returns a list iterator over the elements in the list (in proper order).
 - ListIterator<E> listIterator(int index) - Returns a list iterator of the elements starting at the specified position.
 - Iterator<E> iterator() - (Overrides from Collection<E>) Returns an iterator over the elements. In List, the order is defined.

Range-view Method
 - List<E> subList(int fromIndex, int toIndex) - Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive.

Bulk Operations (overridden from Collection<E> but behave differently due to ordering)
 - boolean addAll(int index, Collection<? extends E> c) - Inserts all elements of the given collection into the list starting at the specified position.
 - boolean addAll(Collection<? extends E> c) - (Overrides Collection<E>) Adds all elements of the given collection to the end of the list.
 - boolean removeAll(Collection<?> c) - (Overrides) Removes from this list all elements also contained in the given collection.
 - boolean retainAll(Collection<?> c) - (Overrides) Retains only the elements in this list that are also in the given collection.
 - void clear()	(Overrides) - Removes all elements from the list.
 - boolean contains(Object o) - (Overrides) Returns true if this list contains the specified element.
 - boolean containsAll(Collection<?> c) - (Overrides) Returns true if this list contains all the elements of the specified collection.

Size and Emptiness (same as in Collection<E>)
 - int size() - Returns the number of elements in the list.
 - boolean isEmpty() - Returns true if the list contains no elements.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

------------------------------------------------------------------ Big-O Time Complexity ------------------------------------------------------------------
Big-O notation is used to describe how fast or slow each operation is in terms of the list's size (n elements).
 - O(1) - Constant time — always fast, no matter the size
 - O(n) - Linear time — slows down as size increases
 - Amortized O(1) - Usually constant time, but occasionally slower (e.g., resizing the array)

 Example (ArrayList):
Operation	        Description	                Why this complexity?
get(int index)	    Access an element by index	✅ O(1): Directly accesses array by index
add(E e)	        Add element to the end	    ✅ Amortized O(1): Usually fast, but resizing the array (if full) is slower
remove(int index)	Remove from any position	⚠️ O(n): Shifts elements after index to the left

In short (ArrayList):
- get() and set() are fast.
- add() to the end is fast unless resizing is needed.
- add(index, elem) and remove(index) are slower because they move elements.
- contains() is slow for large lists.
- Iteration takes time proportional to the size.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

------------------------------------------------------------------ Level 3: class ArrayList<E> ------------------------------------------------------------------
- Backed by a resizable array: Object[] elementData
- Default capacity: 10 (if not specified)
- Growth policy: Increases by ~1.5x on overflow
- Random access: Constant-time performance for get() and set()
- Thread safety: Not synchronized

public class ArrayList<E> extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable
Interface/Class	Role
AbstractList<E> - Provides skeletal implementation for lists
List<E> - Ordered collection with positional access
Collection<E> - Base interface for all collections
RandomAccess - Marker for fast random access (i.e., get(index) is fast)
Cloneable - Supports cloning (via clone() method)
Serializable - Allows the object to be serialized

Inherited from List/Collection
These are methods that ArrayList inherits and typically does not override unless optimization is needed:

Inherited From Collection:
- add(E e)
- addAll(Collection<? extends E> c)
- clear()
- contains(Object o)
- containsAll(Collection<?> c)
- isEmpty()
- iterator()
- remove(Object o)
- removeAll(Collection<?> c)
- retainAll(Collection<?> c)
- size()
- toArray()
- toArray(T[] a)
Inherited From List
- add(int index, E element)
- addAll(int index, Collection<? extends E> c)
- get(int index)
- indexOf(Object o)
- lastIndexOf(Object o)
- listIterator()
- listIterator(int index)
- remove(int index)
- set(int index, E element)
- subList(int fromIndex, int toIndex)

Overridden / Implemented in ArrayList (Optimized or Special Behavior)
- add(E e) - Dynamically grows internal array if needed
- add(int index, E element) - Shifts elements after index
- ensureCapacity(int minCapacity) - Expands internal buffer proactively
- trimToSize() - Shrinks capacity to current size
- clone() - Returns a shallow copy of the list
- remove(Object o) - Removes first occurrence; shifts elements
- remove(int index) - Removes element at index; shifts elements
- subList(...) - Returns a view backed by the same array
- clear() - Sets size to 0, dereferences internal array slots

Performance Characteristics
get(int index) - O(1)
set(int index, E element) - O(1)
add(E e) (amortized) - O(1)
add(int index, E element) - O(n)
remove(int index) - O(n)
contains(Object o) - O(n)
iterator() - O(1) to create, O(n) to iterate
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

------------------------------------------------------------------ Level 3: class LinkedList<E> ------------------------------------------------------------------
 It is a doubly-linked list implementation of the List and Deque interfaces.
 It allows constant-time insertions or removals using iterators, and is efficient for frequent additions/removals at both ends.
 Unlike ArrayList, it does not use a backing array, but instead consists of nodes where each node holds data and links to the next and previous node.

Constructors and Object Instantiation
- public LinkedList()                             // Constructs an empty list -> LinkedList<String> list1 = new LinkedList<>();
- public LinkedList(Collection<? extends E> c)    // Constructs a list with the elements of the given collection -> List<Integer> numbers = List.of(1, 2, 3); LinkedList<Integer> list2 = new LinkedList<>(numbers);

Methods:
- Inherited from Interfaces:
    - boolean add(E e) - Appends the specified element to the end of the list.
    - void add(int index, E element) - Inserts the element at the specified index.
    - boolean addAll(Collection<? extends E> c) - Appends all elements from the specified collection.
    - boolean addAll(int index, Collection<? extends E> c) - Inserts all elements at the specified position.
    - void clear() - Removes all elements from the list.
    - boolean contains(Object o) - Returns true if the list contains the specified element.
    - E get(int index) - Returns the element at the specified index.
    - int indexOf(Object o) - Returns the index of the first occurrence of the element.
    - int lastIndexOf(Object o) - Returns the index of the last occurrence of the element.
    - E remove(int index) - Removes and returns the element at the specified index.
    - boolean remove(Object o) - Removes the first occurrence of the specified element.
    - E set(int index, E element) - Replaces the element at the index with the specified element.
    - int size() - Returns the number of elements in the list.
    - boolean isEmpty() - Returns true if the list has no elements.
    - Object[] toArray() - Returns an array containing all elements in order.
    - <T> T[] toArray(T[] a) - Returns an array containing all elements, of the specified type.
    - Iterator<E> iterator() - Returns an iterator over the list.
    - ListIterator<E> listIterator() - Returns a list iterator over the list.
    - ListIterator<E> listIterator(int index) - Returns a list iterator starting at the specified index.
    - List<E> subList(int fromIndex, int toIndex) - Returns a view of the portion of the list between the given indices.

- From Deque<E>
    // add first element
    - void addFirst(E e) - Inserts the element at the front of the list.
    - boolean offerFirst(E e) - Inserts element at front; returns false on failure.
    // add last element
    - void addLast(E e) - Inserts the element at the end of the list.
    - boolean offerLast(E e) - Inserts element at end; returns false on failure.
    // get first element
    - E getFirst() - Retrieves the first element; throws exception if empty.
    - E peekFirst() - Retrieves the first element without removing, or null if empty.
    // get last element
    - E getLast() - Retrieves the last element; throws exception if empty.
    - E peekLast() - Retrieves the last element without removing, or null if empty.
    // remove first element
    - E removeFirst() - Removes and returns the first element.
    - E pollFirst() - Retrieves and removes the first element, or null if empty.
    // remove last element
    - E removeLast() - Removes and returns the last element.
    - E pollLast() - Retrieves and removes the last element, or null if empty.

- From Queue<E>
    - boolean offer(E e) - Inserts the specified element into the queue.
    - E remove() - Retrieves and removes the head of the queue; throws exception if empty.
    - E poll() - Retrieves and removes the head of the queue, or null if empty.
    - E element() - Retrieves, but does not remove, the head; throws exception if empty.
    - E peek() - Retrieves, but does not remove, the head; returns null if empty.

- Overridden Methods
    - boolean equals(Object o) - Compares the list to another object for equality.
    - int hashCode() - Returns the hash code based on list elements.
    - String toString() - Returns a string representation of the list.

- Methods Unique to LinkedList (not in ArrayList)
    - void push(E e) - Pushes an element onto the stack (front of list).
    - E pop() - Removes and returns the element from the top (front) of the list.
    - E peek() - Retrieves, but does not remove, the first element (stack top).

Performance Characteristics
get(index) - O(n) - Must traverse from start or end.
add(element) - O(1) - Constant time at head or tail.
add(index) - O(n) - Needs traversal to index.
remove(index) - O(n) - Same reason as above.
iterator.add() - O(1) - Constant time with ListIterator.
Memory Overhead - High - Each node holds data + 2 pointers (prev, next).
Random Access - Poor - Not suitable for index-based access.

Comparison with ArrayList
Feature	                    ArrayList LinkedList
Access (get/set by index)	    O(1)	O(n)
Insert/remove at end	        O(1) 	O(1)
Insert/remove at start	        O(n)	O(1)
Insert/remove in middle	        O(n)	O(n)
Memory use	                    Less 	More
Implements Deque?	            ❌ No	✅ Yes
Best Use Case	Frequent reads, rare modifications	Frequent insertions/removals
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

------------------------------------------------------------------ Interface Queue ------------------------------------------------------------------

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
1. Description:
It is designed for holding elements prior to processing, typically in a FIFO (first-in, first-out) order.
The Queue interface is an ordered collection, but the order applies to the head-tail structure (FIFO, usually).
Unlike List, it does not allow positional access (no index-based operations).
The Queue interface introduces methods specific to insertion, retrieval, and removal, often with two variants: one that throws an exception on failure and one that returns a special value (null or false).
Capacity refers to the maximum number of elements a queue can hold, depending on the implementation:
- LinkedList, PriorityQueue - no fixed size, auto scales
- ArrayBlockingQueue, LinkedBlockingQueue - fixed capacity, you must specify it in the constructor

2. Collection methods:
- boolean add(E e) - Inserts the specified element into the queue. May throw IllegalStateException if capacity restrictions prevent addition.
- boolean remove(Object o) - Removes a single instance of the specified element (the first matching element encountered during traversal, earliest occurrence). Returns true if removed.
- boolean contains(Object o) - Returns true if the queue contains the specified element.
- int size() - Description: Returns the number of elements in the queue.
- void clear() - Removes all elements from the queue.

3. Queue methods:
| adding | ["a", "b", "c", "a"] -> add "x" -> ["a", "b", "c", "a", "x"]
- boolean offer(E e) - Inserts the specified element into the queue if possible. Returns true if the element was added successfully, false otherwise (e.g. capacity restrictions). Exception-free alternative to add(E e).
- boolean add(E e) - see above
| removing | ["a", "b", "c", "a"] -> remove "a" -> ["b", "c", "a"]
- E poll() - Retrieves and removes the head of the queue. Returns null if the queue is empty.
- E remove() - Retrieves and removes the head of the queue. Throws NoSuchElementException if the queue is empty.
| getting |
- E peek() - Retrieves, but does not remove, the head of the queue. Returns null if the queue is empty.
- E element() - Retrieves, but does not remove, the head of the queue. Throws NoSuchElementException if the queue is empty.



 */
public class Main {
    public static void main(String[] args) {
    }
}