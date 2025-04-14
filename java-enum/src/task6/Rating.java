package task6;

public enum Rating {

    G(6, "G"),
    PG(8, "PG"),
    PG13(13, "PG13"),
    R(16, "R") {
        String extraInfo = "Do not recommended for people with stress.";
        @Override
        public void showDetails() {
            System.out.println("Name: " + this.name());
            System.out.println("Minimal age: " + this.getMinAge());
            System.out.println("Description: " + this.getDescription());
            System.out.println("Additional info: " + extraInfo);
        }
    };

    private int minAge = 0;
    private String description = "General description";

    Rating(int minAge, String description) {
        this.minAge = minAge;
        this.description = description;
    }

    public void showDetails() {
        System.out.println("Name: " + this.name());
        System.out.println("Minimal age: " + this.minAge);
        System.out.println("Description: " + this.description);
    }

    public int getMinAge() {
        return minAge;
    }

    public String getDescription() {
        return description;
    }
}
