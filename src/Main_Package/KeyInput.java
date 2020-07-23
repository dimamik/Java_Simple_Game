package Main_Package;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        //System.out.println(key);

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tmpObject = handler.object.get(i);
            if (tmpObject.getID() == ID.Player) {

                // key events for player 1

                if (key == KeyEvent.VK_W || key == 38) {
                    tmpObject.setVelY(-5);
                }
                if (key == KeyEvent.VK_S || key == 40) {
                    tmpObject.setVelY(5);
                }
                if (key == KeyEvent.VK_D || key == 39) {
                    tmpObject.setVelX(5);
                }
                if (key == KeyEvent.VK_A || key == 37) {
                    tmpObject.setVelX(-5);
                }

            }
        }
    }

    public void keyReleased(KeyEvent e) {
        //The key is not pressed -> set the speed to 0
        int key = e.getKeyCode();

        //System.out.println(key);

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tmpObject = handler.object.get(i);
            if (tmpObject.getID() == ID.Player) {

                // key events for player 1

                if (key == KeyEvent.VK_W || key == 38) {
                    tmpObject.setVelY(0);
                }
                if (key == KeyEvent.VK_S || key == 40) {
                    tmpObject.setVelY(0);
                }
                if (key == KeyEvent.VK_D || key == 39) {
                    tmpObject.setVelX(0);
                }
                if (key == KeyEvent.VK_A || key == 37) {
                    tmpObject.setVelX(0);
                }

            }
        }
    }

}
