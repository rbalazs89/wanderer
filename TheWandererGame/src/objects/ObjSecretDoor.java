package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ObjSecretDoor extends MyObjects{
    public ObjSecretDoor() {
        pickupMessage[0] = " ";
        pickupMessage[1] = " ";
        pickupMessage[2] = " ";
        pickupMessage[3] = " ";
        pickupMessage[4] = " ";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/tiles/rock1.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        collision = true;
        pickable = true;
    }
    public void objectAction() {
        if(gp.hero.keyH.enterPressed){
            gp.playSE(17);
            gp.obj[gp.hero.currentObjectIndex] = null;
            gp.hero.interactCD = true;
            gp.hero.keyH.enterPressed = false;
        }
    }
}
