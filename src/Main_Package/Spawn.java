package Main_Package;

import java.util.Random;

public class Spawn {

    private Handler handler;
    private HUD hud;
    private Random rand = new Random();
    private int scoreKeep = 0;

    public Spawn(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void tick() {
        scoreKeep++;

        if (scoreKeep >= 5) {

            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);

            /* THE SYSTEM OF SPAWNING */
            if (hud.getLevel() == 2) {
                handler.addObject(new SmartEnemy(50, 50, ID.SmartEnemy, handler));
            } else if (hud.getLevel() == 3) {
                handler.addObject(new BasicEnemy(rand.nextInt(Game.HEIGHT - 50), rand.nextInt(Game.WIDTH - 50),
                        ID.BasicEnemy, handler));
            } else if (hud.getLevel() == 4) {
                handler.addObject(new FastEnemy(rand.nextInt(Game.HEIGHT - 50), rand.nextInt(Game.WIDTH - 50),
                        ID.FastEnemy, handler));
            } else if (hud.getLevel() == 5) {

                handler.ClearEnemys();
                handler.addObject(new BossEnemy(Game.WIDTH / 2, -200, ID.BossEnemy, handler));
            }

        }
    }
}
