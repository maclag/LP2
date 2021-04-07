package figures;

import java.awt.*;

public class Triangle extends Figure {
    int[] xp, yp;

    public Triangle (int[] xp, int[] yp, Color background, Color outline) {
        this.xp = xp;
        this.yp = yp;
        this.background = background;
        this.outline = outline;
    }

    public void print () {
        System.out.printf("Triângulo de vértices em (%d, %d), (%d, %d) e (%d, %d).\n",
                xp[0], yp[0], xp[1], yp[1], xp[2], yp[2]);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Polygon TriangleObject = new Polygon(this.xp, this.yp, 3);

        g2d.setColor(this.background);
        g2d.fillPolygon(TriangleObject);

        g2d.setColor(this.outline);
        g2d.drawPolygon(TriangleObject);
    }
}