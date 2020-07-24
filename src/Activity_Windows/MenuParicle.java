package Activity_Windows;

import java.awt.*;
import java.util.Random;

import Activity_Logic.Handler;
import Enemy.Trail;
import Main_Package.Game;
import Main_Package.GameObject;
import Main_Package.ID;

public class MenuParicle extends GameObject {

    private Handler handler;
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    Random r = new Random();
    private int red = r.nextInt(255);
    private int green = r.nextInt(255);
    private int blue = r.nextInt(255);
    private Color color;

    public MenuParicle(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        r = new Random();
        velX = (r.nextInt(5 - -5) + -5);
        velY = (r.nextInt(5 - -5) + -5);
        color = new Color(red, green, blue);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }

    @Override
    public void tick() {

        x += velX;
        y += velY;

        if (y <= 0 || y >= Game.HEIGHT - 25)
            velY *= -1;
        if (x <= 0 || x >= Game.WIDTH - 32)
            velX *= -1;
        // Adding Trail every tick
        handler.addObject(new Trail(x, y, ID.Trail, handler, 16, 16, color, 0.02f));
    }

    @Override
    public void render(Graphics g) {

        g.setColor(color);
        g.fillRect((int) x, (int) y, 16, 16);
    }

}