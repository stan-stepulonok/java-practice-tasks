package task10;

public class User {

    private UserRole role;
    private String email;
    private int id;

    private static int lastId = 0;

    public User(String email, UserRole role) {
        this.email = email;
        this.role = role;
        lastId++;
        this.id = lastId;
    }

    public void doSmth() {
        switch (this.role) {
            case GUEST -> System.out.println(this.role.getFeatures());
            case USER -> System.out.println(this.role.getFeatures());
            case ADMIN -> System.out.println(this.role.getFeatures());
            default -> System.out.println("Something went wrong!");
        }
    }

}
