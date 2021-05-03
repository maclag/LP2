package figures;

import java.awt.*;

public class Pentagon extends Figure {

    public Pentagon (int x, int y, int w, int h, Color background, Color outline) {
        super(x, y, w, h, background, outline);
    }

    @Override
    public void print () {
        System.out.printf("Pentagono de tamanho (%d,%d) na posicao (%d,%d).\n",
                this.w, this.h, this.x, this.y);
    }

    @Override
    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        int[] xp = new int[]{x + w/2, x + w,  x + (75*w)/100, x + w/4, x};
        int[] yp = new int[]{y, y + (45*h)/100, y + h, y + h, y + (45*h)/100};

        Polygon PentagonObject = new Polygon(xp, yp, 5);

        g2d.setStroke(new BasicStroke(3));

        g2d.setColor(this.background);
        g2d.fillPolygon(PentagonObject);

        g2d.setColor(this.outline);
        g2d.drawPolygon(PentagonObject);
    }
}