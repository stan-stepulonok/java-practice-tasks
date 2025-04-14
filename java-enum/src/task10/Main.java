package task10;

/*
Task 10: Enum Used in a Regular Class
Create an enum UserRole (ADMIN, USER, GUEST) and a class User that has a UserRole field.
Based on the role, perform different actions or permissions in a method.
 */

public class Main {

    public static void main(String[] args) {

        User myAdmin = new User("admin@product.com", UserRole.ADMIN);
        myAdmin.doSmth();

    }

}
