package com.levchenko.snake.core.handlers.simpleCommands;

import com.levchenko.snake.core.handlers.Command;
import com.levchenko.snake.state.StateContext;

/**
 * @author Alexey Levchhenko
 */
public class GameOverCommand implements Command {
    StateContext stateContext;

    public GameOverCommand(StateContext stateContext) {
        this.stateContext = stateContext;
    }

    @Override
    public void execute() {
       stateContext.gameOver();
    }

    @Override
    public void undo() {

    }
}
