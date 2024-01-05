package dev.entities;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Bullet {
    private int x;
    private int y;
    private final int speed = 3;
    private String direction;
    private BufferedImage image;
    public Bullet(int x, int y, String direction) {
        System.out.println("x: " + x);
        System.out.println("y: " + y);
        System.out.println("Direction: " + direction);
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.image = getBulletImage(direction);
    }

    private BufferedImage getBulletImage(String direction) {
        return switch (direction) {
            case "up" -> {
                try {
                    yield ImageIO.read(getClass().getResourceAsStream("/images/bullet/bullet-up.png"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            case "down" -> {
                try {
                    yield ImageIO.read(getClass().getResourceAsStream("/images/bullet/bullet-down.png"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            case "left" -> {
                try {
                    yield ImageIO.read(getClass().getResourceAsStream("/images/bullet/bullet-left.png"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            case "right" -> {
                try {
                    yield ImageIO.read(getClass().getResourceAsStream("/images/bullet/bullet-right.png"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            default -> null;
        };
    }

    public boolean update(Character bot) {
        boolean isHit = false;
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
        if (x == bot.getX() && y == bot.getY()) {
            System.out.println("x: " + x);
            System.out.println("y: " + y);
            System.out.println("bot x: " + bot.getX());
            System.out.println("bot y: " + bot.getY());
            System.out.println("Bullet hit");
            isHit = true;
        }
        return isHit;
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(image, x, y, null);
    }
}
