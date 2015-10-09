package com.levchenko.snake.core.handlers.simpleCommands;

import com.levchenko.snake.core.handlers.Command;
import com.levchenko.snake.items.AppleGenThread;

/**
 * @author Alexey Levchhenko
 */
public class AppleGenPauseCommand implements Command {
    AppleGenThread appleGenThread;

    public AppleGenPauseCommand(AppleGenThread appleGenThread) {
        this.appleGenThread = appleGenThread;
    }

    @Override
    public void execute() {
       appleGenThread.threadPause();
    }

    @Override
    public void undo() {

    }
}
