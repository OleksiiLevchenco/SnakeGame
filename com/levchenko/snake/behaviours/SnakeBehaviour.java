package com.levchenko.snake.behaviours;

import com.levchenko.snake.items.AppleItem;
import com.levchenko.snake.items.SnakeItem;

import java.util.LinkedList;

/**
 * @author Alexey Levchhenko
 */
public class SnakeBehaviour {

    public enum Direction {UP, DOWN, LEFT, RIGHT}

    public void move(SnakeItem snakeItem, SnakeBehaviour.Direction direction) {

        LinkedList<com.levchenko.snake.Point> body = snakeItem.getBody();

        switch (direction) {
            case UP: {
                int newX = body.getFirst().getX();
                int newY = body.getFirst().getY() - 1;
                body.addFirst(new com.levchenko.snake.Point(newX, newY));
                body.removeLast();
            }
            break;
            case DOWN: {
                int newX = body.getFirst().getX();
                int newY = body.getFirst().getY() + 1;
                body.addFirst(new com.levchenko.snake.Point(newX, newY));
                body.removeLast();
            }
            break;
            case LEFT: {
                int newX = body.getFirst().getX() - 1;
                int newY = body.getFirst().getY();
                body.addFirst(new com.levchenko.snake.Point(newX, newY));
                body.removeLast();
            }
            break;
            case RIGHT: {
                int newX = body.getFirst().getX() + 1;
                int newY = body.getFirst().getY();
                body.addFirst(new com.levchenko.snake.Point(newX, newY));
                body.removeLast();
            }
            break;
        }
    }

    public boolean eatApple(SnakeItem snakeItem, AppleItem appleItem) {

        LinkedList<com.levchenko.snake.Point> body = snakeItem.getBody();

        com.levchenko.snake.Point head = snakeItem.getHead();

        if (head.equals(appleItem.getPosition())) {
            body.addLast(body.getLast());
            System.out.println("Eat");
            return true;
        } else return false;
    }

    public boolean eatSelf(SnakeItem snakeItem) {

        LinkedList<com.levchenko.snake.Point> body = snakeItem.getBody();

        int size = body.size();
        com.levchenko.snake.Point head = snakeItem.getHead();
        if (size > 4) {
            for (int i = 4; i < size; i++) {
                if (body.get(i).equals(head)) {
                    System.out.println("equals");
                    for (int j = size - 1; j >= i; j--) {
                        body.remove(j);
                        System.out.println("self");
                    }
                    return true;
                }
            }
        }
        return false;
    }


}
