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
        gh.bot[0].setX(1 * GameConstants.tileSize);
        gh.bot[0].setY(8 * GameConstants.tileSize);
        gh.bot[0].direction = "right";
        // indidual index
        gh.bot[0].index = 0;
        // BOT REGION
        gh.bot[0].Regionx = 1;
        gh.bot[0].Regiony = 8;
        gh.bot[0].wid = 3;
        gh.bot[0].heig = 5;
        


        gh.bot[1] = new Bot(gh);
        gh.bot[1].setX(12 * GameConstants.tileSize);
        gh.bot[1].setY(1 * GameConstants.tileSize);
        gh.bot[1].direction = "left";

        gh.bot[1].index = 1;

        gh.bot[1].Regionx = 12;
        gh.bot[1].Regiony = 1;
        gh.bot[1].wid = 3;
        gh.bot[1].heig = 5;

    }

    public void setItem(GameHandler gh){
        gh.item[0] = new Door(gh);
        gh.item[0].WorldX = 12 * GameConstants.tileSize;
        gh.item[0].WorldY = 11 * GameConstants.tileSize;

    }
    
}
