package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ObjBlessing extends MyObjects{
    public ObjBlessing() {

        pickupMessage[0] = "As you step into the light,\nyou feel overwhelming power.\nHealth full.\n+5 attack\n+10 maximum health";
        pickupMessage[1] = " ";
        pickupMessage[2] = " ";
        pickupMessage[3] = " ";
        pickupMessage[4] = " ";
        //not used, this object is always picked up.
        itemAlreadyOwnedMessage = "You are completely healthy.\nYou don't want to use this\nyet.";

        try{
            //image = ImageIO.read(getClass().getResourceAsStream("/objects/purplehealth.png"));
            image = ImageIO.read(getClass().getResourceAsStream("/objects/light.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void objectAction() {
        //if (gp.hero.maxHealth != gp.hero.health)
        {
            gp.hero.health = gp.hero.maxHealth;
            gp.playSE(20);
            gp.ui.showMessage(gp.obj[gp.hero.currentObjectIndex].pickupMessage[0]);
            gp.obj[gp.hero.currentObjectIndex] = null;
            gp.hero.attack = gp.hero.attack + 5;
            gp.hero.maxHealth +=10;
            gp.hero.health +=10;
        }
        //else {
        //    gp.ui.showMessage(gp.obj[gp.hero.currentObjectIndex].itemAlreadyOwnedMessage);
        //}
    }
}