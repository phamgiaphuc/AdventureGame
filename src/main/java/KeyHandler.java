import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

boolean upDirection, downDirection, leftDirection, rightDirection;

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_W || key == KeyEvent.VK_UP) 
        upDirection = true;		
        
    if(key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN)
        downDirection = true;
        
    if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) 
        leftDirection = true;
        
    if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) 
        rightDirection = true;
                

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_W || key == KeyEvent.VK_UP) 
        upDirection = false;		
        
    if(key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN)
        downDirection = false;
        
    if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) 
        leftDirection = false;
        
    if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) 
        rightDirection = false;
                
    }

    

}
