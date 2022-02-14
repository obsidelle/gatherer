package ch.gatherer.game.ui;

import javax.swing.*;

public class GameWindow extends JFrame {

    public GameWindow()
    {
        initFrame();

    }

    private void initFrame(){
        add(new BoardPanel());
        setResizable(false);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
