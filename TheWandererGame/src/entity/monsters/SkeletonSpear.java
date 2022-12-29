package entity.monsters;

import Main.GamePanel;
import entity.Enemy;
import entity.Entity;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class SkeletonSpear extends Entity implements Enemy {
    public SkeletonSpear(GamePanel gp){
        super(gp);
        defSpeed = 2;
        direction = "up";
        speed = 2;
        getImage();
        entityCollision = true;
        defense = 10;
        damage = 85;
        health = 210;
        hitChance = 80;
        avoidChance = 20;
        isBoss = false;
        hasKey = false;
    }

    public void getImage() {
        try{
            up1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/skeletonspear.png"));
            up2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/skeletonspear.png"));
            down1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/skeletonspear.png"));
            down2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/skeletonspear.png"));
            right1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/skeletonspear.png"));
            right2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/skeletonspear.png"));
            left1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/skeletonspear.png"));
            left2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/skeletonspear.png"));
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
