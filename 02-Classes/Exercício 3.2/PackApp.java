import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import figures.*;

class PackApp {
    public static void main(String[] args) {
        PackFrame frame = new PackFrame();
        frame.setVisible(true);
    }
}

class PackFrame extends JFrame {
    Rect r1;
    Ellipse e1;
    Pentagon p1;

    PackFrame () {
        this.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing (WindowEvent e) {
                        System.exit(0);
                    }
                }
        );
        this.setTitle("Java Packages");
        this.setSize(350, 350);

        this.r1 = new Rect(50, 50, 100, 30, new Color(194, 161, 219), new Color(36, 161, 33));
        this.e1 = new Ellipse(50, 100, 100, 30, new Color(201, 202, 134), Color.pink);

        int[] xPoints = new int[]{140, 230, 195, 87, 50};
        int[] yPoints = new int[]{150, 210, 300, 300, 210};
        this.p1 = new Pentagon(xPoints, yPoints, new Color(153, 212, 180), Color.blue);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.e1.paint(g);
        this.p1.paint(g);
    }
}