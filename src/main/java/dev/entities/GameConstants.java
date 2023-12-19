package dev.entities;

public interface GameConstants {
    int originalTileSize = 16;
    int scale = 3;
    int tileSize = originalTileSize * scale;
    int maxScreenCol = 25;
    int maxScreenRow = 25;
    int screenWidth = maxScreenCol * tileSize;
    int screenHeight = maxScreenRow * tileSize;
    public boolean collision = false;
}
