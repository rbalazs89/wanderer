package objects;

import entity.monsters.SkeletonSword;
import entity.monsters.Zombie;

import javax.imageio.ImageIO;
import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class InteractPillar extends MyObjects {

    public InteractPillar() {
        try{
            image = read(getClass().getResourceAsStream("/objects/pillar.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void objectAction(){
        //final map triggers
        //needs to use aSetters from game panel.
        if(gp.hero.keyH.enterPressed){

            pillarcounter++;
            gp.hero.interactCD = true;
            gp.hero.keyH.enterPressed = false;

            if (gp.hero.currentObjectIndex == 1){
                gp.aSetter.pillar1touched = true;
                gp.monsterOrNPC[1] = new Zombie(gp);
                gp.monsterOrNPC[1].x = gp.tileSize * 1;
                gp.monsterOrNPC[1].y = gp.tileSize * 0;
                gp.monsterOrNPC[1].entityIndex = 1;

            }
            if (gp.hero.currentObjectIndex == 2){
                gp.aSetter.pillar2touched = true;
                gp.monsterOrNPC[2] = new Zombie(gp);
                gp.monsterOrNPC[2].x = gp.tileSize * 4;
                gp.monsterOrNPC[2].y = gp.tileSize * 0;
                gp.monsterOrNPC[2].entityIndex = 2;
            }
            if (gp.hero.currentObjectIndex == 3){
                gp.aSetter.pillar3touched = true;
                gp.monsterOrNPC[3] = new Zombie(gp);
                gp.monsterOrNPC[3].x = gp.tileSize * 6;
                gp.monsterOrNPC[3].y = gp.tileSize * 0;
                gp.monsterOrNPC[3].entityIndex = 3;
            }
            if (gp.hero.currentObjectIndex == 4){
                gp.aSetter.pillar4touched = true;
                gp.monsterOrNPC[4] = new Zombie(gp);
                gp.monsterOrNPC[4].x = gp.tileSize * 8;
                gp.monsterOrNPC[4].y = gp.tileSize * 0;
                gp.monsterOrNPC[4].entityIndex = 4;
            }
            if(pillarcounter == 1){
                gp.ui.showMessage("You touched this pillar once\n");
            }
            if(pillarcounter == 2){
                gp.ui.showMessage("You touched this pillar twice\n");
            }
            if(pillarcounter == 3){
                gp.ui.showMessage("You touched this pillar three\n times.\n");
            }
            if (pillarcounter == 4){

                gp.obj[gp.hero.currentObjectIndex] = null;
                gp.ui.showMessage("You touched this pillar\nfour times and it crumbled\nto ashes.");
            }
        }
    }
}
