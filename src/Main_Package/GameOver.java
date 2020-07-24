package Main_Package;

import java.awt.*;

public class GameOver {
    private int timer = 1500;

    public GameOver() {
    }

    public void tick() {

    }

    public void render(Graphics g) {
        Font font = new Font("Arial", 1, 50);
        if (timer >= 0) {
            timer--;
            g.setColor(Color.red);
            g.setFont(font);
            g.drawString("GAME OVER", 150, 190);
            g.setColor(Color.red);
            g.setFont(font);
            g.drawString("Your score: " + HUD.score, 150, 290);
        } else {
            timer = 1500;
            HUD.MAX_SCORE = Math.max(HUD.score, HUD.MAX_SCORE);
            Game.gameState = Game.STATE.Menu;
        }

    }
}
