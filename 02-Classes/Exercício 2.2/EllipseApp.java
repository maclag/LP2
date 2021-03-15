import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

class EllipseApp {
    public static void main(String[] args) {
        EllipseFrame frame = new EllipseFrame();
        frame.setVisible(true);
    }
}

class EllipseFrame extends JFrame {
    Ellipse e1, e2, e3;

    EllipseFrame () {
        this.addWindowListener (
                new WindowAdapter() {
                    public void windowClosing (WindowEvent e) {
                        System.exit(0);
                    }
                }
        );
        this.setTitle("Ellipse");
        this.setSize(350, 350);
        this.e1 = new Ellipse(50, 100, 250, 100, new Color(235, 222, 112), new Color(113, 39, 39));
        this.e2 = new Ellipse(75, 110, 200, 80, Color.pink, Color.blue);
        this.e3 = new Ellipse(100, 120, 150, 60, new Color(147, 158, 217), Color.orange);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.e1.paint(g);
        this.e2.paint(g);
        this.e3.paint(g);
    }
}

class Ellipse {
    int x, y;
    int w, h;
    Color background;
    Color outline;

    Ellipse (int x, int y, int w, int h, Color background, Color outline) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.background = background;
        this.outline = outline;
    }

    void print () {
        System.out.printf("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
                this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(this.background);
        g2d.fill(new Ellipse2D.Double(this.x, this.y, this.w, this.h));

        g2d.setColor(this.outline);
        g2d.draw(new Ellipse2D.Double(this.x, this.y, this.w, this. h));
    }
}















