package com.levchenko.snake.core.handlers.simpleCommands;

import com.levchenko.snake.core.handlers.Command;
import com.levchenko.snake.ui.WindowItem;

/**
 * @author Alexey Levchhenko
 */
public class WindowPlayCommand implements Command {
    WindowItem windowItem;

    public WindowPlayCommand(WindowItem windowItem) {
        this.windowItem = windowItem;
    }

    @Override
    public void execute() {
       windowItem.showGame();
    }

    @Override
    public void undo() {

    }
}
