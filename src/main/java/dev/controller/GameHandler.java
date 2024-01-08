package dev.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import dev.entities.Bullet;
import dev.entities.Character;
import dev.entities.Item;
import dev.entities.Player;

public class GameHandler extends JPanel implements Runnable, GameConstants {
    
Thread gameThread = null;

    public int gameStatus = 0;

    //public Bullet bulletList[] = new Bullet[20];
    public List<Bullet> bulletList = new ArrayList<Bullet>();

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

    public int quantity;
    

    //public PlayerHandler playerHandler = new PlayerHandler(this, keyHandler, player);
    public TileHandler tileHandler = new TileHandler(this);

    public CollisionChecker checker = new CollisionChecker(this);


    public GameHandler() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
        gameStatus = 3;
        quantity = 0;
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
        if(gameStatus != 3 || gameStatus != 5){
        //PLAYER
        player.update();

        //NPC
        
        int res = 0;
        for(int i = 0; i < bot.length; i++){
            
            if(bot[i] != null)
                if(bot[i].checkDead() != true){
                    bot[i].update();
                    res ++;
                }
                else{
                    bot[i] = null;
                    System.out.println("hello");
                }

            }
        
        // Bullet
        List<Bullet> tmp = new ArrayList<Bullet>();
        for (Bullet bullet : this.bulletList){
            //res ++;
            if(bullet.status != true && bullet.shot != true){
                bullet.update();
                bullet.damage(bot);
            }else
                tmp.add(bullet);
            }
            this.bulletList.removeAll(tmp);
            tmp.removeAll(tmp);
        

    //System.out.println(res);
    quantity = res;
    }
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;

        if(gameStatus == 2){
        // MAP
        tileHandler.draw(graphics2D);
        // LIFE
        panel.drawPlayerLife(graphics2D);
        // NPC
        for(int i = 0; i < bot.length; i++){
            //if(bot[i].isDead == true) bot[i] = null;
            if(bot[i] != null)
                bot[i].draw(graphics2D);
        }
        // Bullet
        for (Bullet bullet : this.bulletList)
            if(bullet.status != true || bullet.shot != true)
                bullet.draw(graphics2D);
            
        
        // Item
        for(int i = 0; i <item.length; i++)
            if(item[i] != null)
                item[i].draw(this, graphics2D);
        
        // PLAYER
        player.draw(graphics2D);
        }
        else
            panel.draw(graphics2D);

        graphics2D.dispose();
    }
}
