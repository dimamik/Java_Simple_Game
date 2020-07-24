package Main_Package;

import java.awt.Graphics;
import java.util.Random;

import Activity_Logic.Handler;
import Activity_Windows.HUD;
import Main_Package.Game.STATE;

import java.awt.*;

public class Player extends GameObject {
    Handler handler;
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    Game game;

    public Player(float x, float y, ID id, Handler handler, Game game) {
        super(x, y, id);
        this.handler = handler;
        this.game = game;
        velX = 0;
        velY = 0;
    }

    public Color getRandomColor() {
        Random rand = new Random();
        float r = rand.nextFloat();
        float ge = rand.nextFloat();
        float b = rand.nextFloat();
        Color to_ret = new Color(r, ge, b);
        return to_ret;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 32, 32);
    }

    @Override
    public void tick() {
        // Each tick the obj makes move to (x+xr,y+yr) point

        x += velX;
        y += velY;
        x = Game.clamp((int) x, 0, Game.WIDTH - 36);
        y = Game.clamp((int) y, 0, Game.HEIGHT - 66);

        collision();
    }

    public void collision() {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getID() == ID.BasicEnemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    // collision code

                    HUD.hudAction(5);
                }
            }
            if (tempObject.getID() == ID.FastEnemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    // collision code

                    HUD.hudAction(10);
                }
            }
            if (tempObject.getID() == ID.BossEnemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    // collision code

                    HUD.hudAction(100);
                }
            }
            if (tempObject.getID() == ID.SmartEnemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    // collision code

                    HUD.hudAction(50);
                }
            }
            if (tempObject.getID() == ID.BossEnemyBullet) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    // collision code

                    HUD.hudAction(5);
                }
            }
            if (HUD.HEALTH <= 0) {
                handler.object.clear();
                Game.gameState = STATE.GameOver;
            }
        }
    }

    @Override
    public void render(Graphics g) {
        // Cast g to g2d
        Graphics2D g2d = (Graphics2D) g;
        // Collision bound to help us tracking the obj
        g.setColor(Color.green);
        g2d.draw(getBounds());
        // Drawing the real Rect
        g.setColor(Color.black);
        g.fillRect((int) x, (int) y, 32, 32);
    }

}
