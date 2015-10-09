package com.levchenko.snake.items.paintingScheme;

import java.awt.*;

/**
 * @author Alexey Levchhenko
 */
public class SnakePaintingScheme implements PaintingScheme {
    private Color headColor = new Color(100, 100, 5);
    private Color bodyColor = new Color(3, 100, 80);

    @Override
    public Color getColor(int i) {
        if (i <= 0) return headColor;
        if (i > 10) return Color.GRAY;
        else return bodyColor;
    }
}
