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

    // 1 GAME OVER
    // 3 WIN
    //5 MENU
    private int count =0;
    public BufferedImage heart_blank, heart_full, heart_half;
    public BufferedImage player_image;

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
            g2.setPaint(new Color(160, 160, 160));
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
            //PLAYER IMAGE
            count ++;
            try {
                if(count >= 0 && count <= 15)
                    player_image = ImageIO.read(getClass().getResourceAsStream("../resources/images/player/boy_left_1.png"));
                if(count > 15 && count <= 30)
                    player_image = ImageIO.read(getClass().getResourceAsStream("../resources/images/player/boy_down_1.png"));
                if(count > 30 && count <= 45)
                    player_image = ImageIO.read(getClass().getResourceAsStream("../resources/images/player/boy_right_1.png"));
                if(count > 45 && count <= 60)
                    player_image = ImageIO.read(getClass().getResourceAsStream("../resources/images/player/boy_up_1.png"));
                
            } catch (IOException e) {
            }
            count = (count == 60) ? 0 : count;
            // menu
            g2.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
            g2.setPaint(new Color(160, 160, 160));
            g2.fillRect(0, 0, GameConstants.screenWidth, GameConstants.screenHeight);

            g2.setPaint(Color.black);
            g2.drawString("A Journey of Wild Ranger", GameConstants.screenWidth / 2 - 307, 152);
            g2.setPaint(Color.white);
            g2.drawString("A Journey of Wild Ranger", GameConstants.screenWidth / 2 - 305, 150);

            g2.drawImage(gh.player.down1, 4* GameConstants.tileSize, 3 * GameConstants.tileSize, (9 * GameConstants.tileSize), 7 *GameConstants.tileSize, null);
            

            //g2.drawImage(img, GameConstants.screenWidth / 2 - 50, 300, null);

            g2.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
            g2.setPaint(Color.black);
            /*
            g2.drawString("Choose a name for your character", GameConstants.screenWidth / 2 - 256, 401);
            g2.setPaint(Color.white);
            g2.drawString("Choose a name for your character", GameConstants.screenWidth / 2 - 255, 400);
            */

            g2.setPaint(Color.black);
            g2.drawString("Press Play to start the game!", GameConstants.screenWidth / 2 - 216, 551);
            g2.setPaint(Color.white);
            g2.drawString("Press Play to start the game!", GameConstants.screenWidth / 2 - 215, 550);
        } else if (gh.gameStatus == 5) {
            // win
            g2.setFont(new Font("Comic Sans MS", Font.PLAIN, 65));
            g2.setPaint(new Color(102, 255, 102));
            g2.fillRect(0, 0, GameConstants.screenWidth, GameConstants.screenHeight);

            g2.setPaint(Color.black);
            g2.drawString("You Win!", GameConstants.screenWidth / 2 - 129, 254);
            g2.setPaint(Color.white);
            g2.drawString("You Win!", GameConstants.screenWidth / 2 - 125, 250);

            g2.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
            g2.setPaint(Color.black);
            g2.drawString("Restart a new game?", GameConstants.screenWidth / 2 - 157, 452);
            g2.setPaint(Color.white);
            g2.drawString("Restart a new game?", GameConstants.screenWidth / 2 - 155, 450);
            g2.drawImage(player_image, 4* GameConstants.tileSize, 3 * GameConstants.tileSize, (9 * GameConstants.tileSize), 7 *GameConstants.tileSize, null);
            
        }

    }
    public void drawPlayerLife(Graphics2D g2) {


        int x = GameConstants.tileSize / 2;
        int y = GameConstants.tileSize / 2;
        int i = 0;

        // Draw Blank Heart
        while (i < gh.player.max_total_lives / 2) {
            
            g2.drawImage(heart_blank, x, y, GameConstants.tileSize, GameConstants.tileSize, null);
            i++;
            x += GameConstants.tileSize;
        }

        x = GameConstants.tileSize / 2;
        i = 0;
        // Draw Full Heart
        while (i < gh.player.total_lives / 2) {
            
            g2.drawImage(this.heart_full, x, y, GameConstants.tileSize, GameConstants.tileSize, null);
            i++;
            x += GameConstants.tileSize;
        }

        if (gh.player.total_lives % 2 == 1)
            
            g2.drawImage(this.heart_half, x, y, GameConstants.tileSize, GameConstants.tileSize, null);
    }
    
}
