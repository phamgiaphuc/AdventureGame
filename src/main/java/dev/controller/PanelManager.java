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

    public BufferedImage heart_blank, heart_full, heart_half;

    public PanelManager(GameHandler gh){
        this.gh = gh;
        try{
            heart_blank = ImageIO.read(getClass().getResourceAsStream("../resources/images/heart/heart_blank.png"));
            heart_full = ImageIO.read(getClass().getResourceAsStream("../resources/images/heart/heart_full.png"));
            heart_half = ImageIO.read(getClass().getResourceAsStream("../resources/images/heart/heart_half.png"));

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    
    }
    public void draw(Graphics2D g2){
        if (gh.gameStatus == 1) {
            // game over
            g2.setFont(new Font("Comic Sans MS", Font.PLAIN, 65));
            g2.setPaint(new Color(102, 178, 255));
            g2.fillRect(0, 0, GameConstants.screenWidth, GameConstants.screenHeight);

            g2.setPaint(Color.black);
            g2.drawString("Game Over!", GameConstants.screenWidth / 2 - 179, 254);
            g2.setPaint(Color.white);
            g2.drawString("Game Over!", GameConstants.screenWidth / 2 - 175, 250);

            //g2.drawImage(img, GameConstants.screenWidth / 2 - 50, 300, null);

            g2.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
            g2.setPaint(Color.black);
            g2.drawString("Press Enter to restart", GameConstants.screenWidth / 2 - 166, 451);
            g2.setPaint(Color.white);
            g2.drawString("Press Enter to restart", GameConstants.screenWidth / 2 - 165, 450);

            g2.setPaint(Color.black);
            g2.drawString("Tip: Be careful while you are walking and", GameConstants.screenWidth / 2 - 306, 551);
            g2.setPaint(Color.white);
            g2.drawString("Tip: Be careful while you are walking and", GameConstants.screenWidth / 2 - 305, 550);

            g2.setPaint(Color.black);
            g2.drawString("try to keep an eye out on those bots!", GameConstants.screenWidth / 2 - 276, 601);
            g2.setPaint(Color.white);
            g2.drawString("try to keep an eye out on those bots!", GameConstants.screenWidth / 2 - 275, 600);
        } else if (gh.gameStatus == 3) {
            // menu
            g2.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
            g2.setPaint(new Color(102, 178, 255));
            g2.fillRect(0, 0, GameConstants.screenWidth, GameConstants.screenHeight);

            g2.setPaint(Color.black);
            g2.drawString("A Journey of Wild Ranger", GameConstants.screenWidth / 2 - 307, 152);
            g2.setPaint(Color.white);
            g2.drawString("A Journey of Wild Ranger", GameConstants.screenWidth / 2 - 305, 150);

            //g2.drawImage(img, GameConstants.screenWidth / 2 - 50, 300, null);

            g2.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
            g2.setPaint(Color.black);
            g2.drawString("Choose a name for your character", GameConstants.screenWidth / 2 - 256, 401);
            g2.setPaint(Color.white);
            g2.drawString("Choose a name for your character", GameConstants.screenWidth / 2 - 255, 400);

            g2.setPaint(Color.black);
            g2.drawString("Press Play to start the game!", GameConstants.screenWidth / 2 - 216, 551);
            g2.setPaint(Color.white);
            g2.drawString("Press Play to start the game!", GameConstants.screenWidth / 2 - 215, 550);
        }
    }
    public void drawPlayerLife(Graphics2D g2) {


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
            g2.drawImage(this.heart_full, x, y, null);
            i++;
            x += GameConstants.tileSize;
        }

        if (gh.player.total_lives % 2 == 1)
            g2.drawImage(this.heart_half, x, y, null);
    }
    
}
