package Main_Package;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/* 
Fixed the switching bug by adding an array of booleans that catches the movements
*/
public class KeyInput extends KeyAdapter {

    private Handler handler;
    private boolean[] keyDown = new boolean[4];
    public KeyInput(Handler handler) {
        this.handler = handler;
        for (int i = 0; i < 4; i++) {
            keyDown[i]=false;
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tmpObject = handler.object.get(i);
            if (tmpObject.getID() == ID.Player) {

                // key events for player 1

                if (key == KeyEvent.VK_W || key == 38) {
                    tmpObject.setVelY(-5);
                    keyDown[0]=true;
                }
                if (key == KeyEvent.VK_S || key == 40) {
                    tmpObject.setVelY(5);
                    keyDown[1]=true;
                }
                if (key == KeyEvent.VK_D || key == 39) {
                    tmpObject.setVelX(5);
                    keyDown[2]=true;
                }
                if (key == KeyEvent.VK_A || key == 37) {
                    tmpObject.setVelX(-5);
                    keyDown[3]=true;
                }

            }
        }

        if (key == KeyEvent.VK_ESCAPE)
            System.exit(1);
    }

    public void keyReleased(KeyEvent e) {
        // The key is not pressed -> set the speed to 0
        int key = e.getKeyCode();

        // System.out.println(key);

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tmpObject = handler.object.get(i);
            if (tmpObject.getID() == ID.Player) {

                // key events to do while button is not re
                if (key == KeyEvent.VK_W || key == 38) {
                    keyDown[0]=false;
                }
                if (key == KeyEvent.VK_S || key == 40) {
                    keyDown[1]=false;

                }
                if (key == KeyEvent.VK_D || key == 39) {
                    keyDown[2]=false;

                }
                if (key == KeyEvent.VK_A || key == 37) {
                    keyDown[3]=false;

                }
                //Vertical movement
                if (!keyDown[0] && !keyDown[1]) tmpObject.setVelY(0);
                //Horizontal movement
                if (!keyDown[2] && !keyDown[3]) tmpObject.setVelX(0);
            }
        }
    }

}
