package Main_Package;

import java.awt.*;

public class BasicEnemy extends GameObject {

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    public BasicEnemy(int x, int y, ID id) {
        super(x, y, id);
        // TODO Auto-generated constructor stub
        velX=5;
        velY=5;
    }

    @Override
    public void tick() {
        // TODO Auto-generated method stub
        x+=velX;
        y+=velY;
        
        if (y<=0 || y>=Game.HEIGHT - 25) velY*=-1;
        if (x<=0 || x>=Game.WIDTH-32) velX*=-1;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 16, 16);
    }

}
