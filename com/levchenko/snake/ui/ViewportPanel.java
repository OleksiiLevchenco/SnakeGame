package com.levchenko.snake.ui;

import com.levchenko.snake.*;
import com.levchenko.snake.items.paintingScheme.PaintingScheme;
import com.levchenko.snake.items.Drawable;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * @author Alexey Levchhenko
 */
public class ViewportPanel extends JPanel {

    private Context gameContext;

    public Context getGameContext() {
        return gameContext;
    }

    public void setGameContext(Context gameContext) {
        this.gameContext = gameContext;
    }

    private LinkedList<Drawable> drawables = new LinkedList<Drawable>();

    public LinkedList<Drawable> getDrawables() {
        return drawables;
    }

    public ViewportPanel(Drawable... drawables){
        Collections.addAll(this.drawables, drawables);
    }

    public void clearDrawables() {
        drawables.clear();
    }

    private void paintDrawables(LinkedList<Drawable> drawables, Graphics2D g2d) {
        for (Drawable item : drawables) {
            Iterator iter = item.iterator();
            PaintingScheme scheme = item.getPaintingScheme();
            int index = 0;
            while (iter.hasNext()) {
                com.levchenko.snake.Point cell = (com.levchenko.snake.Point) iter.next();
                g2d.setColor(scheme.getColor(index++));
                feelCell(cell.getX(), cell.getY(), g2d);
            }
        }
    }

    public void addDrawables(Drawable... drawables){
        Collections.addAll(this.drawables,drawables);
    }

    private void feelCell(int indexX, int indexY, Graphics2D g2d) {
        int sizeH = gameContext.getFieldSize().getHigh();
        int sizeW = gameContext.getFieldSize().getWide();
        int x1 = Math.round((((float) getWidth()) / sizeW) * indexX);
        int y1 = Math.round((((float) getHeight()) / sizeH) * indexY);
        int w = Math.round((((float) getWidth()) / sizeW));
        int h = Math.round((((float) getHeight()) / sizeH));
        g2d.fillRect(x1, y1, w + 1, h + 1);
//        g2d.drawString(Integer.toString(indexX)+"  "+Integer.toString(indexY), x1, y1);
    }


    private void backGround(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());

    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        backGround(g2d);
        paintDrawables(drawables, g2d);

    }

    @Override
    public void repaint() {
        super.repaint();
    }
}
