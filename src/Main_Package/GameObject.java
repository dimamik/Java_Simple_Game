package Main_Package;

import java.awt.Graphics;

//All objects
public abstract class GameObject {
    // Can only be accessed in same package or in child classes
    protected int x, y;
    protected ID id;
    
    // Speed in X and Y directions
    protected int velX, velY;

    public GameObject(int x, int y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    // Accessors and mutators
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setID(ID id) {
        this.id = id;
    }

    public ID getID() {
        return this.id;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    public int getVelX() {
        return this.velX;
    }

    public int getVelY() {
        return this.velY;
    }
}
