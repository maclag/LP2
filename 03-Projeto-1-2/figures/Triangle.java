package figures;

import java.awt.*;

public class Triangle extends Figure {

    public Triangle (int x, int y, int w, int h, Color background, Color outline) {
        super(x, y, w, h, background, outline);
    }

    @Override
    public void print () {
        System.out.printf("Triangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
                this.w, this.h, this.x, this.y);
    }

    @Override
    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        int[] xt = new int[]{x + w/2, x + w, x};
        int[] yt = new int[]{y, y + h, y + h};

        Polygon TriangleObject = new Polygon(xt, yt, 3);

        g2d.setStroke(new BasicStroke(3));

        g2d.setColor(this.background);
        g2d.fillPolygon(TriangleObject);

        g2d.setColor(this.outline);
        g2d.drawPolygon(TriangleObject);
    }
}