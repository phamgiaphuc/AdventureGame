package dev.entities;

import javax.imageio.ImageIO;

import dev.controller.GameHandler;

public class HeartBoost extends Item {
    GameHandler gh;
    public HeartBoost(GameHandler gh){
        this.gh = gh;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("../resources/images/heart/heal.jpg"));
        } catch (Exception e) {
        }
    }

    
}
