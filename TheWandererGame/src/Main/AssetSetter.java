package Main;

import entity.NPC_Gandalf;
import entity.monsters.*;
import objects.*;

import java.util.Arrays;

public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }
    public boolean pillar1touched = false;
    public boolean pillar2touched = false;
    public boolean pillar3touched = false;
    public boolean pillar4touched = false;

    public void setObject(int currentMap) {

        if (currentMap == 1) {
            Arrays.fill(gp.obj, null);

            gp.obj[0] = new ObjKey();
            gp.obj[0].x = 11 * gp.tileSize;
            gp.obj[0].y = 0 * gp.tileSize;

            gp.obj[2] = new ObjHealth();
            gp.obj[2].x = 6 * gp.tileSize;
            gp.obj[2].y = 6 * gp.tileSize;

            gp.obj[3] = new InteractPond();
            gp.obj[3].x = 2 * gp.tileSize;
            gp.obj[3].y = 8 * gp.tileSize;

            gp.obj[4] = new InteractPond();
            gp.obj[4].x = 7 * gp.tileSize;
            gp.obj[4].y = 1 * gp.tileSize;
        }

        else if (currentMap == 2) {
            Arrays.fill(gp.obj, null);

            gp.obj[0] = new ObjKey();
            gp.obj[0].x = 1 * gp.tileSize;
            gp.obj[0].y = 8 * gp.tileSize;

            gp.obj[1] = new InteractPond();
            gp.obj[1].x = 10 * gp.tileSize;
            gp.obj[1].y = 3 * gp.tileSize;

            gp.obj[2] = new ObjHealth();
            gp.obj[2].x = 9 * gp.tileSize;
            gp.obj[2].y = 1 * gp.tileSize;
        }

        else if (currentMap == 3) {
            Arrays.fill(gp.obj, null);

            gp.obj[0] = new InteractPond();
            gp.obj[0].x = 2 * gp.tileSize;
            gp.obj[0].y = 8 * gp.tileSize;

            gp.obj[1] = new InteractPond();
            gp.obj[1].x = 2 * gp.tileSize;
            gp.obj[1].y = 8 * gp.tileSize;

            gp.obj[2] = new ObjKey();
            gp.obj[2].x = 0 * gp.tileSize;
            gp.obj[2].y = 9 * gp.tileSize;

            gp.obj[3] = new interactBearTriggerMap3();
            gp.obj[3].x = 4 * gp.tileSize;
            gp.obj[3].y = 2 * gp.tileSize;
        }

        else if (currentMap == 4) {
            Arrays.fill(gp.obj, null);

            gp.obj[0] = new ObjHealth();
            gp.obj[0].x = 7 * gp.tileSize;
            gp.obj[0].y = 7 * gp.tileSize;

            gp.obj[1] = new ObjHealth();
            gp.obj[1].x = 4 * gp.tileSize;
            gp.obj[1].y = 5 * gp.tileSize;

            gp.obj[2] = new ObjBoots();
            gp.obj[2].x = 6 * gp.tileSize;
            gp.obj[2].y = 9 * gp.tileSize;

            gp.obj[3] = new ObjHealth();
            gp.obj[3].x = 9 * gp.tileSize;
            gp.obj[3].y = 9 * gp.tileSize;

            gp.obj[4] = new ObjHealth();
            gp.obj[4].x = 0 * gp.tileSize;
            gp.obj[4].y = 9 * gp.tileSize;

            gp.obj[5] = new ObjHealth();
            gp.obj[5].x = 1 * gp.tileSize;
            gp.obj[5].y = 0 * gp.tileSize;

            gp.obj[6] = new ObjHealth();
            gp.obj[6].x = 11 * gp.tileSize;
            gp.obj[6].y = 9 * gp.tileSize;
        }

        else if (currentMap == 5) {
            Arrays.fill(gp.obj, null);

            gp.obj[0] = new ObjHealth();
            gp.obj[0].x = 3 * gp.tileSize;
            gp.obj[0].y = 9 * gp.tileSize;

            gp.obj[1] = new ObjHealth();
            gp.obj[1].x = 5 * gp.tileSize;
            gp.obj[1].y = 9 * gp.tileSize;

            gp.obj[2] = new ObjHealth();
            gp.obj[2].x = 6 * gp.tileSize;
            gp.obj[2].y = 9 * gp.tileSize;

            gp.obj[5] = new ObjHealth();
            gp.obj[5].x = 9 * gp.tileSize;
            gp.obj[5].y = 1 * gp.tileSize;

            gp.obj[6] = new ObjHealth();
            gp.obj[6].x = 0 * gp.tileSize;
            gp.obj[6].y = 9 * gp.tileSize;

            gp.obj[3] = new NinjaTriggerMap5();
            gp.obj[3].x = 10 * gp.tileSize;
            gp.obj[3].y = 6 * gp.tileSize;

            gp.obj[4] = new NinjaTriggerMap5();
            gp.obj[4].x = 8 * gp.tileSize;
            gp.obj[4].y = 7 * gp.tileSize;
        }

        else if (currentMap == 6) {
            Arrays.fill(gp.obj, null);

            gp.obj[0] = new ObjHealth();
            gp.obj[0].x = 2 * gp.tileSize;
            gp.obj[0].y = 0 * gp.tileSize;

            gp.obj[1] = new ObjHealth();
            gp.obj[1].x = 2 * gp.tileSize;
            gp.obj[1].y = 1 * gp.tileSize;

            gp.obj[2] = new ObjHealth();
            gp.obj[2].x = 4 * gp.tileSize;
            gp.obj[2].y = 0 * gp.tileSize;

            gp.obj[3] = new InteractCactus();
            gp.obj[3].x = 10 * gp.tileSize;
            gp.obj[3].y = 2 * gp.tileSize;

            gp.obj[4] = new interactSarlacc();
            gp.obj[4].x = 8 * gp.tileSize;
            gp.obj[4].y = 4 * gp.tileSize;
        }
        else if (currentMap == 7) {
            Arrays.fill(gp.obj, null);

            gp.obj[0] = new ObjHealth();
            gp.obj[0].x = 4 * gp.tileSize;
            gp.obj[0].y = 8 * gp.tileSize;

            gp.obj[1] = new ObjHealth();
            gp.obj[1].x = 8 * gp.tileSize;
            gp.obj[1].y = 8 * gp.tileSize;

            gp.obj[2] = new ObjHealth();
            gp.obj[2].x = 0 * gp.tileSize;
            gp.obj[2].y = 8 * gp.tileSize;
        }

        else if (currentMap == 8) {
            Arrays.fill(gp.obj, null);

            gp.obj[0] = new ObjKey();
            gp.obj[0].x = 8 * gp.tileSize;
            gp.obj[0].y = 0 * gp.tileSize;

            gp.obj[1] = new TouchHealingPool();
            gp.obj[1].x = 5 * gp.tileSize;
            gp.obj[1].y = 0 * gp.tileSize;

            gp.obj[2] = new MessageMap8();
            gp.obj[2].x = 6 * gp.tileSize;
            gp.obj[2].y = 2 * gp.tileSize;
        }

        else if (currentMap == 9) {
            Arrays.fill(gp.obj, null);

            gp.obj[0] = new ObjArmor();
            gp.obj[0].x = 11 * gp.tileSize;
            gp.obj[0].y = 9 * gp.tileSize;

            gp.obj[1] = new ObjSecretDoor();
            gp.obj[1].x = 4 * gp.tileSize;
            gp.obj[1].y = 9 * gp.tileSize;

            gp.obj[2] = new ObjHealth();
            gp.obj[2].x = 3 * gp.tileSize;
            gp.obj[2].y = 9 * gp.tileSize;

            gp.obj[3] = new ObjHealth();
            gp.obj[3].x = 5 * gp.tileSize;
            gp.obj[3].y = 2 * gp.tileSize;

        }
        else if (currentMap == 10) {
            Arrays.fill(gp.obj, null);

            gp.obj[0] = new ObjKey();
            gp.obj[0].x = 11 * gp.tileSize;
            gp.obj[0].y = 9 * gp.tileSize;

            gp.obj[1] = new TouchLava();
            gp.obj[1].x = 2 * gp.tileSize;
            gp.obj[1].y = 6 * gp.tileSize;

            gp.obj[2] = new TouchLava();
            gp.obj[2].x = 2 * gp.tileSize;
            gp.obj[2].y = 7 * gp.tileSize;

            gp.obj[3] = new TouchLava();
            gp.obj[3].x = 1 * gp.tileSize;
            gp.obj[3].y = 8 * gp.tileSize;

            gp.obj[2] = new TouchLava();
            gp.obj[2].x = 2 * gp.tileSize;
            gp.obj[2].y = 6 * gp.tileSize;

            gp.obj[4] = new TouchLava();
            gp.obj[4].x = 3 * gp.tileSize;
            gp.obj[4].y = 6 * gp.tileSize;

            gp.obj[5] = new TouchLava();
            gp.obj[5].x = 3 * gp.tileSize;
            gp.obj[5].y = 7 * gp.tileSize;

            gp.obj[6] = new TouchLava();
            gp.obj[6].x = 1 * gp.tileSize;
            gp.obj[6].y = 6 * gp.tileSize;

            gp.obj[7] = new TouchLava();
            gp.obj[7].x = 3 * gp.tileSize;
            gp.obj[7].y = 8 * gp.tileSize;

            gp.obj[8] = new TouchLava();
            gp.obj[8].x = 2 * gp.tileSize;
            gp.obj[8].y = 8 * gp.tileSize;

            gp.obj[9] = new TouchLava();
            gp.obj[9].x = 1 * gp.tileSize;
            gp.obj[9].y = 7 * gp.tileSize;

            gp.obj[10] = new TouchLava();
            gp.obj[10].x = 10 * gp.tileSize;
            gp.obj[10].y = 8 * gp.tileSize;

            gp.obj[11] = new TouchLava();
            gp.obj[11].x = 10 * gp.tileSize;
            gp.obj[11].y = 9 * gp.tileSize;

            gp.obj[12] = new TouchLava();
            gp.obj[12].x = 11 * gp.tileSize;
            gp.obj[12].y = 8 * gp.tileSize;

            gp.obj[13] = new TouchLava();
            gp.obj[13].x = 6 * gp.tileSize;
            gp.obj[13].y = 2 * gp.tileSize;

            gp.obj[14] = new TouchLava();
            gp.obj[14].x = 7 * gp.tileSize;
            gp.obj[14].y = 2 * gp.tileSize;

            gp.obj[16] = new Frog();
            gp.obj[16].x = 2 * gp.tileSize;
            gp.obj[16].y = 7 * gp.tileSize;
        }

        else if (currentMap == 11) {

            Arrays.fill(gp.obj, null);

            gp.obj[0] = new TouchLava();
            gp.obj[0].x = 0 * gp.tileSize;
            gp.obj[0].y = 7 * gp.tileSize;

            gp.obj[1] = new TouchLava();
            gp.obj[1].x = 3 * gp.tileSize;
            gp.obj[1].y = 6 * gp.tileSize;

            gp.obj[2] = new TouchLava();
            gp.obj[2].x = 1 * gp.tileSize;
            gp.obj[2].y = 4 * gp.tileSize;

            gp.obj[3] = new TouchLava();
            gp.obj[3].x = 7 * gp.tileSize;
            gp.obj[3].y = 7 * gp.tileSize;

            gp.obj[4] = new TouchLava();
            gp.obj[4].x = 9 * gp.tileSize;
            gp.obj[4].y = 5 * gp.tileSize;

            gp.obj[5] = new ObjKey();
            gp.obj[5].x = 4 * gp.tileSize;
            gp.obj[5].y = 0 * gp.tileSize;

            gp.obj[6] = new ObjBlessing();
            gp.obj[6].x = 3 * gp.tileSize;
            gp.obj[6].y = 1 * gp.tileSize;

            gp.obj[7] = new ObjNPCAngel();
            gp.obj[7].x = 5 * gp.tileSize;
            gp.obj[7].y = 1 * gp.tileSize;

            gp.obj[8] = new ObjHealth();
            gp.obj[8].x = 4 * gp.tileSize;
            gp.obj[8].y = 5 * gp.tileSize;

            gp.obj[9] = new ObjHealth();
            gp.obj[9].x = 4 * gp.tileSize;
            gp.obj[9].y = 4 * gp.tileSize;

            gp.obj[10] = new ObjHealth();
            gp.obj[10].x = 1 * gp.tileSize;
            gp.obj[10].y = 9 * gp.tileSize;

        }

        else if (currentMap == 12) {
            Arrays.fill(gp.obj, null);

            gp.obj[0] = new interactStoneTablet2();
            gp.obj[0].x = 2 * gp.tileSize;
            gp.obj[0].y = 0 * gp.tileSize;


            gp.obj[1] = new InteractPillar();
            gp.obj[1].x = 5 * gp.tileSize;
            gp.obj[1].y = 2 * gp.tileSize;

            gp.obj[2] = new InteractPillar();
            gp.obj[2].x = 8 * gp.tileSize;
            gp.obj[2].y = 2 * gp.tileSize;

            gp.obj[3] = new InteractPillar();
            gp.obj[3].x = 5 * gp.tileSize;
            gp.obj[3].y = 5 * gp.tileSize;

            gp.obj[4] = new InteractPillar();
            gp.obj[4].x = 8 * gp.tileSize;
            gp.obj[4].y = 5 * gp.tileSize;

            gp.obj[5] = new interactStoneTablet();
            gp.obj[5].x = 4 * gp.tileSize;
            gp.obj[5].y = 0 * gp.tileSize;

            gp.obj[6] = new interactStoneTablet3();
            gp.obj[6].x = 6 * gp.tileSize;
            gp.obj[6].y = 0 * gp.tileSize;

            //removed, one blessing moved to previous level instead
            //gp.obj[7] = new ObjBlessing();
            //gp.obj[7].x = 11 * gp.tileSize;
            //gp.obj[7].y = 2 * gp.tileSize;

            gp.obj[8] = new TouchLava();
            gp.obj[8].x = gp.tileSize * 1;
            gp.obj[8].y = gp.tileSize * 6;

            gp.obj[9] = new TouchLava();
            gp.obj[9].x = 3 * gp.tileSize;
            gp.obj[9].y = 7 * gp.tileSize;

            gp.obj[10] = new TouchLava();
            gp.obj[10].x = 4 * gp.tileSize;
            gp.obj[10].y = 7 * gp.tileSize;

            gp.obj[11] = new TouchLava();
            gp.obj[11].x = 5 * gp.tileSize;
            gp.obj[11].y = 7 * gp.tileSize;

            gp.obj[12] = new TouchLava();
            gp.obj[12].x = 6 * gp.tileSize;
            gp.obj[12].y = 7 * gp.tileSize;

            gp.obj[13] = new TouchLava();
            gp.obj[13].x = 7 * gp.tileSize;
            gp.obj[13].y = 7 * gp.tileSize;

            gp.obj[14] = new TouchLava();
            gp.obj[14].x = 8 * gp.tileSize;
            gp.obj[14].y = 7 * gp.tileSize;

            gp.obj[15] = new TouchLava();
            gp.obj[15].x = 9 * gp.tileSize;
            gp.obj[15].y = 7 * gp.tileSize;

            gp.obj[16] = new TouchLava();
            gp.obj[16].x = 10 * gp.tileSize;
            gp.obj[16].y = 7 * gp.tileSize;
        }
    }

    public void setEntities(int currentMap) {
        if (currentMap == 1) {
            Arrays.fill(gp.monsterOrNPC, null);

            gp.monsterOrNPC[0] = new Bandit(gp);
            gp.monsterOrNPC[0].speed = 0;
            gp.monsterOrNPC[0].x = gp.tileSize * 9;
            gp.monsterOrNPC[0].y = gp.tileSize * 1;

            gp.monsterOrNPC[1] = new Bandit(gp);
            gp.monsterOrNPC[1].speed = 0;
            gp.monsterOrNPC[1].hasKey = true;
            gp.monsterOrNPC[1].x = gp.tileSize * 1;
            gp.monsterOrNPC[1].y = gp.tileSize * 9;

            gp.monsterOrNPC[15] = new BanditBoss(gp);
            gp.monsterOrNPC[15].health = 35;
            gp.monsterOrNPC[15].x = gp.tileSize * 8;
            gp.monsterOrNPC[15].y = gp.tileSize * 8;

        }

        if (currentMap == 2){
            Arrays.fill(gp.monsterOrNPC, null);
            double adjuster2 = 1.3;

            gp.monsterOrNPC[0] = new Bandit(gp);
            gp.monsterOrNPC[0].x = gp.tileSize * 7;
            gp.monsterOrNPC[0].y = gp.tileSize * 4;
            gp.monsterOrNPC[0].damage = (int)(gp.monsterOrNPC[0].damage * adjuster2);

            gp.monsterOrNPC[1] = new Bandit(gp);
            gp.monsterOrNPC[1].direction = "left";
            gp.monsterOrNPC[1].x = gp.tileSize * 4;
            gp.monsterOrNPC[1].y = gp.tileSize * 4;
            gp.monsterOrNPC[1].damage = (int)(gp.monsterOrNPC[1].damage * adjuster2);

            gp.monsterOrNPC[2] = new Bandit(gp);
            gp.monsterOrNPC[2].direction = "right";
            gp.monsterOrNPC[2].hasKey = true;
            gp.monsterOrNPC[2].x = gp.tileSize * 9;
            gp.monsterOrNPC[2].y = gp.tileSize * 1;
            gp.monsterOrNPC[2].damage = (int)(gp.monsterOrNPC[2].damage * adjuster2);

            gp.monsterOrNPC[15] = new BanditBoss(gp);
            gp.monsterOrNPC[15].x = gp.tileSize * 8;
            gp.monsterOrNPC[15].y = gp.tileSize * 8;
            gp.monsterOrNPC[15].damage = (int)(gp.monsterOrNPC[15].damage * adjuster2);
        }

        if (currentMap == 3){
            Arrays.fill(gp.monsterOrNPC, null);
            double adjuster3 = 1.4;

            gp.monsterOrNPC[0] = new Bandit(gp);
            gp.monsterOrNPC[0].hasKey = true;
            gp.monsterOrNPC[0].x = gp.tileSize * 7;
            gp.monsterOrNPC[0].y = gp.tileSize * 4;
            gp.monsterOrNPC[0].damage = (int)(gp.monsterOrNPC[0].damage * adjuster3);

            gp.monsterOrNPC[1] = new Bandit(gp);
            gp.monsterOrNPC[1].direction = "left";
            gp.monsterOrNPC[1].x = gp.tileSize * 7;
            gp.monsterOrNPC[1].y = gp.tileSize * 5;
            gp.monsterOrNPC[1].damage = (int)(gp.monsterOrNPC[1].damage * adjuster3);

            gp.monsterOrNPC[2] = new Bandit(gp);
            gp.monsterOrNPC[2].direction = "right";
            gp.monsterOrNPC[2].x = gp.tileSize * 7;
            gp.monsterOrNPC[2].y = gp.tileSize * 6;
            gp.monsterOrNPC[2].damage = (int)(gp.monsterOrNPC[2].damage * adjuster3);

            gp.monsterOrNPC[3] = new Bandit(gp);
            gp.monsterOrNPC[3].x = gp.tileSize * 9;
            gp.monsterOrNPC[3].y = gp.tileSize * 1;
            gp.monsterOrNPC[3].damage = (int)(gp.monsterOrNPC[3].damage * adjuster3);

            gp.monsterOrNPC[4] = new Bandit(gp);
            gp.monsterOrNPC[4].x = gp.tileSize * 9;
            gp.monsterOrNPC[4].y = gp.tileSize * 2;
            gp.monsterOrNPC[4].damage = (int)(gp.monsterOrNPC[4].damage * adjuster3);

            gp.monsterOrNPC[15] = new BanditBoss(gp);
            gp.monsterOrNPC[15].x = gp.tileSize * 9;
            gp.monsterOrNPC[15].y = gp.tileSize * 8;
            gp.monsterOrNPC[15].damage = (int)(gp.monsterOrNPC[15].damage * adjuster3);
        }

        if (currentMap == 4){
            Arrays.fill(gp.monsterOrNPC, null);

            gp.monsterOrNPC[0] = new Snake(gp);
            gp.monsterOrNPC[0].hasKey = true;
            gp.monsterOrNPC[0].x = gp.tileSize * 7;
            gp.monsterOrNPC[0].y = gp.tileSize * 5;

            gp.monsterOrNPC[1] = new Scorpion(gp);
            gp.monsterOrNPC[1].x = gp.tileSize * 7;
            gp.monsterOrNPC[1].y = gp.tileSize * 6;

            gp.monsterOrNPC[2] = new Snake(gp);
            gp.monsterOrNPC[2].x = gp.tileSize * 9;
            gp.monsterOrNPC[2].y = gp.tileSize * 1;

            gp.monsterOrNPC[3] = new Scorpion(gp);
            gp.monsterOrNPC[3].x = gp.tileSize * 9;
            gp.monsterOrNPC[3].y = gp.tileSize * 2;

            gp.monsterOrNPC[15] = new Spider(gp);
            gp.monsterOrNPC[15].x = gp.tileSize * 11;
            gp.monsterOrNPC[15].y = gp.tileSize * 0;
        }

        if (currentMap == 5){
            Arrays.fill(gp.monsterOrNPC, null);

            gp.monsterOrNPC[0] = new Scorpion(gp);
            gp.monsterOrNPC[0].x = gp.tileSize * 7;
            gp.monsterOrNPC[0].y = gp.tileSize * 5;

            gp.monsterOrNPC[1] = new Scorpion(gp);
            gp.monsterOrNPC[1].x = gp.tileSize * 7;
            gp.monsterOrNPC[1].y = gp.tileSize * 6;

            gp.monsterOrNPC[2] = new Snake(gp);
            gp.monsterOrNPC[2].x = gp.tileSize * 9;
            gp.monsterOrNPC[2].y = gp.tileSize * 1;

            gp.monsterOrNPC[3] = new Snake(gp);
            gp.monsterOrNPC[3].x = gp.tileSize * 9;
            gp.monsterOrNPC[3].y = gp.tileSize * 2;

            gp.monsterOrNPC[15] = new Spider(gp);
            gp.monsterOrNPC[15].x = gp.tileSize * 11;
            gp.monsterOrNPC[15].y = gp.tileSize * 9;
        }

        if (currentMap == 6){
            Arrays.fill(gp.monsterOrNPC, null);
            double adjuster6 = 1.3;
            gp.monsterOrNPC[0] = new Scorpion(gp);
            gp.monsterOrNPC[0].x = gp.tileSize * 8;
            gp.monsterOrNPC[0].y = gp.tileSize * 2;
            gp.monsterOrNPC[0].damage = (int) (gp.monsterOrNPC[0].damage * adjuster6);

            gp.monsterOrNPC[1] = new Scorpion(gp);
            gp.monsterOrNPC[1].hasKey = true;
            gp.monsterOrNPC[1].x = gp.tileSize * 3;
            gp.monsterOrNPC[1].y = gp.tileSize * 7;
            gp.monsterOrNPC[1].damage = (int) (gp.monsterOrNPC[0].damage * adjuster6);

            gp.monsterOrNPC[2] = new Snake(gp);
            gp.monsterOrNPC[2].x = gp.tileSize * 10;
            gp.monsterOrNPC[2].y = gp.tileSize * 1;
            gp.monsterOrNPC[2].damage = (int) (gp.monsterOrNPC[0].damage * adjuster6);

            gp.monsterOrNPC[3] = new Snake(gp);
            gp.monsterOrNPC[3].x = gp.tileSize * 2;
            gp.monsterOrNPC[3].y = gp.tileSize * 4;
            gp.monsterOrNPC[3].damage = (int) (gp.monsterOrNPC[0].damage * adjuster6);

            gp.monsterOrNPC[4] = new Snake(gp);
            gp.monsterOrNPC[4].x = gp.tileSize * 2;
            gp.monsterOrNPC[4].y = gp.tileSize * 5;
            gp.monsterOrNPC[4].damage = (int) (gp.monsterOrNPC[0].damage * adjuster6);

            gp.monsterOrNPC[5] = new Snake(gp);
            gp.monsterOrNPC[5].x = gp.tileSize * 3;
            gp.monsterOrNPC[5].y = gp.tileSize * 6;
            gp.monsterOrNPC[5].damage = (int) (gp.monsterOrNPC[0].damage * adjuster6);

            gp.monsterOrNPC[5] = new Scorpion(gp);
            gp.monsterOrNPC[5].x = gp.tileSize * 3;
            gp.monsterOrNPC[5].y = gp.tileSize * 7;
            gp.monsterOrNPC[5].damage = (int) (gp.monsterOrNPC[0].damage * adjuster6);

            gp.monsterOrNPC[15] = new Spider(gp);
            gp.monsterOrNPC[15].x = gp.tileSize * 11;
            gp.monsterOrNPC[15].y = gp.tileSize * 9;
            gp.monsterOrNPC[15].damage = (int) (gp.monsterOrNPC[0].damage * adjuster6);
        }

        if (currentMap == 7){
            Arrays.fill(gp.monsterOrNPC, null);

            gp.monsterOrNPC[0] = new SkeletonSpear(gp);
            gp.monsterOrNPC[0].hasKey = true;
            gp.monsterOrNPC[0].x = gp.tileSize * 0;
            gp.monsterOrNPC[0].y = gp.tileSize * 9;

            gp.monsterOrNPC[1] = new SkeletonSword(gp);
            gp.monsterOrNPC[1].x = gp.tileSize * 5;
            gp.monsterOrNPC[1].y = gp.tileSize * 1;

            gp.monsterOrNPC[3] = new SkeletonAxeShield(gp);
            gp.monsterOrNPC[3].x = gp.tileSize * 9;
            gp.monsterOrNPC[3].y = gp.tileSize * 4;

            gp.monsterOrNPC[15] = new SkeletonBoss(gp);
            gp.monsterOrNPC[15].x = gp.tileSize * 10;
            gp.monsterOrNPC[15].y = gp.tileSize * 6;
        }

        if (currentMap == 8){
            Arrays.fill(gp.monsterOrNPC, null);

            gp.monsterOrNPC[0] = new SkeletonSpear(gp);
            gp.monsterOrNPC[0].x = gp.tileSize * 2;
            gp.monsterOrNPC[0].y = gp.tileSize * 8;

            gp.monsterOrNPC[1] = new SkeletonAxeShield(gp);
            gp.monsterOrNPC[1].x = gp.tileSize * 3;
            gp.monsterOrNPC[1].y = gp.tileSize * 8;

            gp.monsterOrNPC[2] = new SkeletonSword(gp);
            gp.monsterOrNPC[2].x = gp.tileSize * 4;
            gp.monsterOrNPC[2].y = gp.tileSize * 8;

            gp.monsterOrNPC[3] = new SkeletonSword(gp);
            gp.monsterOrNPC[3].hasKey = true;
            gp.monsterOrNPC[3].x = gp.tileSize * 9;
            gp.monsterOrNPC[3].y = gp.tileSize * 2;

            gp.monsterOrNPC[3] = new NPC_Gandalf(gp);
            gp.monsterOrNPC[3].x = gp.tileSize * 9;
            gp.monsterOrNPC[3].y = gp.tileSize * 2;

            gp.monsterOrNPC[4] = new SkeletonSword(gp);
            gp.monsterOrNPC[4].hasKey = false;
            gp.monsterOrNPC[4].x = gp.tileSize * 3;
            gp.monsterOrNPC[4].y = gp.tileSize * 9;

            gp.monsterOrNPC[5] = new SkeletonSpear(gp);
            gp.monsterOrNPC[5].hasKey = false;
            gp.monsterOrNPC[5].x = gp.tileSize * 4;
            gp.monsterOrNPC[5].y = gp.tileSize * 8;

            gp.monsterOrNPC[6] = new SkeletonAxeShield(gp);
            gp.monsterOrNPC[6].hasKey = false;
            gp.monsterOrNPC[6].x = gp.tileSize * 9;
            gp.monsterOrNPC[6].y = gp.tileSize * 9;


            gp.monsterOrNPC[15] = new SkeletonBoss(gp);
            gp.monsterOrNPC[15].x = gp.tileSize * 11;
            gp.monsterOrNPC[15].y = gp.tileSize * 7;
        }

        if (currentMap == 9){
            Arrays.fill(gp.monsterOrNPC, null);
            double adjuster9 = 1.3;

            gp.monsterOrNPC[0] = new SkeletonSpear(gp);
            gp.monsterOrNPC[0].x = gp.tileSize * 2;
            gp.monsterOrNPC[0].y = gp.tileSize * 8;
            gp.monsterOrNPC[0].damage = (int) (gp.monsterOrNPC[0].damage * adjuster9);

            gp.monsterOrNPC[1] = new SkeletonAxeShield(gp);
            gp.monsterOrNPC[1].x = gp.tileSize * 3;
            gp.monsterOrNPC[1].y = gp.tileSize * 8;
            gp.monsterOrNPC[1].damage = (int) (gp.monsterOrNPC[1].damage * adjuster9);

            gp.monsterOrNPC[2] = new SkeletonSword(gp);
            gp.monsterOrNPC[2].x = gp.tileSize * 9;
            gp.monsterOrNPC[2].y = gp.tileSize * 1;
            gp.monsterOrNPC[2].damage = (int) (gp.monsterOrNPC[2].damage * adjuster9);

            gp.monsterOrNPC[3] = new SkeletonSword(gp);
            gp.monsterOrNPC[3].hasKey = true;
            gp.monsterOrNPC[3].x = gp.tileSize * 9;
            gp.monsterOrNPC[3].y = gp.tileSize * 2;
            gp.monsterOrNPC[3].damage = (int) (gp.monsterOrNPC[3].damage * adjuster9);

            gp.monsterOrNPC[15] = new SkeletonBoss(gp);
            gp.monsterOrNPC[15].x = gp.tileSize * 10;
            gp.monsterOrNPC[15].y = gp.tileSize * 3;
            gp.monsterOrNPC[15].damage = (int) (gp.monsterOrNPC[15].damage * adjuster9);
        }

        if (currentMap == 10){

            Arrays.fill(gp.monsterOrNPC, null);

            gp.monsterOrNPC[0] = new Darkknight(gp);
            gp.monsterOrNPC[0].x = gp.tileSize * 9;
            gp.monsterOrNPC[0].y = gp.tileSize * 6;

            gp.monsterOrNPC[1] = new Darkknight(gp);
            gp.monsterOrNPC[1].x = gp.tileSize * 4;
            gp.monsterOrNPC[1].y = gp.tileSize * 1;

            gp.monsterOrNPC[2] = new Nazgul(gp);
            gp.monsterOrNPC[2].x = gp.tileSize * 5;
            gp.monsterOrNPC[2].y = gp.tileSize * 2;

            gp.monsterOrNPC[3] = new Nazgul(gp);
            gp.monsterOrNPC[3].x = gp.tileSize * 6;
            gp.monsterOrNPC[3].y = gp.tileSize * 5;

            gp.monsterOrNPC[4] = new Terrorblade(gp);
            gp.monsterOrNPC[4].x = gp.tileSize * 9;
            gp.monsterOrNPC[4].y = gp.tileSize * 4;

            gp.monsterOrNPC[15] = new Cocytus(gp);
            gp.monsterOrNPC[15].x = gp.tileSize * 10;
            gp.monsterOrNPC[15].y = gp.tileSize * 3;
        }
        if (currentMap == 11){

            Arrays.fill(gp.monsterOrNPC, null);

            gp.monsterOrNPC[0] = new Darkknight(gp);
            gp.monsterOrNPC[0].x = gp.tileSize * 9;
            gp.monsterOrNPC[0].y = gp.tileSize * 6;

            gp.monsterOrNPC[1] = new Darkknight(gp);
            gp.monsterOrNPC[1].x = gp.tileSize * 8;
            gp.monsterOrNPC[1].y = gp.tileSize * 4;

            gp.monsterOrNPC[2] = new Nazgul(gp);
            gp.monsterOrNPC[2].x = gp.tileSize * 9;
            gp.monsterOrNPC[2].y = gp.tileSize * 7;

            gp.monsterOrNPC[3] = new Nazgul(gp);
            gp.monsterOrNPC[3].x = gp.tileSize * 3;
            gp.monsterOrNPC[3].y = gp.tileSize * 8;

            gp.monsterOrNPC[4] = new Terrorblade(gp);
            gp.monsterOrNPC[4].x = gp.tileSize * 9;
            gp.monsterOrNPC[4].y = gp.tileSize * 6;

            gp.monsterOrNPC[15] = new Cocytus(gp);
            gp.monsterOrNPC[15].x = gp.tileSize * 11;
            gp.monsterOrNPC[15].y = gp.tileSize * 9;

        }
        if (currentMap == 12){
            Arrays.fill(gp.monsterOrNPC, null);

            gp.monsterOrNPC[15] = new Boss(gp);
            gp.monsterOrNPC[15].x = gp.tileSize * 11;
            gp.monsterOrNPC[15].y = gp.tileSize * 9;
        }
    }

    public void nextMapTriggers() { //called after any enemy is killed
        if(gp.currentMap == 1 && gp.hero.currentEnemyIndex == 15){
            gp.obj[15] = new ObjDoor();
            gp.obj[15].x = 9 * gp.tileSize;
            gp.obj[15].y = 5 * gp.tileSize;
        }

        if(gp.currentMap == 2 && gp.hero.currentEnemyIndex == 15){
            gp.obj[15] = new ObjDoor();
            gp.obj[15].x = 11 * gp.tileSize;
            gp.obj[15].y = 9 * gp.tileSize;
        }

        if(gp.currentMap == 3 && gp.hero.currentEnemyIndex == 15){
            gp.obj[15] = new ObjDoor();
            gp.obj[15].x = 11 * gp.tileSize;
            gp.obj[15].y = 9 * gp.tileSize;
        }

        if(gp.currentMap == 4 && gp.hero.currentEnemyIndex == 15){
            gp.obj[15] = new ObjDoor();
            gp.obj[15].x = 11 * gp.tileSize;
            gp.obj[15].y = 3 * gp.tileSize;
        }
        if(gp.currentMap == 5 && gp.hero.currentEnemyIndex == 15){
            gp.obj[15] = new ObjDoor();
            gp.obj[15].x = 11 * gp.tileSize;
            gp.obj[15].y = 3 * gp.tileSize;
        }

        if(gp.currentMap == 6 && gp.hero.currentEnemyIndex == 15){
            gp.obj[15] = new ObjDoor();
            gp.obj[15].x = 0* gp.tileSize;
            gp.obj[15].y = 9 * gp.tileSize;
        }

        if(gp.currentMap == 7 && gp.hero.currentEnemyIndex == 15){
            gp.obj[15] = new ObjDoor();
            gp.obj[15].x = 4* gp.tileSize;
            gp.obj[15].y = 9 * gp.tileSize;
        }
        if(gp.currentMap == 8 && gp.hero.currentEnemyIndex == 15){
            gp.obj[15] = new ObjDoor();
            gp.obj[15].x = 9 * gp.tileSize;
            gp.obj[15].y = 9 * gp.tileSize;
        }

        if(gp.currentMap == 9 && gp.hero.currentEnemyIndex == 15){
            gp.obj[15] = new ObjDoor();
            gp.obj[15].x = 5 * gp.tileSize;
            gp.obj[15].y = 0 * gp.tileSize;
        }

        if(gp.currentMap == 10 && gp.hero.currentEnemyIndex == 15){
            gp.obj[15] = new ObjDoor();
            gp.obj[15].x = 5 * gp.tileSize;
            gp.obj[15].y = 0 * gp.tileSize;
        }
        if(gp.currentMap == 11 && gp.hero.currentEnemyIndex == 15){
            gp.obj[15] = new ObjDoor();
            gp.obj[15].x = 9 * gp.tileSize;
            gp.obj[15].y = 9 * gp.tileSize;
        }
    }

    public void SpecialTriggers() {
        if (gp.currentMap == 12){
            if (pillar1touched && pillar2touched && pillar3touched && pillar4touched) {

                gp.obj[7] = new ObjBlessing();
                gp.obj[7].x = 11 * gp.tileSize;
                gp.obj[7].y = 2 * gp.tileSize;

                pillar1touched = false;
                pillar2touched = false;
                pillar3touched = false;
                pillar4touched = false;
            }
        }
    }
}
