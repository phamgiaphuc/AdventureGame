package dev.controller;

import dev.entities.Character;

public class CollisionChecker {
    
    GameHandler gh;

    public CollisionChecker(GameHandler gh){
        this.gh = gh;
    }

    public void checkTile(Character character){
        // Check 2 corner toward the direction
        
		int LeftX = character.x_coordinate + character.solidArea.x;
		int RightX = character.x_coordinate +character.solidArea.x + character.solidArea.height;
		int TopY = character.y_coordinate + character.solidArea.y;
		int BottomY = character.y_coordinate + character.solidArea.y + character.solidArea.width;
/*        
        int LeftX = character.x_coordinate ;
		int RightX = character.x_coordinate  + character.solidArea.width;
		int TopY = character.y_coordinate ;
		int BottomY = character.y_coordinate + character.solidArea.height;
*/
		int LeftCol = LeftX /gh.tileSize;
		int RightCol = RightX /gh.tileSize;
		int TopRow = TopY /gh.tileSize;
		int BottomRow = BottomY /gh.tileSize;
		
		int tileNum1, tileNum2;
		
        System.out.println("cor: " +character.x_coordinate/48 + " " + character.y_coordinate/48) ;
        

		switch(character.direction) {
			case "up":
			TopRow = (TopY - character.speed)/gh.tileSize;
			tileNum1 = gh.tileHandler.map[TopRow][LeftCol];
			tileNum2 = gh.tileHandler.map[TopRow][RightCol];

				if(gh.tileHandler.tile[tileNum1].collision == true || gh.tileHandler.tile[tileNum2].collision == true )
					character.isCollide = true;
			break;
			case "down":
			BottomRow = (BottomY + character.speed)/gh.tileSize;
			tileNum1 = gh.tileHandler.map[BottomRow][LeftCol];
			tileNum2 = gh.tileHandler.map[BottomRow][RightCol];

				if(gh.tileHandler.tile[tileNum1].collision == true || gh.tileHandler.tile[tileNum2].collision == true )
				    character.isCollide = true;
			break;
			case "left":
			LeftCol = (LeftX - character.speed)/gh.tileSize;
			tileNum1 = gh.tileHandler.map[TopRow][LeftCol];
			tileNum2 = gh.tileHandler.map[BottomRow][LeftCol];
 
				if(gh.tileHandler.tile[tileNum1].collision == true || gh.tileHandler.tile[tileNum2].collision == true )
					character.isCollide = true;
			break;
			case "right":
			RightCol = (RightX + character.speed)/gh.tileSize;
			tileNum1 = gh.tileHandler.map[TopRow][RightCol];
			tileNum2 = gh.tileHandler.map[BottomRow][RightCol];

				if(gh.tileHandler.tile[tileNum1].collision == true || gh.tileHandler.tile[tileNum2].collision == true )
					character.isCollide = true;
			break;
			
		}
        
		//System.out.println(tileNum1 + "  " + tileNum2);

        /* 
        int left = character.x_coordinate;
        int right = character.x_coordinate;
        
        int top = character.y_coordinate;
        int bottom = character.y_coordinate;

        //int right = character.x_coordinate;
        //int bottom = character.y_coordinate;       


        // Upper-right and upper-left corner

        if (gh.keyHandler.upDirection == true) {
            left -= character.speed;
            right = left;
            //Offset 48px
            bottom = top + 48;
        }

        if (gh.keyHandler.downDirection == true) {
            left += character.speed + 48;
            right = left;
            bottom = top + 48;
        }

        if (gh.keyHandler.leftDirection == true) {
            top -= character.speed;
            bottom = top;
            right = left + 48;
        }

        if (gh.keyHandler.rightDirection == true) {
            top += character.speed + 48;
            bottom = top;
            right = left + 48;
        }
         left = left/ gh.tileSize;
         right = right/ gh.tileSize;
          top = top/ gh.tileSize;
         bottom = bottom/ gh.tileSize;
        
        int i, j;
        //int i = gh.tileHandler.map[left][top];
        //int j =  gh.tileHandler.map[right][bottom];
        
        //int z = gh.tileHandler.map[right][top];
        //int k = gh.tileHandler.map[right][bottom];
        
        //if (gh.tileHandler.tile[0].collision[nextX][nextY] == 'X' || board[nextX][nextY] == 'B')
        
        System.out.println(left + " " + top + " " + right + " " + bottom);
        
        switch (character.direction) {
            case "up":
                i = gh.tileHandler.map[left][top];
                j = gh.tileHandler.map[right][top];

                //System.out.println( character.x_coordinate + "  " + character.y_coordinate);
                System.out.println( 1);
                
                if(gh.tileHandler.tile[i].collision == true || gh.tileHandler.tile[j].collision == true)
                    character.isCollide = true;
                
                break;
            case "down":
                i = gh.tileHandler.map[left][bottom];
                j = gh.tileHandler.map[right][bottom];

                //System.out.println( character.x_coordinate + "  " + character.y_coordinate);
                System.out.println( 2);
                
                if(gh.tileHandler.tile[i].collision == true || gh.tileHandler.tile[j].collision == true)
                    character.isCollide = true;
                
                break;
            case "left":
                i = gh.tileHandler.map[left][top];
                j = gh.tileHandler.map[left][bottom];
                
                //System.out.println( character.x_coordinate + "  " + character.y_coordinate);
                System.out.println( 3);
                
                if(gh.tileHandler.tile[i].collision == true || gh.tileHandler.tile[j].collision == true)
                    character.isCollide = true;
                
                break;
            case "right":
                i = gh.tileHandler.map[right][top];
                j = gh.tileHandler.map[right][bottom];

                //System.out.println( character.x_coordinate + "  " + character.y_coordinate);
                System.out.println( 4);
                
                if(gh.tileHandler.tile[i].collision == true || gh.tileHandler.tile[j].collision == true)
                    character.isCollide = true;
                
                break;
        }
        
                //return true;
       //System.out.println(((GameConstants.maxScreenCol - 1) / 2) * GameConstants.tileSize);
       //System.out.println(((GameConstants.maxScreenRow - 1) / 2) * GameConstants.tileSize);

       //System.out.println(i + " " +j);
            // return false;
    */
    }

}
