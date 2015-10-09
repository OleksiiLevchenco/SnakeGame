package com.levchenko.snake.core.handlers.simpleCommands;

import com.levchenko.snake.core.handlers.Command;
import com.levchenko.snake.ui.WindowItem;

/**
 * @author Alexey Levchhenko
 */
public class WindowPauseCommand implements Command {
    WindowItem windowItem;

    public WindowPauseCommand(WindowItem windowItem) {
        this.windowItem = windowItem;
    }

    @Override
    public void execute() {
       windowItem.showPause();
    }

    @Override
    public void undo() {

    }
}
