package figures;

import java.awt.*;

public class Pentagon {
    private int[] x, y;

    public Pentagon (int[] x, int[] y) {
        this.x = x;
        this.y = y;
    }

    public void print () {
        System.out.printf("Pentágono de vértices em (%d, %d), (%d, %d), (%d, %d), (%d, %d) e (%d, %d).\n",
                x[0], y[0], x[1], y[1], x[2], y[2], x[3], y[3], x[4], y[4]);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Polygon PentagonObject = new Polygon(this.x, this.y, 5);

        g2d.drawPolygon(PentagonObject);
    }
}
