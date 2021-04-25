import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import figures.*;
import colors.*;

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<>();
    Figure focus = null;
    Rect rectFocus = null;

    Point p = null;
    Point beforePoint = null, afterPoint = null;

    int distanceX = 0, distanceY = 0;
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
                    public void mousePressed(MouseEvent e) {
                        beforePoint = getMousePosition();
                        int x = beforePoint.x;
                        int y = beforePoint.y;

                        focus = null;
                        for (Figure fig: figs) {
                            boolean insideFigure = fig.x <= x && x <= (fig.x + fig.h) && fig.y <= y && y <= (fig.y + fig.w);
                            if (insideFigure) {
                                focus = fig;
                            }
                        }

                        if (focus != null) {
                            figs.remove(focus);
                            figs.add(focus);
                            distanceX = focus.x - x;
                            distanceY = focus.y - y;
                        }

                        repaint();
                    }
                }
        );

        this.addMouseMotionListener(
                new MouseMotionAdapter() {
                    @Override
                    public void mouseDragged(MouseEvent e) {
                        afterPoint = getMousePosition();
                        int newX = afterPoint.x;
                        int newY = afterPoint.y;

                        if (focus != null) {
                            figs.remove(focus);
                            focus.x = newX + distanceX;
                            focus.y = newY + distanceY;
                            figs.add(focus);
                            repaint();
                        }
                    }
                }
        );

        this.addKeyListener (
                new KeyAdapter() {
                    @Override
                    public void keyPressed (KeyEvent evt) {
                        p = getMousePosition();
                        int x = p.x;
                        int y = p.y;
                        int w = 50;
                        int h = 50;

                        int letter = evt.getKeyChar();
                        int key = evt.getKeyCode();

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
                            focus.x -= 10;
                        }

                        else if (key == 38 && focus != null) { // UP = move the figure up
                            focus.y -= 10;
                        }

                        else if (key == 39 && focus != null) { // RIGHT = move the figure to the right
                            focus.x += 10;
                        }

                        else if (key == 40 && focus != null) { // DOWN = move the figure down
                            focus.y += 10;
                        }

                        // Changing the figure size
                        else if (evt.getKeyChar() == '-' && focus != null) { // SUBTRACT = reduce the figure size
                            if (focus.w > 10 && focus.h > 10) {
                                focus.w -= 10;
                                focus.h -= 10;
                            }
                        }

                        else if (evt.getKeyChar() == '+' && focus != null) { // SUM = increase the figure size
                            if (focus. w != 0 && focus.h != 0) {
                                focus.w += 10;
                                focus.h += 10;
                            }
                        }

                        else if (key == 61 && focus != null) { // EQUALS = return to the default size
                            focus.w = 50;
                            focus.h = 50;
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

        this.setTitle("Projeto 1/2 - Editor Grafico Vetorial");
        this.setSize(600, 450);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g);
        }

        if (focus != null) {
            rectFocus = new Rect(focus.x-5, focus.y-5, focus.w+10, focus.h+10, null, Color.red);
            rectFocus.redFocus(g);
        }
    }
}