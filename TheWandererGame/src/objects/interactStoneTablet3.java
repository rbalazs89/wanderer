package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class interactStoneTablet3 extends MyObjects {

    public interactStoneTablet3() {
        try{
            image = read(getClass().getResourceAsStream("/objects/stonetablet.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void objectAction(){

        if(gp.hero.keyH.enterPressed){
            gp.ui.showMessage("Ego amissus pugna sed autere\nbellum.");
        }
    }
}