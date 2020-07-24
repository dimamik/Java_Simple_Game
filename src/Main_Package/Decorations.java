package Main_Package;

import java.util.Random;

public class Decorations {
    public static Handler handler;
    public static Random r = new Random();

    public Decorations(Handler handler) {
        Decorations.handler = handler;
    }

    public static void newDecorations() {
        for (int i = 0; i < 15; i++) {
            handler.addObject(
                    new MenuParicle(r.nextInt(Game.HEIGHT - 50), r.nextInt(Game.WIDTH - 50), ID.MenuParticle, handler));
        }
    }

    public static void clearDecorations() {
        for (int i = 0; i < handler.object.size(); i++) {
            if (handler.object.get(i).id == ID.MenuParticle) {
                GameObject tmpObject = handler.object.get(i);
                handler.removeObject(tmpObject);
                i--;
            }
        }
    }
}
