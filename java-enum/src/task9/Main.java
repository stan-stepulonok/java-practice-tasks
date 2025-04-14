package task9;

/*
Task 9: Enum with Interface
Create an interface Describable and an enum VehicleType (e.g. CAR, BIKE, TRUCK) that implements it.
In each enum constant, override a method from the interface to describe the vehicle.
 */
public class Main {

    public static void main(String[] args) {

        VehicleType car = VehicleType.CAR;
        car.describeVehicle();

    }

}
