package ao.jfpack.patterns.chor;

public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger() {

    }

    public ConsoleLogger setLevel(int level) {
        this.level = level;
        return this;
    }

    @Override
    protected void log(String message) {
        System.out.println("CONSOLE::LOGGER: " + message);
    }
}
