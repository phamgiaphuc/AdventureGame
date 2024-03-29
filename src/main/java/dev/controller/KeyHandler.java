package dev.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    GameHandler gh;
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    public int spaceCount = 0;
    public boolean upDirection, downDirection, leftDirection, rightDirection;
    @Override
    public void keyTyped(KeyEvent e) {
    }
    public KeyHandler(GameHandler gh){
        this.gh = gh;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_W) {
            upPressed = true;
            upDirection = true;
        }
        if (keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S) {
            downPressed = true;
            downDirection = true;
        }
        if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A) {
            leftPressed = true;
            leftDirection = true;
        }
        if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) {
            rightPressed = true;
            rightDirection = true;
        }
        if (keyCode == KeyEvent.VK_ENTER) {
            //rightPressed = true;
            //rightDirection = true;
            if(gh.gameStatus == 1)
                gh.gameStatus = 3 ;
            if(gh.gameStatus == 3)
                gh.gameStatus = 2;

        }
        if (keyCode == KeyEvent.VK_SPACE && spaceCount == 0) {
            spaceCount++;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_W) {
            upPressed = false;
            upDirection = false;
        }
        if (keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S) {
            downPressed = false;
            downDirection = false;
        }
        if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A) {
            leftPressed = false;
            leftDirection = false;
        }
        if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) {
            rightPressed = false;
            rightDirection = false;
        }
        if (keyCode == KeyEvent.VK_SPACE) {
            spaceCount = 0;
        }
    }
}
