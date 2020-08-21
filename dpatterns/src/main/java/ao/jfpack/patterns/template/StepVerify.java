package ao.jfpack.patterns.template;

public class StepVerify extends StepTemplate {

    @Override
    void read() {
        System.out.println("Read file from filesystem");
    }

    @Override
    void process() {
        System.out.println("Verifying file content validity");
    }

    @Override
    void write() {
        System.out.println("Saving content to database");
    }
}
