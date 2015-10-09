package com.levchenko.snake;

/**
 * @author Alexey Levchhenko
 */
public class Size {
    private int wide;
    private int high;

    public Size(int wide, int high) {
        this.wide = wide;
        this.high = high;
    }

    public Size() {

    }

    public int getWide() {
        return wide;
    }

    public void setWide(int wide) {
        this.wide = wide;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }
}
