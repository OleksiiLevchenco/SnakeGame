package com.levchenko.snake.ui;

import com.levchenko.snake.core.handlers.simpleCommands.FieldResizeCommand;
import com.levchenko.snake.Context;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;


/**
 * @author Alexey Levchhenko
 */
public class WindowItem {

    private Context gameContext;
    private KeyAdapter gameKeyAdapter;

    public WindowItem(Context gameContext, KeyAdapter gameKeyAdapter) {
        this.gameContext = gameContext;
        this.gameKeyAdapter = gameKeyAdapter;
        init();
    }

    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu menu0;
    private JMenu menu1;
    private JPanel basePanel;
    private ViewportPanel viewportPanel;
    private PausePanel pausePanel;
    private GameOverPanel gameOverPanel;
    private CardLayout cardLayout = new CardLayout();
    private NewGameButtonListener newGameButtonListener;

    final String SHOW_GAME = "Game";
    final String SHOW_PAUSE = "Pause";
    final String SHOW_GAME_OVER = "GameOver";

    public Context getGameContext() {
        return gameContext;
    }

    public void setGameContext(Context gameContext) {
        this.gameContext = gameContext;
    }

    public KeyAdapter getGameKeyAdapter() {
        return gameKeyAdapter;
    }

    public void setGameKeyAdapter(KeyAdapter gameKeyAdapter) {
        this.gameKeyAdapter = gameKeyAdapter;
    }

    public PausePanel getPausePanel() {
        return pausePanel;
    }

    public void setPausePanel(PausePanel pausePanel) {
        this.pausePanel = pausePanel;
    }

    public GameOverPanel getGameOverPanel() {
        return gameOverPanel;
    }

    public void setGameOverPanel(GameOverPanel gameOverPanel) {
        this.gameOverPanel = gameOverPanel;
    }

    public void setNewGameButtonListener(NewGameButtonListener newGameButtonListener) {
        this.newGameButtonListener = newGameButtonListener;
    }

    public NewGameButtonListener getNewGameButtonListener() {
        return newGameButtonListener;
    }


    public void init() {
        frame = new JFrame("38 Попугаев");
        menuBar = new JMenuBar();
        menu0 = new JMenu("Score: ");
        menu1 = new JMenu("Попугаев: ");
        basePanel = new JPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLayout(new BorderLayout());

        basePanel.setLayout(cardLayout);
        viewportPanel = new ViewportPanel();
        viewportPanel.setGameContext(gameContext);
        viewportPanel.addDrawables(
                gameContext.getSnakeItem(),
                gameContext.getAppleItems()
        );

        pausePanel = new PausePanel();
        gameOverPanel = new GameOverPanel();



        menuBar.add(menu0);
        menuBar.add(menu1);
        frame.setJMenuBar(menuBar);

        int w = gameContext.getCellSize() * gameContext.getFieldSize().getWide();
        int h = gameContext.getCellSize() * gameContext.getFieldSize().getHigh();
        basePanel.setPreferredSize(new Dimension(w,h));

        basePanel.add(pausePanel,"Pause");
        basePanel.add(gameOverPanel,"GameOver");
        basePanel.add(viewportPanel,"Game");
        showGame();

        frame.add(basePanel);

        frame.addKeyListener(gameKeyAdapter);

        WindowResizeAdapter wra = new WindowResizeAdapter();

        wra.setResizeCommand(new FieldResizeCommand(gameContext));
        viewportPanel.addComponentListener(wra);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void newGameInit() {
        viewportPanel.clearDrawables();

        viewportPanel.getDrawables();
        System.out.println(viewportPanel.getClass());

        viewportPanel.addDrawables(
                gameContext.getSnakeItem(),
                gameContext.getAppleItems()
        );
        System.out.println("Window init");

    }

    public void repaint(Context gameContext) {
        menu0.setText("Score: " + gameContext.getScore());
        menu1.setText("Попугаев: " + gameContext.getAppleItems().size());
        viewportPanel.repaint();
    }

    public void showGame(){
        cardLayout.show(basePanel,SHOW_GAME);
    }

    public void showPause(){
        cardLayout.show(basePanel,SHOW_PAUSE);
    }

    public void showGameOver() {
        cardLayout.show(basePanel,SHOW_GAME_OVER);
    }
}
