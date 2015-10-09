package com.levchenko.snake.state;

/**
 * @author Alexey Levchhenko
 */
public class PlayState implements State {

    private StateContext context;

    public PlayState(StateContext stateContext) {
        this.context = stateContext;
    }

    @Override
    public void pauseOrResume() {

        context.setStateFlag(StateFlag.PAUSE);

        context.getPauseCommand().execute();

        context.setState(context.getPauseState());
    }

    @Override
    public void gameOver() {

        context.getGameOverCommand().execute();
        context.setState(context.getGameOverState());
        context.setStateFlag(StateFlag.PAUSE);

    }

    @Override
    public void newGame() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

        context.setStateFlag(StateFlag.PAUSE);

        context.getPauseCommand().execute();

        context.setState(context.getPauseState());

    }

}

