package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ObjSword extends MyObjects {
    public ObjSword() {
        pickupMessage[0] = "You are now wielder of the\nflame of Anor. Your new sword\ncuts through armor like butter.";
        pickupMessage[1] = "The sword was probably forged\nages ago. But it is still hot\nto the touch.";
        pickupMessage[2] = "You can tell only by looking\nat it, that the word is ancient\nand powerful.";
        pickupMessage[3] = "This sword was forged ages\nago yet it is still sharp.";
        pickupMessage[4] = "The sword feels light and warm\nYou are eager to try it\n against the skeletons.";
        itemAlreadyOwnedMessage = "This is not supposed to happen.\nI have put only one objsword in\nthe game.";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/redsword.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void objectAction(){
        if(gp.hero.hasSword == false) {
            gp.playSE(18);
            int tempnumber = (int) (Math.random() * 5);
            gp.ui.showMessage(gp.obj[gp.hero.currentObjectIndex].pickupMessage[tempnumber]);
            gp.obj[gp.hero.currentObjectIndex] = null;
            gp.hero.hasSword = true;
        }
        else{
            gp.ui.showMessage(gp.obj[gp.hero.currentObjectIndex].itemAlreadyOwnedMessage);
        }
    }
}
