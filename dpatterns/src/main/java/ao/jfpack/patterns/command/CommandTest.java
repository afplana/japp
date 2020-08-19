package ao.jfpack.patterns.command;

import org.junit.jupiter.api.Test;

public class CommandTest {

    @Test
    void testCommand() {
        Stock apple = new Stock();
        Buy buy = new Buy(apple);
        Sell sell = new Sell(apple);
        Invoker invoker = new Invoker();
        invoker.addCommand(buy);
        invoker.addCommand(sell);
        invoker.executeAll();
    }
}
