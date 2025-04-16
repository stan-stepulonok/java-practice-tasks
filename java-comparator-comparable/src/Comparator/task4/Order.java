package Comparator.task4;

import java.time.LocalDate;
import java.util.Comparator;

public class Order implements Comparable<Order> {

    private int id;
    private LocalDate orderCreatedDate;

    public static Comparator<Order> dateComparator = new Comparator<>() {
        @Override
        public int compare(Order order1, Order order2) {
            return order2.orderCreatedDate.compareTo(order1.orderCreatedDate);
        }
    };

    public Order(int id, LocalDate orderCreatedDate) {
        this.id = id;
        this.orderCreatedDate = orderCreatedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getOrderCreatedDate() {
        return orderCreatedDate;
    }

    public void setOrderCreatedDate(LocalDate orderCreatedDate) {
        this.orderCreatedDate = orderCreatedDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderCreatedDate=" + orderCreatedDate +
                '}';
    }

    @Override
    public int compareTo(Order orderToCompare) {
        return Integer.compare(this.id, orderToCompare.id);
    }

}
