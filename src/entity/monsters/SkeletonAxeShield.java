package entity.monsters;

import Main.GamePanel;
import entity.Enemy;
import entity.Entity;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class SkeletonAxeShield extends Entity implements Enemy {
    public SkeletonAxeShield(GamePanel gp){
        super(gp);
        defSpeed = 2;
        direction = "down";
        speed = 2;
        getImage();
        entityCollision = true;
        defense = 25;
        damage = 90;
        health = 200;
        hitChance = 60;
        avoidChance = 10;
        isBoss = false;
        hasKey = false;
    }

    public void getImage() {
        try{
            up1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/skeletonaxeshield.png"));
            up2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/skeletonaxeshield.png"));
            down1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/skeletonaxeshield.png"));
            down2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/skeletonaxeshield.png"));
            right1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/skeletonaxeshield.png"));
            right2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/skeletonaxeshield.png"));
            left1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/skeletonaxeshield.png"));
            left2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/skeletonaxeshield.png"));
            //TODO draw more images for walking animation

        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void setAction() {
        actionLockCounter++;
        if(actionLockCounter == 60) {
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
    }
}
