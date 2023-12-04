package dev.entities;

public class Character {
    private final int width = 48;
    private final int height = 48;
    protected int hp = 100;
    protected int x_coordinate;
    protected int y_coordinate;
    protected boolean isDead = false;
    protected boolean isCollide = false;

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

    public void setCollide(boolean collide) {
        this.isCollide = collide;
    }
}
