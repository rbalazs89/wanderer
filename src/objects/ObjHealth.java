package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ObjHealth extends MyObjects{
    public ObjHealth() {
        pickupMessage[0] = "There is only so much room in\n";
        pickupMessage[0] = "You found some kind of red\nliquid. You drink it and\nfeel healthy.";
        pickupMessage[1] = "You are feeling refreshed.";
        pickupMessage[2] = "You drank a health potion.\nStrength rekindled.";;
        pickupMessage[3] = "You replenished some of your\nhealth.";
        pickupMessage[4] = "You found a health potion. You\nfeel rejuvenated.";
        itemAlreadyOwnedMessage = "You are completely healthy.\nYou don't feel like drinking this\nright now.";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/health.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void objectAction() {
        if (gp.hero.maxHealth != gp.hero.health) {
            gp.hero.health = Math.min((int)(gp.hero.health + gp.hero.maxHealth * 0.35), gp.hero.maxHealth);
            gp.playSE(1);
            int tempnumber = (int)(Math.random()*5);
            gp.ui.showMessage(gp.obj[gp.hero.currentObjectIndex].pickupMessage[tempnumber]);
            gp.obj[gp.hero.currentObjectIndex] = null;
        }
        else {
            gp.ui.showMessage(gp.obj[gp.hero.currentObjectIndex].itemAlreadyOwnedMessage);
        }
    }
}
