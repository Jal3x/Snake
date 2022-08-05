import javax.swing.*;

public class SnakeField extends JPanel{

    public static JFrame jFrame;
    public static final int SCALE = 32;
    public static final int WIDTH = 16;
    public static final int HEIGHT = 16;

    public static void main(String[] args) {
        jFrame = new JFrame("Snake Game");
        jFrame.add(new SnakeField());
        jFrame.setSize(WIDTH * SCALE, HEIGHT * SCALE);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
