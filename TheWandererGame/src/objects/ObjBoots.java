package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ObjBoots extends MyObjects {
    public ObjBoots() {

        pickupMessage[0] = "You found a rusty pair of\nboots. Feels like you can fly\nlike the wind.";
        pickupMessage[1] = "You came upon a pair of shoes.\n You feel more agile.";
        pickupMessage[2] = "You came across a pair of\nboots. Your feet feels\nlighter.";
        pickupMessage[3] = "You picked up a pair of\nboots.You try it on and feel\nmore nimble.";
        pickupMessage[4] = "The boots fits one like a\nglove. You feel more agile.";
        itemAlreadyOwnedMessage = "This is not supposed to happen.\nI have put only one boots in the game.";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/boots.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void objectAction(){
        gp.hero.speed += 3;
        gp.playSE(2);
        int tempnumber = (int)(Math.random()*5);
        gp.ui.showMessage(gp.obj[gp.hero.currentObjectIndex].pickupMessage[tempnumber]);
        gp.obj[gp.hero.currentObjectIndex] = null;
        gp.hero.hasBoots = true;
    }
}
