package ao.jfpack.patterns.template;

public abstract class StepTemplate {
    abstract void read();
    abstract void process();
    abstract void write();

    public final void execute() {
        read();
        process();
        write();
    }
}
