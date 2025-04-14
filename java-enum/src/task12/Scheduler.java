package task12;

import java.util.ArrayList;

public enum Scheduler {

    MONDAY {
        private ArrayList<Activity> activities = new ArrayList<>();
        @Override
        public void assignActivity(Activity activityName) {
            activities.add(activityName);
        }
        @Override
        public void showActivity() {
            System.out.println(MONDAY.name());
            System.out.println(activities);
        }
    },
    TUESDAY {
        private ArrayList<Activity> activities = new ArrayList<>();
        @Override
        public void assignActivity(Activity activityName) {
            activities.add(activityName);
        }
        @Override
        public void showActivity() {
            System.out.println(TUESDAY.name());
            System.out.println(activities);
        }
    },
    WEDNESDAY {
        private ArrayList<Activity> activities = new ArrayList<>();
        @Override
        public void assignActivity(Activity activityName) {
            activities.add(activityName);
        }
        @Override
        public void showActivity() {
            System.out.println(WEDNESDAY.name());
            System.out.println(activities);
        }
    },
    THURSDAY {
        private ArrayList<Activity> activities = new ArrayList<>();
        @Override
        public void assignActivity(Activity activityName) {
            activities.add(activityName);
        }
        @Override
        public void showActivity() {
            System.out.println(THURSDAY.name());
            System.out.println(activities);
        }
    },
    FRIDAY {
        private ArrayList<Activity> activities = new ArrayList<>();
        @Override
        public void assignActivity(Activity activityName) {
            activities.add(activityName);
        }
        @Override
        public void showActivity() {
            System.out.println(FRIDAY.name());
            System.out.println(activities);
        }
    };

    public void assignActivity(Activity activityName) {
        System.out.println("Activity was not assigned!");
    }

    public void showActivity() {
        System.out.println("No activities to show!");
    }


}
