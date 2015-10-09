package com.levchenko.snake;

import com.levchenko.snake.core.GameCycle;

/**
 * @author Alexey Levchhenko
 */
public class GameStarter {

    public static void main(String[] arg) {

        final GameCycle gameCycle = GameCycle.getInstance();
        gameCycle.run();

    }
}