package ao.jfpack.patterns.command;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Buy implements Command {

    private final Stock stock;

    @Override
    public void execute() {
        stock.buy();
    }
}
