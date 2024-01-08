package dev.controller;

import dev.entities.Bot;
import dev.entities.Door;
import dev.entities.Key;

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
        gh.bot[0].level = 3;
        // BOT REGION
        gh.bot[0].Regionx = 1;
        gh.bot[0].Regiony = 8;
        gh.bot[0].wid = 3;
        gh.bot[0].heig = 5;
        


        gh.bot[1] = new Bot(gh);
        gh.bot[1].setX(14 * GameConstants.tileSize);
        gh.bot[1].setY(4 * GameConstants.tileSize);
        gh.bot[1].direction = "left";

        gh.bot[1].index = 1;
        gh.bot[1].level = 3;

        gh.bot[1].Regionx = 12;
        gh.bot[1].Regiony = 1;
        gh.bot[1].wid = 3;
        gh.bot[1].heig = 5;

        gh.bot[2] = new Bot(gh);
        gh.bot[2].setX(18 * GameConstants.tileSize);
        gh.bot[2].setY(4 * GameConstants.tileSize);
        gh.bot[2].direction = "left";

        gh.bot[2].index = 2;
        gh.bot[2].level = 3;

        gh.bot[2].Regionx = 16;
        gh.bot[2].Regiony = 3;
        gh.bot[2].wid = 3;
        gh.bot[2].heig = 3;

        gh.bot[3] = new Bot(gh);
        gh.bot[3].setX(19 * GameConstants.tileSize);
        gh.bot[3].setY(17 * GameConstants.tileSize);
        gh.bot[3].direction = "left";

        gh.bot[3].index = 3;
        gh.bot[3].level = 3;

        gh.bot[3].Regionx = 17;
        gh.bot[3].Regiony = 15;
        gh.bot[3].wid = 3;
        gh.bot[3].heig = 3;

        gh.bot[4] = new Bot(gh);
        gh.bot[4].setX(20 * GameConstants.tileSize);
        gh.bot[4].setY(18 * GameConstants.tileSize);
        gh.bot[4].direction = "left";

        gh.bot[4].index = 4;
        gh.bot[4].level = 3;

        gh.bot[4].Regionx = 17;
        gh.bot[4].Regiony = 18;
        gh.bot[4].wid = 4;
        gh.bot[4].heig = 2;
        
        gh.bot[5] = new Bot(gh);
        gh.bot[5].setX(13 * GameConstants.tileSize);
        gh.bot[5].setY(12 * GameConstants.tileSize);
        gh.bot[5].direction = "up";

        gh.bot[5].index = 5;
        gh.bot[5].level = 2;

        gh.bot[6] = new Bot(gh);
        gh.bot[6].setX(15 * GameConstants.tileSize);
        gh.bot[6].setY(12 * GameConstants.tileSize);
        gh.bot[6].direction = "down";

        gh.bot[6].index = 6;
        gh.bot[6].level = 2;

        gh.bot[7] = new Bot(gh);
        gh.bot[7].setX(17 * GameConstants.tileSize);
        gh.bot[7].setY(12 * GameConstants.tileSize);
        gh.bot[7].direction = "up";

        gh.bot[7].index = 7;
        gh.bot[7].level = 2;

        gh.bot[8] = new Bot(gh);
        gh.bot[8].setX(13 * GameConstants.tileSize);
        gh.bot[8].setY(15 * GameConstants.tileSize);
        gh.bot[8].direction = "left";

        gh.bot[8].index = 8;
        gh.bot[8].level = 3;

        gh.bot[8].Regionx = 13;
        gh.bot[8].Regiony = 15;
        gh.bot[8].wid = 3;
        gh.bot[8].heig = 5;






    }

    public void setItem(GameHandler gh){
        gh.item[0] = new Door(gh);
        gh.item[0].WorldX = 2 * GameConstants.tileSize;
        gh.item[0].WorldY = 16 * GameConstants.tileSize;

        gh.item[1] = new Key(gh);
        gh.item[1].WorldX = 20 * GameConstants.tileSize;
        gh.item[1].WorldY = 19 * GameConstants.tileSize;

    }
    
}
