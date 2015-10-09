package com.levchenko.snake.items;

import com.levchenko.snake.Size;

import java.util.Random;

/**
 * @author Alexey Levchhenko
 */
public class AppleSimpleFactory {
    Random rnd = new Random();

    public AppleItem CreateRandomPosApple(Size size) {
        AppleItem appleItem;
        com.levchenko.snake.Point position = new com.levchenko.snake.Point((rnd.nextInt(size.getWide() - 1)), (rnd.nextInt(size.getHigh() - 1)));
        appleItem = new AppleItem(position);

        return appleItem;
    }
}
