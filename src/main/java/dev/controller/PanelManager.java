package dev.controller;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
public class PanelManager {

    GameHandler gh;
    Graphics2D g2;

    BufferedImage heart_blank, heart_full, heart_half;

    public PanelManager(GameHandler gh){
        this.gh = gh;
    
    }
    
    public void draw(Graphics2D g2){
        g2.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
        g2.setPaint(new Color(64, 64, 64));
        g2.fillRect(0, 0, GameConstants.maxScreenCol, GameConstants.maxScreenRow);
        g2.setPaint(Color.white);
        g2.drawString("Game Over", 125, 150);
        g2.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        g2.drawString("Press Enter to restart", 100, 200);
        
    }
    public void drawPlayerLife() {
        try{
            heart_blank = ImageIO.read(getClass().getResourceAsStream("../resources/images/heart/heart_blank.png"));
            heart_full = ImageIO.read(getClass().getResourceAsStream("../resources/images/heart/heart_full.png"));
            heart_half = ImageIO.read(getClass().getResourceAsStream("../resources/images/heart/heart_half.png"));

        }catch(IOException e){

        }

        int x = GameConstants.tileSize / 2;
        int y = GameConstants.tileSize / 2;
        int i = 0;

        // Draw Blank Heart
        while (i < gh.player.max_total_lives / 2) {
            g2.drawImage(heart_blank, x, y, null);
            i++;
            x += GameConstants.tileSize;
        }

        x = GameConstants.tileSize / 2;
        i = 0;
        // Draw Full Heart
        while (i < gh.player.max_total_lives / 2) {
            g2.drawImage(heart_full, x, y, null);
            i++;
            x += GameConstants.tileSize;
        }

        if (gh.player.total_lives % 2 == 1) g2.drawImage(heart_half, x, y, null);
    }
    
}
