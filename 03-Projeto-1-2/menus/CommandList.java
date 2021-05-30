package menus;

import java.awt.*;

public class CommandList {
    public static void Menu (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.lightGray);
        g2d.fillRect(10, 360, 530, 150);

        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(Color.darkGray);
        g2d.drawRect(10, 360, 530, 150);

        String str0 = "Lista de Comandos:";
        String str1 = " - Criacao de figuras:  e: elipse  |  p: pentagono  |  r: retangulo  |  t: triangulo";
        String str2 = " - Mudanca de cor:  Page Up (cor de fundo)  |  Page Down (cor de borda)";
        String str3 = " - Movimentacao da figura:  LEFT  |  UP  |  RIGHT  |  DOWN";
        String str4 = " - Redimensionamento pelo mouse:  1 (ativado)  |  2 ou clicar fora (desativado)";
        String str5 = " - Redimensionamento pelo teclado:  -  |  +  |  =";
        String str6 = " - Delecao da figura: Delete";

        g2d.setFont(new Font("Roboto", Font.BOLD, 15));
        g2d.setPaint(Color.black);
        g2d.drawString(str0, 20, 380);

        g2d.setFont(new Font("Roboto", Font.PLAIN, 15));
        g2d.drawString(str1, 20, 400);
        g2d.drawString(str2, 20, 420);
        g2d.drawString(str3, 20, 440);
        g2d.drawString(str4, 20, 460);
        g2d.drawString(str5, 20, 480);
        g2d.drawString(str6, 20, 500);
    }
}
