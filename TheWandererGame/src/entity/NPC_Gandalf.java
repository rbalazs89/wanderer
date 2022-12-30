package entity;

import Main.GamePanel;
import objects.ObjDoor;
import objects.ObjSword;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class NPC_Gandalf extends Entity{
    private int speedResetCounter;
    public NPC_Gandalf(GamePanel gp){
        super(gp);
        direction = "down";
        speed = 1;
        getGandalfImage();
        entityCollision = false;
        setDialogue();
    }

    public void setDialogue() {
        dialogues[0] = "Oh hello valiant traveller,\nhow did you wind up here?";
        dialogues[1] = "There is not much here, only\nme and this stone hut.";
        dialogues[2] = "Many millennia ago this was\na great city, with a vast\nnetwork of tunnels and\nchambers.";
        dialogues[3] = "Now only me and this hut\nremains and some snails.";
        dialogues[4] = "The snails are tasty.";
        dialogues[5] = "They cause hallucinations\nthough.";
        dialogues[6] = "The hut keeps me company.";
        dialogues[7] = "Only me and this very old\nhut. I may be older than him\nneither of us can remember\nanymore.";
        dialogues[8] = "You are wondering how I got\nhere?";
        dialogues[9] = "I came with a party of nine.\nWe got separated when I fell\nfrom a bridge.";
        dialogues[10] = "How far are you planning to\ntravel?";
        dialogues[11] = "You can bath in the\nhealing pool near the\ncorner before you go.";
        dialogues[12] = "There are demons of the\n ancient world lurking further\nbelow.";
        dialogues[13] = "You wouldn't want to meet\nany of them.";
        dialogues[14] = "Take my old sword in the\ncorner. I have no use for it\nanymore.";
        dialogues[15] = "...";
        dialogues[16] = "...";
    }

    public void getGandalfImage() {
        try{
            up1 = ImageIO.read(getClass(). getResourceAsStream("/npc/front1.png"));
            up2 = ImageIO.read(getClass(). getResourceAsStream("/npc/front2.png"));
            down1 = ImageIO.read(getClass(). getResourceAsStream("/npc/back1.png"));
            down2 = ImageIO.read(getClass(). getResourceAsStream("/npc/back2.png"));
            right1 = ImageIO.read(getClass(). getResourceAsStream("/npc/right1.png"));
            right2 = ImageIO.read(getClass(). getResourceAsStream("/npc/right2.png"));
            left1 = ImageIO.read(getClass(). getResourceAsStream("/npc/left1.png"));
            left2 = ImageIO.read(getClass(). getResourceAsStream("/npc/left2.png"));
            //TODO draw more images for walking animation

        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void setAction() {

        actionLockCounter++;
        if(x < 7 * gp.tileSize){
            direction = "right";
        }
        else if( y < 1 * gp.tileSize){
            direction = "down";
        }
        else if (actionLockCounter > 60) {
            Random random = new Random();
            int i = random.nextInt(100) + 1;

            if (i <= 25) {
                direction = "right";
            }
            if (i > 25 && i <= 50) {
                direction = "left";
            }

            if (i > 50 && i <= 75) {
                direction = "up";
            }
            if (i > 75 && i <= 100) {
                direction = "down";
            }
            actionLockCounter = 0;
        }
        speedResetCounter++;
        if (speedResetCounter == 500){
            speed = 1;
            speedResetCounter = 0;
        }
    }
    public void speak() {
        if (currentDialogueIndex == 16){
            currentDialogueIndex = 15;
        }
        if (currentDialogueIndex == 14){
            gp.obj[14] = new ObjSword();
            gp.obj[14].x = 11 * gp.tileSize;
            gp.obj[14].y = 0 * gp.tileSize;
            }
        gp.ui.showMessage(dialogues[currentDialogueIndex]);
        currentDialogueIndex++;
    }
}
