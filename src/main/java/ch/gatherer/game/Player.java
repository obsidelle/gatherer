package ch.gatherer.game;

public class Player {


    private final int size = 10;
    private int x = 200;
    private int y = 200;


    public Player() {

    }


    public int getSize(){
        return size;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void movePlayer(int x , int y)
    {
        this.x+=x;
        this.y+=y;
    }
}
