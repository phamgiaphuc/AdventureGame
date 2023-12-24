package dev.controller;

import dev.entities.Bot;

public class EntityManager {
    
    GameHandler gh;

    public EntityManager(GameHandler gh){
        this.gh = gh;
        
    }

    public void setNPC(GameHandler gh){
        gh.bot[0] = new Bot(gh);
        gh.bot[0].setX(10);
        gh.bot[0].setY(10);


    }
    
}
