package objects;

import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class MessageMap8 extends MyObjects {

    public MessageMap8() {
        try{
            image = read(getClass().getResourceAsStream("/objects/blank.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void objectAction(){
        gp.ui.showMessage("Press enter to talk with the\nold man.");
        gp.obj[gp.hero.currentObjectIndex] = null;
    }
}
