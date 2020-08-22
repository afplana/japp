package ao.jfpack.patterns.entity;

public class User {
    long id;
    String username;

    public User(long id, String username) {
        this.id = id;
        this.username = username;
    }

    public User() {
        this(999, "default");
    }

    public String toString() {
        return "{ ID: " + this.id + " USERNAME: " + this.username + " }";
    }
}
