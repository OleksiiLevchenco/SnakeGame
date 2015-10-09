package com.levchenko.snake;

/**
 * @author Alexey Levchhenko
 */
public class Point {

    private int x;
    private int y;
//    private Color color;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
//        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

//    public Color getColor() {
//        return color;
//    }
//
//    public void setColor(Color color) {
//        this.color = color;
//    }

    public boolean equals(Point p) {
        return this.getX() == p.getX() && this.getY() == p.getY();
    }
}
