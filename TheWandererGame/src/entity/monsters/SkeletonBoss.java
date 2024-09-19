package entity.monsters;

import Main.GamePanel;
import entity.Enemy;
import entity.Entity;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class SkeletonBoss extends Entity implements Enemy {
    public SkeletonBoss(GamePanel gp){
        super(gp);
        direction = "down";
        speed = 0;
        getImage();
        entityCollision = true;
        defense = 15;
        damage = 105;
        health = 170;
        hitChance = 100;
        avoidChance = 0;
        isBoss = false;
        hasKey = false;
        defSpeed = 0;
    }

    public void getImage() {
        try{
            up1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/SkeletonBoss.png"));
            up2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/SkeletonBoss.png"));
            down1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/SkeletonBoss.png"));
            down2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/SkeletonBoss.png"));
            right1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/SkeletonBoss.png"));
            right2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/SkeletonBoss.png"));
            left1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/SkeletonBoss.png"));
            left2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/SkeletonBoss.png"));
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