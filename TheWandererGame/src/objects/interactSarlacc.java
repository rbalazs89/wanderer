package objects;

import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class interactSarlacc extends MyObjects {
    public boolean showmessage;
    public boolean jumpedIn = false;

    public interactSarlacc() {
        try{
            image = read(getClass().getResourceAsStream("/objects/sarlacc.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void objectAction(){
        if (messageStatus) {
            gp.ui.showMessage("Press enter to jump into\nthe mouth of the sarlacc.");
        }
        if(gp.hero.keyH.enterPressed){
            messageStatus = false;
            gp.playSE(13);

            if(gp.hero.health > 100){
                gp.hero.health = 10;
                if (jumpedIn == false) {
                    gp.ui.showMessage("Did you really jump into the\nmouth of a sarlacc? You are\nbrave ... or simple minded,\ndepending on who you ask.\nYou miraculously survived and\nclimbed out.");
                }
                if(jumpedIn) {
                    gp.ui.showMessage("Did you really jump into the\nmouth of a sarlacc? AGAIN?\nStop tempting fate.");
                }
                jumpedIn = true;
            }
            else{
                if (jumpedIn) {
                    gp.ui.showMessage("Did you really jump into the\nmouth of a sarlacc AGAIN??");
                }
                else {
                    gp.ui.showMessage("Did you really jump into the\nmouth of a sarlacc....");
                }
                gp.hero.health = -1;
            }

            gp.hero.interactCD = true;
            gp.hero.keyH.enterPressed = false;
        }
    }
}
