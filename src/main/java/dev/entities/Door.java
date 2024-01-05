package dev.entities;

import java.io.IOException;

import javax.imageio.ImageIO;

import dev.controller.GameHandler;

public class Door extends Item {

    GameHandler gh;

    public Door(GameHandler gh){
        SolidX = this.solidArea.x;
        SolidY = this.solidArea.y;
        this.gh = gh;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("../resources/images/player/boy_up_1.png"));
        } catch (IOException e) {
            
        }
    }
    
}
