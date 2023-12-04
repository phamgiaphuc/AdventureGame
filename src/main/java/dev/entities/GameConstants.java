package dev.entities;

public interface GameConstants {
    int originalTileSize = 16;
    int scale = 3;
    int tileSize = originalTileSize * scale;
    int maxScreenCol = 21;
    int maxScreenRow = 17;
    int screenWidth = maxScreenCol * tileSize;
    int screenHeight = maxScreenRow * tileSize;
}
