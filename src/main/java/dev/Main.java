package dev;


import javax.swing.JFrame;
import javax.swing.WindowConstants;

import dev.controller.GameHandler;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("A Journey Of Wild Ranger");
        GameHandler game = new GameHandler();
        frame.add(game);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        game.startGameThread();
    }
}