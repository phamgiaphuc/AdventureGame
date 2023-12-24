package dev.entities;

public interface GameConstants {
    int originalTileSize = 16;
    int scale = 3;
    public final int tileSize = originalTileSize * scale;
    int maxScreenCol = 17;
    int maxScreenRow = 17;
    int screenWidth = maxScreenRow * tileSize;
    int screenHeight = maxScreenCol * tileSize;
    public boolean collision = false;
}
