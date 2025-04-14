/*
Main Features of Enums in Java:

Predefined Constants:
Enum constants are implicitly public, static, and final. You can't create new instances or modify them at runtime.

Constructors:
Enum constructors can have parameters, but they are always private or package-private. The instances are created at the time of enum definition.

Fields and Methods:
Enums can have fields and methods, just like regular classes.
You can define instance fields for each enum constant and initialize them through the constructor.

Overriding Methods:
You can override methods like toString() or define custom methods inside the enum.

Enums implicitly inherit from java.lang.Enum, and some methods from Object like equals(), hashCode(), and toString() can be overridden.

values() Method:
A built-in method that returns an array of all the enum constants.

valueOf(String name) Method:
A method that returns the enum constant whose name matches the specified string.

ordinal() Method:
Returns the zero-based index of the enum constant in its enum declaration.

Implements Interfaces:
Enums can implement interfaces, which allows each enum constant to provide its own behavior for the methods of the interface.

Singleton-like Behavior:
Each enum constant is a singleton, meaning only one instance exists for each constant.
 */

public class Main {
    public static void main(String[] args) {

    }
}