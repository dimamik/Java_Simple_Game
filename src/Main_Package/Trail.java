package Main_Package;

import java.awt.*;


public class Trail extends GameObject {

    private float alpha = 1;
    private Handler handler;
    private Color color;
    private int height, width;
    private float life;

    public Trail(float x, float y, ID id, Handler handler, int width, int height, Color color, float life) {
        super(x, y, id);
        this.handler = handler;
        this.color = color;
        this.height = height;
        this.width = width;
        this.life = life;
    }

    @Override
    public void tick() {
        // If timestamp is not expired than show this trail
        if (alpha > life) {
            alpha -= life - 0.001f;
        } else {
            // Removing expired trails
            handler.removeObject(this);
        }

    }

    @Override
    public Rectangle getBounds() {

        return null;
    }

    @Override
    public void render(Graphics g) {
        //Building Graphics2D connected with g obj
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTransparent(alpha));
        //Filling the transparent blurry rectangle with color
        g.setColor(color);
        g.fillRect((int) x,(int) y, width, height);
        //Setting back the default of setComposite()
        g2d.setComposite(makeTransparent(1));

    }
    
    //Handles Bluring to the end of expire time
    private AlphaComposite makeTransparent(float alpha) {
        int type = AlphaComposite.SRC_OVER;
        return (AlphaComposite.getInstance(type, alpha));
    }
}
