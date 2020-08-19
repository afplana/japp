package ao.jfpack.patterns.chor;

public abstract class AbstractLogger {

    public static final int DEBUG = 1;
    public static final int INFO = 2;
    public static final int WARNING = 3;
    public static final int ERROR = 4;
    protected int level;

    protected AbstractLogger next;

    public void setNext(AbstractLogger abstractLogger) {
        this.next = abstractLogger;
    }

    public void register(int level, String message) {
        if (this.level <= level) {
            log(message);
        }

        if (next != null) {
            next.log(message);
        }
    }

    protected abstract void log(String message);
}
