package dev.entities;

import java.awt.Rectangle;

import dev.controller.GameHandler;

public class Character {
    private final int width = 48;
    private final int height = 48;
    protected int hp = 100;
    protected int x_coordinate;
    protected int y_coordinate;
    protected boolean isDead = false;
    protected boolean isCollide = false;
    protected int speed = 5;

    GameHandler gh;

    public String direction;
    //public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public Rectangle solidArea;
    //protected Direction direction = Direction.NONE;

    public Character(GameHandler gh) {
            this.gh = gh;
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
}
