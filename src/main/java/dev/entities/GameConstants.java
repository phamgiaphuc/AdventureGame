package dev.entities;

public interface GameConstants {
    int originalTileSize = 16;
    int scale = 3;
    public final int tileSize = originalTileSize * scale;
    int maxScreenCol = 25;
    int maxScreenRow = 21;
    int screenWidth = 21 * tileSize;
    int screenHeight = 21 * tileSize;
    public boolean collision = false;
}
