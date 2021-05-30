package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ellipse extends Figure {
    private Ellipse2D EllipseObject;

    public Ellipse (int x, int y, int w, int h, Color background, Color outline) {
        super(x, y, w, h, background, outline);
    }

    @Override
    public void print () {
        System.out.printf("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
                this.w, this.h, this.x, this.y);
    }

    @Override
    public boolean clicked (int x, int y) {
        return EllipseObject.contains(x, y);
    }

    @Override
    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;

        EllipseObject = new Ellipse2D.Double(this.x, this.y, this.w, this.h);

        g2d.setStroke(new BasicStroke(3));

        g2d.setColor(this.background);
        g2d.fill(EllipseObject);

        g2d.setColor(this.outline);
        g2d.draw(EllipseObject);

        if (focused) {
            Ellipse2D ellipseFocus = new Ellipse2D.Double(this.x - 2, this.y - 2, this.w + 4, this.h + 4);
            g2d.setStroke(new BasicStroke(1));
            g2d.setColor(Color.red);
            g2d.draw(ellipseFocus);
        }
    }

}