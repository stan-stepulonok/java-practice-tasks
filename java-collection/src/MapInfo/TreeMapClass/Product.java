package MapInfo.TreeMapClass;

public class Product implements Comparable<Product> {

    public String name;
    public Integer price;

    public Product(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Product product) {
        return this.price.compareTo(product.price);
    }

    @Override
    public String toString() {
        return this.name + " " + this.price;
    }

}
