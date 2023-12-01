import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

    public static int FPS = 60;

	KeyHandler keylistener = new KeyHandler();

    Thread game;
    public GamePanel(){
        this.setPreferredSize(new Dimension(500, 500));
		this.setBackground(Color.black);

		this.setDoubleBuffered(true);
		this.addKeyListener(keylistener);


        // RUNNING GAME
        game = new Thread(this);
        game.start();

    }

    @Override
	public void run(){
		
		// 10^9 = 1s
        double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime; 
		
		while(game != null) {
			
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime)/ drawInterval;
			
			lastTime = currentTime;
			
			if(delta >= 1) {
				 update();
				 repaint();
				 delta--;
			}
			
		}
	}

    public void update(){

    }

}
