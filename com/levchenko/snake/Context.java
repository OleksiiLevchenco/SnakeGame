package com.levchenko.snake;

import com.levchenko.snake.behaviours.SnakeBehaviour;
import com.levchenko.snake.items.AppleList;
import com.levchenko.snake.items.SnakeItem;

/**
 * @author Alexey Levchhenko
 */
public interface Context {

    SnakeItem getSnakeItem();

    void setSnakeItem(SnakeItem snakeItem);

    SnakeBehaviour.Direction getDirection();

    void setDirection(SnakeBehaviour.Direction direction);

    AppleList getAppleItems();

    void setAppleItems(AppleList appleItems);

    int getSpeed();

    void setSpeed(int speed);

    Size getFieldSize();

    void setFieldSize(Size fieldSize);

    int getCellSize();

    void setCellSize(int cellSize);

    int getScore();

    void setScore(int score);

    int getGameOverAppleQty();

    void setGameOverAppleQty(int gameOverAppleQty);

    boolean isCanEatSelf();

    void setCanEatSelf(boolean canEatSelf);

    void init();

    void newGameInit();
}
