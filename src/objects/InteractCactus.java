package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class InteractCactus extends MyObjects {
    int counter = 0;

    public InteractCactus() {
        try{
            image = read(getClass().getResourceAsStream("/objects/cactus.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void objectAction(){
        gp.ui.showMessage("You can eat the cactus to\nregain your strength.");
        if(gp.hero.keyH.enterPressed){
            counter ++;
            gp.playSE(16);
            gp.hero.health = Math.min(gp.hero.maxHealth, gp.hero.health + 100);
            gp.hero.interactCD = true;
            gp.hero.keyH.enterPressed = false;
            if (counter == 3){
                gp.obj[gp.hero.currentObjectIndex] = null;
                gp.ui.showMessage("YOU HAVE EATEN A WHOLE\nCACTUS.");
            }
        }
    }
}
