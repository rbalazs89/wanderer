package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class interactStoneTablet2 extends MyObjects {

    public interactStoneTablet2() {
        try{
            image = read(getClass().getResourceAsStream("/objects/stonetablet.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void objectAction(){

        if(gp.hero.keyH.enterPressed){
            gp.ui.showMessage("You are at the deepest fiery\npits of hell. The evil foe on the\nother side of the lava river\nconsiders you insignificant\nand will not chase you.");
        }
    }
}