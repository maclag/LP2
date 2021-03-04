import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hello2DApp {
    public static void main(String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
        frame.setVisible(true);
    }
}

class Hello2DFrame extends JFrame {
    public Hello2DFrame() {
        this.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing (WindowEvent e) {
                        System.exit(0);
                    }
                }
        );
        this.setTitle("Java2D - Hello World!");
        this.setSize(350, 350);
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        int w = getWidth();
        int h = getHeight();

        Color backgroundColor = new Color(229, 190, 190);
        g2d.setColor(backgroundColor);
        g2d.fillRect(0, 0, w, h);

        int borderWidth = 200;
        int borderHeight = 140;
        Color borderColor = new Color(107, 200, 206);
        g2d.setPaint(borderColor);
        g2d.fillRect(w/2 - borderWidth/2, h/2 - borderHeight/2, borderWidth, borderHeight);

        int rectWidth = 170;
        int rectHeight = 110;
        Color rectColor = new Color(177, 228, 232);
        g2d.setPaint(rectColor);
        g2d.fillRect(w/2 - rectWidth/2, h/2 - rectHeight/2, rectWidth, rectHeight);

        int purpleRectWidth = 270;
        int purpleRectHeight = 20;
        Color purpleRectColor = new Color(199, 161, 228);
        g2d.setPaint(purpleRectColor);
        g2d.fillRect(w/2 - purpleRectWidth/2, h/2 - purpleRectHeight/2 + borderHeight/2 + 5, purpleRectWidth, purpleRectHeight);

        String str = "Hello!";
        int size = str.length() + 1;
        g2d.setPaint(Color.black);
        g2d.drawString(str, w/2 - size*2, h/2 + size);

    }
}
