package dev.controller;

import dev.entities.Character;
import dev.entities.GameConstants;

public class CollisionChecker implements GameConstants {
    
    GameHandler gh;
    public int left;
    public int right;
    public int top;
    public int bot;
    public CollisionChecker(GameHandler gh){
        this.gh = gh;
    }

    public void checkTile(Character character){
        
		int LeftX = character.getX() + character.solidArea.x;
		int RightX = character.getX() +character.solidArea.x + character.solidArea.width;
		int TopY = character.getY() + character.solidArea.y;
		int BottomY = character.getY() + character.solidArea.y + character.solidArea.height;
        
        left = LeftX;
        right = RightX;
        top = TopY;
        bot = BottomY;

        /*
		int LeftX = character.getX() + character.solidArea.x;
		int RightX = character.getX() +character.solidArea.x  + character.solidArea.width;
		int TopY = character.getY() + character.solidArea.y;
		int BottomY = character.getY() + character.solidArea.y + character.solidArea.width;
*/
		int LeftCol = LeftX / (tileSize);
		int RightCol = RightX / (tileSize);
		int TopRow = TopY / (tileSize);
		int BottomRow = BottomY / (tileSize);
		
		int tileNum1, tileNum2;
		
        //System.out.println("cor: " +character.getX()/48 + " " + character.getY()/48) ;
        

		switch(character.direction) {
			case "up":
			TopRow = (TopY - character.getSpeed())/tileSize;
			tileNum1 = gh.tileHandler.map[TopRow][LeftCol];
			tileNum2 = gh.tileHandler.map[TopRow][RightCol];
			System.out.println(TopRow + " " + LeftCol + " " + TopRow + " " + RightCol);
				if(gh.tileHandler.tile[tileNum1].collision == true || gh.tileHandler.tile[tileNum2].collision == true )
					character.setCollide(true);
			break;
			case "down":
			BottomRow = (BottomY + character.getSpeed())/tileSize;
			tileNum1 = gh.tileHandler.map[BottomRow][LeftCol];
			tileNum2 = gh.tileHandler.map[BottomRow][RightCol];

				if(gh.tileHandler.tile[tileNum1].collision == true || gh.tileHandler.tile[tileNum2].collision == true )
				    character.setCollide(true);
			break;
			case "left":
			LeftCol = (LeftX - character.getSpeed())/tileSize;
			tileNum1 = gh.tileHandler.map[TopRow][LeftCol];
			tileNum2 = gh.tileHandler.map[BottomRow][LeftCol];

				if(gh.tileHandler.tile[tileNum1].collision == true || gh.tileHandler.tile[tileNum2].collision == true )
					character.setCollide(true);
			break;
			case "right":
			RightCol = (RightX + character.getSpeed())/tileSize;
			tileNum1 = gh.tileHandler.map[TopRow][RightCol];
			tileNum2 = gh.tileHandler.map[BottomRow][RightCol];

				if(gh.tileHandler.tile[tileNum1].collision == true || gh.tileHandler.tile[tileNum2].collision == true )
					character.setCollide(true);
			break;
			
		}

    }

}
