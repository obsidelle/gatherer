package ch.gatherer.game;

public class Board {
    private final int width = 800;
    private final int height = 500;
    private final Player player;

    public Board(){
    this.player = new Player();
    };

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Player getPlayer() {
        return player;
    }

    public void updateBoard(int playerX,int playerY){
        player.movePlayer(playerX,playerY);

    }
}
