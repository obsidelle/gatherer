package ch.gatherer.game;

import java.awt.*;
import java.util.Random;

public class ItemRandomizer {
    private final Random rnd = new Random();
    private int nextSpawn;
    private int counter;


    public ItemRandomizer()
    {
        nextSpawn = rnd.nextInt(0 ,25);
        counter = 0;


    }

    public void update()
    {
        if( nextSpawn == counter)
        {
            //spawn
            nextSpawn = rnd.nextInt(0 ,25);
            counter = 0;
        }
        else
        {
            counter +=1;
        }
    }

    private void addItem()
    {
        Point pt = new Point(rnd.nextInt(0,800),rnd.nextInt(0,500));
    }

}
