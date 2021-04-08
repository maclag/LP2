package figures;

import java.awt.*;

public class Triangle extends Figure {

    public Triangle (int x, int y, int w, int h, Color background, Color outline) {
        super(x, y, w, h, background, outline);
    }

    public void print () {
        System.out.printf("Triangulo de tamanho (%d,%d) na posicao (%d, %d).\n",
                this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        int[] xp = new int[]{x, x - w, x + w};
        int[] yp = new int[]{y, y + h, y + h};

        Polygon TriangleObject = new Polygon(xp, yp, 3);

        g2d.setColor(this.background);
        g2d.fillPolygon(TriangleObject);

        g2d.setColor(this.outline);
        g2d.drawPolygon(TriangleObject);
    }
}
