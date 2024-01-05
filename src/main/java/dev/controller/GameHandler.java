package dev.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import dev.entities.Character;
import dev.entities.Item;
import dev.entities.Player;

public class GameHandler extends JPanel implements Runnable, GameConstants {
    
Thread gameThread = null;

    public int gameStatus = 0;

    public KeyHandler keyHandler = new KeyHandler(this);

    public PanelManager panel = new PanelManager(this);
    //public Player player = new Player(((maxScreenCol - 1) / 2) * tileSize, ((maxScreenRow - 1) / 2) * tileSize, "Thien");
    
    public Player player = new Player(this, keyHandler, "Thien");
    
    //Manage the objects
    public EntityManager manager = new EntityManager(this);

    // NPC
    public Character bot[] = new Character[10];
    
    // Item
    public Item item[] = new Item[10];
    

    //public PlayerHandler playerHandler = new PlayerHandler(this, keyHandler, player);
    public TileHandler tileHandler = new TileHandler(this);

    public CollisionChecker checker = new CollisionChecker(this);


    public GameHandler() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void startGameThread() {
        if(this.gameStatus == 0){
        gameThread = new Thread(this);
        gameThread.start();

        // OBJECTS SETUP
        manager.setNPC(this);
        manager.setItem(this);
        }
    }
    // public void drawPlayerLife() {

    //     int x = gp.TileSize / 2;
    //     int y = gp.TileSize / 2;
    //     int i = 0;

    //     // Draw Blank Heart
    //     while (i < this.player.max_total_lives / 2) {
    //         g2.drawImage("heart_blank", x, y, null);
    //         i++;
    //         x += gp.TileSize;
    //     }

    //     x = gp.TileSize / 2;
    //     i = 0;
    //     // Draw Full Heart
    //     while (i < this.player.max_total_lives / 2) {
    //         g2.drawImage(heart_full, x, y, null);
    //         i++;
    //         x += gp.TileSize;
    //     }

    //     if (gp.player.life % 2 == 1) g2.drawImage(heart_half, x, y, null);
    // }

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
        //PLAYER

        player.update();

        //NPC
        for(int i = 0; i < bot.length; i++)
            if(bot[i] != null)
                bot[i].update();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;

        if(gameStatus == 0){
        // MAP
        tileHandler.draw(graphics2D);
        // NPC
        for(int i = 0; i < bot.length; i++)
            if(bot[i] != null)
                bot[i].draw(graphics2D);
        // Item

        for(int i = 0; i <item.length; i++)
            if(item[i] != null)
                item[i].draw(this, graphics2D);
        
        // PLAYER
        player.draw(graphics2D);
        }
        else if(gameStatus == 1)
            panel.draw(graphics2D);

        graphics2D.dispose();
    }
}
