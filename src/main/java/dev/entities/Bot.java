package dev.entities;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import dev.controller.GameHandler;

public class Bot extends Character {
        BufferedImage bee1, bee2;

    public Bot(GameHandler gh){
        super(gh);
        direction = "down";
        speed = 7;

        try{
            bee1 = ImageIO.read(getClass().getResourceAsStream("/images/player/walking/boy_up_1.png"));
            bee2 = ImageIO.read(getClass().getResourceAsStream("/images/player/walking/boy_up_1.png"));
        }catch(IOException e){
            
        }
        
        //this.x_coordinate = x_coordinate;
        //this.y_coordinate = y_coordinate;
    }
    
}
