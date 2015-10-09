package com.levchenko.snake.items;

import com.levchenko.snake.Point;
import com.levchenko.snake.items.paintingScheme.PaintingScheme;
import com.levchenko.snake.items.paintingScheme.SnakePaintingScheme;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Alexey Levchhenko
 */
public class SnakeItem implements Drawable {


    private PaintingScheme paintingScheme;

    public SnakeItem(int x, int y) {

        paintingScheme = new SnakePaintingScheme();

        this.body = new LinkedList<Point>();
        body.add(new Point(x, y));
        body.add(new Point(x, y + 1));
        body.add(new Point(x, y + 2));
        body.add(new Point(x, y + 3));
        body.add(new Point(x, y + 4));
        body.add(new Point(x, y + 5));
        body.add(new Point(x, y + 6));
        body.add(new Point(x, y + 7));
        body.add(new Point(x, y + 8));

    }

    private LinkedList<Point> body;

    public LinkedList<Point> getBody() {
        return body;
    }

    public Point getHead() {
        return body.getFirst();
    }

    public int getSize() {
        return body.size();
    }

    public void setBody(LinkedList<Point> body) {
        this.body = body;
    }


    @Override
    public Iterator iterator() {
        return body.iterator();
    }

    @Override
    public PaintingScheme getPaintingScheme() {
        return paintingScheme;
    }


//private class SnakeIterator implements Iterator{
//
//    SnakeItem snakeItem;
//    LinkedList body;
//    Iterator iterator;
//
//    public SnakeIterator(SnakeItem snakeItem) {
//        this.snakeItem = snakeItem;
//        body = snakeItem.getBody();
//    }
//
//    @Override
//    public boolean hasNext() {
//        return false;
//    }
//
//    @Override
//    public Object next() {
//        return null;
//    }
//
//    @Override
//    public void remove() {
//
//    }
//}
}


