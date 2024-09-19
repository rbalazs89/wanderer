package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ObjArmor extends MyObjects {
    public ObjArmor() {
        pickupMessage[0] = "Congratulations. You found a\nsecret armor. You suffer less\ndamage from enemies now.";
        pickupMessage[1] = "Nice find. You picked up a\nplate mail. Enemies make less\n damage now.";
        pickupMessage[2] = "Congratulations. You found a\nsecret. It will come useful in\nin the next areas.";
        pickupMessage[3] = "You found a secret area. This\narmor gives protection against\nenemy attacks.";
        pickupMessage[4] = "Congratulations. You found an\narmor. It will serve you well\nin the fights to come.";
        itemAlreadyOwnedMessage = "This is not supposed to happen.\nFinding even this one is hard\nenough";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/armorRectangle.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void objectAction(){
        if(!gp.hero.hasArmor) {
            gp.playSE(19);
            int tempnumber = (int) (Math.random() * 5);
            gp.ui.showMessage(gp.obj[gp.hero.currentObjectIndex].pickupMessage[tempnumber]);
            gp.obj[gp.hero.currentObjectIndex] = null;
            gp.hero.hasArmor = true;
        }
        else{
            gp.ui.showMessage(gp.obj[gp.hero.currentObjectIndex].itemAlreadyOwnedMessage);
        }
    }
}
