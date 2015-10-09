package com.levchenko.snake.core.handlers.simpleCommands;

import com.levchenko.snake.core.handlers.Command;
import com.levchenko.snake.ui.WindowItem;

/**
 * @author Alexey Levchhenko
 */
public class WindowGameOverCommand implements Command {
    WindowItem windowItem;

    public WindowGameOverCommand(WindowItem windowItem) {
        this.windowItem = windowItem;
    }

    @Override
    public void execute() {
       windowItem.showGameOver();
    }

    @Override
    public void undo() {

    }
}
