package com.levchenko.snake.state;


/**
 * @author Alexey Levchhenko
 */
public class PauseState implements State {

    private StateContext context;

    public PauseState(StateContext stateContext) {
        this.context = stateContext;
    }


    @Override
    public void pauseOrResume() {

        context.setStateFlag(StateFlag.PLAY);

        context.getResumeCommand().execute();

        context.setState(context.getResumeState());
    }

    @Override
    public void gameOver() {

    }

    @Override
    public void newGame() {

    }

    @Override
    public void resume() {

        context.setStateFlag(StateFlag.PLAY);

        context.getResumeCommand().execute();

        context.setState(context.getResumeState());
    }

    @Override
    public void pause() {

    }
}
