package ao.jfpack.patterns.chor;

public class FileLogger extends AbstractLogger {

    public FileLogger() {
    }

    public FileLogger setLevel(int level) {
        this.level = level;
        return this;
    }


    @Override
    protected void log(String message) {
        System.out.println("FILE::LOGGER: " + message);
    }
}
