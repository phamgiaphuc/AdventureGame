package dev.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import dev.entities.Bot;
import dev.entities.GameConstants;
import dev.entities.Player;

public class GameHandler extends JPanel implements Runnable, GameConstants {

    Thread gameThread = null;

    public KeyHandler keyHandler = new KeyHandler();
    //public Player player = new Player(((maxScreenCol - 1) / 2) * tileSize, ((maxScreenRow - 1) / 2) * tileSize, "Thien");
    public Player player = new Player(this, "Thien");
    //Manage the objects
    public EntityManager manager = new EntityManager(this);

    // NPC
    public Bot bot[] = new Bot[10];
    

    public PlayerHandler playerHandler = new PlayerHandler(this, keyHandler, player);
    public TileHandler tileHandler = new TileHandler(this);

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
        // OBJECTS SETUP
        manager.setNPC(this);

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

        for(int i = 0; i < bot.length; i++)
            

        playerHandler.draw(graphics2D);
        
        graphics2D.dispose();
    }
}
