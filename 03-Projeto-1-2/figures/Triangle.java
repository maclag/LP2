package figures;

import java.awt.*;

public class Triangle extends Figure {
    private Polygon TriangleObject;

    public Triangle (int x, int y, int w, int h, Color background, Color outline) {
        super(x, y, w, h, background, outline);
    }

    @Override
    public void print () {
        System.out.printf("Triangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
                this.w, this.h, this.x, this.y);
    }

    @Override
    public boolean clicked (int x, int y) {
        return TriangleObject.contains(x, y);
    }

    @Override
    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;

        int[] xt = new int[]{x + w / 2, x + w, x};
        int[] yt = new int[]{y, y + h, y + h};
        TriangleObject = new Polygon(xt, yt, 3);

        g2d.setStroke(new BasicStroke(3));

        g2d.setColor(this.background);
        g2d.fillPolygon(TriangleObject);

        g2d.setColor(this.outline);
        g2d.drawPolygon(TriangleObject);

        if (focused) {
            int xf = x - 3;
            int yf = y - 3;
            int hf = h + 5;
            int wf = w + 6;
            int[] xFocus = new int[]{xf + wf / 2, xf + wf, xf};
            int[] yFocus = new int[]{yf, yf + hf, yf + hf};
            Polygon triangleFocus = new Polygon(xFocus, yFocus, 3);

            g2d.setStroke(new BasicStroke(1));
            g2d.setColor(Color.red);
            g2d.drawPolygon(triangleFocus);
        }
    }

}