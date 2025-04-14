package task2;

public enum TrafficLight {

    RED(5), YELLOW(2), GREEN(7);

    private int time = 0;

    private TrafficLight(int time) {
        this.time = time;
    }

    public int getTrafficLightTime() {
        return this.time;
    }


}
