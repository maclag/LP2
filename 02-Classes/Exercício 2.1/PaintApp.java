import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PaintApp {
    public static void main(String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame {
    Rect r1, r2, r3;

    PaintFrame () {
        this.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing (WindowEvent e) {
                        System.exit(0);
                    }
                }
        );
        this.setTitle("Painting Figures");
        this.setSize(350, 350);
        this.r1 = new Rect(50, 50, 250, 100, new Color(68, 152, 147), Color.pink);
        this.r2 = new Rect(80, 80, 190, 80, new Color(220, 231, 159), new Color(160, 153, 227));
        this.r3 = new Rect(110, 110, 130, 60, new Color(210, 85, 85), Color.blue);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.r2.paint(g);
        this.r3.paint(g);
    }
}

class Rect {
    int x, y;
    int w, h;
    Color background;
    Color outline;

    Rect (int x, int y, int w, int h, Color background, Color outline) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.background = background;
        this.outline = outline;
    }

    void print () {
        System.out.printf("Retângulo de tamanho (%d,%d) na posição (%d,%d).\n",
                this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(this.background);
        g2d.fillRect(this.x, this.y, this.w, this.h);

        g2d.setColor(this.outline);
        g2d.drawRect(this.x, this.y, this.w, this.h);
    }
}