package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class interactStoneTablet extends MyObjects {

    public interactStoneTablet() {
        try{
            image = read(getClass().getResourceAsStream("/objects/stonetablet.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void objectAction(){
        if(gp.hero.keyH.enterPressed){
            gp.ui.showMessage("Interact with each of the\nfour pillar once to receive\nanother blessing.");
        }
    }
}
