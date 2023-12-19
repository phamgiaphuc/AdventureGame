package dev.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import dev.entities.GameConstants;
import dev.entities.Player;

public class GameHandler extends JPanel implements Runnable, GameConstants {

    Thread gameThread = null;

    public KeyHandler keyHandler = new KeyHandler();
    //public Player player = new Player(((maxScreenCol - 1) / 2) * tileSize, ((maxScreenRow - 1) / 2) * tileSize, "Thien");
    public Player player = new Player(9 * tileSize, 9 * tileSize, "Thien");
    
    public PlayerHandler playerHandler = new PlayerHandler(this, keyHandler, player);
    public TileHandler tileHandler = new TileHandler();

    public CollisionChecker checker = new CollisionChecker(this);

    public GameHandler() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(playerHandler.player_keyHandler);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while (gameThread != null) {
            // update character's information
            update();
            // repaint character's position or effects
            repaint();
            // Thread
            try {
                Thread.sleep(11);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void update() {
        playerHandler.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        tileHandler.draw(graphics2D);
        playerHandler.draw(graphics2D);
        graphics2D.dispose();
    }
}
