package ao.jfpack.patterns.command;

import java.util.Stack;

public class Invoker {

    private final Stack<Command> commands = new Stack<>();

    public void addCommand(Command command){
        commands.push(command);
    }

    public void executeAll(){
        commands.forEach(Command::execute);
        commands.clear();
    }
}
