package com.levchenko.snake.core.handlers;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author Alexey Levchhenko
 */
public class MacroCommand implements Command {
    LinkedList<Command> commands = new LinkedList<Command>();

    public MacroCommand(){}

    public MacroCommand(Command... commands) {
        Collections.addAll(this.commands, commands);
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    @Override
    public void undo() {

    }

    public void add(Command... command){
        Collections.addAll(commands, command);
    }
}
