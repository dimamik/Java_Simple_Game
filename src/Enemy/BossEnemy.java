package Enemy;

import java.awt.*;
import java.util.Random;

import Activity_Logic.Handler;
import Main_Package.Game;
import Main_Package.GameObject;
import Main_Package.ID;

public class BossEnemy extends GameObject {

    private Handler handler;
    Random r = new Random();
    private int timer = 80;
    private int timer2 = 50;
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

    public BossEnemy(int x, int y, ID id, Handler handler, int timer2) {
        super(x, y, id);
        this.handler = handler;
        this.timer2 = timer2;
        velX = 0;
        velY = 2;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x,(int) y, 16, 16);
    }

    @Override
    public void tick() {

        x += velX;
        y += velY;
        
        if (timer <= 0) velY = 0;
        else timer--;

        if (timer <=0) timer2--;
        if (timer2 <= 0){
            if (velX == 0) velX=2;
            int spawn = r.nextInt(10);
            if (spawn == 0) handler.addObject(new BossEnemyBullet((int) x+48, (int) y+48, ID.BossEnemyBullet, handler));
        }

        if (x<=0 || x>=Game.WIDTH - 96) velX*=-1;
        // Adding Trail every tick
        handler.addObject(new Trail(x, y, ID.Trail, handler, 64, 64, Color.red, 0.02f));
    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.red);
        g.fillRect((int) x,(int) y, 32, 32);
    }

}