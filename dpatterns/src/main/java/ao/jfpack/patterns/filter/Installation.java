package ao.jfpack.patterns.filter;

public class Installation {

    long id;
    String status;
    String customer;

    public Installation (long id, String status, String customer) {
        this.id = id;
        this.status = status;
        this.customer = customer;
    }

    public String toString() {
        return "Installation: [ id: " + id + ", Status: " + status + ", Customer: " + customer + " ]";
    }
}
