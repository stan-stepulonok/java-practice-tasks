package task10;

import java.util.ArrayList;

public enum UserRole {

    ADMIN {
        @Override
        protected void addFeatures() {
            this.getFeatures().add("Sign Up");
            this.getFeatures().add("Login");
            this.getFeatures().add("User Management");
        }
    },
    USER {
        @Override
        protected void addFeatures() {
            this.getFeatures().add("Sign Up");
            this.getFeatures().add("Login");
        }
    },
    GUEST {
        @Override
        protected void addFeatures() {
            this.getFeatures().add("Sign Up");
        }
    };

    private ArrayList<String> features;

    UserRole() {
        this.features = new ArrayList<>();
        this.addFeatures();
    }

     protected void addFeatures() {
        System.out.println("No features added.");
    }

    public ArrayList<String> getFeatures() {
        return features;
    }
}
