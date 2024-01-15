package dev.entities;

import javax.imageio.ImageIO;

import dev.controller.GameHandler;

public class Key extends Item {
    GameHandler gh;
    public Key(GameHandler gh){
        this.gh = gh;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("../resources/images/heart/key.png"));
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
}
