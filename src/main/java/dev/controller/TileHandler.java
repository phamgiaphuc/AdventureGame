package dev.controller;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import dev.entities.Map;
import dev.entities.Tile;

public class TileHandler implements GameConstants {

    GameHandler gh;
    public Tile[] tile;
    public int[][] map;
    
    public TileHandler(GameHandler gh) {
        this.gh = gh;

        map =  Map.map_1;
        tile = new Tile[40];
        getTileImage();
        
    }

    public void getTileImage() {
        try {
            
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("../resources/images/tile/floor.png"));
            tile[0].collision = false;
            
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("../resources/images/tile/wall1.png"));
            tile[1].collision = true;
            
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("../resources/images/tile/wall2.png"));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("../resources/images/tile/box3.png"));
            tile[3].collision = true;

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("../resources/images/tile/barrier4.png"));
            tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("../resources/images/tile/barrier5.png"));
            tile[5].collision = true;

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("../resources/images/tile/titan6.png"));
            tile[6].collision = true;

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("../resources/images/tile/titan7.png"));
            tile[7].collision = true;

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("../resources/images/tile/titan8.png"));
            tile[8].collision = true;

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("../resources/images/tile/titan9.png"));
            tile[9].collision = true;

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("../resources/images/tile/titan10.png"));
            tile[10].collision = true;

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("../resources/images/tile/titan11.png"));
            tile[11].collision = true;

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("../resources/images/tile/titan12.png"));
            tile[12].collision = true;

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("../resources/images/tile/titan13.png"));
            tile[13].collision = true;

            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("../resources/images/tile/titan14.png"));
            tile[14].collision = true;

            tile[15] = new Tile();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("../resources/images/tile/titan15.png"));
            tile[15].collision = true;

            tile[16] = new Tile();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("../resources/images/tile/titan16.png"));
            tile[16].collision = true;

            tile[17] = new Tile();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("../resources/images/tile/titan17.png"));
            tile[17].collision = true;

            tile[18] = new Tile();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("../resources/images/tile/titan18.png"));
            tile[18].collision = true;

            tile[19] = new Tile();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("../resources/images/tile/titan19.png"));
            tile[19].collision = true;

            tile[20] = new Tile();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("../resources/images/tile/titan20.png"));
            tile[20].collision = true;

            tile[21] = new Tile();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream("../resources/images/tile/titan21.png"));
            tile[21].collision = true;

            tile[22] = new Tile();
            tile[22].image = ImageIO.read(getClass().getResourceAsStream("../resources/images/tile/titan22.png"));
            tile[22].collision = true;

            tile[23] = new Tile();
            tile[23].image = ImageIO.read(getClass().getResourceAsStream("../resources/images/tile/titan23.png"));
            tile[23].collision = true;

            tile[24] = new Tile();
            tile[24].image = ImageIO.read(getClass().getResourceAsStream("../resources/images/tile/titan24.png"));
            tile[24].collision = true;

            tile[25] = new Tile();
            tile[25].image = ImageIO.read(getClass().getResourceAsStream("../resources/images/tile/titan25.png"));
            tile[25].collision = true;

            tile[26] = new Tile();
            tile[26].image = ImageIO.read(getClass().getResourceAsStream("../resources/images/tile/titan26.png"));
            tile[26].collision = true;

            tile[27] = new Tile();
            tile[27].image = ImageIO.read(getClass().getResourceAsStream("../resources/images/tile/titan27.png"));
            tile[27].collision = true;

            tile[28] = new Tile();
            tile[28].image = ImageIO.read(getClass().getResourceAsStream("../resources/images/tile/titan28.png"));
            tile[28].collision = true;

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public void draw(Graphics2D graphics2D) {

        int col = 0;
		int row = 0;

		while (row < GameConstants.maxScreenRow && col < GameConstants.maxScreenCol) {

			int tileNum = map[col][row];

			int worldX = GameConstants.tileSize * col;
			int worldY = GameConstants.tileSize * row;

			int screenX = worldX - gh.player.getY() + gh.player.screenY;
			int screenY = worldY - gh.player.getX() + gh.player.screenX;

            if(worldX+ GameConstants.tileSize > gh.player.getY() - gh.player.screenY &&
			    worldX - GameConstants.tileSize < gh.player.getY() + gh.player.screenY &&
				worldY + GameConstants.tileSize > gh.player.getX() - gh.player.screenX &&
				worldY - GameConstants.tileSize < gh.player.getX() + gh.player.screenX
                )
            
			graphics2D.drawImage(tile[tileNum].image, screenY, screenX, GameConstants.tileSize, GameConstants.tileSize, null);

            row++;
			
			if(row == GameConstants.maxScreenRow ) {
				row = 0;
				col ++;
			}
		}

	}

    }

