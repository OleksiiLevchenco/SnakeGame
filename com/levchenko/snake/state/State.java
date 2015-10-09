package com.levchenko.snake.state;

/**
 * @author Alexey Levchhenko
 */
public interface State {

    public void pauseOrResume();
//    public void winn();
    public void gameOver();

    public void newGame();

    public void resume();

    public void  pause();


}
