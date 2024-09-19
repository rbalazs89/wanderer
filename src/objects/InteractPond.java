package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class InteractPond extends MyObjects {

    public InteractPond() {
    try{
        image = read(getClass().getResourceAsStream("/objects/blank.png"));
    }catch (IOException e) {
        e.printStackTrace();
        }
    }
    public void objectAction(){
        gp.ui.showMessage("You can drink water from the\npond.");
        if(gp.hero.keyH.enterPressed && !gp.hero.interactCD){
            gp.playSE(12);
            gp.hero.health = Math.min(gp.hero.maxHealth, gp.hero.health + 20);
            gp.hero.interactCD = true;
            gp.hero.keyH.enterPressed = false;
        }
    }
}
