package ao.jfpack.patterns.chor;

public class ErrorLogger extends AbstractLogger {

    private static final int ERROR_LEVEL = 4;

    public ErrorLogger() {
        this.level = ERROR_LEVEL;
    }

    @Override
    protected void log(String message) {
        System.out.println("ERROR::LOGGER: " + message);
    }
}
