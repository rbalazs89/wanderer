package entity.monsters;

import Main.GamePanel;
import entity.Enemy;
import entity.Entity;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class Bear extends Entity implements Enemy {
    private boolean randomPhase;
    public Bear(GamePanel gp) {
        super(gp);
        defSpeed = 3;
        direction = "left";
        speed = 3;
        getImage();
        entityCollision = true;
        hitChance = 120;
        avoidChance = 0;
        damage = 47;
        defense = 2;
        health = 100;
        isBoss = true;
        hasKey = false;
        randomPhase = false;
    }

    public void getImage() {
        try{
            up1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/bear.png"));
            up2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/bear.png"));
            down1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/bear.png"));
            down2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/bear.png"));
            right1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/bear.png"));
            right2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/bear.png"));
            left1 = ImageIO.read(getClass(). getResourceAsStream("/enemy/bear.png"));
            left2 = ImageIO.read(getClass(). getResourceAsStream("/enemy/bear.png"));
            //TODO draw more images for walking animation
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void setAction() {
        actionLockCounter++;
        if(actionLockCounter == 24 && !randomPhase) {
            direction = "down";
        }
        if (actionLockCounter == 48 && !randomPhase) {
            direction = "left";
        }
        if (actionLockCounter > 120) {
            randomPhase = true;
            actionLockCounter = 0;
        }

        if(actionLockCounter > 24 && randomPhase) {
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
