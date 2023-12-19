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
                //player.setY(player.getY() - player.getSpeed());
            } else if (player_keyHandler.downPressed) {
                player.direction = "down";
                //player.setY(player.getY() + player.getSpeed());
            } else if (player_keyHandler.rightPressed) {
                player.direction = "right";
                //player.setX(player.getX() + player.getSpeed());
            } else if (player_keyHandler.leftPressed){
                player.direction = "left";
                //player.setX(player.getX() - player.getSpeed());
            }
            
            
            player.isCollide = false;
            gh.checker.checkTile(player);

            if(player.isCollide == false){
                switch (player.direction) {
                    case "up":
                        player.y_coordinate -= player.speed;
                        break;
                    case "down":
                        player.y_coordinate += player.speed;
                        break;
                    case "left":
                        player.x_coordinate -= player.speed;
                        break;
                    case "right":
                        player.x_coordinate += player.speed;
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
        graphics2D.setColor(Color.GREEN);
        graphics2D.fillRect(player.getX(), player.getY(), player.getWidth(), player.getHeight());
        graphics2D.drawImage(image, player.getX(), player.getY(), player.getWidth(), player.getHeight(), null);
        int labelWidth = graphics2D.getFontMetrics().stringWidth(player.getName());
        int labelX = player.getX() + (player.getWidth() / 2) - (labelWidth / 2);
        int labelY = player.getY() - 10;
        graphics2D.drawString(player.getName(), labelX, labelY);
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
