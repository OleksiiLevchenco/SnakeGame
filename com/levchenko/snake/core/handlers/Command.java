package com.levchenko.snake.core.handlers;

/**
 * @author Alexey Levchhenko
 */
public interface Command {
    public void execute();
    public void undo();



}
