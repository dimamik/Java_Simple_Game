package Main_Package;

import java.awt.event.*;

import Main_Package.Game.STATE;

import java.awt.*;

public class Menu extends MouseAdapter {
    private Game game;
    private Handler handler;

    public Menu(Game game, Handler handler, HUD hud) {
        this.game = game;
        this.handler = handler;
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (mouseOver(mx, my, 230, 100, 200, 74)) {
            Game.gameState = STATE.Game;
            // hud.restart();
            HUD.HEALTH = 100;
            HUD.score = 0;
            HUD.level = 1;
            handler.addObject(new Player(Game.WIDTH / 2, (int) Game.HEIGHT / 2, ID.Player, this.handler, game));
        }
        if (mouseOver(mx, my, 230, 300, 200, 74)) {
            System.exit(1);
        }
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void tick() {

    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            }
        }
        return false;
    }

    public void render(Graphics g) {
        Font font = new Font("Arial", 1, 50);
        Font font2 = new Font("Arial", 1, 35);
        Font font3 = new Font("Arial", 1, 25);
        g.setColor(Color.black);
        g.setFont(font);
        g.drawString("Menu", 270, 80);

        g.setColor(Color.black);
        g.setFont(font2);
        g.drawString("PLAY", 290, 145);

        g.setColor(Color.black);
        g.setFont(font2);
        g.drawString("HELP", 290, 245);

        g.setColor(Color.black);
        g.setFont(font2);
        g.drawString("QUIT", 293, 345);

        g.setColor(Color.black);
        g.setFont(font3);
        g.drawString("MAX SCORE: " + HUD.MAX_SCORE, 10, 50);

        g.setColor(Color.black);
        g.drawRect(230, 100, 200, 74);

        g.setColor(Color.black);
        g.drawRect(230, 200, 200, 74);

        g.setColor(Color.black);
        g.drawRect(230, 300, 200, 74);
    }
}
