package dev.entities;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dev.controller.GameConstants;
import dev.controller.GameHandler;

public class Character {
    public final int width = 48;
    private final int height = 48;
    public int index;
    public int hp = 100;

        
    public int total_lives;
    public int max_total_lives;

    public boolean gun;

    public int x_coordinate;
    public int y_coordinate;

    //NPC ZONE
    public int Regionx;
    public int Regiony;
    public int wid;
    public int heig;
    // NPC TIME
    public boolean available;
    public int duration;

    private boolean isDead;
    public boolean isCollide = false;

    public int speed = 5;

    public int level;


    public BufferedImage up1, up2, up3, down1, down2, down3, left1, left2, left3, right1, right2, right3;

    GameHandler gh;

    public String direction;
    public Rectangle solidArea = new Rectangle(8, 16, 32, 32);

    public int SolidX, SolidY;

    public Character(GameHandler gh) {
            this.gh = gh;
            //this.max_total_lives = 1;
            //this.isDead = false;
    }
    public boolean checkDead(){
        return isDead;
    }
    public void getDead(boolean t){
        this.isDead = t;
    }
    public void setSolidAreaX(int x){
        this.solidArea.x = x;
    }
    public void setSolidAreaY(int y){
        this.solidArea.y = y;
    }
    public int getSolidAreaX(){
      return  this.solidArea.x;
    }
    public int getSolidAreaY(){
      return this.solidArea.y;
    }
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setCollide(boolean isCollide) {
        this.isCollide = isCollide;
    }
    public boolean getCollide() {
        return this.isCollide;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getX() {
        return this.x_coordinate;
    }

    public int getY() {
        return this.y_coordinate;
    }

    public void setX(int x_new) {
        this.x_coordinate = x_new;
    }
    public void setY(int y_new) {
        this.y_coordinate = y_new;
    }

    public void setAction(){


    }

    public void update(){
        setAction();

        isCollide = false;
        gh.checker.checkTile(this);

        gh.checker.checkEntity( this, gh.bot);
        
        gh.checker.checkPlayer(this);
        
    
        if(this.isCollide == false){
            switch (this.direction) {
                case "up": this.setY(y_coordinate - speed); break;
                case "down": this.setY(y_coordinate + speed); break;
                case "left": this.setX(x_coordinate - speed); break;
                case "right": this.setX(x_coordinate + speed); break;
            }
        }
    }
    
    public void draw(Graphics2D g2){
		BufferedImage image = null;
		int screenX = this.getX() - gh.player.getX() + gh.player.screenX;
		int screenY = this.getY() - gh.player.getY() + gh.player.screenY;
			
			if(gh.player.getX() + GameConstants.tileSize > gh.player.getX() - gh.player.screenX &&
					gh.player.getX() - GameConstants.tileSize < gh.player.getX() + gh.player.screenX &&
					gh.player.getY() + GameConstants.tileSize > gh.player.getY() - gh.player.screenY &&
					gh.player.getY() - GameConstants.tileSize < gh.player.getY() + gh.player.screenY
					){
						switch(direction) {
							case "up":
								image = up1;
								break;
							case "down":
								image = down1;
								break;
							case "left":
								image = left1;
								break;
							case "right":
								image = right1;
								break;
							}
			g2.drawImage(image, screenX, screenY, GameConstants.tileSize, GameConstants.tileSize, null);
			}

	}
}
