package Main_Package;

import java.util.Random;

public class Spawn {

    private Handler handler;
    private HUD hud;
    private Random rand= new Random();
    private int scoreKeep = 0;

    public Spawn(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void tick() {
        scoreKeep++;

        if (scoreKeep>=100){
            scoreKeep=0;
            hud.setLevel(hud.getLevel()+1);
            handler.addObject(new FastEnemy(rand.nextInt(Game.HEIGHT-50), rand.nextInt(Game.WIDTH-50), ID.FastEnemy, handler));
            if (hud.getLevel()<=5){
                handler.addObject(new BasicEnemy(rand.nextInt(Game.HEIGHT-50), rand.nextInt(Game.WIDTH-50), ID.BasicEnemy, handler));
            }
        }
    }
}
