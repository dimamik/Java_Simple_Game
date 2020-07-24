package Main_Package;

import java.awt.*;

public class FastEnemy extends GameObject {

    private Handler handler;
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

    public FastEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = 4;
        velY = 10;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);
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
        handler.addObject(new Trail(x, y, ID.Trail, handler, 16, 16, Color.blue, 0.02f));
    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.blue);
        g.fillRect(x, y, 16, 16);
    }

}