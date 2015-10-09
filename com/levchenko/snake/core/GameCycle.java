package com.levchenko.snake.core;

import com.levchenko.snake.core.handlers.controlHandlers.*;
import com.levchenko.snake.core.handlers.simpleCommands.*;
import com.levchenko.snake.Context;
import com.levchenko.snake.GameContext;
import com.levchenko.snake.core.handlers.MacroCommand;
import com.levchenko.snake.items.AppleGenThread;
import com.levchenko.snake.state.StateContext;
import com.levchenko.snake.ui.GameKeyAdapter;
import com.levchenko.snake.ui.WindowItem;


/**
 * @author Alexey Levchhenko
 */
public class GameCycle {


    public synchronized static GameCycle getInstance() {
        if (instance == null) {
            instance = new GameCycle();
        }
        return instance;
    }

    private static GameCycle instance;

    private Context gameContext;
    private WindowItem windowItem;
    private AppleGenThread appleGen;
    private StateContext stateContext;
    private GameKeyAdapter gameKeyAdapter;
    private GameLogic gameLogic;



    public void run() {
        gameContext = new GameContext();
        gameContext.init();

        gameKeyAdapter = new GameKeyAdapter();

        windowItem = new WindowItem(gameContext, gameKeyAdapter);
        gameLogic = new GameLogic();




        appleGen = new AppleGenThread(gameContext);
        appleGen.start();

        stateContext = new StateContext();

        gameKeyAdapter.setUpCommand(new UpHandler(gameContext));
        gameKeyAdapter.setDownCommand(new DownHandler(gameContext));
        gameKeyAdapter.setLeftCommand(new LeftHandler(gameContext));
        gameKeyAdapter.setRightCommand(new RightHandler(gameContext));
        gameKeyAdapter.setPauseResumeCommand(new PauseOrResumeHandler(stateContext));
        gameLogic.setGameOverCommand(new GameOverCommand(stateContext));


        MacroCommand pauseMacroCommand = new MacroCommand(
                new WindowPauseCommand(windowItem),
                new AppleGenPauseCommand(appleGen)
        );
        stateContext.setPauseCommand(pauseMacroCommand);


        MacroCommand resumeMacroCommand = new MacroCommand(
                new WindowPlayCommand(windowItem),
                new AppleGenResumeCommand(appleGen)
        );
        stateContext.setResumeCommand(resumeMacroCommand);


        MacroCommand gameOverMC = new MacroCommand(
                new WindowGameOverCommand(windowItem),
                new AppleGenPauseCommand(appleGen)
        );
        stateContext.setGameOverCommand(gameOverMC);

        MacroCommand newGameMC = new MacroCommand(
                new GameContextInitCommand(gameContext),
                new WindowItemInitCommand(windowItem),
                new ResumeCommand(stateContext)
        );
        windowItem.getGameOverPanel().setNewGameCommand(newGameMC);
        windowItem.getPausePanel().setNewGameCommand(newGameMC);
        windowItem.getPausePanel().setResumeCommand(new ResumeCommand(stateContext));



        while (true) {

            switch (stateContext.getStateFlag()) {
                case PAUSE:

                    try {
                        Thread.sleep(300);
//                        System.out.println("Sleep______");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case PLAY: {
                    gameLogic.update(gameContext);
                    windowItem.repaint(gameContext);
//                    System.out.println("Play_______");

                    try {
                        Thread.sleep(1000 / gameContext.getSpeed());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            }
        }
    }

}
