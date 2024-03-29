package dev.controller;

import dev.entities.Bullet;
import dev.entities.Character;

public class CollisionChecker implements GameConstants {
    
    GameHandler gh;
    public int left;
    public int right;
    public int top;
    public int bot;



	Bullet bullet;
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
			//System.out.println(TopRow + " " + LeftCol + " " + TopRow + " " + RightCol);
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
	public int checkEntity(Character character, Character[] entity){

		
		int pillar = 1000;

		// character.solidArea.x += character.getX();
		// character.solidArea.y += character.getY();

		// gh.player.solidArea.x += gh.player.getX();
		// gh.player.solidArea.y += gh.player.getY();

		for(int i = 0; i < entity.length; i++){

			if(entity[i] != null && character.index != entity[i].index){
				//character.solidArea.x += character.getY();
				//character.solidArea.y += character.getX();
				character.setSolidAreaX( character.getX() + character.getSolidAreaX() );
				character.setSolidAreaY( character.getY() + character.getSolidAreaY() );

				//entity[i].solidArea.x += entity[i].getY();
				//entity[i].solidArea.y += entity[i].getX();
				entity[i].setSolidAreaX( entity[i].getX() + entity[i].getSolidAreaX() );
				entity[i].setSolidAreaY( entity[i].getY() + entity[i].getSolidAreaY() );

				switch (character.direction) {
					case "up":
					//character.setSolidAreaY( character.getSolidAreaX() - character.getSpeed());
					//character.solidArea.y -= character.getSpeed();
					character.setSolidAreaY( character.getSolidAreaY() - character.getSpeed());
					if(character.solidArea.intersects(entity[i].solidArea) == true){
							character.setCollide(true);
							pillar = i;
					}
					break;
					case "down":
					//character.setSolidAreaY( character.getSolidAreaX() - character.getSpeed());
					//character.solidArea.y += character.getSpeed();
					character.setSolidAreaY( character.getSolidAreaY() + character.getSpeed());
					if(character.solidArea.intersects(entity[i].solidArea) == true){
							character.setCollide(true);
							pillar = i;
					}
					break;
					case "left":
					//character.setSolidAreaY( character.getSolidAreaX() - character.getSpeed());
					//character.solidArea.x -= character.getSpeed();
					character.setSolidAreaX( character.getSolidAreaX() - character.getSpeed());
					if(character.solidArea.intersects(entity[i].solidArea) == true){
							character.setCollide(true);
							pillar = i;
					}
					break;
					case "right":
					//character.setSolidAreaY( character.getSolidAreaX() - character.getSpeed());
					//character.solidArea.x += character.getSpeed();
					character.setSolidAreaX( character.getSolidAreaX() + character.getSpeed());
					if(character.solidArea.intersects(entity[i].solidArea) == true){
							character.setCollide(true);
							pillar = i;
					
					}
					break;
				}
				//System.out.println("hello " +character.SolidX + " " + character.SolidY);
			
				character.setSolidAreaX(character.SolidX);
				character.setSolidAreaY(character.SolidY);
				entity[i].setSolidAreaX(entity[i].SolidX);
				entity[i].setSolidAreaY(entity[i].SolidY);
			}
				//character.solidArea.x = character.SolidX;
				//character.solidArea.y = character.SolidY;
				//entity[i].solidArea.x = entity[i].SolidX;
				//entity[i].solidArea.y = entity[i].SolidY;

			}

		return pillar;

	}
	public int checkItem(Character character, boolean player){

		
		int pillar = 1000;


		for(int i = 0; i < gh.item.length; i++){

			if(gh.item[i] != null){
				character.solidArea.x += character.getX();
				character.solidArea.y += character.getY();


				gh.item[i].solidArea.x += gh.item[i].WorldX;
				gh.item[i].solidArea.y += gh.item[i].WorldY;


				switch (character.direction) {
					case "up":

					character.setSolidAreaY( character.getSolidAreaY() - character.getSpeed());
					if(character.solidArea.intersects(gh.item[i].solidArea) == true){
						if(gh.item[i].isCollide == true)
							character.setCollide(true);
						if(player == true){
							pillar = i;

						}
					}
					break;
					case "down":

					character.setSolidAreaY( character.getSolidAreaY() + character.getSpeed());
					if(character.solidArea.intersects(gh.item[i].solidArea) == true){
						if(gh.item[i].isCollide == true)
							character.setCollide(true);
						if(player == true){
							pillar = i;

						}
					}
					break;
					case "left":

					character.setSolidAreaX( character.getSolidAreaX() - character.getSpeed());
					if(character.solidArea.intersects(gh.item[i].solidArea) == true){
						if(gh.item[i].isCollide == true)
							character.setCollide(true);
						if(player == true){
							pillar = i;

						}
					}
					break;
					case "right":

					character.setSolidAreaX( character.getSolidAreaX() + character.getSpeed());
					if(character.solidArea.intersects(gh.item[i].solidArea) == true){
						if(gh.item[i].isCollide == true)
							character.setCollide(true);
						if(player == true){
							pillar = i;
						}
					
					}
					break;
				}
			
				character.setSolidAreaX(character.SolidX);
				character.setSolidAreaY(character.SolidY);
				gh.item[i].solidArea.x = gh.item[i].SolidX;
				gh.item[i].solidArea.y = gh.item[i].SolidY;
			}


			}

		return pillar;

	}


	public void checkPlayer(Character entity){

		entity.setSolidAreaX( entity.getSolidAreaX() + entity.getX());

		entity.setSolidAreaY( entity.getSolidAreaY() + entity.getY());


		gh.player.setSolidAreaX( gh.player.getSolidAreaX() + gh.player.getX());

		gh.player.setSolidAreaY( gh.player.getSolidAreaY() + gh.player.getY());

		switch (entity.direction) {
					case "up":
					entity.setSolidAreaY( entity.getSolidAreaY() - entity.getSpeed() );
					if(entity.solidArea.intersects(gh.player.solidArea) == true){
							entity.setCollide(true);
							if(entity.available == true){
							gh.player.total_lives --;
							if(gh.player.total_lives <= 0){
								gh.gameThread = null;
								gh.gameStatus = 1;
								}
								entity.available = false;
							}
					break;
					}
					case "down":

					entity.setSolidAreaY( entity.getSolidAreaY() + entity.getSpeed() );
					if(entity.solidArea.intersects(gh.player.solidArea) == true){
							entity.setCollide(true);
							if(entity.available == true){
							gh.player.total_lives --;
							if(gh.player.total_lives <= 0){
								gh.gameThread = null;
								gh.gameStatus = 1;
								}
								entity.available = false;
							}
					break;
					}
					case "left":

					entity.setSolidAreaX( entity.getSolidAreaX() - entity.getSpeed() );
					if(entity.solidArea.intersects(gh.player.solidArea) == true){
							entity.setCollide(true);
							if(entity.available == true){
							gh.player.total_lives --;
							if(gh.player.total_lives <= 0){
								gh.gameThread = null;
								gh.gameStatus = 1;
								}
								entity.available = false;
							}
					break;
					}
					case "right":

					entity.setSolidAreaX( entity.getSolidAreaX() + entity.getSpeed() );
					if(entity.solidArea.intersects(gh.player.solidArea) == true){
							entity.setCollide(true);
							if(entity.available == true){
							gh.player.total_lives --;
							if(gh.player.total_lives <= 0){
								gh.gameThread = null;
								gh.gameStatus = 1;
								}
								entity.available = false;
							}
					break;
					}
				}

				entity.setSolidAreaX(entity.SolidX);
				entity.setSolidAreaY(entity.SolidY);
				gh.player.setSolidAreaX(gh.player.SolidX);
				gh.player.setSolidAreaY(gh.player.SolidY);


	}
	public boolean checkSOLID(Bullet bullet){
		int LeftX = bullet.x + bullet.solidArea.x;
		int RightX = bullet.x +bullet.solidArea.x + bullet.solidArea.width;
		int TopY = bullet.y + bullet.solidArea.y;
		int BottomY = bullet.y + bullet.solidArea.y + bullet.solidArea.height;

        left = LeftX;
        right = RightX;
        top = TopY;
        bot = BottomY;

		int LeftCol = LeftX / (tileSize);
		int RightCol = RightX / (tileSize);
		int TopRow = TopY / (tileSize);
		int BottomRow = BottomY / (tileSize);
		
		int tileNum1, tileNum2;

		switch(bullet.direction) {
			case "up":
			TopRow = (TopY - bullet.speed)/tileSize;
			tileNum1 = gh.tileHandler.map[TopRow][LeftCol];
			tileNum2 = gh.tileHandler.map[TopRow][RightCol];

				if(gh.tileHandler.tile[tileNum1].collision == true || gh.tileHandler.tile[tileNum2].collision == true ){
					bullet.power = 0;

					return true;
				}

			break;
			case "down":
			BottomRow = (BottomY + bullet.speed)/tileSize;
			tileNum1 = gh.tileHandler.map[BottomRow][LeftCol];
			tileNum2 = gh.tileHandler.map[BottomRow][RightCol];

				if(gh.tileHandler.tile[tileNum1].collision == true || gh.tileHandler.tile[tileNum2].collision == true ){
					bullet.power = 0;

					return true;

				}
			break;
			case "left":
			LeftCol = (LeftX - bullet.speed)/tileSize;
			tileNum1 = gh.tileHandler.map[TopRow][LeftCol];
			tileNum2 = gh.tileHandler.map[BottomRow][LeftCol];

				if(gh.tileHandler.tile[tileNum1].collision == true || gh.tileHandler.tile[tileNum2].collision == true ){
					return true;

				}
			break;
			case "right":
			RightCol = (RightX + bullet.speed)/tileSize;
			tileNum1 = gh.tileHandler.map[TopRow][RightCol];
			tileNum2 = gh.tileHandler.map[BottomRow][RightCol];

				if(gh.tileHandler.tile[tileNum1].collision == true || gh.tileHandler.tile[tileNum2].collision == true ){
					return true;
				}
			break;
			
		}
		return false;
	}

}
