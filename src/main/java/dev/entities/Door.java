package dev.entities;

import dev.controller.GameHandler;

public class Door extends Item {

    GameHandler gh;

    public Door(GameHandler gh){

        this.gh = gh;
        // try {
        //     image = ImageIO.read(getClass().getResourceAsStream("/images/player/walking/boy_up_1.png"));
        // } catch (IOException e) {
            
        // }
    }
    
}
