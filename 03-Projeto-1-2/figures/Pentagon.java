package figures;

import java.awt.*;

public class Pentagon extends Figure {

    public Pentagon (int x, int y, int w, int h, Color background, Color outline) {
        super(x, y, w, h, background, outline);
    }

    public void print () {
        System.out.printf("Pentagono de tamanho (%d,%d) na posicao (%d, %d).\n",
                this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        int[] xp = new int[]{x, x + w, x + w - w/2, x - w + w/2, x - w};
        int[] yp = new int[]{y, y + h, y + 2*h, y + 2*h, y + h};

        Polygon PentagonObject = new Polygon(xp, yp, 5);

        g2d.setColor(this.background);
        g2d.fillPolygon(PentagonObject);

        g2d.setColor(this.outline);
        g2d.drawPolygon(PentagonObject);
    }
}