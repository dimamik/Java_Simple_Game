package Main_Package;

import java.awt.*;

public class BasicEnemy extends GameObject {

    private Handler handler;
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

    public BasicEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = 5;
        velY = 5;
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
        handler.addObject(new Trail(x, y, ID.Trail, handler, 16, 16, Color.red, 0.02f));
    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.red);
        g.fillRect(x, y, 16, 16);
    }

}
