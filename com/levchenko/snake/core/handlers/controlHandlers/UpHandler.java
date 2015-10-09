package com.levchenko.snake.core.handlers.controlHandlers;

import com.levchenko.snake.Context;
import com.levchenko.snake.behaviours.SnakeBehaviour;
import com.levchenko.snake.core.handlers.Command;

/**
 * @author Alexey Levchhenko
 */
public class UpHandler   implements Command {
    Context gameContext;

    public UpHandler(Context gameContext) {
        this.gameContext = gameContext;
    }

    @Override
    public void execute() {
        if (!gameContext.getDirection().equals(SnakeBehaviour.Direction.DOWN)) {
            gameContext.setDirection(SnakeBehaviour.Direction.UP);
        }
    }

    @Override
    public void undo() {

    }
}
