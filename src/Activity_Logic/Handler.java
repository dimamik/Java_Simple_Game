package Activity_Logic;

/* 
Rendering and updating of objects
*/
import java.awt.Graphics;
import java.util.LinkedList;

import Main_Package.GameObject;
import Main_Package.ID;

public class Handler {

    public LinkedList<GameObject> object = new LinkedList<GameObject>();

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

    public void ClearEnemys() {
        for (int i = 0; i < this.object.size(); i++) {
            GameObject tmp_Object = this.object.get(i);
            if (tmp_Object.getID() != ID.Player) {
                this.removeObject(tmp_Object);
                i -= 1;
            }
        }
    }

    public void removeObject(GameObject object) {
        this.object.remove(object);
    }
}
