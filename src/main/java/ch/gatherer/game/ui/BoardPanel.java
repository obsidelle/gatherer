package ch.gatherer.game.ui;

import ch.gatherer.game.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BoardPanel extends JPanel implements ActionListener  {

    private Timer timer;
    private final Board board;

    public BoardPanel() {
        this.board = new Board();
        initPanel();
    }

    private void initPanel() {
        addKeyListener(new MultiKeyPressListener());
        setFocusable(true);
        setPreferredSize(new Dimension(board.getWidth(), board.getHeight()));
        timer = new Timer(25, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawRect(board.getPlayer().getX(),board.getPlayer().getY(),board.getPlayer().getSize(),board.getPlayer().getSize());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //board.updateBoard(1,1);
        repaint();
    }

    class MultiKeyPressListener implements KeyListener {
        // Set of currently pressed keys
        private final Set<Integer> pressedKeys = new HashSet<>();

        @Override
        public synchronized void keyPressed(KeyEvent e) {
            pressedKeys.add(e.getKeyCode());
            Point offset = new Point();
            if (!pressedKeys.isEmpty()) {
                for (Iterator<Integer> it = pressedKeys.iterator(); it.hasNext();) {
                    switch (it.next()) {
                        case KeyEvent.VK_W:
                        case KeyEvent.VK_UP:
                            offset.y = -1;
                            break;
                        case KeyEvent.VK_A:
                        case KeyEvent.VK_LEFT:
                            offset.x = -1;
                            break;
                        case KeyEvent.VK_S:
                        case KeyEvent.VK_DOWN:
                            offset.y = 1;
                            break;
                        case KeyEvent.VK_D:
                        case KeyEvent.VK_RIGHT:
                            offset.x = 1;
                            break;
                    }
                }
            }
            //System.out.println(offset); // Do something with the offset.
            board.updateBoard(offset.x*5,offset.y*5);
        }

        @Override
        public synchronized void keyReleased(KeyEvent e) {
            pressedKeys.remove(e.getKeyCode());
        }

        @Override
        public void keyTyped(KeyEvent e) { /* Not used */ }
    }
}
