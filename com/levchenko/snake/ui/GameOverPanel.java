package com.levchenko.snake.ui;

import com.levchenko.snake.core.handlers.Command;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Alexey Levchhenko
 */
public class GameOverPanel extends JPanel {

    private Command newGame;

    public void setNewGameCommand(Command newGame) {
        this.newGame = newGame;
    }

    public GameOverPanel(){
//        GridLayout layout = new GridLayout();
//        setLayout(layout);
        JButton newGameButton = new JButton("New game");
        JButton settingsButton = new JButton("Settings");
//        JLabel gameOverLabel = new JLabel("<html> <font color='yellow'>Game Over</font></html>");

        newGameButton.setFocusable(false);
        settingsButton.setFocusable(false);
        add(newGameButton);
        add(settingsButton);
        newGameButton.addActionListener(/*newGameButtonListener*/ new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("new game");
                newGame.execute();
            }
        });

    }


    @Override
    public void paintComponent (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.DARK_GRAY);
        g2d.fillRect(0,0,getWidth(),getHeight());
        g2d.setColor(Color.YELLOW);
        g2d.setFont(new Font("TimesRoman", Font.BOLD, 25));
        g2d.drawString("Game Over",(getWidth()/2)-70 , (getHeight()/2)-30);
    }

}
