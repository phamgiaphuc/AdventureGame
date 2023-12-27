package dev.controller;

import dev.entities.Bot;

public class EntityManager {
    
    GameHandler gh;

    public EntityManager(GameHandler gh){
        this.gh = gh;
        
    }

    public void setNPC(GameHandler gh){
        gh.bot[0] = new Bot(gh);
        gh.bot[0].setX(9 * GameConstants.tileSize);
        gh.bot[0].setY(11 * GameConstants.tileSize);
        gh.bot[0].direction = "";

        gh.bot[1] = new Bot(gh);
        gh.bot[1].setX(10 * GameConstants.tileSize);
        gh.bot[1].setY(9 * GameConstants.tileSize);
        gh.bot[1].direction = "";

    }
    
}
