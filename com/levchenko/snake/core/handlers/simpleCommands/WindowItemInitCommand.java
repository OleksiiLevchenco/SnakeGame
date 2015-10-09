package com.levchenko.snake.core.handlers.simpleCommands;

import com.levchenko.snake.core.handlers.Command;
import com.levchenko.snake.ui.WindowItem;

/**
 * @author Alexey Levchhenko
 */
public class WindowItemInitCommand implements Command {
    WindowItem windowItem;

    public WindowItemInitCommand(WindowItem windowItem) {
        this.windowItem = windowItem;
    }

    @Override
    public void execute() {
        windowItem.newGameInit();
    }

    @Override
    public void undo() {

    }
}
