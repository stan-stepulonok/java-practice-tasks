package task9;

public enum VehicleType implements Describable {

    CAR("red", "Ford") {
        int trunkVolume = 35;
        @Override
        public void describeVehicle() {
            System.out.println("Name: " + this.getName() + " ; Color: " + this.getName() + "; Trunk: " + this.trunkVolume);
        }
    },
    BIKE("white", "BMX") {
        int wheelNum = 2;
        @Override
        public void describeVehicle() {
            System.out.println("Name: " + this.getName() + " ; Color: " + this.getName() + "; Wheels: " + this.wheelNum);
        }
    },
    TRUCK("green", "GMC") {
        int capacity = 1000;
        @Override
        public void describeVehicle() {
            System.out.println("Name: " + this.getName() + " ; Color: " + this.getName() + "; Capacity: " + this.capacity);
        }
    };

    private String name;
    private String color;

    VehicleType(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public void describeVehicle() {
        System.out.println("Name: " + this.name + " ; Color: " + this.color);
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
}
