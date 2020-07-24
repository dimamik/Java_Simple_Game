package Main_Package;

import java.awt.*;
import java.util.Random;

public class BossEnemyBullet extends GameObject {

    private Handler handler;
    Random r = new Random();
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

    public BossEnemyBullet(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = (r.nextInt(5  - -5) + -5);
        velY =  5;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x,(int) y, 16, 16);
    }

    @Override
    public void tick() {

        x += velX;
        y += velY;
        if (y>=Game.HEIGHT) handler.removeObject(this);
       
        // Adding Trail every tick
        handler.addObject(new Trail(x, y, ID.Trail, handler, 16, 16, Color.pink, 0.02f));
    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.pink);
        g.fillRect((int) x,(int) y, 16, 16);
    }

}
