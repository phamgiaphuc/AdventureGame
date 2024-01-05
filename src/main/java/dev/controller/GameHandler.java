package dev.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import dev.entities.Bot;
import dev.entities.Bullet;
import dev.entities.Character;
import dev.entities.Item;
import dev.entities.Player;

public class GameHandler extends JPanel implements Runnable, GameConstants {
    
Thread gameThread = null;

    public KeyHandler keyHandler = new KeyHandler();
    //public Player player = new Player(((maxScreenCol - 1) / 2) * tileSize, ((maxScreenRow - 1) / 2) * tileSize, "Thien");
    
    public Player player = new Player(this, keyHandler, "Thien");

    public List<Bullet> bulletList = new ArrayList<>();
    
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
        
        gameThread = new Thread(this);
        gameThread.start();

        // OBJECTS SETUP
        manager.setNPC(this);
        manager.setItem(this);

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
        //PLAYER

        player.update();

        //NPC
        for (Character character : bot) {
            if (character != null) {
                character.update();
            }
        }

        // Bullet
        for (Bullet bullet : this.bulletList) {
            for (Character bot: bot) {
                if (bot == null) continue;
                if(bullet.update(bot)) {
                    System.out.println("Bullet remove: " + bullet);
                    this.bulletList.remove(bullet);
                }
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        // MAP
        tileHandler.draw(graphics2D);
        // Bullet
        for (Bullet bullet : this.bulletList) {
            bullet.draw(graphics2D);
        }
        // NPC
        for(int i = 0; i < bot.length; i++)
            if(bot[i] != null)
                bot[i].draw(graphics2D);
        // Item
        /*
        for(int i = 0; i <item.length; i++)
            if(item[i] != null)
                item[i].draw(this, graphics2D);
        */
        // PLAYER
        //playerHandler.draw(graphics2D);
        player.draw(graphics2D);
        
        graphics2D.dispose();
    }
}
