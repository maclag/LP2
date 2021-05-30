package menus;

import figures.*;
import ivisible.IVisible;

import java.awt.*;

public class Button implements IVisible {
    public int idx;
    private Figure fig;
    private int x, y;

    public Button (int idx, Figure fig) {
        this.idx = idx;
        this.fig = fig;
        this.x = 20;
        this.y = 50 + idx*50;
    }

    @Override
    public boolean clicked (int x, int y) {
        return this.x <= x && x <= (this.x + 45) && this.y <= y && y <= (this.y + 45);
    }

    @Override
    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;

        if (focused)
            g2d.setColor(Color.darkGray);
        else
            g2d.setColor(Color.gray);
        g2d.fillRect(this.x, this.y, 45, 45);

        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(Color.darkGray);
        g2d.drawRect(this.x, this.y, 45, 45);

        this.fig.paint(g, false);
    }

    public static void paintArea (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.lightGray);
        g2d.fillRect(10, 40, 65, 220);

        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(Color.darkGray);
        g2d.drawRect(10, 40, 65, 220);
    }
}
