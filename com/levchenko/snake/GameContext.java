package com.levchenko.snake;

import com.levchenko.snake.behaviours.SnakeBehaviour;
import com.levchenko.snake.items.AppleSimpleFactory;
import com.levchenko.snake.items.SnakeItem;
import com.levchenko.snake.items.AppleList;

/**
 * @author Alexey Levchhenko
 */

public class GameContext implements Context {

    private SnakeItem snakeItem;
    private SnakeBehaviour.Direction direction;
//    private volatile LinkedList<AppleItem> appleItems = new LinkedList<AppleItem>();

    private volatile AppleList appleItems;


    private int speed;
    private Size fieldSize = new Size();

    private int cellSize;
    private int score;
    private int gameOverAppleQty;

    private boolean canEatSelf;


    @Override
    public SnakeItem getSnakeItem() {
        return snakeItem;
    }

    @Override
    public void setSnakeItem(SnakeItem snakeItem) {
        this.snakeItem = snakeItem;
    }

    @Override
    public SnakeBehaviour.Direction getDirection() {
        return direction;
    }

    @Override
    public void setDirection(SnakeBehaviour.Direction direction) {
        this.direction = direction;
    }

    @Override
    public AppleList getAppleItems() {
        return appleItems;
    }

    @Override
    public void setAppleItems(AppleList appleItems) {
        this.appleItems = appleItems;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public Size getFieldSize() {
        return fieldSize;
    }

    @Override
    public void setFieldSize(Size fieldSize) {
        this.fieldSize = fieldSize;
    }

    @Override
    public int getCellSize() {
        return cellSize;
    }

    @Override
    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int getGameOverAppleQty() {
        return gameOverAppleQty;
    }

    @Override
    public void setGameOverAppleQty(int gameOverAppleQty) {
        this.gameOverAppleQty = gameOverAppleQty;
    }

    @Override
    public boolean isCanEatSelf() {
        return canEatSelf;
    }

    @Override
    public void setCanEatSelf(boolean canEatSelf) {
        this.canEatSelf = canEatSelf;
    }



    @Override
    public void init() {
        appleItems = new AppleList();
        speed = 10; //cells per second
        cellSize = 10;
        fieldSize.setHigh(60);
        fieldSize.setWide(60);
        snakeItem = new SnakeItem(fieldSize.getWide() / 2, fieldSize.getHigh() / 2);

        gameOverAppleQty = 60;
        canEatSelf = true;

        setDirection(SnakeBehaviour.Direction.UP);

        score = snakeItem.getSize();

        presetApples(this);
    }

    @Override
    public void newGameInit() {
        appleItems = new AppleList();
        snakeItem = new SnakeItem(fieldSize.getWide() / 2, fieldSize.getHigh() / 2);
        setDirection(SnakeBehaviour.Direction.UP);
        score = snakeItem.getSize();
        presetApples(this);
        System.out.println("Context item init");
    }

    private void presetApples(Context gameContext){

        AppleSimpleFactory factory = new AppleSimpleFactory();

        for (int i = 0; i < 20; i++) {
            gameContext.getAppleItems().add(factory.CreateRandomPosApple(gameContext.getFieldSize()));
        }

    }


}
