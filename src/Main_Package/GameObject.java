package Main_Package;

import java.awt.*;

//All objects
public abstract class GameObject {
    // Can only be accessed in same package or in child classes
    protected float x, y;
    protected ID id;
    protected boolean status = true;
    // Speed in X and Y directions
    protected float velX, velY;

    public GameObject(float x, float y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }
    public abstract void tick();
    //Helps us target the 
    //Player position without coordinating them
    public abstract Rectangle getBounds();

    public abstract void render(Graphics g);

    // Accessors and mutators
    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public void setID(ID id) {
        this.id = id;
    }

    public ID getID() {
        return this.id;
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }

    public float getVelX() {
        return this.velX;
    }

    public float getVelY() {
        return this.velY;
    }
}
