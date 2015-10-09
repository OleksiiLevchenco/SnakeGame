package com.levchenko.snake.items;


import com.levchenko.snake.items.paintingScheme.PaintingScheme;

/**
 * @author Alexey Levchhenko
 */
public interface Drawable extends Iterable {

    public PaintingScheme getPaintingScheme();

}
