package com.levchenko.snake.core.handlers.controlHandlers;

import com.levchenko.snake.Context;
import com.levchenko.snake.behaviours.SnakeBehaviour;
import com.levchenko.snake.core.handlers.Command;


/**
 * @author Alexey Levchhenko
 */
public class LeftHandler  implements Command {
    Context gameContext;

    public LeftHandler(Context gameContext) {
        this.gameContext = gameContext;
    }

    @Override
    public void execute() {
        if (!gameContext.getDirection().equals(SnakeBehaviour.Direction.RIGHT)) {
            gameContext.setDirection(SnakeBehaviour.Direction.LEFT);
        }
    }

    @Override
    public void undo() {

    }
}