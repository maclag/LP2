package figures;

import java.awt.*;

public class Pentagon {
    private int[] x, y;
    private Color background;
    private Color outline;

    public Pentagon (int[] x, int[] y, Color background, Color outline) {
        this.x = x;
        this.y = y;
        this.background = background;
        this.outline = outline;
    }

    public void print () {
        System.out.printf("Pentágono de vértices em (%d, %d), (%d, %d), (%d, %d), (%d, %d) e (%d, %d).\n",
                x[0], y[0], x[1], y[1], x[2], y[2], x[3], y[3], x[4], y[4]);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Polygon PentagonObject = new Polygon(this.x, this.y, 5);

        g2d.setColor(this.background);
        g2d.fillPolygon(PentagonObject);

        g2d.setColor(this.outline);
        g2d.drawPolygon(PentagonObject);
    }
}