package com.levchenko.snake.core;

import com.levchenko.snake.Point;
import com.levchenko.snake.Context;
import com.levchenko.snake.behaviours.SnakeBehaviour;
import com.levchenko.snake.core.handlers.Command;

/**
 * @author Alexey Levchenko
 */
public class GameLogic {

    private Command winne;
    private Command gameOver;

    private final SnakeBehaviour snakeBehaviour = new SnakeBehaviour();


    public void update(Context gameContext) {
//        final FieldItem fieldItem = gameContext.getFieldItem();
//        snakeBehaviour.moveSnake(gameFieldItem.getSnakeItem(), gameContext.getDirection());
        //Добавить проверку, если яблоко на пути
        //если да, то snakeBehaviour.eat()

        moveSnake(gameContext);
        wrap(gameContext);
        checkEatApples(gameContext);
        if (gameContext.isCanEatSelf()) {
            checkEatSelf(gameContext);
        }
        checkGameOver(gameContext);
    }

    public void setGameOverCommand(Command gameOver) {
        this.gameOver = gameOver;
    }

    private void moveSnake(Context gameContext) {
        snakeBehaviour.move(gameContext.getSnakeItem(), gameContext.getDirection());

    }

    private void wrap(Context gameContext) {
        int xMax = gameContext.getFieldSize().getWide();
        int yMax = gameContext.getFieldSize().getHigh();
        Point head = gameContext.getSnakeItem().getHead();

        if (head.getX() < 0) head.setX(xMax - 1);
        if (head.getX() > xMax - 1) head.setX(0);
        if (head.getY() < 0) head.setY(yMax - 1);
        if (head.getY() > yMax - 1) head.setY(0);
    }

    private void checkEatApples(Context gameContext) {
        for (int i = 0; i < gameContext.getAppleItems().size(); i++) {
            if (snakeBehaviour.eatApple(gameContext.getSnakeItem(), gameContext.getAppleItems().get(i))) {
                gameContext.getAppleItems().remove(i);
                gameContext.setScore(gameContext.getSnakeItem().getSize());
                break;

            }
        }
    }

    private void checkEatSelf(Context gameContext) {
        snakeBehaviour.eatSelf(gameContext.getSnakeItem());
        gameContext.setScore(gameContext.getSnakeItem().getSize());

    }

    private void checkGameOver(Context gameContext){
        if (gameContext.getAppleItems().size() >= gameContext.getGameOverAppleQty()){
            gameOver.execute();
        }
    }


}
