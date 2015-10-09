package com.levchenko.snake.core.handlers.simpleCommands;

import com.levchenko.snake.core.handlers.Command;
import com.levchenko.snake.state.StateContext;

/**
 * @author Alexey Levchhenko
 */
public class PauseCommand implements Command {

    StateContext stateContext;

    public PauseCommand(StateContext stateContext) {
        this.stateContext = stateContext;
    }

    @Override
    public void execute() {
        stateContext.getState().pause();
    }

    @Override
    public void undo() {

    }
}
