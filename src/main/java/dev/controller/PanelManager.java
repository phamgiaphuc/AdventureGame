package dev.controller;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
public class PanelManager {

    GameHandler gh;

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
    
}
