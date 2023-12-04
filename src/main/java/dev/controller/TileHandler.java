package dev.controller;

import dev.entities.GameConstants;
import dev.entities.Map;
import dev.entities.Tile;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.Objects;

public class TileHandler implements GameConstants {
    private final Tile[] tile = new Tile[20];
    private final Map map = new Map();
    public TileHandler() {
        getTileImage();
    }

    public void getTileImage() {
        try {
            tile[0] = new Tile(0);
            tile[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/tile/wall.png")));
            tile[1] = new Tile(1);
            tile[1].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/tile/road00.png")));
            tile[2] = new Tile(2);
            tile[2].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/tile/tree.png")));
            tile[3] = new Tile(3);
            tile[3].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/tile/grass00.png")));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public void draw(Graphics2D graphics2D) {
        int [][] map_1 = map.map_1;
        for (int i = 0; i < map_1.length; i++) {
            for (int j = 0; j < map_1[i].length; j++) {
                graphics2D.drawImage(tile[map_1[i][j]].image, j * tileSize, i * tileSize, tileSize, tileSize, null);
            }
        }
    }
}
