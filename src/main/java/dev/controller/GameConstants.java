package dev.controller;

public interface GameConstants {
    int originalTileSize = 16;
    int scale = 3;
    public final int tileSize = originalTileSize * scale;
    int maxScreenCol = 25;
    int maxScreenRow = 21;
    int screenWidth = 17 * tileSize;
    int screenHeight = 17 * tileSize;
    public boolean collision = false;
}
