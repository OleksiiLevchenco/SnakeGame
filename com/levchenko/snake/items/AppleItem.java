package com.levchenko.snake.items;

/**
 * @author Alexey Levchhenko
 */
public class AppleItem{

    private com.levchenko.snake.Point position;

    public AppleItem(com.levchenko.snake.Point position) {
        this.position = position;
    }

    public com.levchenko.snake.Point getPosition() {
        return position;
    }

    public void setPosition(com.levchenko.snake.Point position) {
        this.position = position;
    }

}

