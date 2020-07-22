package Main_Package;

/* 
Rendering and updating of objects
*/
import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

    LinkedList<GameObject> object = new LinkedList<GameObject>();

    // Updates and renders through all of the game objects
    public void tick() {
        // Iteration through the GameObjects in List
        for (int i = 0; i < object.size(); i++) {
            GameObject tmpObject = object.get(i);
            tmpObject.tick();
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < object.size(); i++) {
            GameObject tmpObject = object.get(i);
            tmpObject.render(g);
        }
    }

    // Adding and removing objects
    public void addObject(GameObject object) {
        this.object.add(object);
    }

    public void removeObject(GameObject object) {
        this.object.remove(object);
    }
}
