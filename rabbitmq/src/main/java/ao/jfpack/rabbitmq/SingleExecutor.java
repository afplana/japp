package ao.jfpack.rabbitmq;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleExecutor {

    private static final ExecutorService exService = Executors.newCachedThreadPool();
    private SingleExecutor(){};

    public static ExecutorService getInstance(){
        return exService;
    }
}
