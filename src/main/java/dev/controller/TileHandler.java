package dev.controller;

import java.awt.Graphics2D;
import java.io.IOException;
import java.util.Objects;

import javax.imageio.ImageIO;

import dev.entities.GameConstants;
import dev.entities.Map;
import dev.entities.Tile;

public class TileHandler implements GameConstants {

    public Tile[] tile;
    public int[][] map;
    
    public TileHandler() {

        //int [][] map_1 = map.map_1;
        map =  Map.map_1;
        tile = new Tile[20];
        getTileImage();
        /*
        for (int i = 0; i < map.map_1.length; i++) {
            for (int j = 0; j < map.map_1[i].length; j++)
                System.out.printf("%d ", (tile[map.map_1[i][j]].collision) ? 1 : 0);
            System.out.println();
        }
        */
        

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
        int [][] map_1 = Map.map_1;
        for (int i = 0; i < map_1.length; i++) {
            for (int j = 0; j < map_1[i].length; j++) {
                graphics2D.drawImage(tile[map_1[i][j]].image, j * tileSize, i * tileSize, tileSize, tileSize, null);

            }
        }
    }
}
