package Main_Package;

import java.awt.Graphics;
import java.awt.Color;

public class Player extends GameObject {
    public Player(int x, int y, ID id) {
        super(x, y, id);
        velX = 0;
        velY = 0;
    }

    @Override
    public void tick() {
        //Each tick the obj makes move to (x+xr,y+yr) point
        int Min = -15;
        int Max = 15;
        x += Min + (int) (Math.random() * ((Max - Min) + 1));
        y += Min + (int) (Math.random() * ((Max - Min) + 1));

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, 32, 32);
    }

}
