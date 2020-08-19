package ao.jfpack.patterns.command;

public class Stock {

    private final String name = "APPLE";
    private final int quantity = 1000;

    public void buy() {
        System.out.println("Stock [Name: "+name+". Quantity: " +quantity+ "] bought");
    }

    public void sell() {
        System.out.println("Stock [Name: "+name+". Quantity: " +quantity+ "] sold");
    }
}
