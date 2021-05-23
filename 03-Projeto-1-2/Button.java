import figures.*;
import ivisible.IVisible;

import java.awt.*;

public class Button implements IVisible {
    public int idx;
    private Figure fig;

    public Button (int idx, Figure fig) {
        this.idx = idx;
        this.fig = fig;
    }

    @Override
    public boolean clicked (int x, int y) {
        return false;
    }

    @Override
    public void paint (Graphics g, boolean focused) {

    }
}
