package Comparator.task1;

public class Product {

    private String productName;
    private double productPrice;

    Product(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductName(String newProductName) {
        this.productName = newProductName;
    }

    public void setProductPrice(double newProductPrice) {
        this.productPrice = newProductPrice;
    }

    @Override
    public String toString() {
        return "Product -> Name: " + productName + "; Price: " + productPrice;
    }

}
