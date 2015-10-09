package com.levchenko.snake.core.handlers.simpleCommands;

import com.levchenko.snake.core.handlers.Command;
import com.levchenko.snake.Context;

/**
 * @author Alexey Levchhenko
 */
public class GameContextInitCommand implements Command {
    Context context;

    public GameContextInitCommand(Context context) {
        this.context = context;
    }

    @Override
    public void execute() {
        context.newGameInit();
    }

    @Override
    public void undo() {

    }
}
