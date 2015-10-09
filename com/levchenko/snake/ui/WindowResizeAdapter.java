package com.levchenko.snake.ui;

import com.levchenko.snake.core.handlers.simpleCommands.FieldResizeCommand;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


/**
 * @author Alexey Levchhenko
 */
public class WindowResizeAdapter extends ComponentAdapter {

    private FieldResizeCommand resizeCommand;


    public void setResizeCommand(FieldResizeCommand resizeCommand) {
        this.resizeCommand = resizeCommand;
    }

    @Override
    public void componentResized(ComponentEvent e) {
        resizeCommand.execute(e);
    }
    
}
