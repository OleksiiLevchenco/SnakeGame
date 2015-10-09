package com.levchenko.snake.items;

import com.levchenko.snake.items.paintingScheme.ApplePaintingScheme;
import com.levchenko.snake.items.paintingScheme.PaintingScheme;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Alexey Levchenko
 */
public class AppleList implements Drawable {

    private PaintingScheme scheme = new ApplePaintingScheme();
    private LinkedList<AppleItem> appleItems = new LinkedList<AppleItem>();

    public void add(AppleItem appleItem){
        this.appleItems.add(appleItem);
    }

    public AppleItem get(int i){
        return appleItems.get(i);
    }

    public void remove(int i){
        this.appleItems.remove(i);
    }

    public int size(){
        return appleItems.size();
    }

    @Override
    public PaintingScheme getPaintingScheme() {
        return scheme;
    }

    @Override
    public Iterator iterator(){return  new Iterator() {
        int pos = 0;

        @Override
        public boolean hasNext() {
            if(pos >= appleItems.size() || appleItems.get(pos)==null) {
                return false;
            }else {
                return true;
            }
        }

        @Override
        public Object next() {
            AppleItem appleItem = appleItems.get(pos);
            pos++;
            return  appleItem.getPosition();
        }
        };
    }

}
