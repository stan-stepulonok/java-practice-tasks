package task7;

public enum Shape {

    CIRCLE(5) {
        @Override
        public double calculateArea() {
            return P * Math.pow(this.getSideRadius(), 2);
        }
    },
    SQUARE(5) {
        @Override
        public double calculateArea() {
            return Math.pow(this.getSideRadius(), 2);
        }
    },
    TRIANGLE(5, 3) {
        @Override
        public double calculateArea() {
            return this.getBase()*this.getHeight()*0.5;
        }
    };

    public abstract double calculateArea();

    public final double P = 3.14;

    private int sideRadius = 0;
    private int height = 0;
    private int base = 0;


    Shape(int sideRadius) {
        this.sideRadius = sideRadius;
    }

    Shape(int base, int height) {
        this.base = base;
        this.height = height;
    }

    public int getSideRadius() {
        return sideRadius;
    }

    public int getHeight() {
        return height;
    }

    public int getBase() {
        return base;
    }



}
