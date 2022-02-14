package ch.gatherer.game;

import ch.gatherer.game.ui.GameWindow;

import java.awt.*;

public class Main {

    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> {
            GameWindow ex = new GameWindow();
            ex.setVisible(true);
        });
    }


}
