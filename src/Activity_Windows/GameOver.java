package Activity_Windows;

import java.awt.event.*;

import Main_Package.Game;
import Main_Package.Game.STATE;

import java.awt.*;

public class GameOver extends MouseAdapter {

    public GameOver() {
    }

    public void tick() {

    }

    public void render(Graphics g) {
        Font font = new Font("Arial", 1, 50);
        Font font2 = new Font("Arial", 1, 35);
        g.setColor(Color.red);
        g.setFont(font);
        g.drawString("GAME OVER", 150, 150);
        g.setColor(Color.red);
        g.setFont(font);
        g.drawString("Your score: " + HUD.score, 150, 240);

        g.setColor(Color.black);
        g.setFont(font2);
        g.drawString("BACK TO MENU", 186, 350);

        g.setColor(Color.black);
        g.drawRect(170, 300, 300, 74);
        // To return to main menu
        /*
         * HUD.MAX_SCORE = Math.max(HUD.score, HUD.MAX_SCORE); Game.gameState =
         * Game.STATE.Menu;
         */

    }

    public void mousePressed(MouseEvent e) {
        if (Game.gameState == Game.STATE.GameOver) {
            int mx = e.getX();
            int my = e.getY();

            if (mouseOver(mx, my, 230, 300, 200, 74)) {
                HUD.MAX_SCORE = Math.max(HUD.score, HUD.MAX_SCORE);
                Game.gameState = Game.STATE.Menu;
                Decorations.newDecorations();
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
