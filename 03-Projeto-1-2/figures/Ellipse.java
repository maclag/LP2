package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Ellipse extends Figure {

    public Ellipse (int x, int y, int w, int h, Color background, Color outline) {
        super(x, y, w, h, background, outline);
    }

    public void print () {
        System.out.printf("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
                this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(this.background);
        g2d.fill(new Ellipse2D.Double(this.x, this.y, this.w, this.h));

        g2d.setColor(this.outline);
        g2d.draw(new Ellipse2D.Double(this.x, this.y, this.w, this.h));
    }
}