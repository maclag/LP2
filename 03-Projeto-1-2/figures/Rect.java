package figures;

import java.awt.*;

public class Rect extends Figure {

    public Rect (int x, int y, int w, int h, Color background, Color outline) {
        super(x, y, w, h, background, outline);
    }

    @Override
    public void print () {
        System.out.printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
                this.w, this.h, this.x, this.y);
    }

    @Override
    public boolean clicked (int x, int y) {
        return this.x <= x && x <= (this.x + this.h) && this.y <= y && y <= (this.y + this.w);
    }

    @Override
    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(3));

        g2d.setColor(this.background);
        g2d.fillRect(this.x, this.y, this.w, this.h);

        g2d.setColor(this.outline);
        g2d.drawRect(this.x, this.y, this.w, this.h);

        if (focused) {
            g2d.setStroke(new BasicStroke(1));
            g2d.setColor(Color.red);
            g2d.drawRect(this.x-2, this.y-2, this.w+4, this.h+4);
        }
    }

    public void redFocus (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(1));

        g2d.setColor(Color.red);
        g2d.drawRect(this.x, this.y, this.w, this.h);
    }

}