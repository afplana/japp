package ao.jfpack.patterns.singleton;

import java.util.Objects;

public class Singleton {

    private String configPath;
    private int configAmount;

    private static final Singleton instance = new Singleton();

    private Singleton(){
        configPath = "/opt/";
        configAmount = 1;
    }

    private static Singleton getInstance() {
        if(Objects.isNull(instance))
            return new Singleton();
        return instance;
    }

    public void setConfigPath(String newPath) {
        configPath = newPath;
    }

    public void setConfigAmount(int newAmount) {
        configAmount = newAmount;
    }
}
