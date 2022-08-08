import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeField extends JPanel implements ActionListener {

    public static JFrame jFrame;
    public static final int SCALE = 32;
    public static final int WIDTH = 16;
    public static final int HEIGHT = 16;
    public static int speed = 10;
    Timer timer = new Timer(1000 / speed, this);

    Snake snake = new Snake(5, 6, 5, 5);
    Apple apple = new Apple(Math.abs((int) (Math.random() * SnakeField.WIDTH - 1)),
            Math.abs((int) (Math.random() * SnakeField.HEIGHT - 1)));

    public SnakeField() {
        timer.start();
        addKeyListener(new KeyBoard());
        setFocusable(true);
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
//
//        for (int x = 0; x < WIDTH * SCALE; x += SCALE) {
//            g.setColor(Color.white);
//            g.drawLine(x, 0, x, HEIGHT * SCALE);
//        }
//
//        for (int y = 0; y < HEIGHT * SCALE; y += SCALE) {
//            g.setColor(Color.white);
//            g.drawLine(0, y, WIDTH * SCALE, y);
//        }

        g.setColor(Color.red);
        g.fillOval(apple.posX * SCALE + 1, apple.posY * SCALE + 1, SCALE - 1, SCALE - 1);

        for (int i = 0; i < snake.length; i++) {

            g.setColor(Color.GREEN);
            g.fillRect(snake.sX[i] * SCALE, snake.sY[i] * SCALE, SCALE, SCALE);
        }

    }

    public static void main(String[] args) {
        jFrame = new JFrame("Snake Game");
        jFrame.add(new SnakeField());
        jFrame.setSize(WIDTH * SCALE + 1, HEIGHT * SCALE + 32);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        snake.move();
        if (snake.sX[0] == apple.posX && snake.sY[0] == apple.posY) {
            apple.setRandomPos();
            snake.length++;
        }
        repaint();
    }

    public class KeyBoard extends KeyAdapter {

        public void keyPressed (KeyEvent event) {
            int key = event.getKeyCode();

            if (key == KeyEvent.VK_UP) {
                snake.direction = 0;
            }

            if (key == KeyEvent.VK_DOWN) {
                snake.direction = 2;
            }

            if (key == KeyEvent.VK_LEFT) {
                snake.direction = 3;
            }

            if (key == KeyEvent.VK_RIGHT) {
                snake.direction = 1;
            }
        }
    }
}
