package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ellipse extends Figure {

    public Ellipse (int x, int y, int w, int h, Color background, Color outline) {
        super(x, y, w, h, background, outline);
    }

    @Override
    public void print () {
        System.out.printf("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
                this.w, this.h, this.x, this.y);
    }

    @Override
    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(3));

        g2d.setColor(this.background);
        g2d.fill(new Ellipse2D.Double(this.x, this.y, this.w, this.h));

        g2d.setColor(this.outline);
        g2d.draw(new Ellipse2D.Double(this.x, this.y, this.w, this.h));
    }

}