package Activity_Windows;

import java.awt.event.*;

import Main_Package.Game;
import Main_Package.Game.STATE;

import java.awt.*;

public class Help extends MouseAdapter {

    public Help() {

    }

    public void tick() {

    }

    public void render(Graphics g) {
        Font font = new Font("Arial", 1, 25);
        g.setColor(Color.black);
        g.setFont(font);
        g.drawString("THIS GAME WAS MADE BY\n DIMAMIK", 100, 170);
        Font font2 = new Font("Arial", 1, 35);
        g.setColor(Color.black);
        g.setFont(font2);
        g.drawString("BACK TO MENU", 186, 350);

        g.setColor(Color.black);
        g.drawRect(170, 300, 300, 74);
    }

    public void mousePressed(MouseEvent e) {
        if (Game.gameState == Game.STATE.Help) {
            int mx = e.getX();
            int my = e.getY();

            if (mouseOver(mx, my, 230, 300, 200, 74)) {
                Game.gameState = Game.STATE.Menu;
            }
        }
    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            }
        }
        return false;
    }
}
