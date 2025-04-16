package Comparator.task1;

import java.util.Comparator;

public class PriceComparator implements Comparator<Product> {

    @Override
    public int compare(Product product1, Product product2) {
        return Double.compare(product2.getProductPrice(), product1.getProductPrice());
        /*
        Alternatively:
        if (product2.getProductPrice() - product1.getProductPrice() > 0) return 1;
        else if (product2.getProductPrice() - product1.getProductPrice() < 0) return -1;
        else return 0;
         */
    }


}
