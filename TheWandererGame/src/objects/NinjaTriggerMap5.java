package objects;

import entity.monsters.Bear;
import entity.monsters.Ninja;

import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class NinjaTriggerMap5 extends MyObjects {
    public NinjaTriggerMap5() {
        try{
            image = read(getClass().getResourceAsStream("/objects/blank.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void objectAction(){
        gp.ui.showMessage("A wild and angry ninja\nappears. He's coming to get\nyou.");
        gp.playSE(15);
        gp.monsterOrNPC[14] = new Ninja(gp);
        gp.monsterOrNPC[14].x = 0 * gp.tileSize;
        gp.monsterOrNPC[14].y = 0 * gp.tileSize;
        gp.monsterOrNPC[14].entityIndex = 14;
        gp.obj[3] = null; // numbers for this (3,4) are preset
        gp.obj[4] = null;
        //gp.hero.currentObjectIndex = 999;
        }
    }

