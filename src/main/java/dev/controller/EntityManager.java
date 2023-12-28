package dev.controller;

import dev.entities.Bot;
import dev.entities.Door;

public class EntityManager {
    
    GameHandler gh;

    public EntityManager(GameHandler gh){
        this.gh = gh;
    }

    public void setNPC(GameHandler gh){
        gh.bot[0] = new Bot(gh);
        gh.bot[0].setX(9 * GameConstants.tileSize);
        gh.bot[0].setY(9 * GameConstants.tileSize);
        gh.bot[0].direction = "right";
        gh.bot[0].index = 0;

        gh.bot[1] = new Bot(gh);
        gh.bot[1].setX(10 * GameConstants.tileSize);
        gh.bot[1].setY(9 * GameConstants.tileSize);
        gh.bot[1].direction = "left";
        gh.bot[1].index = 1;

    }

    public void setItem(GameHandler gh){
        gh.item[0] = new Door(gh);
        gh.item[0].WorldX = 2 * GameConstants.tileSize;
        gh.item[0].WorldY = 2 * GameConstants.tileSize;

    }
    
}