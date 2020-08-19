package ao.jfpack.patterns.command;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Sell implements Command {

    private final Stock stock;

    @Override
    public void execute() {
        stock.sell();
    }
}
