public class Apple {
    public int posX;
    public int posY;

    public Apple(int x, int y) {
        posX = x;
        posX = y;
    }

    public void setRandomPos() {
        posX = Math.abs((int) (Math.random() * SnakeField.WIDTH - 1));
        posY = Math.abs((int) (Math.random() * SnakeField.HEIGHT - 1));
    }
}
