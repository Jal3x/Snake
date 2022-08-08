public class Snake {

    public int length = 2;
    public int direction = 0;

    public int sX[] = new int[300];
    public int sY[] = new int[300];

    public Snake(int x1, int x2, int y1, int y2) {
        sX[0] = x1;
        sX[1] = x2;
        sY[0] = y1;
        sY[1] = y2;
    }

    public void move() {
        for (int i = length; i > 0; i--) {
            sX[i] = sX[i - 1];
            sY[i] = sY[i - 1];
        }

        if (direction == 0) {
            sY[0]--;
        }

        if (direction == 2) {
            sY[0]++;
        }

        if (direction == 1) {
            sX[0]++;
        }

        if (direction == 3) {
            sX[0]--;
        }

        if (sX[0] > SnakeField.WIDTH - 1) {
            sX[0] = 0;
        }

        if (sX[0] < 0) {
            sX[0] = SnakeField.WIDTH - 1;
        }

        if (sY[0] > SnakeField.HEIGHT - 1) {
            sY[0] = 0;
        }

        if (sY[0] < 0) {
            sY[0] = SnakeField.HEIGHT - 1;
        }
    }
}
