package task12;

public class Activity {

    public String activityName;

    public Activity(String activityName) {
        this.activityName = activityName;
    }

    @Override
    public String toString() {
        return activityName;
    }

}
