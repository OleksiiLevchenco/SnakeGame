package com.levchenko.snake.core.handlers.controlHandlers;

import com.levchenko.snake.core.handlers.Command;
import com.levchenko.snake.Context;
import com.levchenko.snake.behaviours.SnakeBehaviour;

/**
 * @author Alexey Levchhenko
 */
public class DownHandler  implements Command {
    Context gameContext;

    public DownHandler(Context gameContext) {
        this.gameContext = gameContext;
    }

    @Override
    public void execute() {
        if (!gameContext.getDirection().equals(SnakeBehaviour.Direction.UP)) {
            gameContext.setDirection(SnakeBehaviour.Direction.DOWN);
        }
    }

    @Override
    public void undo() {

    }
}
