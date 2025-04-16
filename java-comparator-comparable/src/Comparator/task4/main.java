package Comparator.task4;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

/*
Sort Orders by Date (Custom Logic)
Create an Order class with orderId and LocalDate orderDate.
Sort orders using a Comparator so the most recent order comes first.

Sample Output:
[Order{id=3, date=2023-12-20}, Order{id=2, date=2023-11-01}, Order{id=1, date=2023-05-05}]
 */
public class main {

    public static void main(String[] args) {

        Order ord1 = new Order(2, LocalDate.	parse("2023-11-01"));
        Order ord2 = new Order(3, LocalDate.	parse("2023-12-20"));
        Order ord3 = new Order(1, LocalDate.	parse("2023-05-05"));

        List<Order> orders = new ArrayList<>();
        orders.add(ord1);
        orders.add(ord2);
        orders.add(ord3);
        System.out.println("Before: " + orders);

        orders.sort(Order.dateComparator);
        System.out.println("After: " + orders);


    }

}
