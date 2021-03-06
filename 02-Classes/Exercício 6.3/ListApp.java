import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

import figures.*;

class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();

    ListFrame () {
        this.addWindowListener (
                new WindowAdapter() {
                    public void windowClosing (WindowEvent e) {
                        System.exit(0);
                    }
                }
        );

        this.addKeyListener (
                new KeyAdapter() {
                    public void keyPressed (KeyEvent evt) {
                        int x = rand.nextInt(350);
                        int y = rand.nextInt(350);
                        int w = rand.nextInt(50);
                        int h = rand.nextInt(50);

                        if (evt.getKeyChar() == 'r') {
                            Rect r = new Rect(x, y, w, h, Color.yellow, Color.black);
                            figs.add(r);
                        }

                        else if (evt.getKeyChar() == 'e') {
                            figs.add(new Ellipse(x, y, w, h, Color.orange, Color.red));
                        }

                        else if (evt.getKeyChar() == 't') {
                            figs.add(new Triangle(x, y, w, h, Color.pink, Color.blue));
                        }

                        repaint();
                    }
                }
        );

        this.setTitle("Lista de Figuras");
        this.setSize(350, 350);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g);
        }
    }
}
