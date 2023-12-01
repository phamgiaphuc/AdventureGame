import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame app = new JFrame();

        app.setTitle("Advanture Game");
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        app.setResizable(false);
        app.setVisible(true);

        GamePanel game = new GamePanel();
        app.add(game);
        app.pack();
        


    }
}
