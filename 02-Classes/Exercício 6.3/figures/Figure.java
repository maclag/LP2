package figures;

import java.awt.*;

public abstract class Figure {
    int x, y, w, h;
    Color background, outline;

    public abstract void print ();
    public abstract void paint (Graphics g);
}
