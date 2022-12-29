package entity.monsters;

import Main.GamePanel;
import entity.Enemy;
import entity.Entity;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class BanditBoss extends Entity implements Enemy {
    public BanditBoss(GamePanel gp){
        super(gp);
        direction = "down";
        speed = 0;
        getBanditImage();
        entityCollision = true;
        damage = 16;
        health = 55;
        defense = 6;
        hitChance = 80;
        avoidChance = 10;
        isBoss = false;
        hasKey = false;
        defSpeed = 0;
    }

    public void getBanditImage() {
        try{
            up1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/BanditBoss.png"));
            up2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/BanditBoss.png"));
            down1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/BanditBoss.png"));
            down2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/BanditBoss.png"));
            right1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/BanditBoss.png"));
            right2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/BanditBoss.png"));
            left1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/BanditBoss.png"));
            left2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/BanditBoss.png"));
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