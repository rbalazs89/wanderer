package objects;

import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class TouchHealingPool extends MyObjects {

    public TouchHealingPool() {
        try {
            image = read(getClass().getResourceAsStream("/objects/blank.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void objectAction() {
        gp.ui.showMessage("After all the fighting, you\nfeel your aching muscles\nregenerating as you enter the\npool.\n");
        if ( (int)(Math.random() * 6) == 0) {
            gp.hero.health = Math.min(gp.hero.maxHealth, gp.hero.health + 1) ;
        }
    }
}
