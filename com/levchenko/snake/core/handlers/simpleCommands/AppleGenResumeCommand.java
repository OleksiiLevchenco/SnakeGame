package com.levchenko.snake.core.handlers.simpleCommands;

import com.levchenko.snake.core.handlers.Command;
import com.levchenko.snake.items.AppleGenThread;

/**
 * @author Alexey Levchhenko
 */
public class AppleGenResumeCommand implements Command {
    AppleGenThread appleGenThread;

    public AppleGenResumeCommand(AppleGenThread appleGenThread) {
        this.appleGenThread = appleGenThread;
    }

    @Override
    public void execute() {
       appleGenThread.threadResume();
    }

    @Override
    public void undo() {

    }
}
