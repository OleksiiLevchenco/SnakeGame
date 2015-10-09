package com.levchenko.snake.ui;

import com.levchenko.snake.core.handlers.Command;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Alexey Levchhenko
 */
public class PausePanel extends JPanel {
    Command resumeCommand;
    Command newGameCommand;

    public void setResumeCommand(Command resume) {
        this.resumeCommand = resume;
    }

    public void setNewGameCommand(Command newGame) {
        this.newGameCommand = newGame;
    }


    public PausePanel(){
        JButton resumeButton = new JButton("Resume");
        JButton settingsButton = new JButton("Settings");
        JButton newGameButton = new JButton("New Game");

        resumeButton.setFocusable(false);
        settingsButton.setFocusable(false);
        add(resumeButton);
        add(settingsButton);
        add(newGameButton);

        resumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resumeCommand.execute();
            }
        });

        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGameCommand.execute();
            }
        });

    }


    @Override
    public void paintComponent (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.DARK_GRAY);
        g2d.fillRect(0,0,getWidth(),getHeight());
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.setFont(new Font("TimesRoman", Font.BOLD, 25));
        g2d.drawString("Pause",(getWidth()/2)-50 , (getHeight()/2)-30);

    }

}
