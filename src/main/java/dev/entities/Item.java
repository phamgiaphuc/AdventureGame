package dev.entities;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dev.controller.GameConstants;
import dev.controller.GameHandler;

public class Item {
    public int WorldX;
    public int WorldY;
    public BufferedImage image;
	public boolean isCollide = true;
	public Rectangle solidArea = new Rectangle(0, 0, 48, 48);

	public int SolidX, SolidY;

    public void draw(GameHandler gh,Graphics2D g2){
		int screenX = WorldX - gh.player.getX() + gh.player.screenX;
		int screenY = WorldY - gh.player.getY() + gh.player.screenY;
			
			if(gh.player.getX() + GameConstants.tileSize > gh.player.getX() - gh.player.screenX &&
					gh.player.getX() - GameConstants.tileSize < gh.player.getX() + gh.player.screenX &&
					gh.player.getY() + GameConstants.tileSize > gh.player.getY() - gh.player.screenY &&
					gh.player.getY() - GameConstants.tileSize < gh.player.getY() + gh.player.screenY
					)
				g2.drawImage(image, screenX, screenY, GameConstants.tileSize, GameConstants.tileSize, null);
			
    }
    
}
