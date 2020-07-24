package Enemy;

import java.awt.*;

import Activity_Logic.Handler;
import Main_Package.Game;
import Main_Package.GameObject;
import Main_Package.ID;

/* 
Calculating the distance between Enemy and PLayer and set the VelX and VelY to this direction
*/
public class SmartEnemy extends GameObject {

    private Handler handler;
    private GameObject player;
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

    public SmartEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        //Freaky way to find player
        for (int i = 0; i < handler.object.size(); i++) {
            if (handler.object.get(i).getID() == ID.Player) player=handler.object.get(i);
        }

        /* velX = 5;
        velY = 5; */
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }

    @Override
    public void tick() {

        x += velX;
        y += velY;

        float diffX = x-player.getX()-8;
        float diffY = y-player.getY()-8;
        float distance = (float) Math.sqrt((x-player.getX())*(x-player.getX()) + (y-player.getVelY()) * (y-player.getVelY()));
        velX =(float) ((-1.0 / distance) * diffX) * 2;
        velY = (float) ((-1.0 / distance) * diffY) * 2;

        if (y <= 0 || y >= Game.HEIGHT - 25)
            velY *= -1;
        if (x <= 0 || x >= Game.WIDTH - 32)
            velX *= -1;
        // Adding Trail every tick
        handler.addObject(new Trail(x, y, ID.Trail, handler, 16, 16, Color.orange, 0.02f));
    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.orange);
        g.fillRect((int) x, (int) y, 16, 16);
    }

}
