package dev.entities;

import java.io.IOException;

import javax.imageio.ImageIO;

import dev.controller.GameHandler;

public class Bot extends Character {
    int count = 0;
    public Bot(GameHandler gh){
        super(gh);
        direction = "down";
        speed = 1;
        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = 32;
        solidArea.height = 32;
        setImage();
        
        SolidX = 8;
        SolidX = 16;
        //this.x_coordinate = x_coordinate;
        //this.y_coordinate = y_coordinate;
    }

    public void setImage(){
                try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/images/player/walking/boy_up_1.png"));
            //up2 = ImageIO.read(getClass().getResourceAsStream("/images/player/walking/boy_up_1.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/images/player/walking/boy_up_1.png"));
            //down2 = ImageIO.read(getClass().getResourceAsStream("/images/player/walking/boy_up_1.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/images/player/walking/boy_up_1.png"));
            //left2 = ImageIO.read(getClass().getResourceAsStream("/images/player/walking/boy_up_1.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/images/player/walking/boy_up_1.png"));
            //right2 = ImageIO.read(getClass().getResourceAsStream("/images/player/walking/boy_up_1.png"));
        }catch(IOException e){
            
        }
    }
    public void setAction(){
        count ++;
        if(count <= 25)
        direction = "left";
        else if(count <= 75){
            
        } else if(count <= 150){
            direction = "right";
            
        }else if(count <= 300){
            direction = "up";
        }else if(count <= 600){
            direction = "down";
            count = 0;
        }

    }
    
    
}
