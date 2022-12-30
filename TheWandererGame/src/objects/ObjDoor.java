package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ObjDoor extends MyObjects{
    public ObjDoor() {
        pickupMessage[0] = " ";
        pickupMessage[1] = " ";
        pickupMessage[2] = " ";
        pickupMessage[3] = " ";
        pickupMessage[4] = " ";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/dooropen.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        collision = true;
        pickable = true;
    }
    public void objectAction() throws InterruptedException {
        if (gp.hero.hasKey) {
            gp.ui.showMessage("Congratulations, you have\nadvanced to level " + (gp.currentMap + 1 + "."));

            gp.nextLevel();
        }
    }
}