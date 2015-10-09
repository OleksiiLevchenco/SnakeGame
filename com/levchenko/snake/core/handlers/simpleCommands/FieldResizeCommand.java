package com.levchenko.snake.core.handlers.simpleCommands;

import com.levchenko.snake.Context;

import java.awt.event.ComponentEvent;

/**
 * @author Alexey Levchhenko
 */
public class FieldResizeCommand {
    Context gameContext;

    public FieldResizeCommand(Context gameContext) {
        this.gameContext = gameContext;
    }


    public void execute(ComponentEvent e) {
        int w = e.getComponent().getWidth();
        int h = e.getComponent().getHeight();
        int fieldWide = w / gameContext.getCellSize();
        int fieldHigh = h / gameContext.getCellSize();
        gameContext.getFieldSize().setWide(fieldWide);
        gameContext.getFieldSize().setHigh(fieldHigh);
    }

}
