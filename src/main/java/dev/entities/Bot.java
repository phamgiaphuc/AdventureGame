package dev.entities;

import java.io.IOException;

import javax.imageio.ImageIO;

import dev.controller.GameConstants;
import dev.controller.GameHandler;

public class Bot extends Character {
    int count = 0;

    int l[] = {0, 0, -1, 1};
    int r[] = {-1, 1, 0, 0};

    public Bot(GameHandler gh){
        super(gh);
        direction = "down";
        speed = 1;
        solidArea.x = 16;
        solidArea.y = 8;
        solidArea.width = 32;
        solidArea.height = 32;
        setImage();
        
        SolidX = 16;
        SolidY = 8;
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
    public void trespassing(){
        int x1 = this.Regionx * GameConstants.tileSize;
        int y1 = this.Regiony * GameConstants.tileSize;

        int x2 = this.Regionx * GameConstants.tileSize;
        int y2 = (this.Regiony + this.heig) * GameConstants.tileSize;

        int x3 = (this.Regionx +this.wid) * GameConstants.tileSize;
        int y3 = this.Regiony * GameConstants.tileSize;

        int x4 = (this.Regionx +this.wid) * GameConstants.tileSize;
        int y4 = (this.Regiony + this.heig) * GameConstants.tileSize;
        
        int X = this.getY();
        int Y = this.getX();
        // int X = gh.player.getY();
        // int Y = gh.player.getX();
        System.out.println("cor " + X/48 + " " + Y/48);
        System.out.println(x1/48 + " " + y1/48 + "     " + x2/48 + " " + y2/48);
        System.out.println(x3/48 + " " + y3/48 + "     " + x4/48 + " " + y4/48);

    }

    public void setAction(){

        // trespassing();
        //direction = "down";
        count ++;
        if(count <= 10)
        direction = "left";
        else if(count <= 20){
            
        } else if(count <= 40){
            direction = "right";
            
        }else if(count <= 80){
            direction = "up";
        }else if(count <= 160){
           direction = "down";
            count = 0;
        }

     }
    
    
}
