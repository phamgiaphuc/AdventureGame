package dev.entities;

import java.awt.Rectangle;

public class Character {
    private final int width = 48;
    private final int height = 48;
    protected int hp = 100;
    public int x_coordinate;
    public int y_coordinate;
    protected boolean isDead = false;
    public boolean isCollide = false;
    public int speed;

    public String direction;
    //public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public Rectangle solidArea  = new Rectangle(0, 0, 48, 48);
    //protected Direction direction = Direction.NONE;

    public Character(int x_coordinate, int y_coordinate) {
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
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

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        this.isDead = dead;
    }

    public boolean isCollide() {
        return isCollide;
    }

    
}
