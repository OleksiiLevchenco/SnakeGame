package com.levchenko.snake.core.handlers.controlHandlers;

import com.levchenko.snake.core.handlers.Command;
import com.levchenko.snake.state.StateContext;

/**
 * @author Alexey Levchhenko
 */
public class PauseOrResumeHandler implements Command {
    StateContext stateContext;

    public PauseOrResumeHandler(StateContext stateContext) {
        this.stateContext = stateContext;
    }

    @Override
    public void execute() {
       stateContext.pauseOrResume();
    }

    @Override
    public void undo() {

    }
}
