package com.levchenko.snake.core.handlers.simpleCommands;

import com.levchenko.snake.state.StateContext;
import com.levchenko.snake.core.handlers.Command;

/**
 * @author Alexey Levchhenko
 */
public class ResumeCommand implements Command {

    StateContext stateContext;

    public ResumeCommand(StateContext stateContext) {
        this.stateContext = stateContext;
    }

    @Override
    public void execute() {
        stateContext.getState().resume();
    }

    @Override
    public void undo() {

    }
}
