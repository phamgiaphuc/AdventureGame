package dev.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import dev.controller.GameConstants;
import dev.controller.GameHandler;
import dev.controller.KeyHandler;

public class Player extends Character {
    KeyHandler keyH;
    //BufferedImage boy_up_1, boy_up_2, boy_down_1, boy_down_2, boy_right_1, boy_right_2, boy_left_1, boy_left_2;

    int spriteCounter = 0, spriteNum = 1;
    private String name;
    private int level = 1;
    private int score = 0;
    private int energy = 0;
    private int gold = 0;
    private int shield = 0;
    private int bullet = 50;
    private boolean isBulletEffect = false;
    private boolean isSpeedUp = false;
    private boolean isShieldExisted = false;

    public final int screenX;
    public final int screenY;


    public Player(GameHandler gh, KeyHandler keyH, String name) {

        super(gh);

        this.keyH = keyH;

        this.screenX = GameConstants.screenHeight / 2 - (GameConstants.tileSize / 2);
        this.screenY = GameConstants.screenWidth / 2 - (GameConstants.tileSize / 2);

        this.max_total_lives = 6;
        this.x_coordinate = 2 * GameConstants.tileSize;
        this.y_coordinate = 4 * GameConstants.tileSize;
        this.total_lives = this.max_total_lives;

        this.name = name;
        speed = 2;
        solidArea = new Rectangle(8, 16, 32, 32);
        SolidX = this.solidArea.x;
        SolidY = this.solidArea.y;
        this.direction = "down";
        this.index = -1;
        getPlayerImage();


    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("../resources/images/player/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("../resources/images/player/boy_up_2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("../resources/images/player/boy_up_3.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("../resources/images/player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("../resources/images/player/boy_down_2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("../resources/images/player/boy_down_3.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("../resources/images/player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("../resources/images/player/boy_right_2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("../resources/images/player/boy_right_3.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("../resources/images/player/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("../resources/images/player/boy_left_2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("../resources/images/player/boy_left_3.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update() {
        if (keyH.upPressed == true || keyH.downPressed == true ||
                keyH.leftPressed == true || keyH.rightPressed == true) {
            if (keyH.upPressed == true) {
                direction = "up";
            } else if (keyH.downPressed == true) {
                direction = "down";
            } else if (keyH.leftPressed == true) {
                direction = "left";
            } else if (keyH.rightPressed == true) {
                direction = "right";
            }

            this.setCollide(false);
            gh.checker.checkTile(this);

            int indexItem = gh.checker.checkItem(this, true);

            int indexEntity = gh.checker.checkEntity(this, gh.bot);
            //System.out.println(indexEntity + indexItem + "example");

            if (this.getCollide() == false) {
                switch (direction) {
                    case "up":
                        this.setY(this.getY() - this.getSpeed());
                        break;
                    case "down":
                        this.setY(this.getY() + this.getSpeed());
                        break;
                    case "left":
                        this.setX(this.getX() - this.getSpeed());
                        break;
                    case "right":
                        this.setX(this.getX() + this.getSpeed());
                        break;

                }
            }
            spriteCounter++;
            //if (spriteCounter > 15) {
            // spriteNum = (spriteNum == 1) ? 2 : 1;
            // spriteCounter = 0;
            if (spriteCounter >= 0 && spriteCounter <= 6) {
                spriteNum = 1;
            } else if (spriteCounter > 6 && spriteCounter <= 10) {
                spriteNum = 2;
            } else if (spriteCounter > 10 && spriteCounter <= 16) {
                spriteNum = 3;
            } else {
                spriteCounter = 0;
            }
            //}
        }
        if (keyH.spaceCount == 1) {
            keyH.spaceCount = 0;
            gh.bulletList.add(new Bullet((this.getX()) , (this.getY()), direction,gh));
        }
    }

    public void draw(Graphics2D graphics2D) {

        BufferedImage image = null;
        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                if (spriteNum == 3) {
                    image = up3;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                if (spriteNum == 3) {
                    image = down3;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                if (spriteNum == 3) {
                    image = left3;
                }

                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                if (spriteNum == 3) {
                    image = right3;
                }
                break;

        }
        //g2.drawImage(image, screenX, screenY, null);
        graphics2D.drawImage(image, screenY, screenX, this.getWidth(), this.getHeight(), null);
        graphics2D.setColor(Color.RED);
        graphics2D.drawRect(screenY + 8, screenX + 16, 32, 32);
        //graphics2D.drawRect(screenY, screenX, 48, 48);

        int labelWidth = graphics2D.getFontMetrics().stringWidth(this.getName());
        int labelX = screenY + (this.getWidth() / 2) - (labelWidth / 2);
        int labelY = screenX - 10;
        graphics2D.drawString(this.getName(), labelX, labelY);


    }


    public int getX() {
        return this.x_coordinate;
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
