package task3;

public enum CoffeeSize {

    SMALL(100, 3.99), MEDIUM(300, 5.99), LARGE(500, 7.99);

    private int volume = 100;
    private double price = 3.99;

    CoffeeSize(int volume, double price) {
        this.volume = volume;
        this.price = price;
    }

    public void displayCoffeeSizeInfo() {
        String nameStart = this.name().substring(0,1);
        String nameEnd = this.name().substring(1).toLowerCase();
        StringBuilder namePretty = new StringBuilder(nameStart).append(nameEnd);
        System.out.println("The name is: " + namePretty);
        System.out.println("The price is: " + this.price);
        System.out.println("The volume is: " + this.volume);
    }

}
