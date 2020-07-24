package Activity_Windows;

import java.awt.*;

import Main_Package.Game;

//Health Bar

public class HUD {

    public static int HEALTH = 100;
    public static int green = 255;
    public static int DAMAGE = 0;
    public static int timer = 1000;
    public static int timer_default = timer;
    public static int score = 0;
    public static int level = 1;
    public static int MAX_SCORE = 0;

    public void tick() {
        HEALTH = (int) Game.clamp(HEALTH, 0, 100);
        green = 2 * HEALTH;
        green = (int) Game.clamp(green, 0, 255);
        score++;

    }

    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 32);
        g.setColor(new Color(75, green, 0));
        g.fillRect(15, 15, HEALTH * 2, 32);
        g.setColor(Color.black);
        g.drawRect(15, 15, 200, 32);

        g.drawString("Score: " + score, 15, 80);
        g.drawString("Level: " + level, 15, 100);
        g.setFont(new Font("Serif", Font.BOLD, 20));
        g.drawString("HEALTH: " + HEALTH, 20, 37);
        if (HUD.DAMAGE != 0 && timer > 0) {
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

    public void restart() {
        HEALTH = 100;
        score(0);
        setLevel(1);
    }

    public void score(int score) {
        HUD.score = score;
    }

    public int getscore() {
        return HUD.score;
    }

    public int getLevel() {
        return HUD.level;
    }

    public void setLevel(int level) {
        HUD.level = level;
    }
}
