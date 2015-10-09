package com.levchenko.snake.core.handlers.controlHandlers;

import com.levchenko.snake.core.handlers.Command;
import com.levchenko.snake.Context;
import com.levchenko.snake.behaviours.SnakeBehaviour;

/**
 * @author Alexey Levchhenko
 */
public class RightHandler  implements Command {
    Context gameContext;

    public RightHandler(Context gameContext) {
        this.gameContext = gameContext;
    }

    @Override
    public void execute() {
        if (!gameContext.getDirection().equals(SnakeBehaviour.Direction.LEFT)) {
            gameContext.setDirection(SnakeBehaviour.Direction.RIGHT);
        }
    }

    @Override
    public void undo() {

    }
}
