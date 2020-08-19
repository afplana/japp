package ao.jfpack.patterns.chor;

public class ChorTest {

    public static AbstractLogger loggerChain() {
        AbstractLogger errorLogger = new ErrorLogger();
        AbstractLogger fileLogger = new FileLogger().setLevel(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger().setLevel(AbstractLogger.INFO);

        errorLogger.setNext(fileLogger);
        fileLogger.setNext(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = loggerChain();

        loggerChain.register(AbstractLogger.INFO,"This is an information.");
        loggerChain.register(AbstractLogger.DEBUG, "This is a debug level information.");
        loggerChain.register(AbstractLogger.ERROR, "This is an error information.");

    }
}
