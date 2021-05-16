package figures;

import java.awt.*;
import java.io.Serializable;

import ivisible.IVisible;

public abstract class Figure implements IVisible, Serializable {
    public int x, y;
    public int w, h;
    public Color background, outline;

    public Figure (int x, int y, int w, int h, Color background, Color outline) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.background = background;
        this.outline = outline;
    }

    public abstract void print ();

    public boolean clicked (int x, int y) {
        return this.x <= x && x <= (this.x + this.h) && this.y <= y && y <= (this.y + this.w);
    }

    public void drag (int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public void resize (int rw, int rh) {
        this.w += rw;
        this.h += rh;
    }
}