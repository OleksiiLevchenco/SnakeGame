package com.levchenko.snake.ui;

import com.levchenko.snake.core.handlers.Command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Alexey Levchenko
 */
public class NewGameButtonListener implements ActionListener {

    private Command newGame;

    public NewGameButtonListener(Command newGame) {
        this.newGame = newGame;
    }

    public void setNewGameCommand(Command newGame) {
        this.newGame = newGame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("before");
        newGame.execute();
        System.out.println("after");


    }
}
