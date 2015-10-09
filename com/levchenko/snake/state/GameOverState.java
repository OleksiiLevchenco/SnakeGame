package com.levchenko.snake.state;


/**
 * @author Alexey Levchhenko
 */
public class GameOverState implements State {

    private StateContext context;

    public GameOverState(StateContext stateContext) {
        this.context = stateContext;
    }


    @Override
    public void pauseOrResume() {

    }

    @Override
    public void gameOver() {

    }

    @Override
    public void newGame() {

        context.setStateFlag(StateFlag.PLAY);

        context.getNewGameCommand().execute();

        context.setState(context.getResumeState());

    }

    @Override
    public void resume() {

        System.out.println("resume from Game Over");

        context.setStateFlag(StateFlag.PLAY);

        context.getResumeCommand().execute();

        context.setState(context.getResumeState());
    }

    @Override
    public void pause() {

    }
}
