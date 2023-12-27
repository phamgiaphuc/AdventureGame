package dev.controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import dev.entities.Player;

public class PlayerHandler {
    BufferedImage boy_up_1, boy_up_2, boy_down_1, boy_down_2, boy_right_1, boy_right_2, boy_left_1, boy_left_2;
    GameHandler gh;
    int spriteCounter = 0, spriteNum = 1;
    KeyHandler player_keyHandler;
    Player player;

    public PlayerHandler (GameHandler gh,KeyHandler player_keyHandler, Player player) {
        this.gh = gh;
        this.player_keyHandler = player_keyHandler;
        this.player = player;
        getPlayerImage();
        player.direction = "down";
    }

    public void update() {
       
        if (player_keyHandler.upPressed || player_keyHandler.downPressed || player_keyHandler.leftPressed || player_keyHandler.rightPressed) {
            if (player_keyHandler.upPressed) {
                player.direction = "up";

            }
            if (player_keyHandler.downPressed) {
                player.direction = "down";

            }
            if (player_keyHandler.rightPressed) {
                player.direction = "right";

            }
            if (player_keyHandler.leftPressed){
                player.direction = "left";
            }
            
            // CHECK TILE COLLISION
            player.setCollide(false);
            gh.checker.checkTile(player);

            // CHECK BOT COLLISION
            int botIndex = gh.checker.checkEntity(player, gh.bot);
            

            if(player.getCollide() == false){
                switch (player.direction) {
                    case "up":
                        player.setY(player.getY() - player.getSpeed());
                        break;
                    case "down":
                        player.setY(player.getY() + player.getSpeed());
                        break;
                    case "left":
                        player.setX(player.getX() - player.getSpeed());
                        break;
                    case "right":
                        player.setX(player.getX() + player.getSpeed());
                        break;
                    }
            }

            spriteCounter++;
            if (spriteCounter > 15) {
                spriteNum = (spriteNum == 1) ? 2 : 1;
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D graphics2D) {
        BufferedImage image = null;
        int screenX = gh.player.screenX;
		int screenY = gh.player.screenY;
			
		if(player.getX() + GameConstants.tileSize > gh.player.getX() - gh.player.screenX &&
		   player.getX() - GameConstants.tileSize < gh.player.getX() + gh.player.screenX &&
		   player.getY() + GameConstants.tileSize > gh.player.getY() - gh.player.screenY &&
		   player.getY() - GameConstants.tileSize < gh.player.getY() + gh.player.screenY
					){
        switch (player.direction) {
            case "up":
                if (spriteNum == 1) {
                    image = boy_up_1;
                }
                if (spriteNum == 2) {
                    image = boy_up_2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = boy_down_1;
                }
                if (spriteNum == 2) {
                    image = boy_down_2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = boy_left_1;
                }
                if (spriteNum == 2) {
                    image = boy_left_2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = boy_right_1;
                }
                if (spriteNum == 2) {
                    image = boy_right_2;
                }
                break;
        }

        graphics2D.drawImage(image, screenY, screenX, player.getWidth(), player.getHeight(), null);
        graphics2D.setColor(Color.RED);
        graphics2D.drawRect(screenY + player.solidArea.x, screenX + player.solidArea.y, 32, 32);

        int labelWidth = graphics2D.getFontMetrics().stringWidth(player.getName());
        int labelX = screenY + (player.getWidth() / 2) - (labelWidth / 2);
        int labelY = screenX - 10;
        graphics2D.drawString(player.getName(), labelX, labelY);
    }
    }

    public void getPlayerImage() {
        try {
            boy_up_1 = ImageIO.read(getClass().getResourceAsStream("/images/player/walking/boy_up_1.png"));
            boy_up_2 = ImageIO.read(getClass().getResourceAsStream("/images/player/walking/boy_up_2.png"));
            boy_down_1 = ImageIO.read(getClass().getResourceAsStream("/images/player/walking/boy_down_1.png"));
            boy_down_2 = ImageIO.read(getClass().getResourceAsStream("/images/player/walking/boy_down_2.png"));
            boy_right_1 = ImageIO.read(getClass().getResourceAsStream("/images/player/walking/boy_right_1.png"));
            boy_right_2 = ImageIO.read(getClass().getResourceAsStream("/images/player/walking/boy_right_2.png"));
            boy_left_1 = ImageIO.read(getClass().getResourceAsStream("/images/player/walking/boy_left_1.png"));
            boy_left_2 = ImageIO.read(getClass().getResourceAsStream("/images/player/walking/boy_left_2.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
