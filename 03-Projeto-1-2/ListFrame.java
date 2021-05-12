import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import figures.*;
import colors.*;

class ListFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    ArrayList<Figure> figs = new ArrayList<>();
    Figure focus = null;
    Rect rectFocus = null;
    Rect rectResize = new Rect(0, 0, 15, 15, null, Color.red);
    Point pos = null;

    boolean pressedRes = false;

    int distanceX = 0, distanceY = 0;
    int newDistanceX = 0, newDistanceY = 0;
    int changeX = 0, changeY = 0;
    int iFilled = 1, jBorder = 0;

    ListFrame () {
        this.addWindowListener (
                new WindowAdapter() {
                    public void windowClosing (WindowEvent e) {
                        System.exit(0);
                    }
                }
        );

        this.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent beforeEvt) {
                        int x = beforeEvt.getX();
                        int y = beforeEvt.getY();

                        focus = null;
                        for (Figure fig: figs) {
                            if (fig.clicked(x,y)) {
                                focus = fig;
                            }
                        }

                        if (focus != null) {
                            boolean canResize = rectResize.x <= x && x <= (rectResize.x + rectResize.w) && rectResize.y <= y && y <= (rectResize.y + rectResize.h);
                            if (canResize && pressedRes) {
                                distanceX = rectResize.x - x;
                                distanceY = rectResize.y - y;
                            }
                            else {
                                pressedRes = false;
                                figs.remove(focus);
                                figs.add(focus);
                                distanceX = focus.x - x;
                                distanceY = focus.y - y;
                            }
                        }

                        repaint();
                    }
                }
        );

        this.addMouseMotionListener(
                new MouseMotionAdapter() {
                    @Override
                    public void mouseDragged(MouseEvent afterEvt) {
                        int newX = afterEvt.getX();
                        int newY = afterEvt.getY();

                        if (pressedRes && focus != null) {
                            newDistanceX = rectResize.x - newX;
                            newDistanceY = rectResize.y - newY;
                            changeX = distanceX - newDistanceX;
                            changeY = distanceY - newDistanceY;

                            figs.remove(focus);
                            if (changeX + focus.w >= 15 && changeY + focus.h >= 15) {
                                focus.resize(changeX, changeY);
                            }
                            figs.add(focus);
                        }

                        else if (!pressedRes && focus != null) {
                            pressedRes = false;
                            figs.remove(focus);
                            focus.drag(newX + distanceX - focus.x, newY + distanceY - focus.y);
                            figs.add(focus);
                        }

                        repaint();
                    }
                }
        );

        this.addKeyListener (
                new KeyAdapter() {
                    @Override
                    public void keyPressed (KeyEvent evt) {
                        pos = getMousePosition();

                        if (pos == null) {
                            return;
                        }

                        int x = pos.x;
                        int y = pos.y;
                        int w = 50;
                        int h = 50;

                        int letter = evt.getKeyChar();
                        int key = evt.getKeyCode();
                        pressedRes = false;

                        // Creating the figures
                        if (letter == 'r') { // 'r' = create a rectangle
                            figs.add(new Rect(x, y, w, h, Colors.colors.get(0), Colors.colors.get(1)));
                        }

                        else if (letter == 'e') { // 'e' = create an ellipse
                            figs.add(new Ellipse(x, y, w, h, Colors.colors.get(2), Colors.colors.get(3)));
                        }

                        else if (letter == 't') { // 't' = create a triangle
                            figs.add(new Triangle(x, y, w, h, Colors.colors.get(4), Colors.colors.get(5)));
                        }

                        else if (letter == 'p') { // 'p' = create a pentagon
                            figs.add(new Pentagon(x, y, w, h, Colors.colors.get(6), Colors.colors.get(7)));
                        }

                        if (letter == 'r' || letter == 'e' || letter == 't' || letter == 'p') {
                            focus = figs.get(figs.size() - 1);
                        }

                        // Changing focus
                        else if (key == 10) { // ENTER = change focus
                            if (focus == null && !figs.isEmpty()) {
                                focus = figs.get(0);
                            }

                            int index = figs.indexOf(focus) + 1;
                            if (focus != null) {
                                if (figs.indexOf(focus) == (figs.size() - 1))
                                    index = 0;
                                focus = figs.get(index);
                                figs.remove(focus);
                                figs.add(focus);
                            }
                        }

                        // Changing the colors
                        else if (key == 33 && focus != null) { // PAGE UP = change the filled color
                            if (iFilled >= 10)
                                iFilled = 0;
                            focus.background = Colors.colors.get(iFilled);
                            iFilled++;
                        }

                        else if (key == 34 && focus != null) { // PAGE DOWN = change the border color
                            if (jBorder >= 10)
                                jBorder = 0;
                            focus.outline = Colors.colors.get(jBorder);
                            jBorder++;
                        }

                        // Moving the figures
                        else if (key == 37 && focus != null) { // LEFT = move the figure to the left
                            focus.drag(-10, 0);
                        }

                        else if (key == 38 && focus != null) { // UP = move the figure up
                            focus.drag(0, -10);
                        }

                        else if (key == 39 && focus != null) { // RIGHT = move the figure to the right
                            focus.drag(10, 0);
                        }

                        else if (key == 40 && focus != null) { // DOWN = move the figure down
                            focus.drag(0, 10);
                        }

                        // Changing the figure size
                        else if (evt.getKeyChar() == '1' && focus != null) { // '1' = resize (mouse)
                            pressedRes = true;
                        }

                        else if (evt.getKeyChar() == '2' && focus != null) { // '2' = disable resize (mouse)
                            pressedRes = false;
                        }

                        else if (evt.getKeyChar() == '-' && focus != null) { // SUBTRACT = reduce the figure size
                            if (focus.w > 10 && focus.h > 10) {
                                focus.resize(-10, -10);
                            }
                        }

                        else if (evt.getKeyChar() == '+' && focus != null) { // SUM = increase the figure size
                            if (focus. w != 0 && focus.h != 0) {
                                focus.resize(10, 10);
                            }
                        }

                        else if (key == 61 && focus != null) { // EQUALS = return to the default size
                            focus.resize(50 - focus.w, 50 - focus.h);
                        }

                        // Deleting the figure
                        else if (key == 127 && focus != null) { // DELETE = delete the figure
                            figs.remove(focus);
                            focus = null;
                            rectFocus = null;
                        }

                        repaint();
                    }
                }
        );

        this.setTitle("Projeto - Editor Grafico Vetorial");
        this.setSize(600, 450);
        setLocationRelativeTo(null);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g);
        }

        if (focus != null) {
            rectFocus = new Rect(focus.x-5, focus.y-5, focus.w+10, focus.h+10, null, Color.red);
            rectFocus.redFocus(g);
            if (pressedRes) {
                rectResize.x = rectFocus.x + rectFocus.w - 15;
                rectResize.y = rectFocus.y + rectFocus.h - 15;
                rectResize.paint(g);
            }
        }
    }
}