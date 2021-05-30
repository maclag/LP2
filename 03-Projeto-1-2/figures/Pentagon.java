package figures;

import java.awt.*;

public class Pentagon extends Figure {
    private Polygon PentagonObject;

    public Pentagon (int x, int y, int w, int h, Color background, Color outline) {
        super(x, y, w, h, background, outline);
    }

    @Override
    public void print () {
        System.out.printf("Pentagono de tamanho (%d,%d) na posicao (%d,%d).\n",
                this.w, this.h, this.x, this.y);
    }

    @Override
    public boolean clicked (int x, int y) {
        return PentagonObject.contains(x, y);
    }

    @Override
    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;

        int[] xp = new int[]{x + w / 2, x + w, x + (75 * w) / 100, x + w / 4, x};
        int[] yp = new int[]{y, y + (45 * h) / 100, y + h, y + h, y + (45 * h) / 100};
        PentagonObject = new Polygon(xp, yp, 5);

        g2d.setStroke(new BasicStroke(3));

        g2d.setColor(this.background);
        g2d.fillPolygon(PentagonObject);

        g2d.setColor(this.outline);
        g2d.drawPolygon(PentagonObject);

        if (focused) {
            int xf = x - 3;
            int yf = y - 3;
            int hf = h + 5;
            int wf = w + 5;
            int[] xFocus = new int[]{xf + wf / 2, xf + wf, xf + (75 * wf) / 100, xf + wf / 4, xf};
            int[] yFocus = new int[]{yf, yf + (45 * hf) / 100, yf + hf, yf + hf, yf + (45 * hf) / 100};
            Polygon pentagonFocus = new Polygon(xFocus, yFocus, 5);

            g2d.setStroke(new BasicStroke(1));
            g2d.setColor(Color.red);
            g2d.drawPolygon(pentagonFocus);
        }
    }
}