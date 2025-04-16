package Comparator.task1;

/*
Task 2: Sort Products by Price (Comparator)
Create a Product class with name and price.
Write a Comparator<Product> that sorts products by price descending.
Sample Output:
[Product{name='Laptop', price=1500.0}, Product{name='Tablet', price=600.0}, Product{name='Mouse', price=20.0}]
 */

import Comparable.task1.Student;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Product p1 = new Product("XYZ", 30);
        Product p2 = new Product("CDE", 20);
        Product p3 = new Product("ABC", 25);
        List<Product> productList = new ArrayList<>();
        productList.add(p1);
        productList.add(p2);
        productList.add(p3);

        System.out.println("Before: " + productList);

        PriceComparator priceComparatorInstance = new PriceComparator();
        productList.sort(priceComparatorInstance);

        System.out.println("After: " + productList);

    }

}
