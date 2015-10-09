package com.levchenko.snake.ui;

import com.levchenko.snake.core.handlers.Command;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author Alexey Levchhenko
 */
public class GameKeyAdapter extends KeyAdapter {

    private Command up;
    private Command down;
    private Command left;
    private Command right;
    private Command pauseResume;


    public void setUpCommand(Command up) {
        this.up = up;
    }

    public void setDownCommand(Command down) {
        this.down = down;
    }

    public void setLeftCommand(Command left) {
        this.left = left;
    }

    public void setRightCommand(Command right) {
        this.right = right;
    }

    public void setPauseResumeCommand(Command pauseResume) {
        this.pauseResume = pauseResume;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_UP:
                up.execute();
                break;

            case KeyEvent.VK_DOWN:
                down.execute();
                break;

            case KeyEvent.VK_LEFT:
                left.execute();
                break;

            case KeyEvent.VK_RIGHT:
                right.execute();
                break;

            case KeyEvent.VK_SPACE: {
                pauseResume.execute();
                break;
            }

        }

    }

}
