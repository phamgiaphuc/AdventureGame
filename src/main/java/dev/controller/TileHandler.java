package dev.controller;

import java.awt.Graphics2D;
import java.io.IOException;
import java.util.Objects;

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
        tile = new Tile[20];
        getTileImage();

        

    }

    public void getTileImage() {
        try {
            
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/tile/wall.png")));
            tile[0].collision = true;
            
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/tile/road00.png")));
            tile[1].collision = false;
            
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/tile/tree.png")));
            tile[2].collision = true;
            
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/tile/grass00.png")));
            tile[3].collision = false;
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
            //graphics2D.drawImage(tile[tileNum].image, row * GameConstants.tileSize, col * GameConstants.tileSize, GameConstants.tileSize, GameConstants.tileSize, null);
			
            //graphics2D.drawImage(tile[tileNum].image, screenY, screenX, GameConstants.tileSize, GameConstants.tileSize, null);
			

            row++;
			
			if(row == GameConstants.maxScreenRow ) {
				row = 0;
				col ++;
			}
		}

	}

    }

