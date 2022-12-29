package objects;

import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class Frog extends MyObjects {

    public Frog() {
        try{
            image = read(getClass().getResourceAsStream("/objects/frog.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void objectAction(){
        gp.ui.showMessage("I am a frog! I like the high\n temperature here.\n \nI give a reward if you\n kiss me!");
        if(gp.hero.keyH.enterPressed){
            gp.playSE(21);

            gp.obj[29] = new ObjHealth();
            gp.obj[29].x = 0 * gp.tileSize;
            gp.obj[29].y = 7 * gp.tileSize;

            gp.hero.interactCD = true;
            gp.hero.keyH.enterPressed = false;
        }
    }
}
