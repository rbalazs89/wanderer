package objects;

import entity.monsters.Bear;

import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class interactBearTriggerMap3 extends MyObjects {
    public interactBearTriggerMap3() {
        try{
            image = read(getClass().getResourceAsStream("/objects/blank.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void objectAction(){
        gp.ui.showMessage("You can interact with the\nbear den to look inside.");
        if(gp.hero.keyH.enterPressed){
            gp.playSE(14);

            gp.monsterOrNPC[14] = new Bear(gp);
            gp.monsterOrNPC[14].x = 5 * gp.tileSize;
            gp.monsterOrNPC[14].y = 1 * gp.tileSize;
            gp.monsterOrNPC[14].entityIndex = 14;

            gp.hero.interactCD = true;
            gp.hero.keyH.enterPressed = false;
            gp.obj[gp.hero.currentObjectIndex] = null;
            //gp.hero.currentObjectIndex = 999;
        }
    }
}
