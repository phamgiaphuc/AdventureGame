package dev.entities;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import dev.controller.GameConstants;
import dev.controller.GameHandler;

public class Bullet {
    public int x;
    public int y;
    public int speed = 3;
    public int power;
    public boolean shot;
    GameHandler gh;

    int left, right, top, bot;

    //private int count = 0;
    public boolean status;
    public final String direction;
    private BufferedImage image;
    public Rectangle solidArea = new Rectangle(15, 15, 18, 18);
        
    public Bullet(int x, int y, String direction, GameHandler gh) {
        this.gh = gh;
        
        this.x = x;
        this.y = y;
        this.power = 2;
        this.direction = direction;
        this.status = false;
        this.shot = false;
        getBulletImage(direction);
    }
    private void getBulletImage(String direction) {
        switch (direction) {
            case "up" -> {
                try {
                    this.image = ImageIO.read(getClass().getResourceAsStream("../resources/images/player/bullet/bullet-up.png"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            case "down" -> {
                try {
                    this.image = ImageIO.read(getClass().getResourceAsStream("../resources//images/player/bullet/bullet-down.png"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            case "left" -> {
                try {
                    this.image = ImageIO.read(getClass().getResourceAsStream("../resources/images/player/bullet/bullet-left.png"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            case "right" -> {
                try {
                    this.image = ImageIO.read(getClass().getResourceAsStream("../resources/images/player/bullet/bullet-right.png"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void update() {

        if(gh.checker.checkSOLID(this) == false){
        if (direction.equals("up")) {
            this.y -= speed;
        }
        if (direction.equals("down")) {
            this.y += speed;
        }
        if (direction.equals("left")) {
            this.x -= speed;
        }
        if (direction.equals("right")) {
            this.x += speed;
        }
    }else
        status = true;


    }
	public int damage(Character[] entity){

		
		int pillar = 1000;


        // int solidX = this.x;
        // int solidY = this.y;

	for(int i = 0; i < entity.length; i++){


		if(entity[i] != null ){
            int hardX = this.solidArea.x;
            int hardY = this.solidArea.y;
            this.solidArea.x += this.x;
            this.solidArea.y += this.y;
            int solidX = entity[i].solidArea.x;
            int solidY = entity[i].solidArea.y;
            entity[i].solidArea.x += entity[i].getX();
            entity[i].solidArea.y += entity[i].getY();

				switch (this.direction) {
					case "up":

					this.y -= speed;
					if(this.solidArea.intersects(entity[i].solidArea) == true){
                            dead(entity[i]);
                            this.shot = true;

					}
					break;
					case "down":

					this.y += speed;
					if(this.solidArea.intersects(entity[i].solidArea) == true){
                            dead(entity[i]);
                        this.shot = true;

					}
					break;
					case "left":

					this.x -= speed;
					if(this.solidArea.intersects(entity[i].solidArea) == true){
                                dead(entity[i]);
                            this.shot = true;
					}
					break;
					case "right":

					this.x += speed;
					if(this.solidArea.intersects(entity[i].solidArea) == true){
                                dead(entity[i]);
                            this.shot = true;

					
					}
					break;
				}
            this.solidArea.x = hardX;
            this.solidArea.y = hardY;
            entity[i].solidArea.x = solidX;
            entity[i].solidArea.y = solidY;

			}



			}

		return pillar;

	}
    public void dead(Character entity){
    
    if(entity.total_lives > 0)
        entity.total_lives -= power;
    else
        entity.getDead(true);
    
    }
    public void draw(Graphics2D graphics2D) {
    //    if(gh.checker.checkSOLID(this) == false){
		int screenX = this.x - gh.player.getX() + gh.player.screenX;
		int screenY = this.y - gh.player.getY() + gh.player.screenY;
			
			if(gh.player.getX() + GameConstants.tileSize > gh.player.getX() - gh.player.screenX &&
					gh.player.getX() - GameConstants.tileSize < gh.player.getX() + gh.player.screenX &&
					gh.player.getY() + GameConstants.tileSize > gh.player.getY() - gh.player.screenY &&
					gh.player.getY() - GameConstants.tileSize < gh.player.getY() + gh.player.screenY
					)
                graphics2D.drawImage(image, screenX + this.solidArea.x, screenY + this.solidArea.y, null);
    //}
    }
}
