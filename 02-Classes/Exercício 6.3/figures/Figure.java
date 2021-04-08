package figures;

import java.awt.*;

public abstract class Figure {
    int x, y, w, h;
    Color background, outline;
    
    public Figure (int x, int y, int w, int h, Color background, Color outline) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.background = background;
        this.outline = outline;
    }

    public abstract void print ();
    public abstract void paint (Graphics g);
}
