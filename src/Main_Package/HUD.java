package Main_Package;

import java.awt.*;

//Health Bar

public class HUD {

    public static int HEALTH = 100;
    public static int green = 255;
    public static int DAMAGE = 0;
    public static int timer = 150;
    public static int timer_default=150;
    private int score = 0;
    private int level = 1;
    
    public void tick() {
        HEALTH = (int) Game.clamp(HEALTH, 0, 100);
        green = 2*HEALTH;
        green  = (int) Game.clamp(green, 0, 255);
        score++;

    }

    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 32);
        g.setColor(new Color(75,green,0));
        g.fillRect(15, 15, HEALTH * 2, 32);
        g.setColor(Color.black);
        g.drawRect(15, 15, 200, 32);

        g.drawString("Score: " + score, 15, 80);
        g.drawString("Level: " + level, 15, 100);

        if (HUD.DAMAGE != 0 && timer>0) {
            timer--;
            g.setColor(Color.red);
            g.setFont(new Font("Serif", Font.BOLD, 50));
            g.drawString("- " + HUD.DAMAGE, 250, 100);
        }
    }
    public static void hudAction(int damage) {
        HUD.HEALTH -= damage;
        HUD.DAMAGE = damage;
        HUD.timer = HUD.timer_default;
    }
    public void score(int score){
        this.score=score;
    }
    public int getscore(){
        return this.score;
    }
    public int getLevel(){
        return this.level;
    }
    public void setLevel(int level){
        this.level=level;
    }
}
