package com.levchenko.snake.items;

import com.levchenko.snake.Context;

import java.util.Random;

/**
 * @author Alexey Levchhenko
 */
public class AppleGenThread extends Thread {

    private boolean pause = false;

    private Context gameContext;

    public AppleGenThread(Context gameContext) {
        this.gameContext = gameContext;
        pause = false;
    }

    public void threadPause() {
        pause = true;
    }

    public void threadResume() {
        pause = false;
    }

    @Override
    public void run() {
        int delay;

        final int APPLE_APOCALYPSES_COUNT = 38;
        final int APOCALYPSES_DELAY = 150;
        final int ONE_ITEM_DELAY = 20 * 1000;

        AppleSimpleFactory simpleFactory = new AppleSimpleFactory();

        while (true) {
            while (pause) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //TODO: Move method body to GameCycle.run()
            gameContext.getAppleItems().
                    add(simpleFactory.CreateRandomPosApple(gameContext.getFieldSize()));
            Random rand = new Random();

            if (gameContext.getAppleItems().size() > APPLE_APOCALYPSES_COUNT) {
                delay = APOCALYPSES_DELAY;
            } else {
                delay = ONE_ITEM_DELAY / ((gameContext.getAppleItems().size() / 2) + 1);
            }

            try {
                Thread.sleep(delay / 2 + rand.nextInt(delay));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
