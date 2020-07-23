package Main_Package;

import java.awt.Graphics;
import java.util.Random;
import java.awt.Color;

public class Player extends GameObject {
    private Color default_color;
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

    public Player(int x, int y, ID id) {
        super(x, y, id);
        velX = 0;
        velY = 0;
        Random rand = new Random();
        float r = rand.nextFloat();
        float ge = rand.nextFloat();
        float b = rand.nextFloat();
        Color randomColor = new Color(r, ge, b);
        default_color = randomColor;
    }

    @Override
    public void tick() {
        // Each tick the obj makes move to (x+xr,y+yr) point

        /*
         * int Min = -15; int Max = 15; x += Min + (int) (Math.random() * ((Max - Min) +
         * 1)); y += Min + (int) (Math.random() * ((Max - Min) + 1));
         */

        if (x >= WIDTH || y >= HEIGHT || x < 0 || y < 0) {
            this.status = false;
        }
        
        x += velX;
        y += velY;
        x=Game.clamp(x, 0, Game.WIDTH - 36);
        y=Game.clamp(y, 0, Game.HEIGHT -66);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(x, y, 32, 32);
    }

}
