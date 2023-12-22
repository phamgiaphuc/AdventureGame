package dev.entities;
import java.awt.Rectangle;

public class Player extends Character {
    private String name;
    private int level = 1;
    private int score = 0;
    private int energy = 0;
    private int gold = 0;
    private int shield = 0;
    private int bullet = 50;
    private int total_lives;
    private boolean isBulletEffect = false;
    private boolean isSpeedUp = false;
    private boolean isShieldExisted = false;

    

    public Player(int x_coordinate, int y_coordinate, String name) {

        super(x_coordinate, y_coordinate);
        this.name = name;
        speed = 3;
        solidArea = new Rectangle(8, 16, 32, 32);
		//solidArea.x = 8;
		//solidArea.y = 16;
		//solidArea.width = 32;
		//solidArea.height = 32;
    }

    public void setX(int x_new) {
        this.x_coordinate = x_new;
    }

    public int getX() {
        return this.x_coordinate;
    }

    public void setY(int y_new) {
        this.y_coordinate = y_new;
    }

    public int getY() {
        return this.y_coordinate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public int getBullet() {
        return bullet;
    }

    public void setBullet(int bullet) {
        this.bullet = bullet;
    }

    public int getTotal_lives() {
        return total_lives;
    }

    public void setTotal_lives(int total_lives) {
        this.total_lives = total_lives;
    }

    public boolean isBulletEffect() {
        return isBulletEffect;
    }

    public void setBulletEffect(boolean bulletEffect) {
        isBulletEffect = bulletEffect;
    }

    public boolean isSpeedUp() {
        return isSpeedUp;
    }

    public void setSpeedUp(boolean speedUp) {
        isSpeedUp = speedUp;
    }

    public boolean isShieldExisted() {
        return isShieldExisted;
    }

    public void setShieldExisted(boolean shieldExisted) {
        isShieldExisted = shieldExisted;
    }
}
