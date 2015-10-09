package com.levchenko.snake.state;

import com.levchenko.snake.core.handlers.Command;

/**
 * @author Alexey Levchhenko
 */
public class StateContext {

    private State pauseState = new PauseState(this);
    private State resumeState = new PlayState(this);
    private State gameOverState = new GameOverState(this);


    private State state = resumeState;
    private StateFlag stateFlag = StateFlag.PLAY;

    private Command resumeCommand;
    private Command pauseCommand;
    private Command gameOverCommand;
    private Command newGameCommand;

    public StateContext() {}


    public StateFlag getStateFlag() {
        return stateFlag;
    }

    public void setStateFlag(StateFlag stateFlag) {
        this.stateFlag = stateFlag;
    }

 /* get State */
    public State getState() {
        return state;
    }

    public State getResumeState() {
        return resumeState;
    }

    public State getPauseState() {
        return pauseState;
    }

    public State getGameOverState() {
        return gameOverState;
    }



    /* state methods*/
    public void pauseOrResume() {
        state.pauseOrResume();
    }

    public void gameOver() {
        state.gameOver();
    }

    public void newGame() {state.newGame();}



    public void setState(State state) {
        this.state = state;
    }

    public void setResumeCommand(Command resumeCommand) {
        this.resumeCommand = resumeCommand;
    }

    public void setPauseCommand(Command pauseCommand) {
        this.pauseCommand = pauseCommand;
    }

    public void setGameOverCommand(Command gameOverCommand) {
        this.gameOverCommand = gameOverCommand;
    }

    public void setNewGameCommand(Command newGameCommand) {
        this.newGameCommand = newGameCommand;
    }

    public Command getGameOverCommand() {
        return gameOverCommand;
    }

    public Command getResumeCommand() {
        return resumeCommand;
    }

    public Command getPauseCommand() {
        return pauseCommand;
    }

    public Command getNewGameCommand() {
        return newGameCommand;
    }
}
