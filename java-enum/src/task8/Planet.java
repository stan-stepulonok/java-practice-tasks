package task8;

public enum Planet {

    EARH(9999, 99), PLUTO(8888, 88);

    public static int planetCount;

    private double mass = 0;
    private double radius = 0;

    public final double G =  6.67 * Math.pow(10, -11);

    static {
        planetCount = 0;
    }

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }

    public double calculateGravity() {
        planetCount++;
        return G * mass / (radius * radius);
    }

}
