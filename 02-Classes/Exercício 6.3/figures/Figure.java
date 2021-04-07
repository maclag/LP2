package figures;

import java.awt.*;

public abstract class Figure {
    Color background, outline;

    public abstract void print ();

    public abstract void paint (Graphics g);
}