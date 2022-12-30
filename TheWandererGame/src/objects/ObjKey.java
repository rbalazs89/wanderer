package objects;

import javax.imageio.ImageIO;
import java.io.IOException;


public class ObjKey extends MyObjects {
    public ObjKey() {
        pickupMessage[0] = "You discovered a key. May it\ncome useful in your travels.\n";
        pickupMessage[1] = "You have found a key. You are\n eager to find what it opens.\n";
        pickupMessage[2] = "You came upon a key. Its\nshiny glow is mesmerizing.\n";
        pickupMessage[3] = "You came across a key. You\ncan't help but wonder what\nit opens.\n";
        pickupMessage[4] = "You picked up a key. It might\nlead to the next level.\n";
        itemAlreadyOwnedMessage = "You already have a key. There\nis only so much room in your\npocket.\n";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void objectAction(){
        if (!gp.hero.hasKey) {
            gp.playSE(3);
            gp.hero.hasKey = true;
            int tempnumber = (int)(Math.random()*5);
            gp.ui.showMessage(gp.obj[gp.hero.currentObjectIndex].pickupMessage[tempnumber]);
            gp.obj[gp.hero.currentObjectIndex] = null;
        }
        else{
            gp.ui.showMessage(gp.obj[gp.hero.currentObjectIndex].itemAlreadyOwnedMessage);
        }
    }
}
